package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

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
	 *Scop Crearea unei instante unice a planului de aprovizionare
	 * 
	 * @param dataInceput  data de inceput a planului
	 * @param dataSfarsit data de sfarsit a planului
	 * @param persoana persoana responsabila
	 * @return O instanta unica a planului de aprovizionare
	 * 
	 */
	
	//void crearePlanAprovizionare(Date dataInceput, Date dataSfarsit, Persoana persoana);
	
	/**
	 * Scop Actualizare plan de aprovizionare
	 * 
	 * @param plan Planul de aprovizionare care urmeaza a fi actualizat
	 * @param linieCerereAprovizionare linia din cererea de aprovizionare care va fi inserata in plan
	 * @return Plan de aprovizionare actualizat 
	 * 
	 */
	
    void updatePlanAprovizionare(PlanAprovizionare plan,LinieDocument linieCerereAprovizionare );
    
    /**
	 * Scop Crearea unei cerere de oferta
	 * 
	 * @param furnizori  furnizorii carora le va fi trimisa cererea de oferta
	 * @param data data cerere oferta
	 * @return Cerere de oferta noua
	 * 
	 */
    
    Furnizor creareFurnizor(Persoana persoana, Integer cont);
    
    void creareCerereOferta(List<Furnizor> furnizori, Date data);  
    
    /**
  	 * Scop Actualizare cerere oferta
  	 * 
  	 * @param linieCerereOferta  Linia din cererea de oferta ce urmeaza a fi adaugata 
  	 * @return Cerere de oferta actualizata
  	 * 
  	 */
    
    void updateCerereOferta(LinieCerereOferta linieCerereOferta);
    
    /**
  	 * Trimiterea cerererii de oferta la furnizori
  	 * 
  	 * @param cerereOferta  cererea de oferta trimisa la furnizori
  	 * @param furnizori furnizorii carora le va fi trimisa cererea de oferta
  	 * @return Cerere de oferta trimisa la furnizori
  	 * 
  	 */    
    void trimitereCerereOferta(CerereOferta cerereOferta,List<Furnizor> furnizori);
    
    /**
  	 * Creare oferta de achizitie
  	 * 
  	 * @param cerereOferta  cererea de oferta pentru care a fost primita oferta de la furnizor
  	 * @param furnizor furnizorul de la care s-a primit oferta de cumparare
  	 * @return Oferta de achizitie noua
  	 * 
  	 */ 
    OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,Furnizor furnizor);
    
    /**
  	 * Analiza oferte de achizitie
  	 * 
  	 * @param oferteAchizitie ofertele de achizitie care vor fi comparate
  	 * @param cerereOferta cererea de oferta aflata la baza ofertelor de achizitii
  	 * @return Determinare oferta de achizitie convenabila
  	 * 
  	 */   
    
    void analizaOferteAchizitie(List<OfertaAchizitie> oferteAchizitie,CerereOferta cerereOferta );    
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
    Comanda creareComanda(Furnizor furnizor, Date data, Contract contract, Persoana persona);    
    /**
   	 * Actualizare comanda achizitie
   	 * 
   	 * @param linieComanda linie comanda achizitie 
   	 * @return Actualizare comanda achizitie
   	 * 
   	 */       
    void UpdatedComanda(LinieComanda linieComanda);
    /**
   	 * Inregistrare factura furnizor
   	 * 
   	 * @param  furnizor
   	 * @param data data factura
   	 * @param valFact valoare totala factura
   	 * @return Inregistrare factura furnizor
   	 * 
   	 */  
    
    Factura creareFactura(Furnizor furnizor, String nrfact, Double valfact, Double TVATotal );
    
    
    int inregistrareFactura(Factura factura); 
    /**
   	 * Creare nota de intrare receptie
   	 * 
   	 * @param factura furnizor furnizor
   	 * @param data data creare NIR
   	 * @return Inregistrare factura furnizor
   	 * 
   	 */      
    void creareNIR(Factura factura,Date data);
    /**
   	 * Inregistrare receptie materiale
   	 * 
   	 * @param data data receptie
   	 * @param comanda comanda achizitie aferenta
   	 * @return Receptie materiale - actualizare stocuri; creare documente contabile
   	 * 
   	 */    
    
    void receptieMateriale(Date data,Comanda comanda);
    /**
   	 *Creare cerere retur materiale
   	 * 
   	 * @param factura factura care contine articole returnate
   	 * @param data data
   	 * @return Creare cerere retur materiale
   	 * 
   	 */        
    public void creareFacturaRetur(Factura factura, Date data);
    /**
   	 *Actualizare cerere retur
   	 * 
   	 * @param cerereRetur cerere de retur  
   	 * @param linieCerereRetur linie cerere retur
   	 * @return Actualizare cerere retur
   	 * 
   	 */ 
     public void updateFacturaRetur(FacturaRetur facturaRetur,
			LinieFacturaRetur linieFacturaRetur);
    /**
   	 * Efectuare retur materiale
   	 * 
   	 * @param cerereRetur cerere de retur  
   	 * @return Inregistrare retur materiale- actualizare stocuri; inregistrea contabilitate
   	 * 
   	 */ 
    
    void returMateriale(FacturaRetur facturaRetur);
    /**
   	 * Inregistrare progres comanda
   	 *    	 
   	 * @param comanda comanda achizitie 
   	 * @return  Inregistrare progres comanda
   	 * 
   	 */ 
    void progresComanda(Comanda comanda);
    
    }
    
	


