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

public class StocuriImpl implements StocuriSrv{
	
	private AchizitiiSrv achizitiiSrv;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StocuriImpl.class.getName());

	public void setAchizitiiSrv(AchizitiiSrv achizitiiSrv) {
		this.achizitiiSrv = achizitiiSrv;
	}
	
	@Override
	
	public void intrareStoc(Produs produs, Gestiune gestiune) {
		
		
		logger.info("Verifica daca exista articole");
		Articol art = this.getArticolByGestiune(produs, gestiune);
		
		if(art != null)
		{	
			logger.info("Articolul exista: " + art.getIdArticol());
			logger.info("Se creeza un lot nou pentru articolul gasit");
			art.addLot(new Loturi(1, produs.getCantitate(), produs.getPretIntrare(), new Date()));	
			logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
			art.cresteCantitateArticolPeGestiune(produs.getCantitate());
			logger.info("Cantitate noua: "+ art.getCantPeGestiune());
		}
		else
		{
			logger.info("Articolul nu exista");
			logger.info("Se adauga un articol nou pentru produsul primit ca parametru");
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
	public Articol getArticolByGestiune(Produs produs, Gestiune gestiune){
		// TODO Auto-generated method stub
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
	public void creareLot(Produs produs, Gestiune gestiune){
		gestiune.addArticole(new Articol(1, 0.00, gestiune, produs, new ArrayList<Loturi>()));
		Articol art = this.getArticolByGestiune(produs, gestiune);
		logger.info("Se creeaza lotul pentru articolul nou creat: " + art.getIdArticol());
		//List<Loturi> lot = new ArrayList<Loturi>();
		Loturi lot = new Loturi(2, produs.getCantitate(), produs.getPretIntrare(), new Date());
		
		logger.info("!!!!!!!!!!!!!!!Lot pentru articolul nou");
		
		//for (Loturi l : lot){
			art.addLot(lot);
			
			logger.info("Se creste cantitate pentru articolul creat, cantitate veche: " + art.getCantPeGestiune());
			art.cresteCantitateArticolPeGestiune(produs.getCantitate());
			logger.info("Noua cantitate este " + art.getCantPeGestiune() );
		//}
		
		
	}
	
	
	@Override
	public Integer verificareStoc(Produs produs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void iesireStoc(Produs produs, Integer cantitate) {
		// TODO Auto-generated method stub
		
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
