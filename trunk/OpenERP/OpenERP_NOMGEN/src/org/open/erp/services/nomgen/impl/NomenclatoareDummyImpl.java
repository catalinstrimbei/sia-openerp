package org.open.erp.services.nomgen.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateful;

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
@Stateful
//@Local(NomenclatoareSrv.class)
public class NomenclatoareDummyImpl implements NomenclatoareSrv, NomenclatoareSrvRemote, NomenclatoareSrvLocal {

	
	/* Dependente resurse proprii*/
	private static Logger logger = Logger.getLogger(NomenclatoareDummyImpl.class.getName());
	
	/* Dependente resurse injectate*/
	@PersistenceContext(unitName="OpenERP_NOMGEN")
	private EntityManager em;	
	@Resource(mappedName="NomenclatoareSrv")
	//private SessionContext sessionContext;		
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
		
		if (this.nomenclatoareSrv== null)
			rd = new RegistruDocument(em);
			rp = new RegistruPersoana(em);
			rprod = new RegistruProdus(em);
			rdep = new RegistruDepartament(em);
	}
	@Override
	public Set<PersoanaFizica> getPF() {
		return rp.getPF();
		
	}
	@Override
	public PersoanaFizica getPF(String idPersoana) {
		return rp.getPF(idPersoana);
	
	}
	@Override
	public Set<Partener> getPartener() {
		return rp.getPartener();
	
	}
	@Override
	public Partener getPartenerDupaCodPersoana(String idPersoana) {
		return rp.getPartenerDupaCodPersoana(idPersoana);
		
	}
	@Override
	public Set<PersoanaJuridica> getPJ() {
		
		return  rp.getPJ();
	}
	@Override
	public PersoanaJuridica getPJ(String idPersoana) {

		return rp.getPJ(idPersoana);
	}
	@Override
	public void addPersoana(Persoana persoana) {
		return;
		
	}
	@Override
	public void removePersoana(Persoana persoana) {
		rp.removePersoana(persoana);
		
	}
	@Override
	public void refreshPersoana(Persoana persoana) {
		rp.refreshPersoana(persoana);
		
	}
	@Override
	public void addPartener(Partener partener) {
		rp.addPartener(partener);
		
	}
	@Override
	public void removePartener(Partener partener) {
		rp.removePartener(partener);
		
	}
	@Override
	public void refreshPartener(Partener partener) {
		rp.refreshPartener(partener);
		
	}
	@Override
	public void addPersoanaFizica(PersoanaFizica pf) {
		rp.addPersoanaFizica(pf);
		
	}
	@Override
	public void removePersoanaFizica(PersoanaFizica pf) {
		rp.removePersoanaFizica(pf);
		
	}
	@Override
	public void refreshPersoanaFizica(PersoanaFizica pf) {
		rp.refreshPersoanaFizica(pf);
		
	}
	@Override
	public void addPersoanaJuridica(PersoanaJuridica pj) {
		rp.addPersoanaJuridica(pj);
		
	}
	@Override
	public void removePersoanaJuridica(PersoanaJuridica pj) {
		rp.removePersoanaJuridica(pj);
		
	}
	@Override
	public void refreshPersoanaJuridica(PersoanaJuridica pj) {
		rp.refreshPersoanaJuridica(pj);
		
	}
	@Override
	public Persoana getPersoanaDupaAdresa(String adresa) {

		
		return rp.getPersoanaDupaAdresa(adresa);
	}
	@Override
	public Long getCountPersoane() {
		
		return rp.getCountPersoane();
	}
	@Override
	public Set<Document> getDocumente() {
		
		return rd.getDocumente();
	}
	@Override
	public Document getDocumentDupaCod(String codDocument) {
		
		return rd.getDocumentDupaCod(codDocument);
	}
	@Override
	public Set<LinieDocument> getLinieDocument() {
		
		return rd.getLinieDocument();
	}
	@Override
	public LinieDocument getLinieDocumentDupaCodDoc(String codDocument) {
		// TODO Auto-generated method stub
		return rd.getLinieDocumentDupaCodDoc(codDocument);
	}
	@Override
	public LinieDocument getLinieDocumentDupaMaterial(Material m) {
		// TODO Auto-generated method stub
		return rd.getLinieDocumentDupaMaterial(m);
	}
	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		 rd.addDocument(document);
	}
	@Override
	public void addLinieDocument(LinieDocument ld) {
		rd.addLinieDocument(ld);
		
	}
	@Override
	public void removeDocument(Document document) {
		rd.removeDocument(document);
		
	}
	@Override
	public void removeLinieDocument(LinieDocument ld) {
		rd.removeLinieDocument(ld);
		
	}
	@Override
	public void refreshDocument(Document document) {
		rd.refreshDocument(document);
		
	}
	@Override
	public void refreshLinieDocument(LinieDocument ld) {
		// TODO Auto-generated method stub
		rd.removeLinieDocument(ld);
	}
	@Override
	public Document getDocumentDupaNrDocument(String nrDocument) {
		// TODO Auto-generated method stub
		return rd.getDocumentDupaNrDocument(nrDocument);
	}
	@Override
	public Long getCountDocumente() {
		// TODO Auto-generated method stub
		return rd.getCountDocumente();
	}
	@Override
	public List<Produs> getProduse() {
		// TODO Auto-generated method stub
		return rprod.getProduse();
	}
	@Override
	public void setProduse(List<Produs> produse) {
		rprod.setProduse(produse);
		
	}
	@Override
	public void generateRandomProduse(Integer nrProduse) {
		// TODO Auto-generated method stub
		rprod.generateRandomProduse(nrProduse);
		
	}
	@Override
	public Collection<Produs> getProduseOrdonateDupaId() {
		// TODO Auto-generated method stub
		return rprod.getProduseOrdonateDupaId();
	}
	@Override
	public Produs getProdusDupaCod(Integer id) {
		// TODO Auto-generated method stub
		return rprod.getProdusDupaCod(id);
	}
	@Override
	public Collection<MijlocFix> getMFOrdonatbyId() {
		// TODO Auto-generated method stub
		return rprod.getMFOrdonatbyId();
	}
	@Override
	public MijlocFix getMFDupaCod(Integer id) {
		// TODO Auto-generated method stub
		return rprod.getMFDupaCod(id);
	}
	@Override
	public Collection<Material> getMaterialOrdonatbyId() {
		// TODO Auto-generated method stub
		return rprod.getMaterialOrdonatbyId();
	}
	@Override
	public Material getMaterialDupaCod(Integer id) {
		// TODO Auto-generated method stub
		return rprod.getMaterialDupaCod(id);
	}
	@Override
	public Collection<MateriePrima> getMPOrdonatbyId() {
		// TODO Auto-generated method stub
		return rprod.getMPOrdonatbyId();
	}
	@Override
	public MateriePrima getMPDupaCod(Integer id) {
		// TODO Auto-generated method stub
		return rprod.getMPDupaCod(id);
	}
	@Override
	public void addProdus(Produs p) {
		// TODO Auto-generated method stub
		rprod.addProdus(p);
	}
	@Override
	public void removeProdus(Produs p) {
		// TODO Auto-generated method stub
		rprod.removeProdus(p);
	}
	@Override
	public void refreshProdus(Produs p) {
		// TODO Auto-generated method stub
		rprod.refreshProdus(p);
	}
	@Override
	public void addMF(MijlocFix m) {
		// TODO Auto-generated method stub
		rprod.addMF(m);
	}
	@Override
	public void removeMijlocFix(MijlocFix m) {
		// TODO Auto-generated method stub
		rprod.removeMijlocFix(m);
	}
	@Override
	public void refreshMF(MijlocFix m) {
		// TODO Auto-generated method stub
		rprod.refreshMF(m);
	}
	@Override
	public void addMP(MateriePrima mp) {
		// TODO Auto-generated method stub
		rprod.addMP(mp);
	}
	@Override
	public void removeMP(MateriePrima mp) {
		// TODO Auto-generated method stub
		rprod.removeMP(mp);
	}
	@Override
	public void refreshMP(MateriePrima mp) {
		// TODO Auto-generated method stub
		rprod.refreshMP(mp);
	}
	@Override
	public void addMaterial(Material m) {
		// TODO Auto-generated method stub
		rprod.addMaterial(m);
	}
	@Override
	public void removeMaterial(Material m) {
		// TODO Auto-generated method stub
		rprod.removeMaterial(m);
	}
	@Override
	public void refreshMaterial(Material m) {
		// TODO Auto-generated method stub
		rprod.refreshMaterial(m);
	}
	
	
	@Override
	public void synchronize() {
		
		
	}
	@Override
	public Produs getProdus(Integer idProdus) throws Exception {
		// TODO Auto-generated method stub
		return rprod.getProdus(idProdus);
	}
	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume) {
		// TODO Auto-generated method stub
		return rp.cautarePersoanaFizicaDupaPrenume(nume);
	}
	
	@Override
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire) {
		// TODO Auto-generated method stub
		return rp.cautarePersoanaJuridicaDupaDenumire(denumire);
	}
	@Override
	public Produs CautareProdusDupaDenumire(String denumire) {
		// TODO Auto-generated method stub
		return rprod.CautareProdusDupaDenumire(denumire);
	}
	@Override
	public Set<Departament> getDepartament() {
		// TODO Auto-generated method stub
		return rdep.getDepartament();
	}
	@Override
	public Departament getDepDupaCod(Integer codDep) {
		// TODO Auto-generated method stub
		return rdep.getDepDupaCod(codDep);
	}
	@Override
	public void addDepartament(Departament document) {
		// TODO Auto-generated method stub
		rdep.addDepartament(document);
	}
	@Override
	public void removeDepartament(Departament document) {
		// TODO Auto-generated method stub
		rdep.removeDepartament(document);
	}
	@Override
	public Departament getDepartamentDupaDenumire(String den) {
		// TODO Auto-generated method stub
		return rdep.getDepartamentDupaDenumire(den);
	}
	@Override
	public Long getCountDepartament() {
		// TODO Auto-generated method stub
		return rdep.getCountDepartament();
	}
	
	
	
	
	
	}

	
	
	
	
	
	
	
