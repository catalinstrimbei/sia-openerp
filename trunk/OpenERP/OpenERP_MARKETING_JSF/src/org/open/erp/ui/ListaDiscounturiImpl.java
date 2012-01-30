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
import org.open.erp.services.marketing.Discount;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;



//@ManagedBean(name="formDiscounturi")
@SessionScoped
public class ListaDiscounturiImpl implements Converter {
	private Discount discount;
	private List<Discount> discounturi = new ArrayList<Discount>();
	private Map<String, Integer> tipuriDiscount = new HashMap<String, Integer>();
	private Logger logger;
	private Integer tipDiscount = 1;
	
	@EJB(mappedName="MarketingManagementSrvRemote/local", name="MarketingManagementSrvRemote/local") 
	private MarketingManagementSrvLocal marketingSrv;
	
	@PostConstruct
	public void initListaDiscounturi() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(ListaDiscounturiImpl.class.getName());
		
		discounturi = (List<Discount>) marketingSrv.getListaDiscounturi();
		if (!discounturi.isEmpty())
			discount = discounturi.get(0);
		else{
			System.out.println("Nu exista nici un discount!!!");
			this.discount = new Discount();
			discount.setDenumirediscount("Discount nou");
		}
	}

	public Discount getDiscount() {
		return discount;
	}

	
	public void setTipDiscount(Integer tipDiscount) {
		this.tipDiscount = tipDiscount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public List<Discount> getListDiscounturi(){
		return this.discounturi;
	}
	
	public Map<String, Discount> getDiscounturi(){
		logger.info("getDiscounturi : " + this.discounturi.size());
		Map<String, Discount> mapDiscounturi = new HashMap<String, Discount>();
		for (Discount d: discounturi){
			logger.info("<<<<<<Map getDiscounturi:" + d.getDenumireDiscount());
			mapDiscounturi.put(d.getDenumireDiscount() + " " + d.getValoare() + " | " + d.getIdDiscount(), d);
		}
		return mapDiscounturi;
	} 
	/**
	 * @return the tipuriDiscount
	 */
	public Map<String, Integer> getTipuriDiscount() {
		tipuriDiscount.put("Procent",1);
		tipuriDiscount.put("Valoare neta",2);
		return tipuriDiscount;
	}

	/**
	 * @param tipuriDiscount the tipuriDiscount to set
	 */
	public void setTipuriDiscount(Map<String, Integer> tipuriDiscount) {
		this.tipuriDiscount = tipuriDiscount;
	}

	public void setDiscounturi(List<Discount> _discounturi) {
		this.discounturi = _discounturi;
	}

	/* Implementare navigare */
	public void DiscountAnterior(ActionEvent evt){
		logger.info("acesta este discountul anterior");
		Integer idxCurent = this.discounturi.indexOf(discount);
		if (idxCurent > 0)
			this.discount = this.discounturi.get(idxCurent - 1);
	}

	public void DiscountUrmator(ActionEvent evt){
		logger.info("acesta este discountul urmator");
		Integer idxCurent = this.discounturi.indexOf(discount);
		if ((idxCurent+1) < this.discounturi.size())
			this.discount = this.discounturi.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista, dar inainte de setLuna
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.info("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboDiscount")){
			logger.info("Am intrat in index");
			Integer idx = 0;
			Discount uidiscountTemplate= new Discount();
			uidiscountTemplate.setIdDiscount(Integer.valueOf(uiValue));
			if (discounturi.contains(uidiscountTemplate))
			{
				idx = this.discounturi.indexOf(uidiscountTemplate);	
			}
			else
			{
				logger.info("Nu s-a gasit discountul");
				idx = this.discounturi.indexOf(discount);
			}
			logger.info("Id-ul discountului nou este : " + idx);
			return this.discounturi.get(idx);
		} 
		//}
		return null;
	}

	// operatie invocata la generare elemente pentru lista 
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboDiscount")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			Discount uiDiscount = (Discount)uiValue;
			logger.info("<<<<<<<<<< getAsString uiValue promotie:"+uiDiscount.getDenumireDiscount() + " id: " + uiDiscount.getIdDiscount());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiDiscount.getIdDiscount()!=null)
				return uiDiscount.getIdDiscount().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugareDiscount(ActionEvent evt){
		this.discount = new Discount();
		try {
			discount = marketingSrv.salveazaDiscount(discount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.discounturi.add(this.discount);
		  
	}  
	  /*

	 */
	public void salvareDiscount(ActionEvent evt) throws Exception{
		
		this.discount = marketingSrv.salveazaDiscount(this.discount);
		this.discounturi.add(this.discount);
	}

	public ListaDiscounturiImpl() {
		super();
	}
	
}
