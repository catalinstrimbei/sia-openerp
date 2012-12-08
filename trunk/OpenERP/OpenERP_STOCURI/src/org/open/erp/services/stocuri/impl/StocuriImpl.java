package org.open.erp.services.stocuri.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.Produs;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;

import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.LiniiNIR;
import org.open.erp.services.nommat.Material;


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
	
	public void intrareStoc(NIR nir, Gestiune gestiune) 
	{
		for(LiniiNIR linie: nir.getLinieNir())
		{
			//Cei de la achizitii acum obiectul MATERIALE declarat local, cand o sa implementeze clasa MATERIAL de la nom materiale atunci nu o sa mai dea eroare
			logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + linie.getMaterial().getCodMaterial()+ ", cantitatea produsului: " + linie.getCantitate() + ", pretul de intrare: " + linie.getPret());
			
			logger.info("2.2. Verifica daca exista produsul " + linie.getMaterial().getCodMaterial() + " in stoc");
			Articol art = this.getArticolByGestiune(linie.getMaterial(), gestiune);
			if(art != null)
			{	
				logger.info("Produsul este deja inregistrat in stocuri.");
				//logger.info("Se creeza un lot nou pentru articolul gasit");
				//logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
				
				logger.info("2.3. Se creste cantitatea existenta in stoc" + art.getCantPeGestiune() + " cu cantitatea noua" + linie.getCantitate());
				art.addLot(new Loturi(1, linie.getCantitate(), linie.getPret(), new Date()));	
				//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
				logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
			}
			else
			{
				logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
				//logger.info("Se adauga un articol nou pentru produs.");
				this.creareLot(linie, gestiune);
			}
			
			
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
	
	@Override
	public void creareLot(LiniiNIR linie, Gestiune gestiune)
	{
		logger.info("1.1. Se creeaza un lot nou pentru produsul" + linie.getMaterial().getCodMaterial());
		gestiune.addArticole(new Articol(1, 0.00, gestiune, linie.getMaterial(), new ArrayList<Loturi>()));
		Articol art = this.getArticolByGestiune(linie.getMaterial(), gestiune);
		logger.info("1.2. Preluare date specifice produsului: id-ul produsului: " + linie.getMaterial().getCodMateriale + ", cantitatea produsului " + linie.getCantitate() + ", pretul de intrare " + linie.getPret());
		Loturi lot = new Loturi(2, linie.getCantitate(), linie.getPret(), new Date());
		logger.info("1.3. Adaugare date specifice produsului in noul lot");
		art.addLot(lot);
		
		logger.info("1.4 Confirmare/Adaugare lot nou " + lot.getIdLot());
	}
	
	
	@Override
	public Double verificareStoc(Material material, Gestiune gestiune) {
		// TODO Auto-generated method stub
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
	
	
	public void intrareStoc(BonTransfer bonTransfer) 
	{
			//Cei de la achizitii acum obiectul MATERIALE declarat local, cand o sa implementeze clasa MATERIAL de la nom materiale atunci nu o sa mai dea eroare
			logger.info("2.1. Preluare date specifice produsului: id-ul produsul: " + bonTransfer.getMaterial().getCodMaterial()+ ", cantitatea produsului: " + bonTransfer.getCantitate());
			
			logger.info("2.2. Verifica daca exista produsul " + bonTransfer.getMaterial().getCodMaterial() + " in stoc");
			Articol art = this.getArticolByGestiune(bonTransfer.getMaterial(), bonTransfer.getGestiuneIntrare());
			if(art != null)
			{	
				logger.info("Produsul este deja inregistrat in stocuri.");
				//logger.info("Se creeza un lot nou pentru articolul gasit");
				//logger.info("Se creste cantitatea pentru articolul gasit, cantitate veche: " + art.getCantPeGestiune());
				
				logger.info("2.3. Se creste cantitatea existenta in stoc" + art.getCantPeGestiune() + " cu cantitatea noua" + bonTransfer.getCantitate());
				//nu avem deocamdata pretul
				art.addLot(new Loturi(1, bonTransfer.getCantitate(), null, new Date()));	
				//art.cresteCantitateArticolPeGestiune(produs.getCantitate());
				logger.info("2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "+ art.getCantPeGestiune());
			}
			else
			{
				logger.info("Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
				//logger.info("Se adauga un articol nou pentru produs.");
				
				logger.info("1.1. Se creeaza un lot nou pentru produsul" + bonTransfer.getMaterial().getCodMaterial());
				bonTransfer.getGestiuneIntrare().addArticole(new Articol(1, 0.00, bonTransfer.getGestiuneIntrare(), bonTransfer.getMaterial(), new ArrayList<Loturi>()));
				Articol artNou = this.getArticolByGestiune(bonTransfer.getMaterial(), bonTransfer.getGestiuneIntrare());
				logger.info("1.2. Preluare date specifice produsului: id-ul produsului: " + bonTransfer.getMaterial().getCodMaterial() + ", cantitatea produsului " + bonTransfer.getCantitate());
				Loturi lot = new Loturi(2, bonTransfer.getCantitate(),null, new Date());
				logger.info("1.3. Adaugare date specifice produsului in noul lot");
				art.addLot(lot);
				
				logger.info("1.4 Confirmare/Adaugare lot nou " + lot.getIdLot());
				
				//this.creareLot(linie, gestiune);
			}
			
		
	}

	@Override
	public void transfer(BonTransfer bonTransfer) {

		logger.info("5.1. Introducere produs si gestiune din care se transfera. Gestiune din care se transfera produsul "+ bonTransfer.getMaterial().getCodMaterial() + " este " + bonTransfer.getGestiuneIesire().getIdGest());
		logger.info("5.2. Verificare disponibilitate produs. Acest pas se realizeaza in cadrul metodei iesireStoc()");
		logger.info("5.3. Stabilire gestiune in care se transfera. Gestiunea in care se transfera este: " + bonTransfer.getGestiuneIntrare().getIdGest());
		logger.info("5.4. Stabilire cantitate de transferat. Cantitatea care se transfera este " + bonTransfer.getMaterial().getCodMaterial());
		
		logger.info(">>>>>>>>Se declanseaza iesire din gestiunea: " + bonTransfer.getGestiuneIesire().getIdGest() + "<<<<<<<<");
		//iesire standard
		this.iesireStoc(bonTransfer.getMaterial(), bonTransfer.getCantitate(), bonTransfer.getGestiuneIesire());
		logger.info(">>>>>>>>Se finalizeaza iesire din gestiunea: " + bonTransfer.getGestiuneIesire().getIdGest());
	
		logger.info(">>>>>>>>Se declanseaza intrarea in gestiunea: " + bonTransfer.getGestiuneIntrare().getIdGest() + "<<<<<<<<");
		//intrare specifica transferului
		this.intrareStoc(bonTransfer);
		logger.info(">>>>>>>>Se finalizeaza intrarea in gestiunea: " + bonTransfer.getGestiuneIntrare().getIdGest() + "<<<<<<<<");
		
		logger.info("A intrat in gestiune " + bonTransfer.getGestiuneIntrare().getIdGest() + " produsul " + bonTransfer.getMaterial().getCodMaterial() + " cu cantitatea " + bonTransfer.getCantitate());
		logger.info("5.5. Confirmare/Salvare transfer. S-a transferat din gestiunea: "+ bonTransfer.getGestiuneIesire().getIdGest() + " in gestiunea " + bonTransfer.getGestiuneIntrare().getIdGest() + " produsul " + bonTransfer.getMaterial().getCodMaterial() + " in cantitatea de " + bonTransfer.getCantitate());
		
		
	}

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

	@Override
	public void casareLot() {
		// TODO Auto-generated method stub
		
	}

}
