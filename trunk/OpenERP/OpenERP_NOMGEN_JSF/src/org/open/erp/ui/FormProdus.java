package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.Produs;

@ManagedBean(name="formProdus")
@SessionScoped
public class FormProdus implements Converter{
	
private static Logger logger = Logger.getLogger(FormPersoana.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="NomenclatoareSrv", mappedName="NomenclatoareSrv")
	private NomenclatoareSrv nomgenInstance;
	
	/* Data Model */
	private List<Produs> produse = new ArrayList<Produs>();
	private Produs produs;
	
	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs p) {
		logger.debug("Changed proiect : " + p.getDenumire() + " :: " + p.getUnitateMasura());
		this.produs = p;
		//populareModelActivitati();
	}
	
	
	public Map<String, Produs> getProduse(){
		logger.debug("getPersoane : " + this.produse.size());
		Map<String, Produs> mapProduse = new HashMap<String, Produs>();
		for (Produs p: this.produse)
			mapProduse.put(p.getDenumire(), p);
		return mapProduse;
	}
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboPersoane")){
			// StringId - to - produs
			String denumire = new String(uival);
			//Integer idPersoana = new Integer(uival);
			Produs p = new Produs();
			p.setDenumire(denumire);
			Integer idx = this.produse.indexOf(p);
			return this.produse.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboProduse")){
			// produs - to - StringId
			return ((Produs)uival).getDenumire().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextProdus(){
		Integer idx = this.produse.indexOf(this.produs) + 1;
		
		logger.debug("Next produs : " + idx + " | " + this.produse.size());
		
		if (idx > 0 && idx < this.produse.size()){
			this.setProdus(this.produse.get(idx));
			//populareModelActivitati();
		}
		return "FormPersoana";
	}
	
	public void nextProdus(ActionEvent evt){
		nextProdus();
	}

	public void previousProdus(ActionEvent evt){
		previousProdus();
	}
	
	public String previousProdus(){
		Integer idx = this.produse.indexOf(this.produs) - 1;
		
		logger.debug("Previous produs : " + idx + " | " + this.produse.size());
		
		if (idx >= 0 && idx < this.produse.size()){
			this.setProdus(this.produse.get(idx));
			//populareModelActivitati();
		}
		
		return "FormProdus";
		
	}	
	
	
	
	/* Actiuni tranzactionale*/
	public String adaugareProdus(){
		
		this.produs = new Produs();
		this.produse.add(this.produs);
		
		return "FormProdus";
	}
	
	public boolean getDisableNext(){
		if (this.produse.indexOf(this.produs) == this.produse.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvarePersoana() throws Exception{
		logger.debug("LOGGER Salvare produs: " + this.produs.getDenumire() + "::" + this.produs.getUnitateMasura());
		this.produse.remove(this.produs);
		this.produs = (Produs) nomgenInstance.addProdus(produs);
		this.produse.add(this.produs);
		return "FormProdus";
	}
	
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	/* Initializare formularului*/	
	
	/*Strategia 1: Injectare privata EJB - referinta EJB nepartajata */
	@PostConstruct // Referinta EJB injectata este disponibila numai abua in handlerul PostConstruct, si nu la nivelul constructorului
	private void initForm() throws Exception{
		logger.debug("PostConstruct FORM PRODUSE local-nomgen: ..." + this.nomgenInstance);

		this.produse = (List<Produs>) nomgenInstance.getProduse();
		if (!produse.isEmpty())
			this.produs = produse.get(0);
		else{
			System.out.println("No person available!");
			this.produs = new Produs();
			produs.setDenumire("Denumire....");
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("id".equals(uiComponent.getId())){
			System.out.println("Validare id persoana");
			String id = uiValue.toString();
			FacesMessage mesaj = null;
			if (id == null || id.isEmpty()){
				mesaj = new FacesMessage("Idul persoanei trebuie completat!");
			}
			System.out.println("Id: " + id + ": " + id.substring(0, 1));
			
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}

	/* Faces Logic - procesare erori business*/
	private void ridicaEroare(String mesaj, Boolean anulareTranzactie){
		// Cocepere mesaj
		FacesMessage facesMsg = 
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + mesaj, null);			
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// Afisare mesaj
		fc.addMessage(null, facesMsg);
		fc.renderResponse();
		
	}
	
	
	
	
	
}
