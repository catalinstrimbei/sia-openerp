package org.open.erp.services.marketing;

import javax.ejb.Remote;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

@Remote
public interface MarketingSrv {

	public void setNommatSrv(NomenclatorMaterialeSrv nommatSrv);

	public void setNomgenSrv(NomenclatoareSrv nomgenSrv);

	// public void setPersonalSrv(PersonalSrv personalSrv);

	public Promotie crearePromotie(Promotie promotie);

	public CampaniePromovare creareCampaniePromovare(CampaniePromovare campaniePromovare);

	public RaspunsIntrebare creareRaspunsIntrebare(RaspunsIntrebare raspunsIntrebare);

	public Intrebare creareIntrebare(Intrebare intrebare);

	public Chestionar creareChestionar(Chestionar chestionar);

	public CercetarePiata creareCercetarePiata(CercetarePiata cercetarePiata);

	public Reclamatie creareReclamatie(Reclamatie reclamatie);

	public CampaniePromovare findCampanieById(long id);
	
	public CercetarePiata findCercetarePiataById(long id);
	
	public Chestionar findChestionarById(long id);
	
	public Intrebare findIntrebareById(long id);
}
