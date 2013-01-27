package org.open.erp.services.personal.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereConcediu;
import org.open.erp.services.personal.CerereEveniment;
import org.open.erp.services.personal.Concedii;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DoubleParam;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.Post;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.Tuple;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonalImpl implements PersonalSrv, PersonalSrvLocal{

	/* Dependente resurse proprii */
	private static Logger logger = Logger.getLogger(PersonalImpl.class.getName());	
	private RegistruConcedii registruConcedii;

	/* Dependente resurse injectate */
	@PersistenceContext(unitName="OpenERP_PERSONAL")
	private EntityManager em;
	
	@Resource
	private SessionContext sessionContext;
	
	@EJB(lookup="java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrvLocal")
	private NomenclatoareSrvLocal nomSrvLocal;
	
	/* Initializare */
	public PersonalImpl() { }	
	@PostConstruct
	public void init(){		
		if (this.registruConcedii == null)
			registruConcedii = new RegistruConcedii(em);
		
	}	
	
	
	@Override
	public Post crearePost(Integer id,String nivelStudii, int salarMinim, Departament dep){
		Post postLiber = new Post(id, nivelStudii, salarMinim, dep);
		return postLiber;
	}
	
	@Override
	public Anunt creareAnunt(Integer id, String denumirePost, Integer indexCOR,
			Date dataEmitere, Date dataExpirare, String cerintePost, Post postLiber) {
			
		Anunt anuntNou = new Anunt(id, denumirePost, indexCOR,dataEmitere, dataExpirare, cerintePost, postLiber);
		return anuntNou;
		
	}

	@Override
	public Anunt creareAnunt(Anunt anuntVechi) {
		Anunt anuntRepostat = new Anunt(anuntVechi);
		return anuntRepostat;
	}

	@Override
	public Candidat creareCandidat(Integer id, String nume, String sex, String mail,String statutInCompanie, String stareCivila, String dataNastere, String telefon, Adresa adresa){
		Candidat angajatPosibil = new Candidat(id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere, telefon,adresa);
		return angajatPosibil;
	}
	
	@Override
	public CV creareCV(Integer id, Candidat titular,
			List<Tuple<String, Date, Date>> studiiAbsolvite,
			List<Tuple<String, Date, Date>> functiiOcupate,
			List<DoubleParam<String, String>> limbiStraine, String aptitudini) {
	
		CV cvNouAdaugat = new CV(id, titular,studiiAbsolvite,functiiOcupate,limbiStraine,aptitudini);
		return cvNouAdaugat;
	}

	@Override
	public List<Candidat> selectareCandidati(List<CV> listaCVCandidati, Anunt anuntPostLiber) {
		
		List<Candidat> listaCandidatiInterviu = new ArrayList<Candidat>();
		
		for (CV c :listaCVCandidati){
			if(anuntPostLiber.getCerintePost().toLowerCase().contains(c.getAptitudini().toLowerCase())){
				listaCandidatiInterviu.add(c.getTitularCV());
			}
		}
		return listaCandidatiInterviu;
	}

	@Override
	public Interviu creareInterviu(Integer id, Anunt titluAnunt,
			List<Angajat> numeEvaluatori, List<ProbaEvaluare> probeInterviu,
			Date dataInterviu) {
		
		Interviu interviuNou = new Interviu(id, titluAnunt, numeEvaluatori, probeInterviu,dataInterviu);
		return interviuNou;
	}
	

	@Override
	public void stabilireAngajatiNoi(Angajat angajatNou, ContractMunca cm, Post postAtribuit) {
		//introducere angajat nou si un contract aferent;
		
	}

	@Override
	public CerereConcediu creareCerereConcediu(Integer nrInregistrare,
			ContractMunca contract, Date dataCerere, Date dataAprobare,
			Integer perioadaConcediu, String tipConcediu, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CerereConcediu creareCerereConcediu(CerereConcediu CerereConcediuNou) {
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

	@Override
	public ProbaEvaluare creareProbaEvaluare(Integer id, String numeProba) {
		 ProbaEvaluare proba = new ProbaEvaluare(id, numeProba);
		return proba;
	}

	@Override
	public Angajat creareAngajat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa, ContractMunca cm) {
		Angajat angajatNou = new Angajat(id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere, telefon, adresa, cm);
		return angajatNou;
	}
	@Override
	public Post salvarePost(Post post) {

		
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare/salvare post- TRANZACTIE ANULATA");
			
		}else{
			//post = post.salveazaPost(post);
			
		}
		

		return post;		
		}

	@Override
	public Angajat getAngajatById(Integer idAngajat_) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
