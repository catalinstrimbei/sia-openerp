package org.open.erp.web.contabgen.formulare;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;

@ManagedBean(name="formularTranzactii")
@javax.faces.bean.SessionScoped
public class FormularTranzactii implements Converter,Serializable {

	
	
	private static String lookupServiceName="java:global/OpenERP_CONTABGEN/ContabilitateGeneralaImpl!org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv";
	
	private ContabilitateGeneralaLocalSrv serviciu;

	private List<InregistrareOperatiuneContabila> operatiuniCtb;
	private InregistrareOperatiuneContabila opCtb;
	private List<InregistrareOperatiune> inregistrari = new ArrayList<InregistrareOperatiune>();
	private List<SelectItem> selectList = new ArrayList<SelectItem>();
	private boolean afiseazaInregistrari=true;
	
	public List<InregistrareOperatiuneContabila> getOperatiuniCtbList() {
		if (operatiuniCtb==null) {
			operatiuniCtb = serviciu.getRegistru().getInregistrariOperatiuneContabila();
		}
		if (!this.operatiuniCtb.isEmpty()) {
			this.opCtb = this.operatiuniCtb.get(0);
		}else{
			InregistrareOperatiuneContabila inregOpCtb;

			InregistrareOperatiune de = new InregistrareOperatiune(null, null,
					InregistrareOperatiune.Tip.DEBIT, 0.0);
			InregistrareOperatiune ce = new InregistrareOperatiune(null, null,
					InregistrareOperatiune.Tip.CREDIT, 0.0);
			inregOpCtb = new InregistrareOperatiuneContabila(new Date(),"Descriere", 0.0, de, ce);

			ce.setInregistrare(inregOpCtb);
			de.setInregistrare(inregOpCtb);
			opCtb = serviciu.salveazaOperatiuneContabila(inregOpCtb);
			operatiuniCtb = serviciu.getRegistru().getInregistrariOperatiuneContabila();

		}
		return operatiuniCtb;
	}

	public Map<Integer, InregistrareOperatiuneContabila> getOperatiuniCtb() {
		Map<Integer, InregistrareOperatiuneContabila> operatiuniCtbMap = new HashMap<Integer, InregistrareOperatiuneContabila>();
		for (InregistrareOperatiuneContabila c : getOperatiuniCtbList())
			operatiuniCtbMap.put(c.getIdOperatiune(), c);
		return operatiuniCtbMap;
	}

	public InregistrareOperatiuneContabila getInregistrareOperatiuneContabila() {
		return opCtb;
	}

	
	
	public boolean isAfiseazaInregistrari() {
		return(opCtb.getCredit().getTransferCont()==null 
				|| opCtb.getDebit().getTransferCont()==null)?false:true;
	}

	public void setAfiseazaInregistrari(boolean afiseazaInregistrari) {
		this.afiseazaInregistrari = afiseazaInregistrari;
	}

	public void setInregistrareOperatiuneContabila(InregistrareOperatiuneContabila opCtb) {
		this.opCtb = opCtb;
	}

	public List<InregistrareOperatiune> getInregistrariList() {
		if (inregistrari.isEmpty()) {
			inregistrari.add(opCtb.getCredit());
			inregistrari.add(opCtb.getDebit());
		}
		return inregistrari;
	}

	public Map<String, InregistrareOperatiune> getInregistrari() {
		Map<String, InregistrareOperatiune> inregistrariMap = new HashMap<String, InregistrareOperatiune>();
		for (InregistrareOperatiune p : getInregistrariList())
			inregistrariMap.put(p.getTip().toString(), p);
		return inregistrariMap;
	}

	public FormularTranzactii() {
		if(serviciu == null){
			InitialContext ic = null;
			try {
				ic = new InitialContext();
				serviciu = (ContabilitateGeneralaLocalSrv )ic.lookup(lookupServiceName);
			} catch (NamingException e) {
				e.printStackTrace();	
			}
		}
		getOperatiuniCtbList();
		for (Cont cont : serviciu.getRegistru().getConturiDinClaseleDeConturi()) {
			selectList.add(new SelectItem(cont, cont.getCodCont()+" "+cont.getDenumireCont()));
		}
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		Cont contSablon = serviciu.getRegistru().getContDinClasaDeConturi(
				Integer.valueOf(arg2));
		return contSablon;

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		return ((Cont) arg2).getCodCont().toString();
	}

	public List<SelectItem> getSelectList() {
		if(selectList.isEmpty()){
			for (Cont cont : serviciu.getRegistru().getConturiDinClaseleDeConturi()) {
				selectList.add(new SelectItem(cont, cont.getCodCont()+" "+cont.getDenumireCont()));
			}
		}
		return selectList;
	}

	public void previousOpCtb(ActionEvent evt) {
		Integer idxCurent = this.getOperatiuniCtbList().indexOf(this.opCtb);
		if (idxCurent - 1 >= 0)
			this.opCtb = this.getOperatiuniCtbList().get(idxCurent - 1);
	}

	public void nextOpCtb(ActionEvent evt) {
		Integer idxCurent = this.getOperatiuniCtbList().indexOf(this.opCtb);
		if (idxCurent + 1 < this.getOperatiuniCtbList().size())
			this.opCtb = this.getOperatiuniCtbList().get(idxCurent + 1);
	}

	public void adaugareInregistrareOperatiuneContabila(ActionEvent evt) {
		InregistrareOperatiuneContabila opCtbNou = new InregistrareOperatiuneContabila();
		this.getOperatiuniCtbList().add(opCtbNou);
		this.opCtb = opCtbNou;
	}

	public void stergereInregistrareOperatiuneContabila(ActionEvent evt) {
		this.getOperatiuniCtbList().remove(this.opCtb);
		//serviciu.stergeClasa(this.clasa);

		if (this.getOperatiuniCtbList().size() > 0)
			this.opCtb = this.getOperatiuniCtbList().get(0);
		else
			this.opCtb = null;
	}

	public void salveazaOperatiuneContabila(ActionEvent evt) {
		serviciu.salveazaOperatiuneContabila(this.opCtb);
	}

	public void abandonInregistrareOperatiune(ActionEvent evt) {
		/*
		 * if(this.em.contains(this.Clasa)) { this.em.getTransaction().begin();
		 * this.em.refresh(this.Clasa); this.em.getTransaction().commit(); }
		 * else { if(this.clase.size() > 0) this.Clasa=this.clase.get(0); }
		 */

	}

	public void adaugaInregistrareOperatiune(ActionEvent evt) throws ExceptieContNetranzactionabil {
		opCtb.getCredit().getTransferCont().adaugaIntrare(opCtb.getCredit());
		opCtb.getDebit().getTransferCont().adaugaIntrare(opCtb.getDebit());
		opCtb = serviciu.salveazaOperatiuneContabila(opCtb);
		inregistrari.clear();

	}

	public void stergeInregistrareOperatiune(ActionEvent evt) {
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes()
				.get("selectedId").toString());
		InregistrareOperatiune inregSablon = new InregistrareOperatiune();
		
	}
}