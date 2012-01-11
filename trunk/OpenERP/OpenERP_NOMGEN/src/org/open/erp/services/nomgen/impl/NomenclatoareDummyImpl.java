package org.open.erp.services.nomgen.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;


import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.NomenclatoareSrvRemote;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.RegistruDepartament;
import org.open.erp.services.nomgen.RegistruDocument;
import org.open.erp.services.nomgen.RegistruPersoana;
import org.open.erp.services.nomgen.RegistruProdus;

/**
 * @author Echipa NomGen
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
@Stateful(name="NomenclatoareSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Local(NomenclatoareSrv.class)
public class NomenclatoareDummyImpl implements NomenclatoareSrv, NomenclatoareSrvRemote, NomenclatoareSrvLocal {

	
	/* Dependente resurse proprii*/
	private static Logger logger = Logger.getLogger(NomenclatoareDummyImpl.class.getName());
	
	/* Dependente resurse injectate*/
	@PersistenceContext(unitName="OpenERP_NOMGEN")
	private EntityManager em;	
	@Resource
	private SessionContext sessionContext;		
	private NomenclatoareSrvLocal nomenclatoareSrv;
	private RegistruDocument rd;
	private RegistruPersoana rp;
	private RegistruProdus rprod;
	private RegistruDepartament rdep;
	

	/* Initializare */
	public NomenclatoareDummyImpl() { }
	@PostConstruct
	public void init(){ 
		logger.debug(">>>>>>>>>>>> Exista em? " + em);		
		logger.debug(">>>>>>>>>>>> Exista NomenclatoareSrv? " + nomenclatoareSrv);		
		
		if (this.nomenclatoareSrv== null || this.rd==null || this.rp==null || this.rdep==null || this.rprod==null)
			rd = new RegistruDocument(em);
			rp = new RegistruPersoana(em);
			rprod = new RegistruProdus(em);
			rdep = new RegistruDepartament(em);
	}
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<PersoanaFizica> getPF() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica pf = (PersoanaFizica) this.rp.getPF();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (Set<PersoanaFizica>) pf;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaFizica getPF(String idPersoana) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	PersoanaFizica of = rp.getPF(idPersoana);
	logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Partener> getPartener() throws Exception  {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = (Partener) rp.getPartener();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (Set<Partener>) p;
	
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Partener getPartenerDupaCodPersoana(String idPersoana)  throws Exception {
		
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = (Partener) rp.getPartenerDupaCodPersoana(idPersoana);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return p;
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<PersoanaJuridica> getPJ() throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica p = (PersoanaJuridica) rp.getPJ();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return  (Set<PersoanaJuridica>) p;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaJuridica getPJ(String idPersoana) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana p = rp.getPJ(idPersoana);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return (PersoanaJuridica) p;
	}
	@Override
	public void addPersoana(Persoana persoana) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana p = new Persoana();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoana(p);
			logger.debug(">>>>>>End AddPersoana");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		;
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoana(Persoana persoana) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(persoana == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoana(persoana);
			logger.debug(">>>>>>End removePersoana");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoana(Persoana persoana) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(persoana == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoana(persoana);
			logger.debug(">>>>>>End removePersoana");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPersoana(persoana);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addPartener(Partener partener) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = new Partener();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPartener(p);
			logger.debug(">>>>>>End AddPartener");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.addPartener(partener);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePartener(Partener partener) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Partener p = new Partener();
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePartener(p);
			logger.debug(">>>>>>End removePartener");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.removePartener(partener);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPartener(Partener partener) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(partener == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPartener(partener);
			logger.debug(">>>>>>End refreshPartener");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPartener(partener);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addPersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica p = new PersoanaFizica();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoanaFizica(p);
			logger.debug(">>>>>>End AddPersoanaFizica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.addPersoanaFizica(pf);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pf == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoanaFizica(pf);
			logger.debug(">>>>>>End removePersoanaFizica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.removePersoanaFizica(pf);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoanaFizica(PersoanaFizica pf) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pf == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoanaFizica(pf);
			logger.debug(">>>>>>End refreshPersoanaFizica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.refreshPersoanaFizica(pf);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addPersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica p = new PersoanaJuridica();
		if(p==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rp.addPersoanaJuridica(p);
			logger.debug(">>>>>>End AddPersoanaJuridica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.addPersoanaJuridica(pj);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removePersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pj == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.removePersoanaJuridica(pj);
			logger.debug(">>>>>>End removePersoanaJuridica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rp.removePersoanaJuridica(pj);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshPersoanaJuridica(PersoanaJuridica pj) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(pj == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rp.refreshPersoanaJuridica(pj);
			logger.debug(">>>>>>End refreshPersoanaJuridica");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rp.refreshPersoanaJuridica(pj);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Persoana getPersoanaDupaAdresa(String adresa) throws Exception {

		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Persoana of = rp.getPersoanaDupaAdresa(adresa);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountPersoane() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long of = rp.getCountPersoane();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Document> getDocumente() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<Document> of = rd.getDocumente();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Document getDocumentDupaCod(String codDocument) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Document of = rd.getDocumentDupaCod(codDocument);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<LinieDocument> getLinieDocument() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<LinieDocument> of = rd.getLinieDocument();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public LinieDocument getLinieDocumentDupaCodDoc(String codDocument) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument of = rd.getLinieDocumentDupaCodDoc(codDocument);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public LinieDocument getLinieDocumentDupaMaterial(Material m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument of = rd.getLinieDocumentDupaMaterial(m);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addDocument(Document document) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		Document d = new Document();
		if(d==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rd.addDocument(d);
			logger.debug(">>>>>>End AddDocument");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		 //rd.addDocument(document);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addLinieDocument(LinieDocument ld) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		LinieDocument dl = new LinieDocument();
		if(dl==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rd.addLinieDocument(dl);
			logger.debug(">>>>>>End AddLinieDocument");
		}
		
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.addLinieDocument(dl);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeDocument(Document document) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.removeDocument(document);
			logger.debug(">>>>>>End removeDocument");
		}
		
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.removeDocument(document);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeLinieDocument(LinieDocument ld) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		if(ld == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.removeLinieDocument(ld);
			logger.debug(">>>>>>End removeLinieDocument");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.removeLinieDocument(ld);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshDocument(Document document) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.refreshDocument(document);
			logger.debug(">>>>>>End refreshDocument");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rd.refreshDocument(document);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshLinieDocument(LinieDocument ld) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(ld == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rd.refreshLinieDocument(ld);
			logger.debug(">>>>>>End refreshDocument");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rd.removeLinieDocument(ld);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Document getDocumentDupaNrDocument(String nrDocument) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Document of = rd.getDocumentDupaNrDocument(nrDocument);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountDocumente() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long of = rd.getCountDocumente();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<Produs> getProduse() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		List<Produs> of = rprod.getProduse();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void setProduse(List<Produs> produse) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(produse == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.setProduse(produse);
			logger.debug(">>>>>>End setProduse");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.setProduse(produse);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void generateRandomProduse(Integer nrProduse) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(nrProduse == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.generateRandomProduse(nrProduse);
			logger.debug(">>>>>>End generateRandomProduse");
		}
		
		
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rprod.generateRandomProduse(nrProduse);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Produs> getProduseOrdonateDupaId() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<Produs> of = rprod.getProduseOrdonateDupaId();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs getProdusDupaCod(Integer id) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs of = rprod.getProdusDupaCod(id);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<MijlocFix> getMFOrdonatbyId() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<MijlocFix> of = rprod.getMFOrdonatbyId();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public MijlocFix getMFDupaCod(Integer id) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MijlocFix of = rprod.getMFDupaCod(id);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Material> getMaterialOrdonatbyId() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<Material> of = rprod.getMaterialOrdonatbyId();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Material getMaterialDupaCod(Integer id) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Material of = rprod.getMaterialDupaCod(id);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<MateriePrima> getMPOrdonatbyId() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Collection<MateriePrima> of = rprod.getMPOrdonatbyId();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public MateriePrima getMPDupaCod(Integer id) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MateriePrima of = rprod.getMPDupaCod(id);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addProdus(Produs p) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs pr = new Produs();
		if(pr==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addProdus(pr);
			logger.debug(">>>>>>End AddProdus");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.addProdus(p);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeProdus(Produs p) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeProdus(p);
			logger.debug(">>>>>>End removeLinieDocument");
		}
		

		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.removeProdus(p);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshProdus(Produs p) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(p == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshProdus(p);
			logger.debug(">>>>>>End refreshProdus");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.refreshProdus(p);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addMF(MijlocFix m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MijlocFix mj = new MijlocFix();
		if(mj==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMF(mj);
			logger.debug(">>>>>>End AddMijlocFix");
		}
		
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMF(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMijlocFix(MijlocFix m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMijlocFix(m);
			logger.debug(">>>>>>End removeMijlocFix");
		}
		
				
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rprod.removeMijlocFix(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMF(MijlocFix m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMF(m);
			logger.debug(">>>>>>End refreshMijlocFix");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		//rprod.refreshMF(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addMP(MateriePrima mp) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		MateriePrima pm = new MateriePrima();
		if(pm==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMP(mp);
			logger.debug(">>>>>>End AddMateriePrima");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMP(mp);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMP(MateriePrima mp) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(mp == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMP(mp);
			logger.debug(">>>>>>End removeMijlocFix");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.removeMP(mp);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMP(MateriePrima mp) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(mp == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMP(mp);
			logger.debug(">>>>>>End refreshProdus");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.refreshMP(mp);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addMaterial(Material m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Material pm = new Material();
		if(pm==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rprod.addMaterial(pm);
			logger.debug(">>>>>>End AddMaterial");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.addMaterial(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeMaterial(Material m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.removeMaterial(m);
			logger.debug(">>>>>>End removeMijlocFix");
		}
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.removeMaterial(m);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void refreshMaterial(Material m) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(m == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rprod.refreshMaterial(m);
			logger.debug(">>>>>>End refreshProdus");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rprod.refreshMaterial(m);
	}
	
	
	@Override
	public void synchronize() throws Exception {
		
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs getProdus(Integer idProdus) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs of = rprod.getProdus(idProdus);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of ;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaFizica of = rp.cautarePersoanaFizicaDupaPrenume(nume);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		PersoanaJuridica of = rp.cautarePersoanaJuridicaDupaDenumire(denumire);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs CautareProdusDupaDenumire(String denumire) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Produs  of = rprod.CautareProdusDupaDenumire(denumire);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Set<Departament> getDepartament() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Set<Departament> of = rdep.getDepartament();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Departament getDepDupaCod(Integer codDep) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Departament  of = rdep.getDepDupaCod(codDep);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addDepartament(Departament document) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
		Departament dd = new Departament();
		if(dd==null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else 
		{
			this.rdep.addDepartament(dd);
			logger.debug(">>>>>>End AddMateriePrima");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		rdep.addDepartament(document);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void removeDepartament(Departament document) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		if(document == null)
		{
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		else
		{
			this.rdep.removeDepartament(document);
			logger.debug(">>>>>>End removeDepartament");
		}
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
	//	rdep.removeDepartament(document);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Departament getDepartamentDupaDenumire(String den) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Departament  of = rdep.getDepartamentDupaDenumire(den);
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Long getCountDepartament() throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		Long  of = rdep.getCountDepartament();
		logger.debug(" End >> " + Thread.currentThread().getStackTrace()[2].getMethodName());
		return of;
	}
	
	}

	
	
	
	
	
	
	
