 package org.open.erp.services.achizitii;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.achizitii.exceptions.AchizitiiExceptions;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;

/**
 * Returneaza o interfata a serviciului Aprovizionare
 * 
 * @ApplicationServiceFacade(ServiceAPI) * 
 * 
 * @author AchizitiiTeam
 * 
 * @Depinde: NomenclatoareSrv,  ContabilitateSrv, StocuriSrv 
 * 
 * @EntitatiNomGen: Partener, Persoana, Material, Document, LinieDocument
 * 
 * @EntitatiAlteSrv:CerereAprovizionare  
 * 
 * @EntitatiLocale:Articol, Categorie, CerereOferta, LinieCerereOferta, Comanda, LinieComanda,Contract, Furnizor,
 * FacturaAchizitie, LinieFacturaAchizitie, NIR, LinieNIR, PlanAprovizionare, LiniePlanAprovizionare, OfertaAchizitie, LinieOfertaAchizitie
 * 
 *  * @UseCase:
 * 1. Creeaza instanta cerere aprovizionare
 * 2. Gestioneaza plan de aprovizionare
 * 3. Gestioneaza cereri de oferta
 * 4. Gestioneaza Furnizori
 * 5. Analiza Oferte Furnizori
 * 6. Inregistrare comanda achizitie
 * 7. Inregistrare Receptie materiale
 * 8. Inregistrare Facturi furnizor
 * 9. Retur materiale
 * 
 *   
 *  
 */

public interface AprovizionareSrv extends PropertyChangeListener{
	/**
	 *Returneaza un planul existent sau un nou plan de aprovizionare
	 * 
	 * 
	 * @return Plan de aprovizionare 
	 * @throws AchizitiiExceptions 
	 * 
	 */
	public PlanAprovizionare getPlanAprovizionare() throws AchizitiiExceptions;
	/**
	 * Scop Inregistreaza cererile de aprovizionare intr-un plan de aprovizionare
	 * 
	 * @param CerereAprovizionare  CerereAprovizionare de inregistrat 
	 * @return Plan de aprovizionare actualizat 
	 * @throws AchizitiiExceptions 
	 * 
	 */
	
	public PlanAprovizionare inregistrareCerereAprovizionare(PlanAprovizionare plan,Document cerereAprovizionare) throws AchizitiiExceptions;
	
	
    
    /**
	 * Scop Adaugare linii intr-o cerere de oferta, linii care provin din Planul de aprovizionare
	 * 
	 * @param cerere  cererea de aprovizionare careia i se adauga linii
	 * @param liniiPlan liniile din planul de aprovizionare care se adauga in Cererea de oferta
	 * @return Cerere de oferta actualizata
	 * 
	 */
    
