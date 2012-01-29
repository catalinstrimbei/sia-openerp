package org.open.erp.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegConturi;


//@ManagedBean(name="formConturi")
//@SessionScoped
public class FormConturi implements Converter{
	private static org.apache.log4j.Logger logger;
	private List<Cont> conturi = new ArrayList<Cont>();
	private Cont contCurent;// = null;
	private RegConturi rc;
		
	public List<Cont> getConturiList() {
		return conturi;
	}
	

	public void setConturi(List<Cont> conturi) {
		this.conturi = conturi;
	}

	@EJB(name = "ContabilizareSrv/local", mappedName="ContabilizareSrv/local")
	private ContabilizareSrv contabSrv;
	
	
	@PostConstruct
	public void init() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(FormConturi.class.getName());
		logger.debug("Conturi_form - init()");
		
		rc = contabSrv.getPlanConturi();
		conturi = rc.getPlanConturi();
		if (!conturi.isEmpty())
			this.contCurent = conturi.get(0);
//		else
//			this.contCurent = new Cont();	
	}

//	public Integer getConturiCount() {
//		return conturi.size();
//	}

	public Map<String, Cont> getConturi() {
		Map<String, Cont> conturiMap = new LinkedHashMap<String, Cont>();
		if (this.conturi != null && !this.conturi.isEmpty()) {
			for (Cont c : this.conturi) {
				conturiMap.put(c.toString(), c);
			}
		}
		return conturiMap;
	}

	public Cont getContCurent() {
		return contCurent;
	}
	

	public void setContCurent(Cont contCurent) {
		this.contCurent = contCurent;
	}

	public void next(ActionEvent p0) {
		logger.debug("Conturi_form - next()");
		if (this.conturi.isEmpty())
			return;
		
		int idCurrentItem = this.conturi.indexOf(contCurent);
		if (idCurrentItem > 0)
			this.contCurent = this.conturi.get(idCurrentItem - 1);
	}

	public void previous(ActionEvent p0) {
		logger.debug("Conturi_form - previous()");
		if (this.conturi.isEmpty())
			return;
		
		int idCurrentItem = this.conturi.indexOf(contCurent);
		if (idCurrentItem + 1 < this.conturi.size())
			this.contCurent = this.conturi.get(idCurrentItem + 1);
	}

	public void adaugare(ActionEvent p0) {
		logger.debug("Conturi_form - adaugare()");
		contCurent = new Cont();
//		contCurent.setIdCont(9999);
		contCurent.setSimbolCont("XXXX");
//		contCurent.setTipCont(TipCont.ACTIV);
//		contCurent.setTipSintetic(StatusSintetic.ANALITIC);
	}

	public void stergere(ActionEvent p0) {
		logger.debug("Conturi_form - stergere()");
		//TODO: nema remove cont
		this.conturi.remove(this.contCurent);
		
//		if (!this.conturi.isEmpty())
//			this.contCurent = this.conturi.get(0);
//		else
//			this.contCurent = null;
	}

	public void abandon(ActionEvent p0) {
		logger.debug("Conturi_form - abandon()");
		
	}

	public void salveaza(ActionEvent p0) {
		logger.debug("Conturi_form - salveaza()");
		this.rc.addCont(this.contCurent);
		this.conturi.add(this.contCurent);
	}

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
          
            if (uiComp.getId().equals("cboConturi")){
            	Cont uiInregTemplate = new Cont();
            	uiInregTemplate.setIdCont(Integer.valueOf(uiValue));
                Integer idx = this.conturi.indexOf(uiInregTemplate);
                                      
                    return this.conturi.get(idx);
            } 
            return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {              
            if (uiComp.getId().equals("cboConturi")){
            	Cont uiInreg = (Cont)uiValue;
                   
                    if (uiInreg.getIdCont()!=null)
                            return uiInreg.getIdCont().toString();
            }
            return null;
    }
}