package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author ApprroovviizziioonnaarreeTeam
 * 
 * @Depinde: NomenclatoareSrv, FinPlatiSrv, ContabilitateSrv, StocuriSrv
 * 
 * @EntitatiNomGen: Partener, Persoana
 * 
 * @EntitatiAlteSrv:Contract, CerereAprovizionare 
 * 
 * @EntitatiLocale: 
 *  
 *  
 */

/**
 * Returneaza o interfata a serviciului Aprovizionare
 * 
 * @UseCase:
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
 */

public interface AprovizionareSrv {
	/**
	 * Scop Inregistreaza cererile de aprovizionare intr-un plan de aprovizionare
	 * 
	 * @param CerereAprovizionare  CerereAprovizionare de inregistrat 
	 * @return Plan de aprovizionare actualizat 
	 * 
	 */
	
	public PlanAprovizionare inregistrareCerereAprovizionare(Document cerereAprovizionare);
	
	
    
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
  	 * 
  	 */ 
    OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,Date data,Furnizor furnizor,List<LinieOfertaAchizitie> linii);
    
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
  	
    
    }
    
	


