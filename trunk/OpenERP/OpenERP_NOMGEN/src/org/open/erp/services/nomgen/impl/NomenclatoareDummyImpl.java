package org.open.erp.services.nomgen.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.NomenclatoareSrvRemote;
import org.open.erp.services.nomgen.PF;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.logger.NomgenLogger;
import org.open.erp.services.nomgen.impl.NomgenInterceptor;


/**
 * @author Echipa NomGen
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
@Stateful(name="NomenclatoareSrv")
@Interceptors({NomgenInterceptor.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Local(NomenclatoareSrv.class)
public class NomenclatoareDummyImpl implements  NomenclatoareSrvLocal, NomenclatoareSrvRemote {

	final static long MILLIS_PER_DAY = 24 * 3600 * 1000;
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
	NomgenLogger logger = new NomgenLogger();
	
	private RegistruDocument rd;
	private RegistruPersoana rp;
	private RegistruProdus rprod;
	private RegistruDepartament rdep;
	
	@PersistenceContext(unitName="OpenERP_NOMGEN")
	private EntityManager em;
	@Resource
	private SessionContext sessionContext;	
	
	/* Dependente resurse proprii*/
//	private static Logger logger = Logger.getLogger(NomenclatoareDummyImpl.class.getName());
	
	/* Dependente resurse injectate
	@PersistenceContext(unitName="OpenERP_NOMGEN")
	private EntityManager em;	
	@Resource
	private SessionContext sessionContext;		
	private NomenclatoareSrvLocal nomenclatoareSrv;
	private RegistruDocument rd;
	private RegistruPersoana rp;
	private RegistruProdus rprod;
	private RegistruDepartament rdep;*/
	

	/* Initializare */
	public NomenclatoareDummyImpl() { }
	@PostConstruct
	public void init(){ 
		logger.logDEBUG(">>>>>>>>>>>> Exista em? " + em);		
		//logger.debug(">>>>>>>>>>>> Exista NomenclatoareSrv? " + nomenclatoareSrv);		
		
		/*if (this.nomenclatoareSrv== null || this.rd==null || this.rp==null || this.rdep==null || this.rprod==null)
			rd = new RegistruDocument(em);
			rp = new RegistruPersoana(em);
			rprod = new RegistruProdus(em);
			rdep = new RegistruDepartament(em);*/
		
		if (this.rp == null)
			rp = new RegistruPersoana(em);
		
		if (this.rd == null)
			rd = new RegistruDocument(em);
		
		if (this.rprod == null)
			rprod = new RegistruProdus(em);
		
		if (this.rdep == null)
			rdep = new RegistruDepartament(em);
		
		
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<PersoanaFizica> getPF() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica pf = (PersoanaFizica) this.rp.getPF();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (Set<PersoanaFizica>) pf;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaFizica getPF(String idPersoana) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	PersoanaFizica of = rp.getPF(idPersoana);
	logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	
	}
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Partener> getPartener() throws Exception  {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = (Partener) rp.getPartener();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (Set<Partener>) p;
	
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Partener getPartenerDupaCodPersoana(Integer idPersoana)  throws Exception {
		
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = (Partener) rp.getPartenerDupaCodPersoana(idPersoana);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return p;
		
	}
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<PersoanaJuridica> getPJ() throws Exception{
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica p = (PersoanaJuridica) rp.getPJ();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return  (Set<PersoanaJuridica>) p;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaJuridica getPJ(String idPersoana) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana p = rp.getPJ(idPersoana);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (PersoanaJuridica) p;
	}
	@SuppressWarnings("unused")
	@Override
	public Persoana addPersoana(Persoana persoana) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana p = new Persoana();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoana(p);
			logger.logDEBUG(">>>>>>End AddPersoana");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		;
		return persoana;
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoana(Persoana persoana) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(persoana == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoana(persoana);
			logger.logDEBUG(">>>>>>End removePersoana");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoana(Persoana persoana) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(persoana == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoana(persoana);
			logger.logDEBUG(">>>>>>End removePersoana");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPersoana(persoana);
		
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addPartener(Partener partener) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = new Partener();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPartener(p);
			logger.logDEBUG(">>>>>>End AddPartener");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.addPartener(partener);
		
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePartener(Partener partener) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = new Partener();
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePartener(p);
			logger.logDEBUG(">>>>>>End removePartener");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.removePartener(partener);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPartener(Partener partener) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(partener == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPartener(partener);
			logger.logDEBUG(">>>>>>End refreshPartener");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPartener(partener);
		
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaFizica addPersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica p = new PersoanaFizica();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoanaFizica(p);
			logger.logDEBUG(">>>>>>End AddPersoanaFizica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.addPersoanaFizica(pf);
		return p;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pf == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoanaFizica(pf);
			logger.logDEBUG(">>>>>>End removePersoanaFizica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.removePersoanaFizica(pf);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pf == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoanaFizica(pf);
			logger.logDEBUG(">>>>>>End refreshPersoanaFizica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.refreshPersoanaFizica(pf);
		
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaJuridica addPersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica p = new PersoanaJuridica();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoanaJuridica(p);
			logger.logDEBUG(">>>>>>End AddPersoanaJuridica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.addPersoanaJuridica(pj);
		return p;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pj == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoanaJuridica(pj);
			logger.logDEBUG(">>>>>>End removePersoanaJuridica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.removePersoanaJuridica(pj);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pj == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoanaJuridica(pj);
			logger.logDEBUG(">>>>>>End refreshPersoanaJuridica");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPersoanaJuridica(pj);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Persoana getPersoanaDupaAdresa(String adresa) throws Exception {

		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana of = rp.getPersoanaDupaAdresa(adresa);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountPersoane() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long of = rp.getCountPersoane();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Document> getDocumente() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<Document> of = rd.getDocumente();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Document getDocumentDupaCod(String codDocument) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Document of = rd.getDocumentDupaCod(codDocument);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<LinieDocument> getLinieDocument() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<LinieDocument> of = rd.getLinieDocument();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public LinieDocument getLinieDocumentDupaCodDoc(String codDocument) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument of = rd.getLinieDocumentDupaCodDoc(codDocument);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public LinieDocument getLinieDocumentDupaMaterial(Material m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument of = rd.getLinieDocumentDupaMaterial(m);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public  Document addDocument(Document document) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		Document d = new Document();
		if(d==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rd.addDocument(d);
			logger.logDEBUG(">>>>>>End AddDocument");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		 //rd.addDocument(document);
		return d;
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addLinieDocument(LinieDocument ld) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument dl = new LinieDocument();
		if(dl==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rd.addLinieDocument(dl);
			logger.logDEBUG(">>>>>>End AddLinieDocument");
		}
		
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.addLinieDocument(dl);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeDocument(Document document) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.removeDocument(document);
			logger.logDEBUG(">>>>>>End removeDocument");
		}
		
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.removeDocument(document);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeLinieDocument(LinieDocument ld) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		if(ld == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.removeLinieDocument(ld);
			logger.logDEBUG(">>>>>>End removeLinieDocument");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.removeLinieDocument(ld);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshDocument(Document document) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.refreshDocument(document);
			logger.logDEBUG(">>>>>>End refreshDocument");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.refreshDocument(document);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshLinieDocument(LinieDocument ld) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(ld == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.refreshLinieDocument(ld);
			logger.logDEBUG(">>>>>>End refreshDocument");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rd.removeLinieDocument(ld);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Document getDocumentDupaNrDocument(String nrDocument) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Document of = rd.getDocumentDupaNrDocument(nrDocument);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountDocumente() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long of = rd.getCountDocumente();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<Produs> getProduse() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		List<Produs> of = rprod.getProduse();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void setProduse(List<Produs> produse) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(produse == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.setProduse(produse);
			logger.logDEBUG(">>>>>>End setProduse");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.setProduse(produse);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void generateRandomProduse(Integer nrProduse) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(nrProduse == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.generateRandomProduse(nrProduse);
			logger.logDEBUG(">>>>>>End generateRandomProduse");
		}
		
		
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rprod.generateRandomProduse(nrProduse);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Produs> getProduseOrdonateDupaId() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<Produs> of = rprod.getProduseOrdonateDupaId();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs getProdusDupaCod(Integer id) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs of = rprod.getProdusDupaCod(id);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<MijlocFix> getMFOrdonatbyId() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<MijlocFix> of = rprod.getMFOrdonatbyId();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public MijlocFix getMFDupaCod(Integer id) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MijlocFix of = rprod.getMFDupaCod(id);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Material> getMaterialOrdonatbyId() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<Material> of = rprod.getMaterialOrdonatbyId();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Material getMaterialDupaCod(Integer id) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Material of = rprod.getMaterialDupaCod(id);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<MateriePrima> getMPOrdonatbyId() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<MateriePrima> of = rprod.getMPOrdonatbyId();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public MateriePrima getMPDupaCod(Integer id) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MateriePrima of = rprod.getMPDupaCod(id);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs addProdus(Produs p) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs pr = new Produs();
		if(pr==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addProdus(pr);
			logger.logDEBUG(">>>>>>End AddProdus");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.addProdus(p);
		return pr;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeProdus(Produs p) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeProdus(p);
			logger.logDEBUG(">>>>>>End removeLinieDocument");
		}
		

		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.removeProdus(p);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshProdus(Produs p) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshProdus(p);
			logger.logDEBUG(">>>>>>End refreshProdus");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.refreshProdus(p);
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addMF(MijlocFix m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MijlocFix mj = new MijlocFix();
		if(mj==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMF(mj);
			logger.logDEBUG(">>>>>>End AddMijlocFix");
		}
		
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMF(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMijlocFix(MijlocFix m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMijlocFix(m);
			logger.logDEBUG(">>>>>>End removeMijlocFix");
		}
		
				
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rprod.removeMijlocFix(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMF(MijlocFix m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMF(m);
			logger.logDEBUG(">>>>>>End refreshMijlocFix");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.refreshMF(m);
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addMP(MateriePrima mp) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MateriePrima pm = new MateriePrima();
		if(pm==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMP(mp);
			logger.logDEBUG(">>>>>>End AddMateriePrima");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMP(mp);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMP(MateriePrima mp) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(mp == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMP(mp);
			logger.logDEBUG(">>>>>>End removeMijlocFix");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.removeMP(mp);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMP(MateriePrima mp) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(mp == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMP(mp);
			logger.logDEBUG(">>>>>>End refreshProdus");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.refreshMP(mp);
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Material addMaterial(Material m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Material pm = new Material();
		if(pm==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMaterial(pm);
			logger.logDEBUG(">>>>>>End AddMaterial");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMaterial(m);
		return m;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMaterial(Material m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMaterial(m);
			logger.logDEBUG(">>>>>>End removeMijlocFix");
		}
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.removeMaterial(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMaterial(Material m) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMaterial(m);
			logger.logDEBUG(">>>>>>End refreshProdus");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.refreshMaterial(m);
	}
	
	
	@Override
	public void synchronize() throws Exception {
		
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs getProdus(Integer idProdus) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs of = rprod.getProdus(idProdus);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of ;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica of = rp.cautarePersoanaFizicaDupaPrenume(nume);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica of = rp.cautarePersoanaJuridicaDupaDenumire(denumire);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs CautareProdusDupaDenumire(String denumire) throws Exception{
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs  of = rprod.CautareProdusDupaDenumire(denumire);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Departament> getDepartament() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<Departament> of = rdep.getDepartament();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Departament getDepDupaCod(Integer codDep) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Departament  of = rdep.getDepDupaCod(codDep);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@SuppressWarnings("unused")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Departament addDepartament(Departament document) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		Departament dd = new Departament();
		if(dd==null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rdep.addDepartament(dd);
			logger.logDEBUG(">>>>>>End AddMateriePrima");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rdep.addDepartament(document);
		return dd;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeDepartament(Departament document) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.logDEBUG(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rdep.removeDepartament(document);
			logger.logDEBUG(">>>>>>End removeDepartament");
		}
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rdep.removeDepartament(document);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Departament getDepartamentDupaDenumire(String den) throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Departament  of = rdep.getDepartamentDupaDenumire(den);
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountDepartament() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long  of = rdep.getCountDepartament();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Set<Persoana> getPersoana() throws Exception {
		logger.logDEBUG(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		List<Persoana> of = (List<Persoana>) rp.getPersoana();
		logger.logDEBUG(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (Set<Persoana>) of ;
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public PF crearePF( String  nume, String  prenume, String  formaAdresare, char   gen, String  cnp, Persoana p) throws Exception {
		
		logger.logDEBUG(">>>>>>>>>>>> START Creare PF >>>>>>>>>>>>>>> ");	
		
		PersoanaFizica pf = new PersoanaFizica(nume, prenume,formaAdresare, gen, cnp);
		p.adaugaPF(pf);
		pf.setP(p);
		
		/* 1. Direct activitate */
		//activitate = this.registruProiect.salveazaActivitateBugetata(activitate);
		//logger.debug(">>>>>>>>>>>> Activitate salvata direct >>>>>>>>>>>>>>>");
		
		/* 2. Mod agregat - cascadare @OneoMany */
		this.rp.addPersoana(p);
		logger.logDEBUG(">>>>>>>>>>>> Activitate salvata in agregat proiect >>>>>>>>>>>>>>>");
		
		logger.logDEBUG(">>>>>>>>>>>> END Creare activitate >>>>>>>>>>>>>>>");
		return pf;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	
	
	
	
	
	
