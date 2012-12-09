package org.open.erp.services.stocuri.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.impl.NomenclatorMaterialeImpl;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.personal.PersonalSrv;
/*
import java.util.Date;
import java.util.List;
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.UnitateDeMasura;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereConcediu;
import org.open.erp.services.personal.CerereEveniment;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DoubleParam;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.Post;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.Tuple;
*/


public class StocuriSrvFactory {
	
	private static Logger logger = Logger.getLogger(StocuriSrvFactory.class.getName());
	
	public static StocuriSrv getStocuriSrv(){
		StocuriSrv stocuriSrv = new StocuriImpl();
		//NomenclatorMaterialeSrv nomenclatorMaterialeSrv = StocuriSrvFactory.getNomenclatoareMaterialeSrv();
		//stocuriSrv.setNomenclatorMaterialeSrv(nomenclatorMaterialeSrv);
		logger.info("Crerare StocuriSrv instance from StocuriSrvFactory!");
		return stocuriSrv;
		
	}
	

	public static NomenclatorMaterialeSrv getNomenclatoareMaterialeSrv(){
		logger.info("Creaza Dummy NOMMAT SRV----");
		return new NomenclatorMaterialeImpl();
	}


	public static PersonalSrv getPersonalSrv(){
		logger.info("Creaza Dummy NOMMAT SRV----");
		return new PersonalImpl();
	}
	
	
}
