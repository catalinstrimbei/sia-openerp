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
		logger.info("Verifica daca exista articol");
		Articol art = this.getArticolByGestiune(produs, gestiune);
		if(art != null)
		{	
			logger.info("Articolul exista: " + art.getIdArticol());
			logger.info("Se creeza un lot nou pentru articolul gasit");
			logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
			art.addLot(new Loturi(1, produs.getCantitate(), produs.getPretIntrare(), new Date()));	
			//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
			logger.info("Cantitate noua: "+ art.getCantPeGestiune());
		}
		else
		{
			logger.info("Articolul nu exista");
			logger.info("Se adauga un articol nou pentru produs.");
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
		//se adauga un articol pentru produs
		gestiune.addArticole(new Articol(1, 0.00, gestiune, produs, new ArrayList<Loturi>()));
		Articol art = this.getArticolByGestiune(produs, gestiune);
		logger.info("Se creeaza lotul pentru articolul nou creat: " + art.getIdArticol());
		logger.info("Se creste cantitate pentru articolul creat, cantitate veche: " + art.getCantPeGestiune());
		Loturi lot = new Loturi(2, produs.getCantitate(), produs.getPretIntrare(), new Date());
		art.addLot(lot);
		//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
		logger.info("Cantitate noua " + art.getCantPeGestiune() );
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
				logger.info("Se verifica in cadrul metodei verificare stoc existenta produsului cautat");
				return art.getCantPeGestiune();
				
			}
		}
		return null;
	}

	
	@Override
	public void iesireStoc(Produs produs, Gestiune gestiune, Double cantitate) 
	{
		Articol art;
		List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
		art = this.getArticolByGestiune(produs, gestiune);
		if(this.verificareStoc(produs, gestiune) < cantitate)
		{
			logger.info("Nu exista in gestiunea " + gestiune.getDenumireGest() + "suficienta cantitate pentru produsul " + produs.getIdProd());
		}
		else
		{
			//listaLoturiDeSters = art.getLoturiArticole();
			for(Loturi l : art.getLoturiArticole())
			{
				logger.info("Lotul: " +l.getIdLot());
				
				if(l.getCantitate() > cantitate)
				{
					logger.info("Se scade cantitatea: " + cantitate + " din lotul " +  l.getIdLot());
					l.scadeCantitatea(cantitate);
					//logger.info("Se scade cantitatea de: " + cantitate + " din gestiune a articolului " +  art.getIdArticol());
					art.scadeCantitateArticolPeGestiune(cantitate);
					break;
				}
				else if(l.getCantitate() == cantitate)
				{
					logger.info("Se sterge lotul: " + l.getIdLot() + " din gestiune pentru articolul: " + art.getIdArticol());
					logger.info("Se scade cantitatea din gestiune a articolului " +  art.getIdArticol());
					//art.removeLot(l);
					listaLoturiDeSters.add(l);
				
					break;
				}
				else
				{
					logger.info("Se scade cantitatea: " + l.getCantitate() + " din lotul: "  + l.getIdLot());
					cantitate = cantitate - l.getCantitate();
					//logger.info("Se sterge lotul "  + l.getIdLot());
					logger.info("Cantitatea care ramane de cautat dupa scoaterea din primul lot este: " + cantitate);
					//art.removeLot(l);
					listaLoturiDeSters.add(l);
	
				}
			
			}
			for(Loturi lot : listaLoturiDeSters)
			{
				art.removeLot(lot);
			}
		}
		logger.info("Cantitatea ramasa in gestiunea: " + gestiune.getIdGest() + " " + gestiune.getDenumireGest() + " este " + art.getCantPeGestiune());
		if(this.verificareStoc(produs, gestiune) == 0.0)
		{
			logger.info("Articolul " + art.getIdArticol() + "are cantitatea egala cu 0 si este sters.");
			gestiune.removeArticole(art);
			logger.info("Articolul s-a sters.");
		}
		
	}

	@Override
	public void transfer(Produs produs, Gestiune gestiuneIesire,
			Gestiune gestiuneIntrare, Integer cantitate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alertaStoc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void casareLot() {
		// TODO Auto-generated method stub
		
	}

}