    CerereOferta adaugareLiniiCerereOferta(CerereOferta cerere, List<LiniePlanAprovizionare> liniiPlan);      
      
    
    /**
  	 * Creare oferta de achizitie
  	 * 
  	 * @param cerereOferta  cererea de oferta pentru care a fost primita oferta de la furnizor
  	 * @param furnizor furnizorul de la care s-a primit oferta de cumparare
  	 * @return Oferta de achizitie noua
     * @throws AchizitiiExceptions 
  	 * 
  	 */ 
    OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,Date data,Furnizor furnizor,LinkedList<LinieOfertaAchizitie> linii) throws AchizitiiExceptions;
    
    /**
  	 * Analiza oferte de achizitie
  	 * 
  	 * @param oferteAchizitie ofertele de achizitie care vor fi comparate
  	 * @param cerereOferta cererea de oferta aflata la baza ofertelor de achizitii
  	 * @return Determinare oferta de achizitie convenabila
  	 * 
  	 */   
    
    Comanda analizaOferteAchizitie(List<OfertaAchizitie> oferteAchizitie );    
    /**
  	 * Creare comanda de achizitie
  	 * 
  	 * @param furnizor furnizorul pentru care se va emite o comanda de achizitie
  	 * @param data data comanda
  	 * @param contract contract 
  	 * @param persoana persoana de contact
  	 * @return Creare comanda de achizitie
  	 * 
  	 */     
    public Comanda adaugaLiniiComanda(Comanda comanda, List<LiniePlanAprovizionare> liniiPlan) ;
    /**
  	 * Creare comanda de achizitie din Oferta achizitie
  	 * 
  	 * @param oferta Oferta din achizitie din care va fi creata comanda de achizitie
  	 * @return Comanda achizitie
  	 * 
  	 */  
    public Comanda creareComandaDinOferta(OfertaAchizitie oferta);
        /**
   	 * Inregistrare factura furnizor
   	 * 
   	 * @param  furnizor
   	 * @param data data factura
   	 * @param valFact valoare totala factura
   	 * @return Inregistrare factura furnizor
     * @throws CtbException 
   	 * 
   	 */  
    
   
    
    
    public int inregistrareFactura(Factura factura) throws CtbException;    
    /**
   	 * Inregistrare receptie materiale
   	 * 
   	 * @param nir Document pe baza caruia se va realiza actualizarea stocurilor 
   	 * @return Receptie materiale - actualizare stocuri; creare documente contabile
   	 * 
   	 */    
    
    void receptieMateriale(Document nir);
    /**
   	 *Creare cerere retur materiale
   	 * 
   	 * @param factura factura care contine articole returnate
   	 * @param data data
   	 * @return Creare cerere retur materiale
   	 * 
   	 */       
   
    
    public void returMateriale(Document facturaRetur);
    
    /**
   	 *Adauga linii in NIR
   	 * 
   	 * @param NIR unde se vor adauga liniile
   	 * @param liniiNIR lista linii
   	 * @return Creare NIR actualizat
   	 * 
   	 */   
	NIR adaugareLiniiNir(NIR nir, List<LinieDocument> liniiNIR)
			throws CtbException;
	Articol getArticoleById(Integer idMaterial_) throws Exception;
	Collection<Articol> getListaArticole() throws Exception;
	Articol salveazaArticol(Articol articol_) throws Exception;
	void stergeArticol(Articol articol_) throws Exception;
	Categorie getCategorieById(long id_cat_) throws Exception;
	Collection<Categorie> getListaCategorii() throws Exception;
	Categorie salveazaCategorie(Categorie categorie_) throws Exception;
	void stergeCategorie(Categorie categorie_) throws Exception;
	CerereOferta getCerereOfertaById(long id_CerereOferta_) throws Exception;
	Collection<CerereOferta> getListaCereriOferta() throws Exception;
	CerereOferta salveazaCerereOferta(CerereOferta cerereOferta_)
			throws Exception;
	void stergeCerereOferta(CerereOferta cerereOferta_) throws Exception;
	Comanda getComandaById(Integer idComanda_) throws Exception;
	Collection<Comanda> getListaComenzi() throws Exception;
	Comanda salveazaComanda(Comanda comanda_) throws Exception;
	void stergeComanda(Comanda comanda_) throws Exception;
	NIR getNIRByIdId(long nrDocument_) throws Exception;
	Collection<NIR> getListaNIR() throws Exception;
	NIR salveazaNIR(NIR NIR_) throws Exception;
	void stergeNIR(NIR NIR_) throws Exception;
	OfertaAchizitie getOfertaAchizitie(long id_OfertaAchizitie_)
			throws Exception;
	Collection<OfertaAchizitie> getListaOfertaAchizitie() throws Exception;
	OfertaAchizitie salveazaOfertaAchizitie(OfertaAchizitie OfertaAchizitie_)
			throws Exception;
	void stergeOfertaAchizitie(OfertaAchizitie OfertaAchizitie)
			throws Exception;
	PlanAprovizionare getPlanAprovizionareById(long idPlanAprovizionare_)
			throws Exception;
	Collection<PlanAprovizionare> getListaPlanAprovizionare() throws Exception;
	PlanAprovizionare salveazaPlanAprovizionare(
			PlanAprovizionare PlanAprovizionare_) throws Exception;
	void stergePlanAprovizionare(PlanAprovizionare PlanAprovizionare_)
			throws Exception;
	Factura getFacturaById(Integer idActivitate_) throws Exception;
	Collection<Factura> getListaFactura() throws Exception;
	Factura salveazaFactura(Factura factura_) throws Exception;
	void stergeFactura(Factura factura_) throws Exception;
	Furnizor getFurnizorById(Integer id_) throws Exception;
	Collection<Furnizor> getListaFurnizor() throws Exception;
	Furnizor salveazaFurnizor(Furnizor furnizor_) throws Exception;
	LinieCerereOferta getLinieCerereOfertaById(Integer idliniecerereoferta_)
			throws Exception;
	Collection<LinieCerereOferta> getLinieCerereOferta() throws Exception;
	LinieCerereOferta salveazaLinieCerereOferta(
			LinieCerereOferta liniecerereoferta_) throws Exception;
	void stergeLinieCerereOferta(LinieCerereOferta liniecerereoferta_)
			throws Exception;
	LinieComanda getLinieComandaById(Integer idliniecomanda_) throws Exception;
	Collection<LinieComanda> getLinieComanda() throws Exception;
	LinieComanda salveazaLinieComanda(LinieComanda liniecomanda_)
			throws Exception;
	void stergeLinieComanda(LinieComanda liniecomanda_) throws Exception;
	LinieFacturaAchizitie getLinieFacturaAchizitieById(Integer linieDoc)
			throws Exception;
	Collection<LinieFacturaAchizitie> getLinieFacturaAchizitie()
			throws Exception;
	LinieFacturaAchizitie salveazaLinieFacturaAchizitie(
			LinieFacturaAchizitie lfactAchiz_) throws Exception;
	void stergeLinieFacturaAchizitie(LinieFacturaAchizitie lFactAchiz_)
			throws Exception;
	LinieNIR getLinieNIRById(Integer linieDoc) throws Exception;
	Collection<LinieNIR> getLinieNIR() throws Exception;
	LinieNIR salveazaLinieNIR(LinieNIR linieNir_) throws Exception;
	void stergeLinieNIR(LinieNIR linieNir_) throws Exception;
	LinieOfertaAchizitie getLinieOfertaAchizitieById(Integer linieDoc)
			throws Exception;
	Collection<LinieOfertaAchizitie> getLinieOfertaAchizitie() throws Exception;
	LinieOfertaAchizitie salveazaLinieOfertaAchizitie(
			LinieOfertaAchizitie lofertaAchiz_) throws Exception;
	void stergeLinieOfertaAchizitie(LinieOfertaAchizitie lofertaAchiz_)
			throws Exception;
	LiniePlanAprovizionare getLiniePlanAprovizionareById(
			Integer idLiniePlanAprovizionare) throws Exception;
	LiniePlanAprovizionare salveazaLiniePlanAprovizionare(
			LiniePlanAprovizionare lofertaAprov_) throws Exception;
	void stergeLiniePlanAprovizionare(LiniePlanAprovizionare lofertaAprov_)
			throws Exception;
	Collection<LiniePlanAprovizionare> getLiniePlanAprovizionare()
			throws Exception;
  	
    
    }
    
	


