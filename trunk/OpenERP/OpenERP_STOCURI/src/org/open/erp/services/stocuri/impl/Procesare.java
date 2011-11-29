package org.open.erp.services.stocuri.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.CerereAprovizionare;
import org.open.erp.services.achizitii.LinieCerereAprovizionare;
import org.open.erp.services.nomenclatoare.MaterialPrim;
import org.open.erp.services.nomenclatoare.Material;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.BonConsum;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.ComandaProduse;
import org.open.erp.services.stocuri.Document;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Linie;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.exceptions.IesiriStocExceptions;
import org.open.erp.services.stocuri.exceptions.IntrariStocExceptions;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.exceptions.TransferStocExceptions;
import org.open.erp.services.stocuri.teste.ProjectDummyFactory;
import org.open.erp.services.stocuri.util.StocuriLogger;

/**
 * 
 * @BusinessObject(Service)
 * 
 */

public class Procesare {
	private List<Gestiune> gestiuni = new ArrayList<Gestiune>();
	private Angajat responsabil;
	private AplicarePret aplicarepret;
	private StocuriLogger logger = new StocuriLogger();

	public Procesare(List<Gestiune> gestiuni, Angajat responsabil,
			AplicarePret aplicarepret) {
		super();
		this.gestiuni = gestiuni;
		this.responsabil = responsabil;
		this.aplicarepret = aplicarepret;
		logger.loggeazaDEBUG("Creare obiect Procesare.-----");
	}

	public Document preoceseazaComandaMateriale(
			CerereAprovizionare comandaMateriale) {
		logger.loggeazaDEBUG("Inceput Procesare comanda Materiale.-----");
		try {
			List<Linie> produseInSuficiente = new ArrayList<Linie>();
			List<Linie> produseSuficiente = new ArrayList<Linie>();
			Integer canNecesara = 0;
			Integer cantExistenta = 0;
			MaterialPrim prodTest;
			BonConsum bonConsum;
			CerereAprovizionare comAprov;
			for (Linie linie : comandaMateriale.getLinii()) {
				prodTest = (MaterialPrim) linie.getMaterial();
				canNecesara = linie.getCantitate();
				cantExistenta = verificareStocMaterial(prodTest);

				if (canNecesara > cantExistenta) {
					produseInSuficiente.add(linie);
				} else {
					produseSuficiente.add(linie);
				}

			}
			
			if (!produseInSuficiente.isEmpty()
					&& comandaMateriale.getLivrarePartiala().equalsIgnoreCase(
							"yes")) {

				bonConsum = new BonConsum(1, new Date(), "solicitant",
						responsabil);
				bonConsum.getLinii().addAll(produseSuficiente);

				comAprov = new CerereAprovizionare(1, "1", new Date(),
						"observatie");
				addLiniiCerereAprovizionare(comAprov, produseInSuficiente);
				// apelem metoda din modului achizitii
				ProjectDummyFactory.getAchizitionareSrv()
						.inregistrareCerereAprovizionare(comAprov);
				// TODO de adaugat in lista cu prioritati
			} else if (!produseInSuficiente.isEmpty()
					&& comandaMateriale.getLivrarePartiala().equalsIgnoreCase(
							"no")) {
				// intoarcem bon consum null
				// bonConsum = new BonConsum(1, new Date(), "solicitant",
				// responsabil);
				bonConsum = null;
				comAprov = new CerereAprovizionare(1, "1", new Date(),
						"observatie");
				addLiniiCerereAprovizionare(comAprov, produseInSuficiente);
				// apelem metoda din modului achizitii
				ProjectDummyFactory.getAchizitionareSrv()
						.inregistrareCerereAprovizionare(comAprov);
				// TODO de adaugat in lista cu prioritati
			} else {
				bonConsum = new BonConsum(1, new Date(), "solicitant",
						responsabil);
				bonConsum.getLinii().addAll(produseSuficiente);

			}
			proceseazaBonConsum(bonConsum);
			logger.loggeazaDEBUG("Sfarsit Procesare comanda Materiale.-----");
			return bonConsum;
			
		} catch (StocuriExceptions x) {
			x.printStackTrace();
			x.logger.loggeazaERROR(x.getMessage(), x);
			return null;
		}
	}

