/*package org.open.erp.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.AprovizionareSrvLocal;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.LinieCerereOferta;



@ManagedBean(name="formCerereOferta")
@SessionScoped
public class FormCerereOferta implements Converter{

	private static Logger logger = Logger.getLogger(FormCerereOferta.class.getPackage().getName());
	private static Logger logger = Logger.getLogger(FormCerereOferta.class.getPackage().getName());

	
	public FormCerereOferta() {
	super();
}


	 Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss 
	//@EJB(name="AprovizionareImpl/local", mappedName="AprovizionareImpl/local")
	private AprovizionareSrvLocal achizitiiInstance;
	
	
	 Data Model 
	public List<CerereOferta> cereri = new ArrayList<CerereOferta>();
	public CerereOferta cerereOferta;
	 
	 
	public void setCerereOferta(CerereOferta cerereOferta) {
		logger.debug("Changed CerereOferta : " + cerereOferta.getId_CerereOferta());
		this.cerereOferta = cerereOferta;
		populareModelLinii();
	}
	
	
	public Map<String, CerereOferta> getCerereOferta(){
		logger.debug("getCerereOferta : " + this.cereri.size());
		Map<String, CerereOferta> mapCereriOferta = new HashMap<String, CerereOferta>();
		for (CerereOferta c: this.cereri){
			long id = c.getId_CerereOferta();
			Integer idi	=(int)id;
			mapCereriOferta.put(idi.toString(), c);
		}
		return mapCereriOferta;
	}
	
	
	private LinieCerereOferta linie;
	
	public LinieCerereOferta getALinieCerereOferta() {
		
		logger.debug("get id: " + ((liniecerereoferta!=null)? liniecerereoferta.getIdLinieCerereOferta() : "null") );
		return liniecerereoferta;
	}

	public DataModel<LinieCerereOferta> getLiniii() {
		logger.debug("Check model linii ... ");
		if (this.linii == null)
			populareModelLinii();
		return linii;
	}
	
	private void populareModelLinii(){
		if (cerereoferta!= null){
			this.linii = new ListDataModel<CerereOferta>();
			this.linii.setWrappedData(cerereoferta.getLinii());
			logger.debug("Populare model linii ... DEBUG ");
		}else
			this.linii = null;
	}

	
	 Logica Convertor
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboCerereOferta")){
			// StringId - to - Proiect
			Integer idCerereOferta = new Integer(uival);
			int idC =idCerereOferta;
			long idCerere=(long)idC;
			CerereOferta c = new CerereOferta();
			c.setId_CerereOferta(idCerere);
			Integer idx = this.cereri.indexOf(c);
			return this.cereri.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboCerereOferta")){
			// Proiect - to - StringId
			long idCerere=((CerereOferta)uival).getId_CerereOferta();
			Integer idCerereInt=(int)idCerere;
			return idCerereInt.toString();
		}
		return null;
	}		
	 Actiuni UI Controller 
	public String nextCerereOferta(){
		Integer idx = this.cereri.indexOf(this.cerereOferta) + 1;
		
		logger.debug("Next cerereOferta : " + idx + " | " + this.cereri.size());
		
		if (idx > 0 && idx < this.cereri.size()){
			this.setCerereOferta(this.cereri.get(idx));
		}
		return "FormCerereOferta";
	}
	
	public void nextCerereOferta(ActionEvent evt){
		nextCerereOferta();
	}
	
	public void previousCerereOferta(ActionEvent evt){
		previousCerereOferta();
	}
	
	public String previousCerereOferta(){
		Integer idx = this.cereri.indexOf(this.cereri) - 1;
		
		logger.debug("Previous categorie : " + idx + " | " + this.cereri.size());
		
		if (idx >= 0 && idx < this.cereri.size()){
			this.setCerereOferta(this.cereri.get(idx));
			//populareModelActivitati();
		}
		
		return "FormCerereOferta";
		
	}
	
	 Actiuni tranzactionale
	public String adaugareCerereOferta(){
		
		this.cerereOferta = new CerereOferta();
		this.cereri.add(this.cerereOferta);
		
		return "FormCerereOferta";
	}
	
	public boolean getDisableNext(){
		if (this.cereri.indexOf(this.cerereOferta) == this.cereri.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareCerereOferta() throws Exception{
		logger.debug("LOGGER Salvare cerere oferta: " + this.cerereOferta.getId_CerereOferta() );
		this.cereri.remove(this.cerereOferta);
		this.cerereOferta = achizitiiInstance.salveazaCerereOferta(this.cerereOferta);
		this.cereri.add(this.cerereOferta);
		return "FormCerereOferta";
	}
	
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
 Initializare formularului	
	
	Strategia 1: Injectare privata EJB - referinta EJB nepartajata 
	@PostConstruct // Referinta EJB injectata este disponibila numai abua in handlerul PostConstruct, si nu la nivelul constructorului
	private void initForm() throws Exception{
		InitialContext ctx = initJBossJNDICtx();		
		achizitiiInstance = (AprovizionareSrvLocal)ctx.lookup("AprovizionareSrv/local");	
		logger.debug("PostConstruct FORM CerereOferta local-achizitii: ..." + this.achizitiiInstance);

		this.cereri = (List<CerereOferta>) achizitiiInstance.getListaCereriOferta();
		if (!cereri.isEmpty())
			this.cerereOferta = cereri.get(0);
		else{
			System.out.println("No category available!");
			this.cerereOferta = new CerereOferta();
			cerereOferta.setId_CerereOferta(0);
		}
		
	}	
	
}




	*/