package org.open.erp.services.stocuri.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.ListaGestiuni;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.nommat.Material;


/**
 * @ApplicationServiceImplementation
 * 
 */
@Stateless
public class StocuriImpl implements StocuriSrv, StocuriSrvLocal{
	
	//private AchizitiiSrv achizitiiSrv;
	//private NomenclatorMaterialeSrv nomenclatorMaterialeSrv;
	
	//Dependente resurse proprii
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StocuriImpl.class.getName());
	
	//Dependente resurse injectate
	@PersistenceContext(unitName="OpenERP_STOCURI")
	private EntityManager em;
	
	//Initializare
	public StocuriImpl() { }
	
	
	//intrarea in stoc pentru modulul achizitii
	@Override
	public void intrareStoc(Material material, Double cantitate, Double pret, Gestiune gestiune) 
	{
		//for(LiniiNIR linie: nir.getLinieNir())
		//{
			//Cei de la achizitii acum obiectul MATERIALE declarat local, cand o sa implementeze clasa MATERIAL de la nom materiale atunci nu o sa mai dea eroare
			logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + material.getCodMaterial()+ ", cantitatea produsului: " + cantitate + ", pretul de intrare: " + pret);
			
			logger.info("2.2. Verifica daca exista produsul " + material.getCodMaterial() + " in stoc");
			Articol art = this.getArticolByGestiune(material, gestiune);
			if(art != null)
			{	
				logger.info("Produsul este deja inregistrat in stocuri.");
				//logger.info("Se creeza un lot nou pentru articolul gasit");
				//logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
				
				logger.info("2.3. Se creste cantitatea existenta in stoc " + art.getCantPeGestiune() + " cu cantitatea noua " + cantitate);
				art.addLot(new Loturi(1, cantitate, pret, new Date()));	
				//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
				logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
			}
			else
			{
				logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
				//logger.info("Se adauga un articol nou pentru produs.");
				this.creareLot(material, cantitate, pret, gestiune);
				
			}
			
			
		}
		
	
	//intrarea in stoc pentru transferul intre gestiuni
	@Override
	public void intrareStoc(BonTransfer bonTransfer, Double pret)
    {
        //logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + bonTransfer.getMaterial().getCodMaterial()+ ", cantitatea produsului: " + bonTransfer.getCantitate());
                
        //logger.info("2.2. Verifica daca exista produsul " + bonTransfer.getMaterial().getCodMaterial() + " in stoc");
        Articol art = this.getArticolByGestiune(bonTransfer.getMaterial(), bonTransfer.getGestiuneIntrare());
        if(art != null)
        {     
        	//logger.info("Produsul este deja inregistrat in stocuri.");
            //logger.info("Se creeza un lot nou pentru articolul gasit");
            //logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
                       
            //logger.info("2.3. Se creste cantitatea existenta in stoc " + art.getCantPeGestiune() + " cu cantitatea noua " + bonTransfer.getCantitate());
            //nu avem deocamdata pretul
            art.addLot(new Loturi(1, bonTransfer.getCantitate(), pret, new Date())); 
            //art.cresteCantitateArticolPeGestiune(produs.getCantitate());
            //logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
        }
        else
        {
        	//logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
            //logger.info("Se adauga un articol nou pentru produs.");
                       
            //logger.info("1.1. Se creeaza un lot nou pentru produsul " + bonTransfer.getMaterial().getCodMaterial());
            bonTransfer.getGestiuneIntrare().addArticole(new Articol(1, 0.00, bonTransfer.getGestiuneIntrare(), bonTransfer.getMaterial(), new ArrayList<Loturi>()));
            Articol artNou = this.getArticolByGestiune(bonTransfer.getMaterial(), bonTransfer.getGestiuneIntrare());
            //logger.info("1.2. Preluare date specifice produsului: id-ul produsului: " + bonTransfer.getMaterial().getCodMaterial() + ", cantitatea produsului " + bonTransfer.getCantitate());
            Loturi lot = new Loturi(2, bonTransfer.getCantitate(),pret, new Date());
            //logger.info("1.3. Adaugare date specifice produsului in noul lot");
            artNou.addLot(lot);
                       
            //logger.info("1.4 Confirmare/Adaugare lot nou " + lot.getIdLot());
                       
            //this.creareLot(linie, gestiune);
        }
                     
    }
	
	//intrarea in stoc pentru modulul productie
	@Override
	public void intrareStoc(Material material, Gestiune gestiune, Double cantitate) {
		logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + material.getCodMaterial() + ", cantitatea produsului: " + cantitate);
		logger.info("2.2. Verifica daca exista produsul " + material.getCodMaterial() + " in stoc");
								
		Articol art = this.getArticolByGestiune(material, gestiune);
		if (art != null) {
			logger.info("Produsul este deja inregistrat in stocuri.");
			// logger.info("Se creeza un lot nou pentru articolul gasit");
			// logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: "+ art.getCantPeGestiune());

			logger.info("2.3. Se creste cantitatea existenta in stoc " + art.getCantPeGestiune() + " cu cantitatea noua " + cantitate); 
					
			art.addLot(new Loturi(1, cantitate, null, new Date()));  // Seteaza pretul preluandu-l de la modulul ContabilitateGestiune 
			// art.cresteCantitateArticolPeGestiune(produs.getCantitate());
			logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: " + art.getCantPeGestiune());
		} 
		else {
			logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
			// logger.info("Se adauga un articol nou pentru produs.");
			logger.info("1.1. Se creeaza un lot nou pentru produsul " + material.getCodMaterial());
			gestiune.addArticole(new Articol(1, 0.00, gestiune,	material, new ArrayList<Loturi>()));
			Articol artNou = this.getArticolByGestiune(material, gestiune);
			logger.info("1.2. Preluare date specifice produsului: id-ul produsului: "+ material.getCodMaterial() + ", cantitatea produsului " + cantitate);
			Loturi lotNou = new Loturi(2, cantitate, null, new Date());
			logger.info("1.3. Adaugare date specifice produsului in noul lot");
			artNou.addLot(lotNou);

			logger.info("1.4 Confirmare/Adaugare lot nou " + lotNou.getIdLot());
		}
				
	}	
		
	//crearea unui art si lot nou la intrarea in gestiune
	@Override
	public void creareLot(Material material, Double cantitate, Double pret, Gestiune gestiune)
	{
		Double cantitateinitiala;
		logger.info("1.1. Se creeaza un lot nou pentru produsul " + material.getCodMaterial());
		gestiune.addArticole(new Articol(1, 0.00, gestiune, material, new ArrayList<Loturi>()));
		Articol art = this.getArticolByGestiune(material, gestiune);
		logger.info("1.2. Preluare date specifice produsului: id-ul produsului: " + material.getCodMaterial() + ", cantitatea produsului " + cantitate + ", pretul de intrare " + pret);
		Loturi lot = new Loturi(2, cantitate, pret, new Date());
		logger.info("1.3. Adaugare date specifice produsului in noul lot");
		cantitateinitiala = art.getCantPeGestiune();
		art.addLot(lot);
		
		logger.info("1.4 Confirmare/Adaugare lot nou " + lot.getIdLot());
		
		logger.info("2.3. Se creste cantitatea existenta in stoc " + cantitateinitiala + " cu cantitatea noua " + cantitate);
		logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
	}
	
	
	//returnarea articolului dintr-o gestiune care contine un anumit material
	@Override
	public Articol getArticolByGestiune(Material material, Gestiune gestiune)
	{
		for(Articol art: gestiune.getArticole())
		{
			if(art.getMaterial().equals(material))
			{	
				return art;	
			}
		}
		return null;
	}
	
	// returnarea cantitatii unui material din stoc pe o anumita gestiune
	@Override
	public Double verificareStoc(Material material, Gestiune gestiune) {
		if (material == null){
			logger.info ("Valoarea produsului oferit ca parametru trebuie sa fie diferita de null");
			return null;
		}
		if (gestiune == null){
			logger.info ("Valoarea gestiunii oferita ca parametru trebuie sa fie diferita de null");
			return null;
		}
		
		for(Articol art: gestiune.getArticole())
		{
			if(art.getMaterial().equals(material))
			{
				return art.getCantPeGestiune();
				
			}
		}
		return null;
	}
	
	//crearea si returnarea unei liste cu gestiunile existente in toata aplicatie si pe care le pot folosii cei care au nevoie
	@Override
	public ListaGestiuni GestiuniDisponibile (){
		ListaGestiuni lista = new ListaGestiuni(1,null);
	    Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
	    Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
	    Gestiune gest3 = new Gestiune(3, "Gestiune 3", new Depozit(2, "Vaslui"));
	    lista.addGestiune(gest1);
	    lista.addGestiune(gest2);
	    lista.addGestiune(gest3);
	    return lista;
	}
		
	//verificarea stocului si returnarea contitatii unui material pe toate gestiunile
	@Override
	public Double verificareStoc(Material material, ListaGestiuni listagest) {
	    if (material == null){
	    	logger.info ("Valoarea produsului oferit ca parametru trebuie sa fie diferita de null");
	        return null;
	    }
	    if (listagest == null){
	    	logger.info ("Valoarea listei de gestiuni oferita ca parametru trebuie sa fie diferita de null");
	        return null;
	    }
	    Double CantitateDeReturnat = 0.00;
	            
	    for(Gestiune g: listagest.getGestiuni())
	    	{
	        	for(Articol art: g.getArticole())
	        	{
	        		if(art.getMaterial().equals(material))
	        		{
	        			CantitateDeReturnat = CantitateDeReturnat + art.getCantPeGestiune();
	                }
	             }
	    	}
	    return CantitateDeReturnat;
	}	

	//verificare stocului pentru un material, fara lista de gestiuni ca si parametru
	@Override
	public Double verificareStoc(Material material){
		return -1.00;
	}

	//iesire din gestiune pentru vanzari si productie
	@Override
	public void iesireStoc(Material material, Double cantitate, Gestiune gestiune) 
	{
		logger.info("3.1. Preluare date specifice produsului: id-ul produsul: " + material.getCodMaterial() + ", cantitatea: " + cantitate );
		Articol art;
		Double cantitateDeIesit, cantitateInitialaStoc;
		List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
		art = this.getArticolByGestiune(material, gestiune);
		cantitateDeIesit = cantitate;
		cantitateInitialaStoc = art.getCantPeGestiune();
		
		logger.info("3.2 Verificare identificare lot conform cu caracteristicile produsului.");
		if(this.verificareStoc(material, gestiune) < cantitate)
		{
			logger.info("Nu exista in gestiunea " + gestiune.getDenumireGest() + "suficienta cantitate pentru produsul " + material.getCodMaterial());
		}
		else
		{
			for(Loturi l : art.getLoturiArticole())
			{
				//logger.info("Lotul: " +l.getIdLot());
				if(l.getCantitate() > cantitate)
				{
					//logger.info("3.3. Scaderea lotului avand cantitatea:" + l.getCantitate() + "cu cantitate " + cantitate);
					l.scadeCantitatea(cantitate);
					//logger.info("3.4. Actualizarea stocului pentru gestiune: " + gestiune.getIdGest() + " cu cantitatea " + cantitate);
					art.scadeCantitateArticolPeGestiune(cantitate);
					break;
				}
				else if(l.getCantitate() == cantitate)
				{
					//logger.info("Se scade cantitatea din gestiune a articolului " +  art.getIdArticol());
					//art.removeLot(l);
					listaLoturiDeSters.add(l);
				
					break;
				}
				else
				{
					//logger.info("Se scade cantitatea: " + l.getCantitate() + " din lotul: "  + l.getIdLot());
					cantitate = cantitate - l.getCantitate();
					//logger.info("Se sterge lotul "  + l.getIdLot());
					//logger.info("Cantitatea care ramane de cautat dupa scoaterea din primul lot este: " + cantitate);
					//art.removeLot(l);
					listaLoturiDeSters.add(l);
	
				}
			
			}
			for(Loturi lot : listaLoturiDeSters)
			{
				art.removeLot(lot);
			}
		}
		logger.info("3.3. Scaderea stocului avand cantitatea initiala: " + cantitateInitialaStoc + " cu cantitatea " + cantitateDeIesit);
		logger.info("Cantitatea ramasa in gestiunea: " + gestiune.getIdGest() + " este " + art.getCantPeGestiune());
		
		this.alertaStoc(art);
		if(this.verificareStoc(material, gestiune) == 0.0)
		{
			logger.info("Articolul " + art.getIdArticol() + " are cantitatea egala cu 0 si este sters.");
			gestiune.removeArticole(art);
			logger.info("Articolul s-a sters.");
		}
		
	}
	

	//transferul unui material cu o anumita cantitate dintr-o gestiune in alta
	@Override
	public void transfer(BonTransfer bonTransfer) {

		logger.info("5.1. Introducere produs si gestiune din care se transfera. Gestiune din care se transfera produsul "+ bonTransfer.getMaterial().getCodMaterial() + " este " + bonTransfer.getGestiuneIesire().getIdGest());
        logger.info("5.2. Verificare disponibilitate produs. Acest pas se realizeaza in cadrul metodei iesireStoc()");
        logger.info("5.3. Stabilire gestiune in care se transfera. Gestiunea in care se transfera este: " + bonTransfer.getGestiuneIntrare().getIdGest());
        logger.info("5.4. Stabilire cantitate de transferat. Cantitatea care se transfera este " + bonTransfer.getMaterial().getCodMaterial());
         
        logger.info(">>>>>>>>Se declanseaza iesire din gestiunea: " + bonTransfer.getGestiuneIesire().getIdGest() + "<<<<<<<<");
        //iesire standard
        Articol art;
        Double cantitateDeIesit, cantitateInitialaStoc;
        List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
        art = this.getArticolByGestiune(bonTransfer.getMaterial(), bonTransfer.getGestiuneIesire());
        cantitateDeIesit = bonTransfer.getCantitate();
        cantitateInitialaStoc = art.getCantPeGestiune();
        BonTransfer bonintermediar;
         
        logger.info("3.2 Verificare identificare lot conform cu caracteristicile produsului.");
        if(this.verificareStoc(bonTransfer.getMaterial(), bonTransfer.getGestiuneIesire()) < cantitateDeIesit)
        {
        	logger.info("Nu exista in gestiunea " + bonTransfer.getGestiuneIesire().getDenumireGest() + "suficienta cantitate pentru produsul " + bonTransfer.getMaterial().getCodMaterial());
        }
        else
        {
        	for(Loturi l : art.getLoturiArticole())
            {
        		//logger.info("Lotul: " +l.getIdLot());
        		if(l.getCantitate() > cantitateDeIesit)
        		{
        			//logger.info("3.3. Scaderea lotului avand cantitatea:" + l.getCantitate() + "cu cantitate " + cantitate);
        			l.scadeCantitatea(cantitateDeIesit);
                              
        			//logger.info("3.4. Actualizarea stocului pentru gestiune: " + gestiune.getIdGest() + " cu cantitatea " + cantitate);
        			art.scadeCantitateArticolPeGestiune(cantitateDeIesit);
        			bonintermediar = new BonTransfer(bonTransfer.getMaterial(),cantitateDeIesit,bonTransfer.getGestiuneIntrare(),null);
        			this.intrareStoc(bonintermediar,l.getPretIntrare());
        			break;
        		}
        		else if(l.getCantitate() == cantitateDeIesit)
            		{
                		//logger.info("Se scade cantitatea din gestiune a articolului " +  art.getIdArticol());
                    	//art.removeLot(l);
                    	listaLoturiDeSters.add(l);
                    	bonintermediar = new BonTransfer(bonTransfer.getMaterial(),cantitateDeIesit,bonTransfer.getGestiuneIntrare(),null);
                    	this.intrareStoc(bonintermediar,l.getPretIntrare());
                    	break;
            		}
             		else
             		{
             			//logger.info("Se scade cantitatea: " + l.getCantitate() + " din lotul: "  + l.getIdLot());
             			cantitateDeIesit = cantitateDeIesit - l.getCantitate();
             			//logger.info("Se sterge lotul "  + l.getIdLot());
             			//logger.info("Cantitatea care ramane de cautat dupa scoaterea din primul lot este: " + cantitate);
             			//art.removeLot(l);
             			listaLoturiDeSters.add(l);
             			bonintermediar = new BonTransfer(bonTransfer.getMaterial(),l.getCantitate(),bonTransfer.getGestiuneIntrare(),null);
             			this.intrareStoc(bonintermediar,l.getPretIntrare());
             		}
            }
            
        	for(Loturi lot : listaLoturiDeSters)
            {
        		art.removeLot(lot);
            }
        }
        logger.info("3.3. Scaderea stocului avand cantitatea initiala: " + cantitateInitialaStoc + " cu cantitatea " + cantitateDeIesit);
        logger.info("Cantitatea ramasa in gestiunea: " + bonTransfer.getGestiuneIesire().getIdGest() + " este " + art.getCantPeGestiune());
         
        this.alertaStoc(art);
        if(this.verificareStoc(bonTransfer.getMaterial(), bonTransfer.getGestiuneIesire()) == 0.0)
        {
        	logger.info("Articolul " + art.getIdArticol() + " are cantitatea egala cu 0 si este sters.");
            bonTransfer.getGestiuneIesire().removeArticole(art);
            logger.info("Articolul s-a sters.");
        }
        logger.info(">>>>>>>>Se finalizeaza iesire din gestiunea: " + bonTransfer.getGestiuneIesire().getIdGest());
   
        //logger.info(">>>>>>>>Se declanseaza intrarea in gestiunea: " + bonTransfer.getGestiuneIntrare().getIdGest() + "<<<<<<<<");
        //intrare specifica transferului
        //logger.info(">>>>>>>>Se finalizeaza intrarea in gestiunea: " + bonTransfer.getGestiuneIntrare().getIdGest() + "<<<<<<<<");
         
        logger.info("A intrat in gestiune " + bonTransfer.getGestiuneIntrare().getIdGest() + " produsul " + bonTransfer.getMaterial().getCodMaterial() + " cu cantitatea " + bonTransfer.getCantitate());
        logger.info("5.5. Confirmare/Salvare transfer. S-a transferat din gestiunea: "+ bonTransfer.getGestiuneIesire().getIdGest() + " in gestiunea " + bonTransfer.getGestiuneIntrare().getIdGest() + " produsul " + bonTransfer.getMaterial().getCodMaterial() + " in cantitatea de " + bonTransfer.getCantitate());
         
         
    }

	
	//alerta stoc cand valoarea acestuia ajunge sa fie egala sau mai mica cu un parg (2 in cazul de fata)
	@Override
	public void alertaStoc(Articol articol) {
		logger.info("-------------Declansare alerta-------------");
		logger.info("6.1. Preluare informatii produs " + articol.getMaterial().getCodMaterial());
		Double pragStoc =2.00;
		logger.info("6.2. Verificare cantitate ramasa in stoc raportat la pragul minim stabilit.");
		if(articol.getCantPeGestiune() <= pragStoc)
		{
			logger.info("Alerta!!! Produsul " + articol.getMaterial().getCodMaterial() + " are cantitatea sub pragul stabilit pentru stocul acestuia");
		}
		else
		{
			logger.info("Produsul " + articol.getMaterial().getCodMaterial() + " are cantitatea peste pragul stabilit pentru stocul acestuia");
		}
		logger.info("-------------Final alerta-------------");
	}

	
	/*
	@Override
	public boolean existaArticol(Produs produs, Gestiune gestiune){
		// TODO Auto-generated method stub
		for(Articol art: gestiune.getArticole())
		{
			if(art.getProdus().equals(produs))
			{
				//exista loturi
				return true;
			}	
		}
		return false;
	}
	*/
	
}
