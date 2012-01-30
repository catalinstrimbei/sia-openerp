package org.open.erp.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import org.open.erp.services.ctbgen.LunaLucru;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegLuniLucru;


//@ManagedBean(name="formluni")
//@SessionScoped
public class FormLuna implements Converter{
	private List<LunaLucru> luni = new ArrayList<LunaLucru>();
	private LunaLucru lunaCurenta;// = null;
	private RegLuniLucru rl;
		
	public List<LunaLucru> getLuniList() {
		return luni;
	}
	

	public void setLuni(List<LunaLucru> luni) {
		this.luni = luni;
	}

	@EJB(name = "ContabilizareSrv/local", mappedName="ContabilizareSrv/local")
	private ContabilizareSrv contabSrv;
	
	
	@PostConstruct
	public void init() throws Exception{

		
		rl = contabSrv.getRegLuniLucru();
		luni = rl.getLuniLucru();
		if (!luni.isEmpty())
			this.lunaCurenta = luni.get(0);
		else
			this.lunaCurenta = new LunaLucru();
	}

//	public Integer getluniCount() {
//		return luni.size();
//	}

	public Map<String, LunaLucru> getLuni() {
		Map<String, LunaLucru> luniMap = new LinkedHashMap<String, LunaLucru>();
		if (this.luni != null && !this.luni.isEmpty()) {
			for (LunaLucru c : this.luni) {
				luniMap.put(c.toString(), c);
			}
		}
		return luniMap;
	}

	public LunaLucru getLunaCurenta() {
		return lunaCurenta;
	}
	

	public void setLunaCurenta(LunaLucru lunaCurenta) {
		this.lunaCurenta = lunaCurenta;
	}

	public String previous2() {
		
		Integer idCurrentItem = this.luni.indexOf(lunaCurenta);
		if (idCurrentItem > 0)
			this.lunaCurenta = this.luni.get(idCurrentItem -1 );
		return "Form";
	}

	public String next2() {
		
		Integer idCurrentItem = this.luni.indexOf(lunaCurenta);
		if (idCurrentItem + 1 < this.luni.size())
			this.lunaCurenta = this.luni.get(idCurrentItem + 1);
		return "Form";
	}
//////////////////////////////////////////////////////
	
	/* Actiuni UI Controller */

	
	public void next(ActionEvent evt){
		next2();
	}

	public void previous(ActionEvent evt){
		previous2();
	}


	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}


}
	
/////////////////////////////////////////////////////////////////	
//	public void adaugare(ActionEvent p0) {
//		logger.debug("luni_form - adaugare()");
//		contCurent = new LunaLucru();
////		contCurent.setIdCont(9999);
//		contCurent.setSimbolCont("new..");
//		contCurent.setTipCont(TipCont.ACTIV);
//		contCurent.setTipSintetic(StatusSintetic.ANALITIC);
//		//this.luni.add(contCurent);
//	}
//
//	public void stergere(ActionEvent p0) {
//		logger.debug("luni_form - stergere()");
//		//TODO: nema remove cont
//		contabSrv.stergeCont(contCurent);
//		FacesMessage mesaj = null;
//		mesaj = new FacesMessage("Am sters " + contCurent.toString());
//		FacesContext.getCurrentInstance().addMessage("Stergere cont:",mesaj);	
//		if (!this.luni.isEmpty())
//			this.contCurent = this.luni.get(0);
//		else
//			this.contCurent = null;
//	}
//
//	public void abandon(ActionEvent p0) {
//		logger.debug("luni_form - abandon()");
//		
//	}
//	
//	
//	public void salveaza(ActionEvent p0) {
////		logger.debug("luni_form - salveaza()");
////		this.rl.addCont(this.contCurent);
////		this.luni.add(this.contCurent);
//		
//		//this.luni.remove(this.contCurent);
//		this.contCurent = contabSrv.crearePlanCont(contCurent.getDenCont(), contCurent.getSimbolCont(), contCurent.getClasaCont(),StatusSintetic.ANALITIC , luni.get(20), TipCont.ACTIV);
//		this.luni.add(this.contCurent);
//		//return "FormProiecte";
//		FacesMessage mesaj = null;
//		mesaj = new FacesMessage("Am salvat contul " + contCurent.toString());
//		FacesContext.getCurrentInstance().addMessage("Salvare cont:",mesaj);
//	}
//
//    @Override
//    public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
//          
//            if (uiComp.getId().equals("cboluni")){
//            	LunaLucru uiInregTemplate = new LunaLucru();
//            	uiInregTemplate.setIdCont(Integer.valueOf(uiValue));
//                Integer idx = this.luni.indexOf(uiInregTemplate);
//                                      
//                    return this.luni.get(idx);
//            } 
//            return null;
//    }
//
//    @Override
//    public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {              
//            if (uiComp.getId().equals("cboluni")){
//            	LunaLucru contStr = (LunaLucru)uiValue;
//                   
//                    if (contStr.getIdCont()!=null)
//                            return contStr.getIdCont().toString();
//            }
//            return null;
//    }
//}
