/*package org.open.erp.services.achizitii.teste;

<<<<<<< .mine
import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.impl.AchizitiiImpl;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;


=======
import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.impl.AchizitiiImpl;
import org.open.erp.services.nomgen.NomenclatoareGeneraleSrv;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;


>>>>>>> .r1385
public class AchizitiiSrvFactory {
<<<<<<< .mine
	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());

	public static AchizitiiSrv getAchizitiiSrv(){
		
		AchizitiiSrv achizitiiSrv = new AchizitiiImpl();
		NomenclatorGeneralSrv nomGenSrv = AchizitiiSrvFactory.getAchizitiiMatSrv();
		achizitiiSrv.setMaterialSrv(nomGenSrv);		
		logger.info("Crerare AchizitiiSrv instance from AchizitiiSrvFactory!");
		
		return achizitiiSrv;
	}
=======
	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());

>>>>>>> .r1385

<<<<<<< .mine
	
	public static NomenclatorGeneralSrv getAchizitiiMatSrv(){
		logger.info("Creare dummy instance of NomenclatorGeneralSrv from MaterialeSrvFactory!");

		return new NomenclatorGeneralSrv(){
			@Override
			public Materiale creareMaterial(Materiale material) {
				logger.info("1.2 Stabilire material pe linie");
				return new Materiale();
			}
		};
	}
	
	
	//mai trebuie facut si pentru furnizori
}=======
	public static AchizitiiSrv getAchizitiiSrv(){
		AchizitiiSrv achizitiiSrv = new AchizitiiImpl();
		NomenclatorGeneralSrv nomGenServ = AchizitiiSrvFactory.getMaterialSrv();
	//	NomenclatoareGeneraleSrv nomGen2Srv=AchizitiiSrvFactory.getFurnizoriSrv();
		achizitiiSrv.setMaterialSrv(nomGenServ);
		
		logger.info("Crerare ProjectManagementSrv instance from ProjectManagementSrvFactory!");
		
		return achizitiiSrv;
	}
	
	

	public static NomenclatorGeneralSrv getMaterialSrv(){
		logger.info("Creare dummy instance of NomenclatorGeneralSrv from NomenclatorGeneralSrvFactory!");
		// Dummmy Implementation of BugetareSrv
		return new NomenclatorGeneralSrv()
		{
			
			
		};
		// ----
		
		}
		
	
	
	
	
	//mai trebuie facut si pentru furnizori
}>>>>>>> .r1385

*/
package org.open.erp.services.achizitii.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.impl.AchizitiiImpl;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.UnitateDeMasura;

import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;


public class AchizitiiSrvFactory {
	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());

	public static AchizitiiSrv getAchizitiiSrv(){
		
		AchizitiiImpl achizitiiSrv = new AchizitiiImpl();
		NomenclatorMaterialeSrv nomGenSrv = AchizitiiSrvFactory.getAchizitiiMatSrv();
		StocuriSrv stoc = new StocuriImpl();
		
		achizitiiSrv.setStocuriSrv(stoc);
		
		achizitiiSrv.setMaterialSrv(nomGenSrv);	
		
		logger.info("Crerare AchizitiiSrv instance from AchizitiiSrvFactory!");
		
		return achizitiiSrv;
	}

	

	public static NomenclatorMaterialeSrv getAchizitiiMatSrv(){

		return new NomenclatorMaterialeSrv() {
			
			@Override
			public Material creareMaterial(Material material) {

				logger.info("1.2 Stabilire material pe linie");
				return new Material();
			}

			@Override
			public Material introducereMaterial(String codMaterial,
					String denumireMaterial, String cantitateStandard,
					String pretStandard, String procentTVACurent,
					String observatii, ListaCaracteristici listaCaracteristici) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public UnitateDeMasura incarcareUnitate(String id,
					String unitateDeMasura) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListaCaracteristici incarcareLista(String id,
					String listaCaracteristici) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		
			
	}
}	
			
		
	
	
	
	//mai trebuie facut si pentru furnizori


	

