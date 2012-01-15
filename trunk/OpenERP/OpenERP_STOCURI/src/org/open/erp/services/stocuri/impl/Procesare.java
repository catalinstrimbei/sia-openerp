package org.open.erp.services.stocuri.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.BonConsum;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.PrioritateMaterialeProductie;
import org.open.erp.services.stocuri.exceptions.IesiriStocExceptions;
import org.open.erp.services.stocuri.exceptions.IntrariStocExceptions;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.registri.RegistruArticoleStoc;
import org.open.erp.services.stocuri.registri.RegistruGestiune;
import org.open.erp.services.stocuri.registri.RegistruLoturiIntrari;
import org.open.erp.services.stocuri.registri.RegistruPrioritatiMaterialeProductie;
import org.open.erp.services.stocuri.util.StocuriLogger;

/**
 * 
 * @BusinessObject(Service)
 * 
 */

public class Procesare {
	private List<Gestiune> gestiuni = new ArrayList<Gestiune>();

	private AplicarePret aplicarepret;
	private final StocuriLogger logger = new StocuriLogger();
	// Cei care vor astepta <CerereAprovizionare>. In cazul nostru
	// AprovizionareImpl
	private final List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

	private EntityManager em;
	private RegistruGestiune regGest;
	private RegistruArticoleStoc regArtStoc;
	private RegistruLoturiIntrari regLoturi;
	private RegistruPrioritatiMaterialeProductie regPrioritati;

	public RegistruGestiune getRegGest() {
		return regGest;
	}

	public RegistruArticoleStoc getRegArtStoc() {
		return regArtStoc;
	}

	public RegistruLoturiIntrari getRegLoturi() {
		return regLoturi;
	}

	public Procesare() {
	};

	public Procesare(AplicarePret aplicarepret, EntityManager em) {
		super();
		this.aplicarepret = aplicarepret;
		this.em = em;
		regGest = new RegistruGestiune(em);
		regArtStoc = new RegistruArticoleStoc(em);
		regLoturi = new RegistruLoturiIntrari(em);
		//
		gestiuni = regGest.getListaByClasa(Gestiune.class);

		logger.loggeazaDEBUG("Creare obiect Procesare cu em-----");
	}

	public Procesare(List<Gestiune> gestiuni, AplicarePret aplicarepret) {
		super();
		this.gestiuni = gestiuni;
		this.aplicarepret = aplicarepret;
		logger.loggeazaDEBUG("Creare obiect Procesare.-----");
	}

	public Document proceseazaComandaMateriale(
			CerereAprovizionare comandaMateriale) {
		logger.loggeazaDEBUG("Inceput Procesare comanda Materiale.-----");
		try {
			List<LinieDocument> produseInSuficiente = new ArrayList<LinieDocument>();
			List<LinieDocument> produseSuficiente = new ArrayList<LinieDocument>();
			Double canNecesara = 0.0;
			Double cantExistenta = 0.0;
			MateriePrima prodTest;
			BonConsum bonConsum;
			CerereAprovizionare comAprov;
			for (LinieDocument linie : comandaMateriale.getLiniiDocument()) {
				prodTest = (MateriePrima) linie.getMaterial();
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

				bonConsum = new BonConsum(1, new Date(), "solicitant", null);
				bonConsum.getLiniiDocument().addAll(produseSuficiente);

				comAprov = new CerereAprovizionare(1, new Date(), null,
						"observatie");
				addLiniiCerereAprovizionare(comAprov, produseInSuficiente);
				// apelem metoda din modului achizitii
				// ProjectDummyFactory.getAprovizionareSrv().inregistrareCerereAprovizionare(comAprov);

				PrioritateMaterialeProductie prioritate = new PrioritateMaterialeProductie(
						null, new Date(), null);
				prioritate.getLiniiDocument().addAll(
						comAprov.getLiniiDocument());
				regPrioritati.saveEntity(prioritate);
			} else if (!produseInSuficiente.isEmpty()
					&& comandaMateriale.getLivrarePartiala().equalsIgnoreCase(
							"no")) {
				// intoarcem bon consum null
				// bonConsum = new BonConsum(1, new Date(), "solicitant",
				// responsabil);
				bonConsum = null;
				comAprov = new CerereAprovizionare(1, new Date(), null,
						"observatie");
				addLiniiCerereAprovizionare(comAprov, produseInSuficiente);
				// apelem metoda din modului achizitii
				// ProjectDummyFactory.getAprovizionareSrv().inregistrareCerereAprovizionare(comAprov);
				// TODO de adaugat in lista cu prioritati
			} else {
				bonConsum = new BonConsum(1, new Date(), "solicitant", null);
				bonConsum.getLiniiDocument().addAll(produseSuficiente);

			}
			proceseazaBonConsum(bonConsum);
			logger.loggeazaDEBUG("Sfarsit Procesare comanda Materiale.-----");
			return bonConsum;

			// todo de salvat bonConsum si comandaAprovizionare cu meotdele de
			// la cei de la NOMGEN

		} catch (StocuriExceptions x) {
			x.printStackTrace();
			StocuriExceptions.logger.loggeazaERROR(x.getMessage(), x);
			return null;
		}
	}