	private void proceseazaBonConsum(Document doc) throws StocuriExceptions {
		logger.loggeazaDEBUG("Inceput Procesare bon consum.-----");
		if (doc == null) {
			return;
		}
		Integer cantLot;
		Material mijCirc;
		Integer cantNecesara;
		ArticolStoc articol;
		Integer cantitateLivrata = 0;
		for (Linie linie : doc.getLinii()) {
			mijCirc = linie.getMaterial();
			cantNecesara = linie.getCantitate();
			terminatLinie:
			// caut in fiecare gestiune stocul de produse/materiale(pe loturi)
			for (int i = 0; i < gestiuni.size(); i++) {
				articol = getArticolByMijlocAndGestiune(mijCirc,
						gestiuni.get(i));
				// pt fiecare lot in parte verifice daca cantitatea e suficienta
				// daca e sufucienta iau din lot(actualizez stocul) si trec la
				// umatoare linie din
				// bonul de consum.
				if (articol != null) {
					for (LoturiIntrari lot : articol.getLoturiIntrariArt()) {
						cantLot = lot.getCantitate();
						if (cantNecesara > cantLot) {
							cantNecesara -= lot.getCantitate();
							cantitateLivrata = lot.getCantitate();
							lot.setCantitate(0);
						} else {
							cantitateLivrata = cantNecesara;
							lot.setCantitate(cantLot - cantNecesara);
							cantNecesara = 0;
						}
						// se aplica metoda pretului stabilit( FIFO, LIFO) pt
						// fiecare lot in parte si se aduna
						// la valoarea liniei din bonul de consum pt produsul
						// respectiv
						linie.incementeazaPret(cantitateLivrata
								* aplicarepret.getPretProdLot(articol));
						// se actualizeaza stocul pe fiecare articol din
						// gestiunea respectiva
						if (lot.getCantitate() == 0) {
							lot.getArticol().removeLotIntrare(lot);
						} else {
							lot.getArticol()
									.decrementeazaCantArticolPeGestiune(
											cantitateLivrata);
						}

						if (cantNecesara == 0) {
							break terminatLinie;
						}
					}

				}
			}
		}
		logger.loggeazaDEBUG("Sfarsit Procesare bon consum.-----");
	}

	public ArticolStoc getArticolByMijlocAndGestiune(Material mijCirc,
			Gestiune gestiune) {
		   logger.loggeazaDEBUG("Cautare articol din gestiunea "+ gestiune.getDenumire()+" cu mijlocul circulant "+mijCirc.getDenumire()+" -----");
			for (ArticolStoc a : gestiune.getArticole()) {
				if (a.getMaterial().equals(mijCirc)) {
					  logger.loggeazaDEBUG("Gasit articolul "+a.getIdArticolStoc()+" -----");
					return a;
				}
			
		}
		return null;
	}

	public void addLiniiCerereAprovizionare(CerereAprovizionare comAprov,
			List<Linie> produseInSuficiente) {
		for (Linie l : produseInSuficiente) {
			comAprov.addlinie(new LinieCerereAprovizionare(1, comAprov,
					(MaterialPrim) l.getMaterial(), l.getCantitate()));
		}
	}

	public Integer verificareStocMaterial(Material material) throws StocuriExceptions {
		logger.loggeazaDEBUG("Verificare Stoc total pt material "+material.getDenumire()+" -----");
		Integer cant = 0;
		boolean exista = false;
		for (Gestiune gest : gestiuni) {
			for (ArticolStoc art : gest.getArticole()) {
				if (art.getMaterial().equals(material)) {
					for (LoturiIntrari lot : art.getLoturiIntrariArt()) {
						cant += lot.getCantitate();
					}
					exista = true;
				}
			}
		}
		if (!exista) {
			throw new StocuriExceptions("Materialul nu este in soc in nici o gestiune");
		}
		logger.loggeazaDEBUG("Gasit cantitate stoc "+cant+" -----");
		return cant;
	}

	public void intrareInStoc(Material material,
			LoturiIntrari lot, Gestiune gestiune) throws IntrariStocExceptions {
		  logger.loggeazaDEBUG("Intrare in Stoc pt mijlocul "+material
				  +" cu lotul "+ lot.getIdLot()+ "in gestiunea "+ gestiune.getDenumire()+" -----");
		if (material == null){
			throw new IntrariStocExceptions("Mijlocul Circulant nu trebuie sa fie null la intrarea in stoc!!");
		}
		if (gestiune == null){
			throw new IntrariStocExceptions("Gestiunea in  nu trebuie sa fie nulla !!");
		}
		boolean exista = false;
		for (ArticolStoc articol : gestiune.getArticole()) {
			if (articol.getMaterial().equals(material)) {
				articol.addLotIntrare(lot);
				lot.setArticol(articol);
				exista = true;
				break;
			}
		}
		if (!exista) {// id-ul va fi generat din baza de date
			ArticolStoc artNou = new ArticolStoc(100, 0, gestiune,
					material);
			artNou.addLotIntrare(lot);
			lot.setArticol(artNou);
			gestiune.addArticole(artNou);
		}
		  logger.loggeazaDEBUG("END Adaugat in Stoc  -----");
	}

