package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;

@SessionScoped
public class FormContracteAngajatiImpl implements Converter{

	private Angajat angajat;
	private List<Angajat> angajati = new ArrayList<Angajat>();
	private List<ContractMunca> contracte = new ArrayList<ContractMunca>();
	private ContractMunca contract;
	HtmlDataTable contracteTable;
	public HtmlDataTable getContracteTable() {
		return contracteTable;
	}

	public void setContracteTable(HtmlDataTable contracteTable) {
		this.contracteTable = contracteTable;
	}

	public List<ContractMunca> getContracte() {
		return contracte;
	}

	public void setContracte(List<ContractMunca> contracte) {
		this.contracte = contracte;
	}

	private PersonalLogger logger;
		
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	@PostConstruct
	public void initFormAngajati() throws Exception{
		logger = new PersonalLogger();
		
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		if (!angajati.isEmpty())
		{
			angajat = angajati.get(0);
			contracte = (List<ContractMunca>) personalSrv.getListaContracteAngajatEJB(angajat); 
		}
		else{
			System.out.println("Nu exista angajati!!!");
			this.angajat = new Angajat();
			angajat.setNume("Def angajat ...");
		}
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		logger.logINFO("Am intrat pe setAngajat cu  Nume | Id : " + angajat.getNume() + angajat.getId());
		this.angajat = angajat;
	}
	
	public List<Angajat> getAngajatiList(){
		return this.angajati;
	}
	
	public Map<String, Angajat> getAngajati(){
		logger.logINFO("Am intrat pe getAngajati : " + this.angajati.size());
		Map<String, Angajat> mapAngajati = new HashMap<String, Angajat>();
		for (Angajat a: angajati){
			logger.logINFO("Detalii Angajat Curent :" + a.getNume());
			mapAngajati.put(a.getNume() + " " + a.getPrenume() + " | " + a.getId(), a);
		}
		return mapAngajati;
	} 

	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}

	/* Implementare navigare */
	public void previousAngajat(ActionEvent evt){
		Integer idxCurent = this.angajati.indexOf(angajat);
		if (idxCurent > 0)
		{
			this.angajat = this.angajati.get(idxCurent - 1);
			try {
				contracte = (List<ContractMunca>) personalSrv.getListaContracteAngajatEJB(this.angajat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	public void nextAngajat(ActionEvent evt){
		Integer idxCurent = this.angajati.indexOf(angajat);
		if ((idxCurent+1) < this.angajati.size())
		{
			this.angajat = this.angajati.get(idxCurent + 1);
			try {
				contracte = (List<ContractMunca>) personalSrv.getListaContracteAngajatEJB(this.angajat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.logINFO(" uiValue = :"+uiValue);
		if (uiComp.getId().equals("cboAngajat")){
			Angajat uiAngajatTemplate = new Angajat();
			uiAngajatTemplate.setId(Integer.valueOf(uiValue));
			Integer idx = this.angajati.indexOf(uiAngajatTemplate);
			logger.logINFO("Id-ul angajatului curent:"+idx);
			try {
				contracte = (List<ContractMunca>) personalSrv.getListaContracteAngajatEJB(this.angajati.get(idx));
			} catch (Exception e) {				
				e.printStackTrace();
			} 
			return this.angajati.get(idx);
		} 
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {		
		if (uiComp.getId().equals("cboAngajat")){
			Angajat uiAngajat = (Angajat)uiValue;
			logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume() + " id: " + uiAngajat.getId());			
			if (uiAngajat.getId()!=null)
				return uiAngajat.getId().toString();
		}
		return null;
	}
	
	public void adaugareContract(ActionEvent evt){
		this.contract = new ContractMunca();
		this.contract.setEditable(true);
		this.contracte.add(this.contract);	  
	} 
	
	public String editAction(){
		logger.logINFO("Am intrat pe editAction ");
		ContractMunca contract_ = null;
		contract_ = contracte.get(contracteTable.getRowIndex());
		logger.logINFO("Am intrat pe editAction si am gasit contract curent cu nr" + contract_.getNrContract());
		contract_.setEditable(true);
		return null;
	}
	public String deleteAction(){
		logger.logINFO("Am intrat pe deleteAction ");
		ContractMunca contract_ = null;
		contract_ = contracte.get(contracteTable.getRowIndex());
		try {
			contract_ = personalSrv.getContractMuncaById(contract_.getNrContract());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.logINFO("Am intrat pe deleteAction si am gasit contract curent cu nr" + contract_.getNrContract());
		try {
			if (contract_ != null)
			{
				logger.logINFO("Am intrat pe deleteAction si am gasit contractul de sters cu nr" + contract_.getNrContract());
				personalSrv.stergeContractMunca(contract_);
			}
			else
				logger.logINFO("Am intrat pe deleteAction si am gasit contractul de sters NULL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String saveAction(){
		logger.logINFO("Am intrat pe saveAction ");
		ContractMunca contract_ = null;
		contract_ = contracte.get(contracteTable.getRowIndex());
		logger.logINFO("Am intrat pe saveAction si am gasit contract curent cu nr" + contract_.getNrContract());
		try {
			contract_.setEditable(false);
			//contract_.setFunctie(personalSrv.getFunctieById(contract.getFunctie().getIdFunctie()));
			personalSrv.salveazaContractMunca(contract_);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public String modificaContract(ContractMunca contract_){
		logger.logINFO("Am intrat pe modificaContract cu NrContract: ");
		contract_.setEditable(true);
		return null;
	}

	public void modificaContracte(ActionEvent evt) throws Exception{		
		for(ContractMunca ctrCurent : contracte)
		{
			ctrCurent.setEditable(true);
		}		
	}
	public void salvareContracte(ActionEvent evt) throws Exception{	
		for(ContractMunca ctrCurent : contracte)
		{
			logger.logINFO("Am intrat pe salvareContract cu NrContract: " + ctrCurent.getNrContract());
			ctrCurent.setEditable(false);
			this.contract = personalSrv.salveazaContractMunca(ctrCurent);
		}
		return;
		/*
		logger.logINFO("Am intrat pe salvareContract cu NrContract: " + contract.getNrContract());
		if (this.contract.getSalarBaza() == null)
		{
			this.contract = contracte.get(0);
		}
		else
		{
			this.contract.setAngajat(this.angajat);
		}
		this.contract = personalSrv.salveazaContractMunca(this.contract);
		logger.logINFO("Am salvat contractul cu NrContract: " + contract.getNrContract());
		this.contracte.add(this.contract);
		this.contract = null;
		*/
	}
			
}