	private void proceseazaBonConsum(Document doc) throws StocuriExceptions {
		logger.loggeazaDEBUG("Inceput Procesare bon consum.-----");
		if (doc == null) {
			return;
		}
		Integer cantLot;
		Material material;
		Integer cantNecesara;
		ArticolStoc articol;
		Integer cantitateLivrata = 0;
		for (LinieDocument linie : doc.getLiniiDocument()) {
			material = linie.getMaterial();
			cantNecesara = linie.getCantitate().intValue();
			terminatLinie:
			// caut in fiecare gestiune stocul de produse/materiale(pe loturi)
			for (int i = 0; i < gestiuni.size(); i++) {
				articol = regArtStoc.getArticolByGestiuneAndMaterial(gestiuni
						.get(i).getIdGestiune(), material.getIdMaterial());

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
						linie.setPret(linie.getPret() + cantitateLivrata
								* aplicarepret.getPretProdLot(articol));
						// se actualizeaza stocul pe fiecare articol din
						// gestiunea respectiva
						if (lot.getCantitate() == 0) {
							regLoturi.removeEntity(lot);
						} else {
							lot.getArticol()
									.decrementeazaCantArticolPeGestiune(
											cantitateLivrata);
						}

						if (cantNecesara == 0) {
							regArtStoc.saveEntity(articol);
							break terminatLinie;
						}
					}

				}
				regArtStoc.saveEntity(articol);
			}
		}
		logger.loggeazaDEBUG("Sfarsit Procesare bon consum.-----");
	}

	public void addLiniiCerereAprovizionare(CerereAprovizionare comAprov,
			List<LinieDocument> produseInSuficiente) {
		for (LinieDocument l : produseInSuficiente) {
			comAprov.addLinie(new LinieDocument(1, comAprov, l.getMaterial(), l
					.getCantitate(), 0.0, 0.0));
		}
		// Se notifica listener-ii, in cazul acesta AprovizionareImpl, de
		// crearea unei Cereri de Aprovizionare
		notifyListeners(this, comAprov);
	}

	private void notifyListeners(Object sursa, CerereAprovizionare cerere) {
		for (Iterator<PropertyChangeListener> iterator = listener.iterator(); iterator
				.hasNext();) {
			PropertyChangeListener name = iterator.next();
			PropertyChangeEvent evt = new PropertyChangeEvent(sursa, null,
					null, cerere);
			name.propertyChange(evt);

		}
	}

	public void addChangeListener(PropertyChangeListener newListener) {
		listener.add(newListener);
	}

	public Double verificareStocMaterial(Material material)
			throws StocuriExceptions {
		logger.loggeazaDEBUG("Verificare Stoc total pt material "
				+ material.getDenumire() + " -----");
		Double cant = 0.0;
		boolean exista = false;
		for (Gestiune gest : gestiuni) {
			for (ArticolStoc art : gest.getArticole()) { /*
														 * problema posibila too
														 * deep bag
														 */
				if (art.getMaterial().equals(material)) {
					for (LoturiIntrari lot : regLoturi.getLoturiByArticol(art
							.getIdArticolStoc())) {
						cant += lot.getCantitate();
					}
					exista = true;
				}
			}
		}

		if (!exista) {
			throw new StocuriExceptions(
					"Materialul nu este in stoc in nici o gestiune");
		}
		logger.loggeazaDEBUG("Gasit cantitate stoc " + cant + " -----");
		return cant;
	}

	public Boolean intrareInStoc(Document doc, Gestiune gestIn) {
		try {
			if (gestIn == null) {
				gestIn = gestiuni.get(0);
			}
			for (LinieDocument l : doc.getLiniiDocument()) {
				// id va fi autogenerat
				intrareInStoc(l.getMaterial(), new LoturiIntrari(1, l
						.getCantitate().intValue(), l.getPret(), new Date(),
						null), gestIn);
			}
			return true;
		} catch (IntrariStocExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR("eroare !!!");
			return false;
		}

	}

	public void intrareInStoc(Material material, LoturiIntrari lot,
			Gestiune gestiune) throws IntrariStocExceptions {

		logger.loggeazaDEBUG("Intrare in Stoc pt mijlocul "
				+ material.getDenumire() + " cu lotul " + lot.getIdLot()
				+ "in gestiunea " + gestiune.getDenumire() + " -----");
		if (material == null) {
			throw new IntrariStocExceptions(
					"Mijlocul Circulant nu trebuie sa fie null la intrarea in stoc!!");
		}
		if (gestiune == null) {
			throw new IntrariStocExceptions(
					"Gestiunea in  nu trebuie sa fie nula !!");
		}
		boolean exista = false;
		for (ArticolStoc articol : gestiune.getArticole()) {
			if (articol.getMaterial().equals(material)) {
				articol.addLotIntrare(lot);
				lot.setArticol(articol);
				exista = true;
				regArtStoc.saveEntity(articol);
				break;
			}
		}
		if (!exista) {// id-ul va fi generat din baza de date
			ArticolStoc artNou = new ArticolStoc(100, 0, gestiune, material);
			artNou.addLotIntrare(lot);
			lot.setArticol(artNou);
			gestiune.addArticole(artNou);
			regGest.saveEntity(gestiune);
		}
		logger.loggeazaDEBUG("END Adaugat in Stoc  -----");

	}

	public List<LoturiIntrari> iesireDinStocPeGestiune(Gestiune gestOut,
			Material material, Integer cantitateOut) throws StocuriExceptions {
		logger.loggeazaDEBUG("Iesire din stoc a mijlocului "
				+ material.getDenumire() + "in cantitate de " + cantitateOut
				+ " -----");
		if (material == null) {
			throw new IesiriStocExceptions(
					"Mijlocul Circulant nu trebuie sa fie null la intrarea in stoc!!");
		}
		if (gestOut == null) {
			throw new IesiriStocExceptions(
					"Gestiunea out nu trebuie sa fie nulla !!");
		}
		if (cantitateOut == null || cantitateOut <= 0) {
			throw new IesiriStocExceptions(
					"Cantitatea trebuie sa fie pozitiva !!");
		}

		boolean are = false;
		Integer cantRamasa = cantitateOut;
		Document comandaProductie = new Document();
		List<LoturiIntrari> loturiOut = new ArrayList<LoturiIntrari>();
		List<LoturiIntrari> loturiRemove = new ArrayList<LoturiIntrari>();
		articoleFor: for (ArticolStoc art : gestOut.getArticole()) {
			if (art.getMaterial().equals(material)) {
				if (cantRamasa > art.getCatitateStocPeGestiune()) {
					if (art.getMaterial() instanceof Produs) {
						Integer cantTemp = (cantRamasa + art
								.getCantitateMinimaStoc())
								- art.getCatitateStocPeGestiune();
						comandaProductie.addLinie(new LinieDocument(null,
								comandaProductie, art.getMaterial(), cantTemp
										.doubleValue(), 0.0, 0.0));
					}
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

							// id-ul va fi generat din baza de date
							LoturiIntrari lotPartial = new LoturiIntrari(400,
									cantRamasa, lot.getPretIntrare(),
									lot.getDataIntrare(), art);
							loturiOut.add(lotPartial);

							cantRamasa = 0;
							break;
						}
					}
					for (LoturiIntrari l : loturiRemove) {
						art.removeLotIntrare(l);
					}
				}
				are = true;
				regArtStoc.saveEntity(art);
				regGest.saveEntity(gestOut);
				break articoleFor;
			}

			if (!comandaProductie.getLiniiDocument().isEmpty()) {
				trimiteComandaPtProductie(comandaProductie);
			}
		}
		regGest.saveEntity(gestOut);
		if (!are) {
			throw new IesiriStocExceptions(
					"Gestiunea out  nu contine materialul/produsul necesar !!");
		}
		logger.loggeazaDEBUG("END Iesit mijloc Circ  -----");
		return loturiOut;
	}

	public void urmarireListaPrioritati() throws StocuriExceptions {
		double cantitate = 0.0;
		double cantitateDisponibila = 0.0;
		Material material;
		List<PrioritateMaterialeProductie> prioritati = regPrioritati
				.getListaByClasa(PrioritateMaterialeProductie.class);
		for (int i = 0; i < prioritati.size(); i++) {
			for (LinieDocument l : prioritati.get(i).getLiniiDocument()) {
				cantitate = l.getCantitate();
				material = l.getMaterial();
				cantitateDisponibila = verificareStocMaterial(material);
				if (cantitateDisponibila > cantitate) {
					// todo de notificat productia --send mail
				}
			}
		}

	}

	public void trimiteComandaPtProductie(Document comandaProductie) {
		QueueConnection conn = null;
		QueueSession session = null;
		Queue que;

		try {
			Hashtable props = new Hashtable();

			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,
					"jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			props.put("java.naming.rmi.security.manager", "yes");

			InitialContext iniCtx = new InitialContext(props);

			Object tmp = iniCtx.lookup("ConnectionFactory");
			QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;

			conn = qcf.createQueueConnection();
			que = (Queue) iniCtx.lookup("queue/coadaProductie");
			session = conn.createQueueSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);
			conn.start();

			QueueSender queueSender = session.createSender(que);

			ObjectMessage message = session.createObjectMessage();
			message.setObject(comandaProductie);/*
												 * documentul trebuie sa fie
												 * serializabil
												 */
			queueSender.send(message);

			queueSender.close();

		} catch (NamingException e) {
			System.out.println(e.toString());
		} catch (JMSException e) {
			System.out.println("JMS Exception");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (JMSException e) {
					System.out.println("JMS Exception");
				}
			}
		}

	}

	public boolean iesireDinStoc(Material material, Integer cantitate)
			throws StocuriExceptions {
		// verific daca cantitatea ceruta nu e mai mare decat cantitatea
		// totala din stocuri(pe toate loturile, din toate gestiunile)
		try {
			if (cantitate > verificareStocMaterial(material)) {
				throw new IesiriStocExceptions(
						"Produse/materiale insuficiete in stoc!!!");
			}
			Integer cantTemp = 0;

			for (Gestiune g : gestiuni) {
				ArticolStoc a = regArtStoc.getArticolByGestiuneAndMaterial(
						g.getIdGestiune(), material.getIdMaterial());
				cantTemp = a.getCatitateStocPeGestiune();

				if (cantitate > cantTemp) {
					cantitate -= cantTemp;
					iesireDinStocPeGestiune(g, material, cantTemp);
				} else {
					iesireDinStocPeGestiune(g, material, cantitate);
					cantitate = 0;
					break;
				}

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// metoda suport pt vanzari
	public void procesareComandaIesire(Document doc) throws StocuriExceptions {
		for (LinieDocument l : doc.getLiniiDocument()) {
			iesireDinStoc(l.getMaterial(), l.getCantitate().intValue());
		}
	}

	public void transfer(Gestiune gestOut, Gestiune gestIn, Material material,
			Integer cantitate) throws StocuriExceptions {

		List<LoturiIntrari> loturiOut = iesireDinStocPeGestiune(gestOut,
				material, cantitate);
		for (LoturiIntrari l : loturiOut) {
			intrareInStoc(material, l, gestIn);
		}

	}

}
