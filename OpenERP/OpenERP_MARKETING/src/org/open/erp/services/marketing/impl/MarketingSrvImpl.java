package org.open.erp.services.marketing.impl;

import java.util.Date;

import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.CanalDistributie;
import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Reclamatie;
import org.open.erp.services.marketing.StatusReclamatie;
import org.open.erp.services.marketing.TipPromovare;
import org.open.erp.services.nomgen.Angajat;
import org.open.erp.services.nomgen.AngajatSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.productie.Produs;
import org.open.erp.services.productie.ProdusSrv;

public class MarketingSrvImpl implements MarketingSrv {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MarketingSrvImpl.class.getName());

	private ProdusSrv produsSrv;
	private AngajatSrv angajatSrv;
	private NomenclatoareSrv nomgenSrv;

	public void setProdusSrv(ProdusSrv produsSrv) {
		this.produsSrv = produsSrv;
	}

	@Override
	public void setNomgenSrv(NomenclatoareSrv nomgenSrv) {
		this.nomgenSrv = nomgenSrv;
		
	}

	public void setAngajatSrv(AngajatSrv angajatSrv) {
		this.angajatSrv = angajatSrv;
	}

	public MarketingSrvImpl() {

	}

	@Override
	public Promotie crearePromotie(int pretPromotional, Date dataStart, Date dataFinal) {
		logger.info("5.1 Initiere/Creare promotie noua");

		Promotie promotieNoua = new Promotie(1, null, pretPromotional, dataStart, dataFinal);
		Produs produsNou = produsSrv.creareProdus();
		promotieNoua.setProdusPromotie(produsNou);

		return promotieNoua;
	}

	@Override
	public CampaniePromovare creareCampaniePromovare(TipPromovare tipPromovare, Date data, CanalDistributie canalDistributie, int buget) {
		logger.debug("3.1 Initiere/Creare campanie promovare noua");

		CampaniePromovare campaniePromovareNoua = new CampaniePromovare(1, tipPromovare, data, canalDistributie, buget);

		Angajat angajatPromoter = angajatSrv.creareAngajat();
		campaniePromovareNoua.setPromoter(angajatPromoter);

		Produs produs = produsSrv.creareProdus();
		Promotie promotie = crearePromotie(11, data, data);
		campaniePromovareNoua.adaugaPromotie(promotie);

		return campaniePromovareNoua;
	}

	@Override
	public RaspunsIntrebare creareRaspunsIntrebare(String textRaspuns) {
		logger.debug("2.3 Initiere/Creare raspuns nou");

		RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare(1, textRaspuns);

		return raspunsIntrebare;
	}

	@Override
	public Intrebare creareIntrebare(String textIntrebare) {
		logger.debug("2.2 Initiere/Creare intrebare noua");

		Intrebare intrebareNoua = new Intrebare(1, textIntrebare);
		String textRaspuns = "";
		RaspunsIntrebare raspuns = creareRaspunsIntrebare(textRaspuns);
		intrebareNoua.adaugaRaspuns(raspuns);

		return intrebareNoua;
	}

	@Override
	public Chestionar creareChestionar(Date data, String titlu, Persoana persoanaChestionata) {
		logger.debug("2.1 Initiere/Creare chestionar nou");

		Chestionar chestionarNou = new Chestionar(1, data, titlu, persoanaChestionata);
		String textIntrebare = "";
		Intrebare intrebareNoua = creareIntrebare(textIntrebare);
		chestionarNou.adaugaIntrebare(intrebareNoua);

		return chestionarNou;
	}

	@Override
	public CercetarePiata creareCercetarePiata(Date dataStart, Date dataFinal, int buget) {
		logger.debug("1.1 Initiere/Creare cercetare de piata noua");

		Angajat responsabilCercetarePiata = angajatSrv.creareAngajat();
		CercetarePiata cercetarePiataNoua = new CercetarePiata(1, dataStart, dataFinal, buget, responsabilCercetarePiata);

		String titlu = "";
		Persoana persoanaChestionata = nomgenSrv.crearePF(null, null, null, null, null, null, null, null, null);
		Chestionar chestionarNou = creareChestionar(dataStart, titlu, persoanaChestionata);
		cercetarePiataNoua.adaugaChestionar(chestionarNou);

		return cercetarePiataNoua;
	}

	@Override
	public Reclamatie creareReclamatie(Date data, String text, String raspuns, StatusReclamatie status) {
		logger.debug("5.1 Initiere/Creare reclamatie noua");

		Persoana persoanaReclamanta = nomgenSrv.crearePF(null, null, null, null, null, null, null, null, null);
		Reclamatie reclamatieNoua = new Reclamatie(1, persoanaReclamanta, data, text, raspuns, status);

		return reclamatieNoua;
	}

	


}
