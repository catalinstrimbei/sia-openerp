package org.open.erp.services.stocuri.teste;

/*
import java.util.Date;
import java.util.List;
*/
import org.apache.log4j.Logger;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;
/*
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;
*/

public class StocuriSrvFactory {
	
	private static Logger logger = Logger.getLogger(StocuriSrvFactory.class.getName());
	
	public static StocuriSrv getStocuriSrv(){
		StocuriSrv stocuri = new StocuriImpl();
		//AchizitiiSrv achizitiiSrv = StocuriSrvFactory.getAchizitiiSrv(); 
	    //stocuri.setAchizitiiSrv(achizitiiSrv);
		logger.info("Crerare StocuriSrv instance from StocuriSrvFactory!");
		
		//NomenclatorMaterialeSrv nomenclatorMaterialeSrv = StocuriSrvFactory.getNomenclatoareMateriaelSrv();
		//stocuri.setNomenclatoareGeneraleSrv(nomenclatorMaterialeSrv);
		
		return stocuri;
		
	}
	
	/*public static AchizitiiSrv getAchizitiiSrv(){
		logger.info("Creaza Dummy ACHIZITIONARE SRV----");
		return new AchizitiiSrv()
		{
			@Override
			public Produs preluareProdus(Produs produs) {
				logger.info("2.1. Preluare date produs");
				return new Produs();
			}
		};
	}*/

	/*public static ProductieSrv getProductieSrv(){
		logger.info("Creaza Dummy PRODUCTIE SRV----");
		return new ProductieSrv(){
			// Null implementation
		};
	}
	
	public static VanzariSrv getVanzariSrv(){
		logger.info("Creaza Dummy VANZARI SRV----");
		return new VanzariSrv(){
			// Null implementation
		};
	}*/

/*
public static NomenclatorMaterialeSrv getNomenclatoareMateriaelSrv(){
	logger.info("Creaza Dummy NOMMAT SRV----");
	return new NomenclatorMaterialeSrv(){

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
*/
/*
public static PersonalSrv getPersonalSrv(){
	logger.info("Creaza Dummy NOMMAT SRV----");
	return new PersonalSrv(){

		@Override
		public Angajat creareAngajat(Integer id, String nume, String sex,
				String mail, String statutInCompanie, String stareCivila,
				String dataNastere, String telefon, Adresa adresa,
				ContractMunca cm) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Post crearePost(String nivelStudii, int salarMinim,
				Departament dep) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public Anunt creareAnunt(Anunt anuntNou) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat creareCandidat(Integer id, String nume, String sex,
				String mail, String statutInCompanie, String stareCivila,
				String dataNastere, String telefon, Adresa adresa) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CV creareCV(Candidat titular,
				List<Tuple<String, Date, Date>> studiiAbsolvite,
				List<Tuple<String, Date, Date>> functiiOcupate,
				List<DoubleParam<String, String>> limbiStraine,
				String aptitudini) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> selectareCandidati(List<CV> listaCVCandidati,
				Anunt anuntPostLiber) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ProbaEvaluare creareProbaEvaluare(String numeProba) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Interviu creareInterviu(Anunt titluAnunt,
				List<Angajat> numeEvaluatori,
				List<ProbaEvaluare> probeInterviu, Date dataInterviu) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void stabilireAngajatiNoi(Angajat angajatNou, ContractMunca cm,
				Post postAtribuit) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public CerereConcediu creareCerereConcediu(Integer nrInregistrare,
				ContractMunca contract, Date dataCerere, Date dataAprobare,
				Integer perioadaConcediu, String tipConcediu, String status) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CerereConcediu creareCerereConcediu(
				CerereConcediu CerereConcediuNou) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CerereEveniment creareCerereEveniment(Integer nrInregistrare,
				ContractMunca contract, Date dataCerere, Date dataAprobare,
				Integer perioadaEveniment, String tipEveniment, String status) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CerereEveniment creareCerereEveniment(
				CerereEveniment CerereEvenimentNou) {
			// TODO Auto-generated method stub
			return null;
		}
		
		

	};
}*/
}
