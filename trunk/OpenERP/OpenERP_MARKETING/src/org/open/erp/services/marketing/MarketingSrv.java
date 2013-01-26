package org.open.erp.services.marketing;

import java.util.Date;

import javax.ejb.Remote;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

@Remote
public interface MarketingSrv {

	public void setNommatSrv(NomenclatorMaterialeSrv nommatSrv);

	public void setNomgenSrv(NomenclatoareSrv nomgenSrv);

	//public void setPersonalSrv(PersonalSrv personalSrv);

	public Promotie crearePromotie(Promotie promotie);

	public CampaniePromovare creareCampaniePromovare(CampaniePromovare campaniePromovare);

	public RaspunsIntrebare creareRaspunsIntrebare(String textRaspuns);

	public Intrebare creareIntrebare(String textIntrebare);

	public Chestionar creareChestionar(Date data, String titlu, Persoana persoanaChestionata);

	public CercetarePiata creareCercetarePiata(CercetarePiata cercetarePiata);

	public Reclamatie creareReclamatie(Reclamatie reclamatie);
	
	public CampaniePromovare findCampanieById(long id);
}
