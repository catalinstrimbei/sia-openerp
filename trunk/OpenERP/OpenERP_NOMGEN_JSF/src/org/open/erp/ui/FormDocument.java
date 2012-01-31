package org.open.erp.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;





@ManagedBean(name="formDocument")
@SessionScoped
public class FormDocument implements Converter{

	
private static Logger logger = Logger.getLogger(FormDocument.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="NomenclatoareSrv/local", mappedName="NomenclatoareSrv/local")
	private NomenclatoareSrvLocal nomgenInstance;
	
	/* Data Model */
	private List<Document> documente= new ArrayList<Document>();
	private Document document;
	
	public Document getDocument() {
		return document;
	}


	public void setDocument(Document d) {
		logger.debug("Changed proiect : " + d.getNrDoc() + " :: " + d.getDataDocument());
		this.document = d;
		//populareModelActivitati();
	}
	
	
	
	public Map<Date, Document> getDocumente(){
		logger.debug("getdocumente : " + this.documente.size());
		Map<Date, Document> mapDocumente = new HashMap<Date, Document>();
		for (Document p: this.documente)
			mapDocumente.put(p.getDataDocument(), p);
		return mapDocumente;
	}
	
	

	
	
	
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboDocumente")){
			// StringnrDocument - to - document
			Integer nrDocumentDocument = new Integer(uival);
			Document d = new Document();
			d.setNrDoc(nrDocumentDocument);
			Integer nrDocumentx = this.documente.indexOf(d);
			return this.documente.get(nrDocumentx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboDocumente")){
			// document - to - StringnrDocument
			return ((UIComponent) uival).getId().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextDocument(){
		Integer nrDocumentx = this.documente.indexOf(this.document) + 1;
		
		logger.debug("Next document : " + nrDocumentx + " | " + this.documente.size());
		
		if (nrDocumentx > 0 && nrDocumentx < this.documente.size()){
			this.setDocument(this.documente.get(nrDocumentx));
			//populareModelActivitati();
		}
		return "FormDocument";
	}
	
	public void nextDocument(ActionEvent evt){
		nextDocument();
	}

	public void previousDocument(ActionEvent evt){
		previousDocument();
	}
	
	public String previousDocument(){
		Integer nrDocumentx = this.documente.indexOf(this.document) - 1;
		
		logger.debug("Previous document : " + nrDocumentx + " | " + this.documente.size());
		
		if (nrDocumentx >= 0 && nrDocumentx < this.documente.size()){
			this.setDocument(this.documente.get(nrDocumentx));
			//populareModelActivitati();
		}
		
		return "FormDocument";
		
	}	
	

	/* Actiuni tranzactionale*/
	public String adaugareDocument(){
		
		this.document = new Document();
		this.documente.add(this.document);
		
		return "FormDocument";
	}
	
	public boolean getDisableNext(){
		if (this.documente.indexOf(this.document) == this.documente.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareDocument() throws Exception{
		logger.debug("LOGGER Salvare document: " + this.document.getDataDocument() + "::" + this.document.getNrDoc());
		this.documente.remove(this.document);
		this.document = nomgenInstance.addDocument(document);
		this.documente.add(this.document);
		return "FormDocument";
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
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.nomgenInstance);

		 Calendar cal = Calendar.getInstance();
		   Date sdf = new Date();
		    //return sdf.format(cal.getTime());

		
		this.documente = (List<Document>) nomgenInstance.getDocumente();
		if (!documente.isEmpty())
			this.document = documente.get(0);
		else{
			System.out.println("No document available!");
			this.document = new Document();
			document.setDataDocument(sdf);
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("nrDocument".equals(uiComponent.getId())){
			System.out.println("Validare numar documente ");
			String nrDocument = uiValue.toString();
			FacesMessage mesaj = null;
			if (nrDocument == null || nrDocument.isEmpty()){
				mesaj = new FacesMessage("Numarul documentului  trebuie completat!");
			}
			System.out.println("Numar Document: " + nrDocument + ": " + nrDocument.substring(0, 1));
			
			
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
