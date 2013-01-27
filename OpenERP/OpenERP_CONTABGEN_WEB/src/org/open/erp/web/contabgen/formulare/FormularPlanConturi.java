package org.open.erp.web.contabgen.formulare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;

@ManagedBean(name="formularPlanConturi")
@javax.faces.bean.SessionScoped
public class FormularPlanConturi implements Converter,Serializable {

	
	
	@EJB(lookup="java:global/OpenERP_CONTABGEN/ContabilitateGeneralaImpl!org.open.erp.services.contabgen.ContabilitateGeneralaSrv")
	private ContabilitateGeneralaSrv serviciu;

	private List<Clasa> clase;
	private Clasa clasa;
	private List<Cont> conturi = new ArrayList<Cont>();
	private List<SelectItem> selectList = new ArrayList<SelectItem>();

	public List<Clasa> getClaseList(){
		if (clase==null) {
			clase = serviciu.getRegistru().getClaseleDeConturi();
		}
		if (!this.clase.isEmpty()) {
			this.clasa = this.clase.get(0);
		}else{
			Cont capital = null;
			try {
				capital = serviciu.creazaCont(Tip.PASIV, 104,"Prime legate de capital", "", 0.0, true);
			} catch (ExceptieTipContInvalid e) {
				e.printStackTrace();
			}
			serviciu.adaugaCont(capital, 1);
			clase = serviciu.getRegistru().getClaseleDeConturi();
			this.clasa = this.clase.get(0);
		}
		return clase;
	}

	public Map<String, Clasa> getClase() {
		Map<String, Clasa> claseMap = new HashMap<String, Clasa>();
		for (Clasa c : getClaseList())
			claseMap.put(c.getDenumireClasa(), c);
		return claseMap;
	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	public List<Cont> getConturiList() {
		if (conturi.isEmpty()) {
			conturi = serviciu.getRegistru().getConturiDinClaseleDeConturi();
		}
		return conturi;
	}

	public Map<String, Cont> getConturi() {
		Map<String, Cont> conturiMap = new HashMap<String, Cont>();
		for (Cont p : getConturiList())
			conturiMap.put(p.getDenumireCont(), p);
		return conturiMap;
	}

	public FormularPlanConturi() {
	}

	@PostConstruct
	public void init(){
		for (Clasa clasa : getClaseList()) {
			selectList.add(new SelectItem(clasa, clasa.getDenumireClasa()));
		}
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		Clasa clasaSablon = serviciu.getRegistru().getClasaDeConturi(
				Integer.valueOf(arg2));
		return this.getClaseList()
				.get(this.getClaseList().indexOf(clasaSablon));

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		return ((Clasa) arg2).getCodClasa().toString();
	}

	public List<SelectItem> getSelectList() {
		return selectList;
	}

	public void previousClasa(ActionEvent evt) {
		Integer idxCurent = this.getClaseList().indexOf(this.clasa);
		if (idxCurent - 1 >= 0)
			this.clasa = this.getClaseList().get(idxCurent - 1);
	}

	public void nextClasa(ActionEvent evt) {
		Integer idxCurent = this.getClaseList().indexOf(this.clasa);
		if (idxCurent + 1 < this.getClaseList().size())
			this.clasa = this.getClaseList().get(idxCurent + 1);
	}

	public void adaugareClasa(ActionEvent evt) {
		Clasa clasaNou = new Clasa();
		this.getClaseList().add(clasaNou);
		this.clasa = clasaNou;
	}

	public void stergereClasa(ActionEvent evt) {
		this.getClaseList().remove(this.clasa);
		//serviciu.stergeClasa(this.clasa);

		if (this.getClaseList().size() > 0)
			this.clasa = this.getClaseList().get(0);
		else
			this.clasa = null;
	}

	public void salvareClasa(ActionEvent evt) {
		serviciu.salveazaClasa(this.clasa);
	}

	public void abandonClasa(ActionEvent evt) {
		/*
		 * if(this.em.contains(this.Clasa)) { this.em.getTransaction().begin();
		 * this.em.refresh(this.Clasa); this.em.getTransaction().commit(); }
		 * else { if(this.clase.size() > 0) this.Clasa=this.clase.get(0); }
		 */

	}

	public void adaugaCont(ActionEvent evt) {
		Cont contNou = new Cont();
		this.clasa.getConturi().add(contNou);
	}

	public void stergeCont(ActionEvent evt) {
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes()
				.get("selectedId").toString());
		Cont contSablon = new Cont();
		contSablon.setCodCont(selectedId);
		this.clasa.getConturi().remove(contSablon);
	}
}