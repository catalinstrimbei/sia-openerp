package org.open.erp.services.stocuri.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.Produs;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;

/**
 * @ApplicationServiceImplementation
 * 
 */
public class StocuriImpl implements StocuriSrv{
	
	private AchizitiiSrv achizitiiSrv;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StocuriImpl.class.getName());

	public void setAchizitiiSrv(AchizitiiSrv achizitiiSrv) {
		this.achizitiiSrv = achizitiiSrv;
	}
	
	@Override
	
	public void intrareStoc(Produs produs, Gestiune gestiune) 
	{
		logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + produs.getIdProd() + ", cantitatea produsului: " + produs.getCantitate() + ", pretul de intrare: " + produs.getPretIntrare());
		
		logger.info("2.2. Verifica daca exista produsul " + produs.getIdProd() + " in stoc");
		Articol art = this.getArticolByGestiune(produs, gestiune);
		if(art != null)
		{	
			logger.info("Produsul este deja inregistrat in stocuri.");
			//logger.info("Se creeza un lot nou pentru articolul gasit");
			//logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
			
			logger.info("2.3. Se creste cantitatea existenta in stoc" + art.getCantPeGestiune() + " cu cantitatea noua" + produs.getCantitate());
			art.addLot(new Loturi(1, produs.getCantitate(), produs.getPretIntrare(), new Date()));	
			//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
			logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
		}
		else
		{
			logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
			//logger.info("Se adauga un articol nou pentru produs.");
			this.creareLot(produs, gestiune);
		}
		
	}
		
	/*@Override
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
	}*/
	
	@Override
	public Articol getArticolByGestiune(Produs produs, Gestiune gestiune)
	{
		for(Articol art: gestiune.getArticole())
		{
			if(art.getProdus().equals(produs))
			{	
				return art;	
			}
		}
		return null;
	}
	
	@Override
	public void creareLot(Produs produs, Gestiune gestiune)
	{
		logger.info("1.1. Se creeaza un lot nou pentru produsul" + produs.getIdProd());
		gestiune.addArticole(new Articol(1, 0.00, gestiune, produs, new ArrayList<Loturi>()));
		Articol art = this.getArticolByGestiune(produs, gestiune);
		logger.info("1.2. Preluare date specifice produsului: id-ul produsului: " + produs.getIdProd() + ", cantitatea produsului " + produs.getCantitate() + ", pretul de intrare " + produs.getPretIntrare());
		Loturi lot = new Loturi(2, produs.getCantitate(), produs.getPretIntrare(), new Date());
		logger.info("1.3. Adaugare date specifice produsului in noul lot");
		art.addLot(lot);
		
		logger.info("1.4 Confirmare/Adaugare lot nou " + lot.getIdLot());
	}
	
	
	@Override
	public Double verificareStoc(Produs produs,Gestiune gestiune) {
		// TODO Auto-generated method stub
		if (produs == null){
			logger.info ("Valoarea produsului oferit ca parametru trebuie sa fie diferita de null");
			return null;
		}
		if (gestiune == null){
			logger.info ("Valoarea gestiunii oferita ca parametru trebuie sa fie diferita de null");
			return null;
		}
		
		for(Articol art: gestiune.getArticole())
		{
			if(art.getProdus().equals(produs))
			{
				return art.getCantPeGestiune();
				
			}
		}
		return null;
	}

	
	@Override
	public void iesireStoc(Produs produs, Gestiune gestiune, Double cantitate) 
	{
		logger.info("3.1. Preluare date specifice produsului: id-ul produsul: " + produs.getIdProd() + ", cantitatea: " + cantitate + ", pretul de intrare: " + produs.getPretIntrare());
		Articol art;
		Double cantitateDeIesit, cantitateInitialaStoc;
		List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
		art = this.getArticolByGestiune(produs, gestiune);
		cantitateDeIesit = cantitate;
		cantitateInitialaStoc = art.getCantPeGestiune();
		
		logger.info("3.2 Verificare identificare lot conform cu caracteristicile produsului.");
		if(this.verificareStoc(produs, gestiune) < cantitate)
		{
			logger.info("Nu exista in gestiunea " + gestiune.getDenumireGest() + "suficienta cantitate pentru produsul " + produs.getIdProd());
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
		if(this.verificareStoc(produs, gestiune) == 0.0)
		{
			logger.info("Articolul " + art.getIdArticol() + " are cantitatea egala cu 0 si este sters.");
			gestiune.removeArticole(art);
			logger.info("Articolul s-a sters.");
		}
		
	}

	@Override
	public void transfer(Produs produs, Gestiune gestiuneIesire,Gestiune gestiuneIntrare) {

		logger.info("5.1. Introducere produs si gestiune din care se transfera. Gestiune din care se transfera produsul "+ produs.getIdProd() + " este " + gestiuneIesire.getIdGest());
		logger.info("5.2. Verificare disponibilitate produs. Acest pas se realizeaza in cadrul metodei iesireStoc()");
		logger.info("5.3. Stabilire gestiune in care se transfera. Gestiunea in care se transfera este: " + gestiuneIntrare.getIdGest());
		logger.info("5.4. Stabilire cantitate de transferat. Cantitatea care se transfera este " + produs.getCantitate());
		
		logger.info(">>>>>>>>Se declanseaza iesire din gestiunea: " + gestiuneIesire.getIdGest() + "<<<<<<<<");
		this.iesireStoc(produs, gestiuneIesire, produs.getCantitate());
		logger.info(">>>>>>>>Se finalizeaza iesire din gestiunea: " + gestiuneIesire.getIdGest());
	
		logger.info(">>>>>>>>Se declanseaza intrarea in gestiunea: " + gestiuneIntrare.getIdGest() + "<<<<<<<<");
		this.intrareStoc(produs, gestiuneIntrare);
		logger.info(">>>>>>>>Se finalizeaza intrarea in gestiunea: " + gestiuneIntrare.getIdGest() + "<<<<<<<<");
		
		logger.info("A intrat in gestiune " + gestiuneIntrare.getIdGest() + " produsul " + produs.getIdProd() + " cu cantitatea " + produs.getCantitate());
		logger.info("5.5. Confirmare/Salvare transfer. S-a transferat din gestiunea: "+ gestiuneIesire.getIdGest() + " in gestiunea " + gestiuneIntrare.getIdGest() + " produsul " + produs.getIdProd() + " in cantitatea de " + produs.getCantitate());
		
		
	}

	@Override
	public void alertaStoc(Articol articol) {
		logger.info("-------------Declansare alerta-------------");
		logger.info("6.1. Preluare informatii produs " + articol.getProdus().getIdProd());
		Double pragStoc =2.00;
		logger.info("6.2. Verificare cantitate ramasa in stoc raportat la pragul minim stabilit.");
		if(articol.getCantPeGestiune() <= pragStoc)
		{
			logger.info("Alerta!!! Produsul " + articol.getProdus().getIdProd() + " are cantitatea sub pragul stabilit pentru stocul acestuia");
		}
		else
		{
			logger.info("Produsul " + articol.getProdus().getIdProd() + " are cantitatea peste pragul stabilit pentru stocul acestuia");
		}
		logger.info("-------------Final alerta-------------");
	}

	@Override
	public void casareLot() {
		// TODO Auto-generated method stub
		
	}

}
