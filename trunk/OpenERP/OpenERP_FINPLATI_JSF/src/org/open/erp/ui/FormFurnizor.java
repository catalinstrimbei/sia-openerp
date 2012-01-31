package org.open.erp.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.plati.DummyFurnizor;
/*import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipPlata;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.plati.exceptions.PlatiExceptions;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.ExtrasCont;
import org.open.erp.services.plati.FacturaPrimita;*/
import org.open.erp.services.plati.FinPlatiSrv;
/*import org.open.erp.services.plati.FinPlatiSrvLocal;
import org.open.erp.services.plati.FinPlatiSrvRemote;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.Plata;*/
//import org.open.erp.services.achizitii.AprovizionareSrv;

@ManagedBean(name="FormInregistrareChitanta")
@SessionScoped
public class FormFurnizor implements Converter {
	
private static Logger logger = Logger.getLogger(FormFurnizor.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="FinplatiSrv", mappedName="FinplatiSrv")
	private FinPlatiSrv finplatiinstance;
	
	private List<DummyFurnizor> furnizori = new ArrayList<DummyFurnizor>();
	private DummyFurnizor furnizor;
	
	public void setFurnizor(DummyFurnizor c) {
		logger.debug("Changed proiect : " + c.getDenumire() + " :: " + c.getTelefon());
		this.furnizor = c;
		//populareModelActivitati();
	}
	
	public Map<String, DummyFurnizor> getFurnizori(){
		logger.debug("getFurnizori : " + this.furnizori.size());
		Map<String, DummyFurnizor> mapFurnizori = new HashMap<String, DummyFurnizor>();
		for (DummyFurnizor c: this.furnizori)
			mapFurnizori.put(c.getDenumire(), c);
		return mapFurnizori;
	}
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboFurnizori")){
		
			Integer setIdFurnizor = new Integer(uival);
			DummyFurnizor c = new DummyFurnizor();
			c.setIdFurnizor(setIdFurnizor);
			Integer idx = this.furnizori.indexOf(c);
			return this.furnizori.get(idx);
		}
		return null;
	}
	
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboFurnizori")){
			
			return ((DummyFurnizor)uival).getCUI().toString();
		}
		return null;
	}
	
	/*--- Utils: InitialContext Furnizor EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	/* Initializare formularului*/	
	
	/*Strategia 1: Injectare privata EJB - referinta EJB nepartajata */
	@PostConstruct 
	private void initForm() throws Exception{
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.finplatiinstance);

		this.furnizori = (List<DummyFurnizor>) finplatiinstance.getfurnizor();
		if (!furnizori.isEmpty())
			this.furnizor = furnizori.get(0);
		else{
			System.out.println("Nici un furnizor nu este disponibil!");
			this.furnizor = new DummyFurnizor();
			furnizor.setAdresa("Adresa....");
		}
		
	}
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("id".equals(uiComponent.getId())){
			System.out.println("Validare id furnizor");
			String idFurnizor = uiValue.toString();
			FacesMessage mesaj = null;
			if (idFurnizor == null || idFurnizor.isEmpty()){
				mesaj = new FacesMessage("Idul furnizorilui trebuie completat!");
			}
			System.out.println("Id: " + idFurnizor + ": " + idFurnizor.substring(0, 1));
			
			
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
