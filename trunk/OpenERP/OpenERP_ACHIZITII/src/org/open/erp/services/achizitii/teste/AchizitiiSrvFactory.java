//
//package org.open.erp.services.achizitii.teste;
//
//import org.apache.log4j.Logger;
//import org.open.erp.services.achizitii.AchizitiiSrv;
//import org.open.erp.services.achizitii.impl.AchizitiiImpl;
//import org.open.erp.services.nommat.ListaCaracteristici;
//import org.open.erp.services.nommat.Material;
//import org.open.erp.services.nommat.UnitateDeMasura;
//
//import org.open.erp.services.nommat.ListaCaracteristici;
//import org.open.erp.services.nommat.Material;
//import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
//import org.open.erp.services.nommat.UnitateDeMasura;
//import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
//import org.open.erp.services.stocuri.StocuriSrv;
//import org.open.erp.services.stocuri.impl.StocuriImpl;
//
//
//public class AchizitiiSrvFactory {
//	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());
//
//	public static AchizitiiSrv getAchizitiiSrv(){
//		
//		AchizitiiImpl achizitiiSrv = new AchizitiiImpl();
//		NomenclatorMaterialeSrv nomGenSrv = AchizitiiSrvFactory.getAchizitiiMatSrv();
//		StocuriSrv stoc = new StocuriImpl();
//		
//		achizitiiSrv.setStocuriSrv(stoc);
//		
//		achizitiiSrv.setMaterialSrv(nomGenSrv);	
//		
//		logger.info("Crerare AchizitiiSrv instance from AchizitiiSrvFactory!");
//		
//		return achizitiiSrv;
//	}
//
//	
//
//	public static NomenclatorMaterialeSrv getAchizitiiMatSrv(){
//
//		return new NomenclatorMaterialeSrv() {
//			
//			@Override
//			public String stergereMaterial(String CodMaterial) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public Material modificareMaterial(String codMaterial,
//					String newcodMaterial, String newdenumireMaterial,
//					String newcantitateStandard, String newpretStandard,
//					String newcategorieMaterial, String newprocentTVACurent,
//					String newobservatii, ListaCaracteristici newcaracteristici,
//					Boolean overwrite) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public Material introducereMaterial(String codMaterial,
//					String denumireMaterial, String cantitateStandard,
//					String pretStandard, String categorieMaterial,
//					String procentTVACurent, String observatii,
//					ListaCaracteristici listaCaracteristici) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public ListaCaracteristici incarcareLista(String id,
//					String listaCaracteristici) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public Material cautareMaterialDupaDenumire(String denumire) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//	}
////			
////			@Override
////			public Material creareMaterial(Material material) {
////
////				logger.info("1.2 Stabilire material pe linie");
////				return new Material();
////			}
////
////			@Override
////			public Material introducereMaterial(String codMaterial,
////					String denumireMaterial, String cantitateStandard,
////					String pretStandard, String procentTVACurent,
////					String observatii, ListaCaracteristici listaCaracteristici) {
////				// TODO Auto-generated method stub
////				return null;
////			}
////
////			@Override
////			public UnitateDeMasura incarcareUnitate(String id,
////					String unitateDeMasura) {
////				// TODO Auto-generated method stub
////				return null;
////			}
////
////			@Override
////			public ListaCaracteristici incarcareLista(String id,
////					String listaCaracteristici) {
////				// TODO Auto-generated method stub
////				return null;
////			}
////			
////		};
////		
////			
////	}
//}	
//			
//		
//	
//	
//	
//	//mai trebuie facut si pentru furnizori
//
//
//	
//
