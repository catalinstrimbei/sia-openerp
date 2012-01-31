package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;

@SessionScoped
public class FormContracteCVFunctieImpl implements Converter{

	private Functie functie;
	private List<Functie> functii = new ArrayList<Functie>();
	private List<ContractMunca> contracte = new ArrayList<ContractMunca>();
	private ContractMunca contract;
	private List<CV>  cvuri = new ArrayList<CV>();
	private CV cv;
	public ContractMunca getContract() {
		return contract;
	}

	public void setContract(ContractMunca contract) {
		this.contract = contract;
	}

	public List<CV> getCvuri() {
		return cvuri;
	}

	public void setCvuri(List<CV> cvuri) {
		this.cvuri = cvuri;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	HtmlDataTable contracteTable;
	HtmlDataTable cvTable;
	public HtmlDataTable getCvTable() {
		return cvTable;
	}

	public void setCvTable(HtmlDataTable cvTable) {
		this.cvTable = cvTable;
	}

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
		
		functii = (List<Functie>) personalSrv.getListaFunctii();
		if (!functii.isEmpty())
		{
			functie = functii.get(0);
			cvuri = (List<CV>) personalSrv.getListaCVuri();		
			contracte = (List<ContractMunca>) personalSrv.getListaContracteMunca();			
		}
		else{
			System.out.println("Nu exista functii!!!");
			this.functie = new Functie();
			functie.setNumeFunctie("Def functie ...");
		}
	}

	
	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		logger.logINFO("<<<<<<setFunctie: " + functie.getNumeFunctie());
		this.functie = functie;
	}

	
	public List<Functie> getFunctiiList(){
		return this.functii;
	}
	
	public Map<String, Functie> getFunctii(){
		logger.logINFO("getFunctii : " + this.functii.size());
		Map<String, Functie> mapFunctii = new HashMap<String, Functie>();
		for (Functie f: functii){
			logger.logINFO("<<<<<<Map getFunctii:" + f.getNumeFunctie());
			mapFunctii.put(f.getNumeFunctie()  + " | " + f.getIdFunctie(), f);
		}
		return mapFunctii;
	} 

	public void setFunctii(List<Functie> functii) {
		this.functii = functii;
	}

	/* Implementare navigare */
	public void previousFunctie(ActionEvent evt){
		Integer idxCurent = this.functii.indexOf(functie);
		logger.logINFO("INDEX CURENT:" + idxCurent);
		if (idxCurent > 0)
			this.functie = this.functii.get(idxCurent - 1);
	}

	public void nextFunctie(ActionEvent evt){
		Integer idxCurent = this.functii.indexOf(functie);
		logger.logINFO("INDEX CURENT:" + idxCurent);
		if ((idxCurent+1) < this.functii.size())
			this.functie = this.functii.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.logINFO("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboFunctie")){
			Functie uiFunctieTemplate = new Functie();
			//uiFunctieTemplate.setIdFunctie(Integer.valueOf(uiValue));
			try {
				uiFunctieTemplate = personalSrv.getFunctieById(Integer.valueOf(uiValue));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//in personal nu am metoda equals
			
			logger.logINFO("<<<<<<<Size Functii "+functii.size());
			
			for (Functie f: functii){
				logger.logINFO("<<<<<<Indexul functiei:" + f.getIdFunctie() + " este" + functii.indexOf(f));
				
			}
			logger.logINFO("ID-ul functiei setate este: " + uiFunctieTemplate.getIdFunctie());
			Integer idx = functii.indexOf(uiFunctieTemplate);
			logger.logINFO("<<<<<<<getAsObject: INDEX-ul functiei din array este:"+idx);
			return functii.get(idx);
		} 
		//}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboFunctie")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue functie:"+uiValue);
			Functie uiFunctie = (Functie)uiValue;
			logger.logINFO("<<<<<<<<<< getAsString uiValue functie:"+uiFunctie.getNumeFunctie() + " id: " + uiFunctie.getIdFunctie());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiFunctie.getIdFunctie()!=null)
				return uiFunctie.getIdFunctie().toString();
		}
		// }
		return null;
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
	public String editActionCV(){
		logger.logINFO("Am intrat pe editActionCV ");
		CV cv_ = null;
		cv_ = cvuri.get(cvTable.getRowIndex());
		logger.logINFO("Am intrat pe editAction si am gasit contract curent cu nr" + cv_.getNrCV());
		cv_.setEditable(true);
		return null;
	}
	
	public String saveActionCV(){
		logger.logINFO("Am intrat pe saveAction ");
		CV cv_ = null;
		cv_ = cvuri.get(cvTable.getRowIndex());
		logger.logINFO("Am intrat pe editAction si am gasit contract curent cu nr" + cv_.getNrCV());
		try {
			cv_.setEditable(false);
			//contract_.setFunctie(personalSrv.getFunctieById(contract.getFunctie().getIdFunctie()));
			personalSrv.salveazaCV(cv_);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public String deleteActionCV(){		
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