	public  List<LoturiIntrari> iesireDinStocPeGestiune(Gestiune gestOut,
			Material material, Integer cantitate )throws StocuriExceptions{
		  logger.loggeazaDEBUG("Iesire din stoc a mijlocului "+material.getDenumire()
				  +"in cantitate de "+ cantitate+" -----");
		if (material == null){
			throw new IesiriStocExceptions("Mijlocul Circulant nu trebuie sa fie null la intrarea in stoc!!");
		}
		if (gestOut == null){
			throw new IesiriStocExceptions("Gestiunea out nu trebuie sa fie nulla !!");
		}
		if (cantitate == null|| cantitate <= 0){
			throw new IesiriStocExceptions("Cantitatea trebuie sa fie pozitiva !!");
		}
		
		boolean are = false;
		Integer cantRamasa = cantitate;
		List<LoturiIntrari> loturiOut = new ArrayList<LoturiIntrari>();
		List<LoturiIntrari> loturiRemove = new ArrayList<LoturiIntrari>();
		articoleFor:
		for (ArticolStoc art : gestOut.getArticole()) {
			if (art.getMaterial().equals(material)) {
				if (cantRamasa > art.getCatitateStocPeGestiune()) {
					throw new IesiriStocExceptions(
							"Stoc insuficient in aceasta  gestiune !!");
				} else {
					for (LoturiIntrari lot : art.getLoturiIntrariArt()) {
						if (cantRamasa >= lot.getCantitate() && cantRamasa != 0) {
							// art.removeLotIntrare(lot);
							loturiRemove.add(lot);
							loturiOut.add(lot);
							cantRamasa = cantRamasa - lot.getCantitate();
						} else if (cantRamasa <= lot.getCantitate()
								&& cantRamasa != 0) {
							lot.decrementeazaCant(cantRamasa);
							
							// id-ul va fi  generat din  baza de date
							LoturiIntrari lotPartial = new LoturiIntrari(400,
									cantRamasa, lot.getPretIntrare(),
									lot.getDataIntrare(), art);
							loturiOut.add(lotPartial);
						
							cantRamasa = 0;
							break ;
						}
					}
					for (LoturiIntrari l : loturiRemove) {
						art.removeLotIntrare(l);
					}
					
				}
				are = true;
				break articoleFor;
			}

		}
		if (!are) {
			throw new IesiriStocExceptions(
					"Gestiunea out  nu contine materialul/produsul necesar transferului !!");
		}
		  logger.loggeazaDEBUG("END Iesit mijloc Circ  -----");
		return loturiOut;
	}
	
	public void iesireDinStoc(Material material, Integer cantitate)throws StocuriExceptions {
		//verific daca cantitatea ceruta nu e mai mare decat cantitatea
		//totala din stocuri(pe toate loturile, din toate gestiunile)
		if(cantitate > verificareStocMaterial(material)){
			throw new IesiriStocExceptions("Produse/materiale insuficiete in stoc!!!");
		}
		Integer cantTemp=0;
		
		for(Gestiune g :gestiuni){
			ArticolStoc a = getArticolByMijlocAndGestiune(material, g);
			cantTemp = a.getCatitateStocPeGestiune();
			
			if( cantitate > 0 && cantitate > cantTemp){
				cantitate-=cantTemp;
				iesireDinStocPeGestiune(g, material, cantTemp);
			}else{
				iesireDinStocPeGestiune(g, material, cantitate);
				cantitate=0;
			}
			
		}
		
	}
	
	public void procesareComandaProduseVanzare(ComandaProduse comProd)throws StocuriExceptions{
		for(Linie l :comProd.getLinii()){
			iesireDinStoc(l.getMaterial(), l.getCantitate());
		}
	}
	
	
	
	
	public void transfer(Gestiune gestOut, Gestiune gestIn,
			Material material, Integer cantitate) throws StocuriExceptions{
		
		    List<LoturiIntrari> loturiOut = iesireDinStocPeGestiune(gestOut, material, cantitate);
			for (LoturiIntrari l : loturiOut) {
				intrareInStoc(material, l, gestIn);
			}
		

	}

}
