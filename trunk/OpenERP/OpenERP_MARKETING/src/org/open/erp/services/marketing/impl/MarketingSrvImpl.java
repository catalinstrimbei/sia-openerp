package org.open.erp.services.marketing.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.CanalDistributie;
import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.MarketingSrvLocal;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Reclamatie;
import org.open.erp.services.marketing.StatusReclamatie;
import org.open.erp.services.marketing.TipPromovare;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

@Stateless
public class MarketingSrvImpl implements MarketingSrv, MarketingSrvLocal {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MarketingSrvImpl.class.getName());

	
	///////////////////////////////////// trebuie verificat.
	@PersistenceContext(unitName="OpenERP_MARKETING")
	private EntityManager entityManager;
	
	
	@EJB(lookup="java:global/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv")
	private NomenclatorMaterialeSrv nommatSrv;
	
	/*@EJB(lookup="java:global/OpenERP_PERSONAL/PersonalImpl!org.open.erp.services.personal.PersonalSrv")
	private PersonalSrv personalSrv;*/
	
	@EJB(lookup="java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrv")
	private NomenclatoareSrv nomgenSrv;

	public void setNommatSrv(NomenclatorMaterialeSrv nommatSrv) {
		this.nommatSrv = nommatSrv;
	}

	@Override
	public void setNomgenSrv(NomenclatoareSrv nomgenSrv) {
		this.nomgenSrv = nomgenSrv;
		
	}

/*	public void setPersonalSrv(PersonalSrv personalSrv) {
		this.personalSrv = personalSrv;
	}*/

	public MarketingSrvImpl() {
	}

	@Override
	public Promotie crearePromotie(int pretPromotional, Date dataStart, Date dataFinal) {
		logger.info("5.1 Initiere/Creare promotie noua");

		Promotie promotieNoua = new Promotie(1, null, pretPromotional, dataStart, dataFinal);
		Material produsNou = nommatSrv.introducereMaterial(null, null, null, null, null, null, null, null);
		promotieNoua.setProdusPromotie(produsNou);

///////////////////////////////////// trebuie reverificat.
		entityManager.persist(produsNou);
		entityManager.persist(promotieNoua);
		return promotieNoua;
	}

	@Override
	public CampaniePromovare creareCampaniePromovare(TipPromovare tipPromovare, Date data, CanalDistributie canalDistributie, int buget) {
		logger.debug("3.1 Initiere/Creare campanie promovare noua");

		CampaniePromovare campaniePromovareNoua = new CampaniePromovare(1, tipPromovare, data, canalDistributie, buget);

		/*Angajat angajatPromoter = personalSrv.creareAngajat(null, null, null, null, null, null, null, null, null, null);
		entityManager.persist(angajatPromoter);
		campaniePromovareNoua.setPromoter(angajatPromoter);*/

		Material produs = nommatSrv.introducereMaterial(null, null, null, null, null, null, null, null);
		entityManager.persist(produs);
		
		Promotie promotie = crearePromotie(11, data, data);
		entityManager.persist(promotie);
		
		promotie.setProdusPromotie(produs);
		campaniePromovareNoua.adaugaPromotie(promotie);
		
		entityManager.persist(campaniePromovareNoua);
		
		return campaniePromovareNoua;
	}

	@Override
	public RaspunsIntrebare creareRaspunsIntrebare(String textRaspuns) {
		logger.debug("2.3 Initiere/Creare raspuns nou");

		RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare(1, textRaspuns);
		
		entityManager.persist(raspunsIntrebare);

		return raspunsIntrebare;
	}

	@Override
	public Intrebare creareIntrebare(String textIntrebare) {
		logger.debug("2.2 Initiere/Creare intrebare noua");

		Intrebare intrebareNoua = new Intrebare(1, textIntrebare);
		String textRaspuns = "";
		RaspunsIntrebare raspuns = creareRaspunsIntrebare(textRaspuns);
		entityManager.persist(raspuns);
		
		intrebareNoua.adaugaRaspuns(raspuns);
		entityManager.persist(intrebareNoua);

		return intrebareNoua;
	}

	@Override
	public Chestionar creareChestionar(Date data, String titlu, Persoana persoanaChestionata) {
		logger.debug("2.1 Initiere/Creare chestionar nou");

		Chestionar chestionarNou = new Chestionar(1, data, titlu, persoanaChestionata);
		String textIntrebare = "";
		Intrebare intrebareNoua = creareIntrebare(textIntrebare);
		entityManager.persist(intrebareNoua);
		
		chestionarNou.adaugaIntrebare(intrebareNoua);
		entityManager.persist(chestionarNou);

		return chestionarNou;
	}

	@Override
	public CercetarePiata creareCercetarePiata(Date dataStart, Date dataFinal, int buget) {
		logger.debug("1.1 Initiere/Creare cercetare de piata noua");

		/*Angajat responsabilCercetarePiata = personalSrv.creareAngajat(null, null, null, null, null, null, null, null, null, null);
		entityManager.persist(responsabilCercetarePiata);*/
		
		CercetarePiata cercetarePiataNoua = new CercetarePiata(1, dataStart, dataFinal, buget);//, responsabilCercetarePiata);

		String titlu = "";
		Persoana persoanaChestionata = nomgenSrv.crearePF(null, null, null, null, null, null, null, null, null);
		entityManager.persist(persoanaChestionata);
		
		Chestionar chestionarNou = creareChestionar(dataStart, titlu, persoanaChestionata);
		entityManager.persist(chestionarNou);
		
		cercetarePiataNoua.adaugaChestionar(chestionarNou);
		entityManager.persist(cercetarePiataNoua);

		return cercetarePiataNoua;
	}

	@Override
	public Reclamatie creareReclamatie(Date data, String text, String raspuns, StatusReclamatie status) {
		logger.debug("5.1 Initiere/Creare reclamatie noua");

		Persoana persoanaReclamanta = nomgenSrv.crearePF(null, null, null, null, null, null, null, null, null);
		entityManager.persist(persoanaReclamanta);
		
		Reclamatie reclamatieNoua = new Reclamatie(1, persoanaReclamanta, data, text, raspuns, status);
		entityManager.persist(reclamatieNoua);

		return reclamatieNoua;
	}
}
