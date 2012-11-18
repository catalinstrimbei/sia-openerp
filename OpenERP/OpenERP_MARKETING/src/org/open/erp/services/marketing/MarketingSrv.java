package org.open.erp.services.marketing;

import java.util.Date;

import org.open.erp.services.nomgen.Angajat;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.productie.Produs;

public interface MarketingSrv {

	public Promotie crearePromotie(Produs produsPromotie, int pretPromotional,
			Date dataStart, Date dataFinal);

	public CampaniePromovare creareCampaniePromovare(TipPromovare tipPromovare,
			Date data, CanalDistributie canalDistributie,
			int buget);

	public RaspunsIntrebare creareRaspunsIntrebare(String textRaspuns);

	public Intrebare creareIntrebare(String textIntrebare);

	public Chestionar creareChestionar(Date data, String titlu,
			Persoana persoanaChestionata);

	public CercetarePiata creareCercetarePiata(Date dataStart,
			Date dataFinal, int buget);

	public Reclamatie creareReclamatie(Date data,
			String text, String raspuns, StatusReclamatie status);
}
