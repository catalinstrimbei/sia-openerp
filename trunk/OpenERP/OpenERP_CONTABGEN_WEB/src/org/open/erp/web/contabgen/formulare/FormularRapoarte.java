package org.open.erp.web.contabgen.formulare;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;

import org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.web.contabgen.util.GeneratorRaport;

@ManagedBean(name = "formularRapoarte")
@javax.faces.bean.SessionScoped
public class FormularRapoarte implements Converter, Serializable {

	private static String lookupServiceName="java:global/OpenERP_CONTABGEN/ContabilitateGeneralaImpl!org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv";

	private ContabilitateGeneralaLocalSrv serviciu;

	private List<SelectItem> selectList = new ArrayList<SelectItem>();

	private BilantContabil bilant = new BilantContabil();
	private Date deLa;
	private Date panaLa;

	public Date getDeLa() {
		return deLa;
	}

	public void setDeLa(Date deLa) {
		this.deLa = deLa;
	}

	public Date getPanaLa() {
		return panaLa;
	}

	public void setPanaLa(Date panaLa) {
		this.panaLa = panaLa;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return this.bilant;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((BilantContabil) arg2).getDenumire();
	}

	public FormularRapoarte() {
		if(serviciu == null){
			InitialContext ic = null;
			try {
				ic = new InitialContext();
				serviciu = (ContabilitateGeneralaLocalSrv )ic.lookup(lookupServiceName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		selectList.add(new SelectItem(bilant, "Bilant Contabil"));
	}

	public List<SelectItem> getSelectList() {
		return selectList;
	}

	public BilantContabil getBilant() {
		return bilant;
	}

	public void setBilant(BilantContabil bilant) {
		this.bilant = bilant;
	}

	public void genereazaRaport() throws IOException {
		bilant=new BilantContabil(serviciu.getConturiDinClaseleDeConturi());
		GeneratorRaport.genereaza(bilant);
		FileInputStream baos = new FileInputStream("c:/temp/Raport.pdf");

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ctx = context.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) ctx.getResponse();
		
		response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=Raport.pdf");

        OutputStream os = response.getOutputStream();
        byte buffer[] = new byte[8192];
        int bytesRead;
        while ((bytesRead = baos.read(buffer)) != -1) {
        
        	os.write(buffer, 0, bytesRead);
       	
        }
        os.flush();
        os.close();
        context.responseComplete();
        context.renderResponse();
	}

}
