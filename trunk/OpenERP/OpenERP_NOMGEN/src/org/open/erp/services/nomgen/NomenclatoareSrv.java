package org.open.erp.services.nomgen;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Echipa NomGen
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */

public interface NomenclatoareSrv {
	
	public Set<Departament> getDepartament();
	public Departament getDepDupaCod(Integer codDep);
	 public void addDepartament(Departament document);
	 public void removeDepartament(Departament document);
	 public Departament getDepartamentDupaDenumire(String den);
	 public Long getCountDepartament();
	
	
	public Produs  CautareProdusDupaDenumire(String denumire);
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire);
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume);
	public Set<PersoanaFizica> getPF();
	 public PersoanaFizica getPF(String idPersoana);
	 public Set<Partener> getPartener();
	 public Partener getPartenerDupaCodPersoana(String idPersoana);
	 public Set<PersoanaJuridica> getPJ();
	 public PersoanaJuridica getPJ(String idPersoana);
	 public void addPersoana(Persoana persoana);
	 public void removePersoana(Persoana persoana);
	 public void refreshPersoana(Persoana persoana);
	 public void addPartener(Partener partener);
	 public void removePartener(Partener partener);
	 public void refreshPartener(Partener partener);
	 public void addPersoanaFizica(PersoanaFizica pf);
	 public void removePersoanaFizica(PersoanaFizica pf);
	 public void refreshPersoanaFizica(PersoanaFizica pf);
	 public void addPersoanaJuridica(PersoanaJuridica pj);
	 public void removePersoanaJuridica(PersoanaJuridica pj);
	 public void refreshPersoanaJuridica(PersoanaJuridica pj);
	 public Persoana getPersoanaDupaAdresa(String adresa);
	 public Long getCountPersoane();
	 
	 
	
	 public Set<Document> getDocumente();
	 public Document getDocumentDupaCod(String codDocument);
	 public Set<LinieDocument> getLinieDocument();
	 public LinieDocument getLinieDocumentDupaCodDoc(String codDocument);
	 public LinieDocument getLinieDocumentDupaMaterial(Material m);
	  public void addDocument(Document document);
	  public void addLinieDocument(LinieDocument ld);
	  public void removeDocument(Document document);
	  public void removeLinieDocument(LinieDocument ld);
	  public void refreshDocument(Document document);
	  public void refreshLinieDocument(LinieDocument ld);
	  public Document getDocumentDupaNrDocument(String nrDocument);
	  public Long getCountDocumente();
	  
	  public List<Produs> getProduse();
	  public void setProduse(List<Produs> produse);
	  public void generateRandomProduse(Integer nrProduse);
	  public Collection<Produs> getProduseOrdonateDupaId();
	  public Produs getProdusDupaCod(Integer id);
	  public Collection<MijlocFix> getMFOrdonatbyId();
	  public MijlocFix getMFDupaCod(Integer id);
	  public Collection<Material> getMaterialOrdonatbyId();
	  public Material getMaterialDupaCod(Integer id);
	  public Collection<MateriePrima> getMPOrdonatbyId();
	  public MateriePrima getMPDupaCod(Integer id);
	  public void addProdus(Produs p);
	  public void removeProdus(Produs p);
	  public void refreshProdus(Produs p);
	  public void addMF(MijlocFix m);
	  public void removeMijlocFix(MijlocFix m);
	  public void refreshMF(MijlocFix m);
	  public void addMP(MateriePrima mp);
	  public void removeMP(MateriePrima mp);
	  public void refreshMP(MateriePrima mp);
	  public void addMaterial(Material m);
	  public void removeMaterial(Material m);
	  public void refreshMaterial(Material m);
	  public Produs getProdus(Integer idProdus) throws Exception;
	  public void synchronize();
	  
	 
	
    
    
    
}
