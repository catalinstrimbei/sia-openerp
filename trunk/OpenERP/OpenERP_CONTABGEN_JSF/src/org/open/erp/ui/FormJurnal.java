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



import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.InregistrareRJ;
import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.RegInregistrareRJ;

@ManagedBean(name="formJurnal")
@SessionScoped
public class FormJurnal implements Converter{
		
	        private InregistrareRJ inregistrare;
	        private List<InregistrareRJ> inregistrari = new ArrayList<InregistrareRJ>();
	        private List<ArticolCtb> articole = new ArrayList<ArticolCtb>();
	        private ArticolCtb articol;
	        HtmlDataTable articoleTable;
	        
	        
	        public HtmlDataTable getArticoleTable() {
	                return articoleTable;
	        }

	        public void setArticoleTable(HtmlDataTable artTable) {
	                this.articoleTable = artTable;
	        }

	        public List<ArticolCtb> getArticole() {
	                return articole;
	        }

	        public void setArticole(List<ArticolCtb> art) {
	                this.articole = art;
	        }

	     
	                
	        @EJB(mappedName="ContabilizareSrv/local", name="ContabilizareSrv/local") 
	        private ContabilizareSrv instanteCtb;
	        
	        @PostConstruct
	        public void initForm() throws Exception{

	                RegInregistrareRJ regInr=instanteCtb.getRegInregistrari();
	                inregistrari = regInr.getListaInreg();
	                if (!inregistrari.isEmpty())
	                {
	                        inregistrare = inregistrari.get(0);
	                        articole = (List<ArticolCtb>) instanteCtb.getListArt(inregistrare.getIdInregRJ()); 
	                }
	                else{
	                        System.out.println("Nu exista inregistrari!!!");
	                        this.inregistrare = new InregistrareRJ();
	                        //inregistrare.setNume("Def angajat ...");
	                }
	        }

	        public InregistrareRJ getInregistrare() {
	                return inregistrare;
	        }

	        public void setInregistrare(InregistrareRJ inreg) {
	               
	                this.inregistrare = inreg;
	        }
	        
	        public List<InregistrareRJ> getInregistrariList(){
	                return this.inregistrari;
	        }
	        
	        public Map<String, InregistrareRJ> getInregistrari(){
	                
	                Map<String, InregistrareRJ> mapInregistrari = new HashMap<String, InregistrareRJ>();
	                for (InregistrareRJ a: inregistrari){
	                        
	                        mapInregistrari.put(a.getIdInregRJ() + " " + a.getDataInregRJ().toString(),a);}
	                return mapInregistrari;
	                
	        } 

	        public void setInregistrari(List<InregistrareRJ> inregistrari) {
	                this.inregistrari = inregistrari;
	        }

	        /* Implementare navigare */
	        public void previousInreg(ActionEvent evt){
	                Integer idxCurent = this.inregistrari.indexOf(inregistrare);
	                if (idxCurent > 0)
	                {
	                        this.inregistrare = this.inregistrari.get(idxCurent - 1);
	                        try {
	                                articole = (List<ArticolCtb>) instanteCtb.getListArt(this.inregistrare.getIdInregRJ());
	                        } catch (Exception e) {
	                                // 
	                                e.printStackTrace();
	                        } 
	                }
	        }

	        public void nextInreg(ActionEvent evt){
	                Integer idxCurent = this.inregistrari.indexOf(inregistrare);
	                if ((idxCurent+1) < this.inregistrari.size())
	                {
	                        this.inregistrare = this.inregistrari.get(idxCurent + 1);
	                        try {
	                        	 articole = (List<ArticolCtb>) instanteCtb.getListArt(this.inregistrare.getIdInregRJ());
	                        } catch (Exception e) {
	                                // 
	                                e.printStackTrace();
	                        } 
	                }
	        }       

	        @Override
	        public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
	              
	                if (uiComp.getId().equals("cboInreg")){
	                	InregistrareRJ uiInregTemplate = new InregistrareRJ();
	                	uiInregTemplate.setIdInregRJ(Integer.valueOf(uiValue));
	                    Integer idx = this.inregistrari.indexOf(uiInregTemplate);
	                        
	                        try {
	                                articole = (List<ArticolCtb>) instanteCtb.getListArt(this.inregistrari.get(idx).getIdInregRJ());
	                        } catch (Exception e) {                         
	                                e.printStackTrace();
	                        } 
	                        return this.inregistrari.get(idx);
	                } 
	                return null;
	        }

	        @Override
	        public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {              
	                if (uiComp.getId().equals("cboInreg")){
	                	InregistrareRJ uiInreg = (InregistrareRJ)uiValue;
	                       
	                        if (uiInreg.getIdInregRJ()!=null)
	                                return uiInreg.getIdInregRJ().toString();
	                }
	                return null;
	        }
	        
	        public void adaugareArticol(ActionEvent evt){
	                this.articol = new ArticolCtb();
	                this.articole.add(this.articol);        
	        } 
	        

	        public String deleteAction(){
	               
//	        	ArticolCtb articol_ = null;
//	        	articol_ = articole.get(articoleTable.getRowIndex());
//	                try {
//	                	articol_ = instanteCtb.getContractMuncaById(articol_.getNrContract());
//	                } catch (Exception e1) {
//	                        // TODO Auto-generated catch block
//	                        e1.printStackTrace();
//	                }
//	               
//	                try {
//	                        if (contract_ != null)
//	                        {
//	                               
//	                                instanteCtb.stergeContractMunca(articol_);
//	                        }
//	                        else
//	                            
//	                } catch (Exception e) {
//	                        // TODO Auto-generated catch block
//	                        e.printStackTrace();
//	                }
	                return null;
	        }
	        
	        public String saveAction(){
	       
//	        	ArticolCtb contract_ = null;
//	                contract_ = articole.get(articoleTable.getRowIndex());
//	                try {
//	                        contract_.setEditable(false);
//	                        //contract_.setFunctie(personalSrv.getFunctieById(contract.getFunctie().getIdFunctie()));
//	                        instanteCtb.salveazaContractMunca(contract_);                   
//	                } catch (Exception e) {
//	                        // TODO Auto-generated catch block
//	                        e.printStackTrace();
//	                }               
	                return null;
	        }
	        
	        public String modificaArticol(ArticolCtb contract_){
	               
	                return null;
	        }

	        public void modificaArticole(ActionEvent evt) throws Exception{                
	                for(ArticolCtb ctrCurent : articole)
	                {
	                      //  ctrCurent.setEditable(true);
	                }               
	        }
	        public void salvareArticole(ActionEvent evt) throws Exception{ 
	                for(ArticolCtb atrCurent : articole)
	                {
	                          //      this.articol = instanteCtb.salveazaContractMunca(atrCurent);
	                }
	                return;
	               
	        }
	                        
	}



