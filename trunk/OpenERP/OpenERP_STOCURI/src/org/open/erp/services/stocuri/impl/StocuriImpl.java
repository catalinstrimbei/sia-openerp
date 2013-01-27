package org.open.erp.services.stocuri.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.UserTransaction;
import javax.xml.rpc.handler.MessageContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nommat.Material;

import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.ListaGestiuni;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;

/**
 * @ApplicationServiceImplementation
 * 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StocuriImpl implements StocuriSrv, StocuriSrvLocal {

	// private AchizitiiSrv achizitiiSrv;
	// private NomenclatorMaterialeSrv nomenclatorMaterialeSrv;

	// Dependente resurse proprii
	private static Logger logger = Logger
			.getLogger(StocuriImpl.class.getName());
	private RegistruStocuri registruStocuri;

	// Dependente resurse injectate
	@PersistenceContext(unitName = "OpenERP_STOCURI")
	private EntityManager em;

	@Resource
	private SessionContext sessionContext;

	// Initializare
	public StocuriImpl() {
	}

	@PostConstruct
	public void init() {
		if (this.registruStocuri == null)
			registruStocuri = new RegistruStocuri(em);

	}

	// intrarea in stoc pentru modulul achizitii - DONE
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void intrareStoc(Material material, Double cantitate, Double pret,
			Gestiune gestiune) throws Exception {
		List<Articol> lista = this.getArticolByGestiune(material, gestiune);
		if (lista.isEmpty()) {
			logger.info("Produsul nu este inregistrat in stoc, se creeaza un lot nou.");
			this.adaugareArtLot(material, cantitate, pret, gestiune);
		} else {
			for (Articol art : lista) {
				if (art != null) {
					logger.info("Produsul este deja inregistrat in stocuri.");
					art.addLot(creareLot(cantitate, pret, new Date(), art));
					// update articol
					this.salvareArticol(art);
				}
			}
		}
	}

	// intrarea in stoc pentru transferul intre gestiuni
	@Override
	public void intrareStoc(BonTransfer bonTransfer, Double pret)
			throws Exception {
		logger.info("2.1. Preluare date specifice produsului: id-ul produsul: "
				+ bonTransfer.getMaterial().getCodMaterial()
				+ ", cantitatea produsului: " + bonTransfer.getCantitate());
		logger.info("2.2. Verifica daca exista produsul "
				+ bonTransfer.getMaterial().getCodMaterial() + " in stoc");
		List<Articol> artLista = this.getArticolByGestiune(
				bonTransfer.getMaterial(), bonTransfer.getGestiuneIntrare());
		if (artLista.isEmpty()) {
			this.adaugareArtLot(bonTransfer.getMaterial(),
					bonTransfer.getCantitate(), pret,
					bonTransfer.getGestiuneIntrare());
		} else {
			for (Articol art : artLista) {
				if (art != null) {
					Loturi lot = creareLot(bonTransfer.getCantitate(), pret,
							new Date(), art);
					art.addLot(lot);
					// update
					this.salvareArticol(art);
				}
			}
		}
	}

	// intrarea in stoc pentru modulul productie
	@Override
	public void intrareStoc(Material material, Gestiune gestiune,
			Double cantitate) throws Exception {
		/*
		 * logger.info("2.1. Preluare date specifice produsului: id-ul produsul: "
		 * + material.getCodMaterial() + ", cantitatea produsului: " +
		 * cantitate); logger.info("2.2. Verifica daca exista produsul " +
		 * material.getCodMaterial() + " in stoc");
		 * 
		 * Articol art = this.getArticolByGestiune(material, gestiune); if (art
		 * != null) { logger.info("Produsul este deja inregistrat in stocuri.");
		 * // logger.info("Se creeza un lot nou pentru articolul gasit"); //
		 * logger
		 * .info("Se creste cantitatea pentru articolul gasit, cantitate veche: "
		 * + // art.getCantPeGestiune());
		 * 
		 * logger.info("2.3. Se creste cantitatea existenta in stoc " +
		 * art.getCantPeGestiune() + " cu cantitatea noua " + cantitate);
		 * 
		 * art.addLot(creareLot(cantitate, null, new Date(), art)); // Seteaza
		 * // pretul // preluandu-l // de la // modulul // ContabilitateGestiune
		 * 
		 * // update this.salvareArticol(art); //
		 * art.cresteCantitateArticolPeGestiune(produs.getCantitate());
		 * logger.info(
		 * "2.4. Confirmare/Modificare stoc curent, cantitatea dupa modificare este: "
		 * + art.getCantPeGestiune()); } else { logger.info(
		 * "Produsul nu este inregistrat in stoc, deci se creeaza un lot nou.");
		 * // logger.info("Se adauga un articol nou pentru produs.");
		 * logger.info("1.1. Se creeaza un lot nou pentru produsul " +
		 * material.getCodMaterial()); Articol artNou = creareArticol(0.00,
		 * gestiune, material, new ArrayList<Loturi>());
		 * gestiune.addArticole(artNou); // Articol artNou =
		 * this.getArticolByGestiune(material, gestiune);
		 * logger.info("1.2. Preluare date specifice produsului: id-ul produsului: "
		 * + material.getCodMaterial() + ", cantitatea produsului " +
		 * cantitate); // Loturi lotNou = new Loturi(2, cantitate, null, new
		 * Date());
		 * logger.info("1.3. Adaugare date specifice produsului in noul lot");
		 * Loturi lotNou = creareLot(cantitate, null, new Date(), artNou);
		 * artNou.addLot(lotNou); // update this.salvareArticol(artNou);
		 * 
		 * logger.info("1.4 Confirmare/Adaugare lot nou " + lotNou.getIdLot());
		 * }
		 */
	}

	// crearea unui art si lot nou la intrarea in gestiune
	@Override
	public void adaugareArtLot(Material material, Double cantitate,
			Double pret, Gestiune gestiune) throws Exception {
		Articol art = creareArticol(0.00, gestiune, material,
				new ArrayList<Loturi>());
		gestiune.addArticole(art);
		Loturi lot = creareLot(cantitate, pret, new Date(), art);
		art.addLot(lot);
		// modifica cantitatea pe gestiune
		this.salvareArticol(art);

	}

	// returnarea articolului dintr-o gestiune care contine un anumit material
	// @Override
	public List<Articol> getArticolByGestiune(Material material,
			Gestiune gestiune) {
		List<Articol> artLista = registruStocuri.getArticolByGestiune(
				material.getCodMaterial(), gestiune.getIdGest());
		return artLista;
	}

	// returnarea cantitatii unui material din stoc pe o anumita gestiune
	@Override
	public Double verificareStoc(Material material, Gestiune gestiune) {
		if (material == null) {
			logger.info("Valoarea produsului oferit ca parametru trebuie sa fie diferita de null");
			return null;
		}
		if (gestiune == null) {
			logger.info("Valoarea gestiunii oferita ca parametru trebuie sa fie diferita de null");
			return null;
		}

		List<Articol> artLista = this.getArticolByGestiune(material, gestiune);
		if (artLista.isEmpty())
			logger.info("Produsul nu exista in stoc");
		else
			for (Articol art : artLista) {
				return art.getCantPeGestiune();
			}
		return null;
	}

	// crearea si returnarea unei liste cu gestiunile existente in toata
	// aplicatie si pe care le pot folosii cei care au nevoie
	@Override
	public ListaGestiuni GestiuniDisponibile() {
		ListaGestiuni lista = new ListaGestiuni(1, null);
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		Gestiune gest3 = new Gestiune(3, "Gestiune 3", new Depozit(2, "Vaslui"));
		lista.addGestiune(gest1);
		lista.addGestiune(gest2);
		lista.addGestiune(gest3);
		return lista;
	}

	// verificarea stocului si returnarea contitatii unui material pe toate
	// gestiunile
	@Override
	public Double verificareStoc(Material material, ListaGestiuni listagest) {
		if (material == null) {
			logger.info("Valoarea produsului oferit ca parametru trebuie sa fie diferita de null");
			return null;
		}
		if (listagest == null) {
			logger.info("Valoarea listei de gestiuni oferita ca parametru trebuie sa fie diferita de null");
			return null;
		}
		Double CantitateDeReturnat = 0.00;

		for (Gestiune g : listagest.getGestiuni()) {
			for (Articol art : g.getArticole()) {
				if (art.getMaterial().equals(material)) {
					CantitateDeReturnat = CantitateDeReturnat
							+ art.getCantPeGestiune();
				}
			}
		}
		return CantitateDeReturnat;
	}

	// verificare stocului pentru un material, fara lista de gestiuni ca si
	// parametru
	@Override
	public Double verificareStoc(Material material) {
		return -1.00;
	}

	// iesire din gestiune pentru vanzari si productie
	@Override
	public void iesireStoc(Material material, Double cantitate,
			Gestiune gestiune) throws Exception {
		logger.info("3.1. Preluare date specifice produsului: id-ul produsul: "
				+ material.getCodMaterial() + ", cantitatea: " + cantitate);
		Double cantitateDeIesit, cantitateInitialaStoc;
		List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
		List<Articol> artLista = this.getArticolByGestiune(material, gestiune);
		cantitateDeIesit = cantitate;
		if (artLista.isEmpty())
			logger.info("Nu exista produsul in stoc");
		else {
			for (Articol art : artLista) {
				if (this.verificareStoc(material, gestiune) < cantitate) {
					logger.info("Nu exista in gestiunea "
							+ gestiune.getDenumireGest()
							+ "suficienta cantitate pentru produsul "
							+ material.getCodMaterial());
				} else {
					for (Loturi l : art.getLoturiArticole()) {
						if (l.getCantitate() > cantitate) {
							l.scadeCantitatea(cantitate);
							// update lot
							this.salvareLot(l);
							art.scadeCantitateArticolPeGestiune(cantitate);
							// update articol
							this.salvareArticol(art);
							break;
						} else if (l.getCantitate() == cantitate) {
							listaLoturiDeSters.add(l);
							break;
						} else {
							cantitate = cantitate - l.getCantitate();
							listaLoturiDeSters.add(l);
						}
					}
				}
				for (Loturi lot : listaLoturiDeSters) {
					art.removeLot(lot);
					// romove lot din registru
					this.registruStocuri.stergeLot(lot);
				}

				this.alertaStoc(art);
				if (this.verificareStoc(material, gestiune) == 0.0) {
					logger.info("Articolul " + art.getIdArticol()
							+ " are cantitatea egala cu 0 si este sters.");
					gestiune.removeArticole(art);
					logger.info("Articolul s-a sters.");
				}
			}
		}
	}

	// transferul unui material cu o anumita cantitate dintr-o gestiune in alta
	@Override
	public void transfer(BonTransfer bonTransfer) throws Exception {
		Double cantitateDeIesit;
		List<Loturi> listaLoturiDeSters = new ArrayList<Loturi>();
		List<Articol> artLista = this.getArticolByGestiune(
				bonTransfer.getMaterial(), bonTransfer.getGestiuneIesire());
		cantitateDeIesit = bonTransfer.getCantitate();
		
		if (artLista.isEmpty())
			logger.info("Nu exista articol pentru materialul de transferat");
		else {
			for (Articol art : artLista) {
				if (this.verificareStoc(bonTransfer.getMaterial(),
						bonTransfer.getGestiuneIesire()) < cantitateDeIesit) {
					logger.info("Nu exista in gestiunea "
							+ bonTransfer.getGestiuneIesire().getDenumireGest()
							+ "suficienta cantitate pentru produsul "
							+ bonTransfer.getMaterial().getCodMaterial());
				} else {
					for (Loturi l : art.getLoturiArticole()) {
						if (l.getCantitate() > cantitateDeIesit) {
							l.scadeCantitatea(cantitateDeIesit);
							logger.debug("Imi afiseaza info-uri");
							// update lot
							this.salvareLot(l);
							art.scadeCantitateArticolPeGestiune(cantitateDeIesit);
							// update articol
							this.salvareArticol(art);
							this.intrareStoc(bonTransfer.getMaterial(),
									cantitateDeIesit, l.getPretIntrare(),
									bonTransfer.getGestiuneIntrare());
							break;
						} else if (l.getCantitate() == cantitateDeIesit) {
							logger.info("Se scade cantitatea din gestiune a articolului "
									+ art.getIdArticol());
							// art.removeLot(l);
							listaLoturiDeSters.add(l);
							this.intrareStoc(bonTransfer.getMaterial(),
									cantitateDeIesit, l.getPretIntrare(),
									bonTransfer.getGestiuneIntrare());

							break;
						} else {
							cantitateDeIesit = cantitateDeIesit
									- l.getCantitate();
							listaLoturiDeSters.add(l);
							this.intrareStoc(bonTransfer.getMaterial(),
									l.getCantitate(), l.getPretIntrare(),
									bonTransfer.getGestiuneIntrare());

						}
					}
					for (Loturi lot : listaLoturiDeSters) {
						art.removeLot(lot);
						// sterge loturile care au cantitatea 0
						this.registruStocuri.stergeLot(lot);
					}
				}
			}

		}

	}

	// alerta stoc cand valoarea acestuia ajunge sa fie egala sau mai mica cu un
	// parg (2 in cazul de fata)
	@Override
	public void alertaStoc(Articol articol) {
		logger.info("-------------Declansare alerta-------------");
		logger.info("6.1. Preluare informatii produs "
				+ articol.getMaterial().getCodMaterial());
		Double pragStoc = 2.00;
		logger.info("6.2. Verificare cantitate ramasa in stoc raportat la pragul minim stabilit.");
		if (articol.getCantPeGestiune() <= pragStoc) {
			logger.info("Alerta!!! Produsul "
					+ articol.getMaterial().getCodMaterial()
					+ " are cantitatea sub pragul stabilit pentru stocul acestuia");
		} else {
			logger.info("Produsul "
					+ articol.getMaterial().getCodMaterial()
					+ " are cantitatea peste pragul stabilit pentru stocul acestuia");
		}
		logger.info("-------------Final alerta-------------");
	}

	/*
	 * @Override public boolean existaArticol(Produs produs, Gestiune gestiune){
	 * // TODO Auto-generated method stub for(Articol art:
	 * gestiune.getArticole()) { if(art.getProdus().equals(produs)) { //exista
	 * loturi return true; } } return false; }
	 */

	@Override
	public Articol creareArticol(Double cantPeGestiune, Gestiune gestiune,
			Material material, List<Loturi> loturiArticole) throws Exception {
		Articol articol = new Articol(cantPeGestiune, gestiune, material,
				loturiArticole);
		// salvare in baza de date
		salvareArticol(articol);
		return articol;
	}

	@Override
	public Articol salvareArticol(Articol articol) throws Exception {

		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true) {
			logger.debug("END Creare/salvare articol - TRANZACTIE ANULATA");
		} else {
			articol = this.registruStocuri.salveazaArticol(articol);
		}
		return articol;
	}

	public Loturi creareLot(Double cantitate, Double pretIntrare,
			Date dataIntrare, Articol articol) throws Exception {
		Loturi lot = new Loturi(cantitate, pretIntrare, dataIntrare, articol);

		// salvare in baza de date
		salvareLot(lot);
		return lot;
	}

	public Loturi salvareLot(Loturi lot) throws Exception {

		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true) {
			logger.debug(">>>>>>>>>>>> END Creare/salvare lot - TRANZACTIE ANULATA");
		} else {
			lot = this.registruStocuri.salveazaLot(lot);
		}
		return lot;
	}

	@Override
	public Depozit creareDepozit(String locatie) throws Exception {

		Depozit depozit = new Depozit(locatie);
		salvareDepozit(depozit);

		return depozit;
	}

	@Override
	public Depozit salvareDepozit(Depozit depozit) throws Exception {

		logger.debug("salvare depozit");
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true) {
			logger.debug(">>>>>>>>>>>> END Creare/salvare depozit - TRANZACTIE ANULATA");

		} else {
			depozit = this.registruStocuri.salveazaDepozit(depozit);
		}
		return depozit;
	}

	public Gestiune creareGestiune(String denumire, Depozit depozit)
			throws Exception {
		Gestiune gestiune = new Gestiune(denumire, depozit);

		// salvare in baza de date
		salvareGestiune(gestiune);
		return gestiune;
	}

	@Override
	public Gestiune salvareGestiune(Gestiune gestiune) throws Exception {

		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true) {
			logger.debug(">>>>>>>>>>>> END Creare/salvare gestiune - TRANZACTIE ANULATA");
		} else {
			gestiune = this.registruStocuri.salveazaGestiune(gestiune);

		}
		return gestiune;
	}

	public BonTransfer creareBonTransfer(Material material, Double cantitate,
			Gestiune gestiuneIntrare, Gestiune gestiuneIesire) throws Exception {
		BonTransfer bonTransfer = new BonTransfer(material, cantitate,
				gestiuneIntrare, gestiuneIesire);

		salvareBonTransfer(bonTransfer);
		return bonTransfer;
	}

	@Override
	public BonTransfer salvareBonTransfer(BonTransfer bonTransfer)
			throws Exception {

		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true) {
			logger.debug(">>>>>>>>>>>> END Creare/salvare bon transfer - TRANZACTIE ANULATA");
		} else {
			bonTransfer = this.registruStocuri.salveazaBonTransfer(bonTransfer);
		}

		return bonTransfer;
	}

	// Material
	public Material creareMaterial(Material mat) throws Exception {
		// Material material = new Material();
		em.persist(mat);
		return mat;
	}

	public Material getMaterial(String i) throws Exception {
		Material mat = registruStocuri.getMaterial(i);
		return mat;
	}

	@Override
	public List<Material> getMateriale() throws Exception {
		List<Material> materiale = registruStocuri.getToateMaterialele();
		if (materiale.isEmpty())
			logger.debug("Returner 000 material!");
		else
			logger.debug("Returner " + materiale.size() + " materiale!");
		return materiale;
	}

	// Gestiune
	@Override
	public Gestiune getGestiune(int IdGestiune) throws Exception {
		Gestiune gestiune = registruStocuri.getGestiune(IdGestiune);
		return gestiune;
	}

	@Override
	public List<Gestiune> getGestiuni() throws Exception {
		List<Gestiune> gestiuni = registruStocuri.getToateGestiunile();
		if (gestiuni.isEmpty())
			logger.debug("Returner 000 gestiuni!");
		else
			logger.debug("Returner " + gestiuni.size() + " gestiuni!");
		return gestiuni;
	}

	// Depozit
	@Override
	public List<Depozit> getDepozite() throws Exception {
		List<Depozit> depozite = registruStocuri.getToateDepozitele();
		if (depozite.isEmpty())
			logger.debug("Returner 000 depozite!");
		else
			logger.debug("Returner " + depozite.size() + " depozite!");
		return depozite;
	}

	@Override
	public void stergereDepozit(Depozit depozit) throws Exception {
		registruStocuri.stergeDepozit(depozit);
	}

	@Override
	public Depozit getDepozit(int i) throws Exception {
		Depozit depozit = registruStocuri.getDepozit(i);
		return depozit;
	}

}
