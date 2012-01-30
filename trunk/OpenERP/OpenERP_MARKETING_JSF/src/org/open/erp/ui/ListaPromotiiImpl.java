package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;
import org.open.erp.services.marketing.Promotie;



//@ManagedBean(name="formPromotii")
@SessionScoped
public class ListaPromotiiImpl implements Converter{

	
	private Promotie promotie;
	private List<Promotie> promotii = new ArrayList<Promotie>();
	private Map<String, Integer> tipuriPromotie = new HashMap<String, Integer>();
	private Logger logger;
	private Integer tipPromotie = 1;
	
	@EJB(mappedName="MarketingManagementSrvRemote/local", name="MarketingManagementSrvRemote/local") 
	private MarketingManagementSrvLocal marketingSrv;
	
	@PostConstruct
	public void initListaPromotii() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(ListaPromotiiImpl.class.getName());
		
		promotii = (List<Promotie>) marketingSrv.getListaPromotii();
		if (!promotii.isEmpty())
			promotie = promotii.get(0);
		else{
			System.out.println("Nu exista nicio promotie!!!");
			this.promotie = new Promotie();
			promotie.setDenumirePromotie("Promotie noua");
		}
	}

	public Promotie getPromotie() {
		return promotie;
	}

	/**
	 * @param tipPromotie the tipPromotie to set
	 */
	public void setTipPromotie(Integer tipPromotie) {
		this.tipPromotie = tipPromotie;
	}

	public void setPromotie(Promotie promotie) {
		this.promotie = promotie;
	}
	
	public List<Promotie> getListPromotii(){
		return this.promotii;
	}
	
	public Map<String, Promotie> getPromotii(){
		logger.info("getPromotii : " + this.promotii.size());
		Map<String, Promotie> mapPromotii = new HashMap<String, Promotie>();
		for (Promotie p: promotii){
			logger.info("<<<<<<Map getPromotii:" + p.getDenumirePromotie());
			mapPromotii.put(p.getDenumirePromotie() + " " + p.getMesajPromotional() + " | " + p.getIdPromotie(), p);
		}
		return mapPromotii;
	} 
	/**
	 * @return the tipuriPromotie
	 */
	public Map<String, Integer> getTipuriPromotie() {
		tipuriPromotie.put("Discount",1);
    	tipuriPromotie.put("ProduseAditionale",2);
		return tipuriPromotie;
	}

	/**
	 * @param tipuriPromotie the tipuriPromotie to set
	 */
	public void setTipuriPromotie(Map<String, Integer> tipuriPromotie) {
		this.tipuriPromotie = tipuriPromotie;
	}

	public void setPromotii(List<Promotie> _promotii) {
		this.promotii = _promotii;
	}

	/* Implementare navigare */
	public void PromotieAnterioara(ActionEvent evt){
		logger.info("am intrat in anterioara");
		Integer idxCurent = this.promotii.indexOf(promotie);
		if (idxCurent > 0)
			this.promotie = this.promotii.get(idxCurent - 1);
	}

	public void PromotieUrmatoare(ActionEvent evt){
		logger.info("am intrat in urmatoare");
		Integer idxCurent = this.promotii.indexOf(promotie);
		if ((idxCurent+1) < this.promotii.size())
			this.promotie = this.promotii.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista, dar inainte de setLuna
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.info("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboPromotie")){
			logger.info("Am itrat in index");
			Integer idx = 0;
			Promotie uipromotieTemplate= new Promotie();
			uipromotieTemplate.setIdPromotie(Integer.valueOf(uiValue));
			//in personal nu am metoda equals
//			for (Promotie p : promotii)
//			{
//				if (p.getIdPromotie().toString().matches(uiValue))//equals(Integer.parseInt(uiValue)))
//				{
//					idx = this.promotii.indexOf(p);
//				}
//			}
			if (promotii.contains(uipromotieTemplate))
			{
				idx = this.promotii.indexOf(uipromotieTemplate);	
			}
			else
			{
				logger.info("Nu s-a gasit promotia");
				idx = this.promotii.indexOf(promotie);
			}
			logger.info("Id promotie noua este : " + idx);
			return this.promotii.get(idx);
		} 
		//}
		return null;
	}

	// operatie invocata la generare elemente pentru lista, 
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboPromotie")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			Promotie uiPromotie = (Promotie)uiValue;
			logger.info("<<<<<<<<<< getAsString uiValue promotie:"+uiPromotie.getDenumirePromotie() + " id: " + uiPromotie.getIdPromotie());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiPromotie.getIdPromotie()!=null)
				return uiPromotie.getIdPromotie().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugarePromotie(ActionEvent evt){
		this.promotie = new Promotie();
		try {
			promotie = marketingSrv.salveazaPromotie(promotie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.promotii.add(this.promotie);
		  
	}  
	  /*

	 */
	public void salvarePromotie(ActionEvent evt) throws Exception{
		
		this.promotie = marketingSrv.salveazaPromotie(this.promotie);
		this.promotii.add(this.promotie);
	}

	public ListaPromotiiImpl() {
		super();
	}		
}
