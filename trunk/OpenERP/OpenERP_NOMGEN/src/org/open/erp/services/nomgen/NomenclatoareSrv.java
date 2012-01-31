package org.open.erp.services.nomgen;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

/**
 * 
 * @author Echipa NomGen
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */
@Remote
public interface NomenclatoareSrv {
	
	public Set<Departament> getDepartament() throws Exception;
	public Departament getDepDupaCod(Integer codDep) throws Exception;
	 public Departament addDepartament(Departament document) throws Exception;
	 public void removeDepartament(Departament document) throws Exception;
	 public Departament getDepartamentDupaDenumire(String den) throws Exception;
	 public Long getCountDepartament() throws Exception;
	
	
	public Produs  CautareProdusDupaDenumire(String denumire) throws Exception;
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire) throws Exception;
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume) throws Exception;
	public Set<PersoanaFizica> getPF() throws Exception;
	 public PersoanaFizica getPF(String idPersoana) throws Exception;
	 public Set<Partener> getPartener() throws Exception;
	 public Partener getPartenerDupaCodPersoana(Integer idPersoana) throws Exception;
	 public Set<PersoanaJuridica> getPJ() throws Exception;
	 public PersoanaJuridica getPJ(String idPersoana) throws Exception;
	 public Persoana addPersoana(Persoana persoana) throws Exception;
	 public void removePersoana(Persoana persoana) throws Exception;
	 public void refreshPersoana(Persoana persoana) throws Exception;
	 public void addPartener(Partener partener) throws Exception;
	 public void removePartener(Partener partener) throws Exception;
	 public void refreshPartener(Partener partener) throws Exception;
	 public PersoanaFizica addPersoanaFizica(PersoanaFizica pf) throws Exception;
	 public void removePersoanaFizica(PersoanaFizica pf) throws Exception;
	 public void refreshPersoanaFizica(PersoanaFizica pf) throws Exception;
	 public PersoanaJuridica addPersoanaJuridica(PersoanaJuridica pj) throws Exception;
	 public void removePersoanaJuridica(PersoanaJuridica pj) throws Exception;
	 public void refreshPersoanaJuridica(PersoanaJuridica pj) throws Exception;
	 public Persoana getPersoanaDupaAdresa(String adresa) throws Exception;
	 public Long getCountPersoane() throws Exception;
	 
	 
	
	 public Set<Document> getDocumente() throws Exception;
	 public Document getDocumentDupaCod(String codDocument) throws Exception;
	 public Set<LinieDocument> getLinieDocument() throws Exception;
	 public LinieDocument getLinieDocumentDupaCodDoc(String codDocument) throws Exception;
	 public LinieDocument getLinieDocumentDupaMaterial(Material m) throws Exception;
	  public Document addDocument(Document document) throws Exception;
	  public void addLinieDocument(LinieDocument ld) throws Exception;
	  public void removeDocument(Document document) throws Exception;
	  public void removeLinieDocument(LinieDocument ld) throws Exception;
	  public void refreshDocument(Document document) throws Exception;
	  public void refreshLinieDocument(LinieDocument ld) throws Exception;
	  public Document getDocumentDupaNrDocument(String nrDocument) throws Exception;
	  public Long getCountDocumente() throws Exception;
	  
	  public List<Produs> getProduse() throws Exception;
	  public void setProduse(List<Produs> produse) throws Exception;
	  public void generateRandomProduse(Integer nrProduse) throws Exception;
	  public Collection<Produs> getProduseOrdonateDupaId() throws Exception;
	  public Produs getProdusDupaCod(Integer id) throws Exception;
	  public Collection<MijlocFix> getMFOrdonatbyId() throws Exception;
	  public MijlocFix getMFDupaCod(Integer id) throws Exception;
	  public Collection<Material> getMaterialOrdonatbyId() throws Exception;
	  public Material getMaterialDupaCod(Integer id) throws Exception;
	  public Collection<MateriePrima> getMPOrdonatbyId() throws Exception;
	  public MateriePrima getMPDupaCod(Integer id) throws Exception;
	  public Produs addProdus(Produs p) throws Exception;
	  public void removeProdus(Produs p) throws Exception;
	  public void refreshProdus(Produs p) throws Exception;
	  public void addMF(MijlocFix m) throws Exception;
	  public void removeMijlocFix(MijlocFix m) throws Exception;
	  public void refreshMF(MijlocFix m) throws Exception;
	  public void addMP(MateriePrima mp) throws Exception;
	  public void removeMP(MateriePrima mp) throws Exception;
	  public void refreshMP(MateriePrima mp) throws Exception;
	  public Material addMaterial(Material m) throws Exception;
	  public void removeMaterial(Material m) throws Exception;
	  public void refreshMaterial(Material m) throws Exception;
	  public Produs getProdus(Integer idProdus) throws Exception;
	  public void synchronize() throws Exception;
	  
	  public Set<Persoana> getPersoana() throws Exception;
	PF crearePF(String nume, String prenume, String formaAdresare, char gen,
			String cnp, Persoana p) throws Exception;
	
    
    
    
}
