package org.open.erp.services.personal.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereConcediu;
import org.open.erp.services.personal.CerereEveniment;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DoubleParam;
import org.open.erp.services.personal.Post;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.Tuple;

public class PersonalImpl implements PersonalSrv{

	@Override
	public Post crearePost(String nivelStudii, int salarMinim){
		Post postLiber = new Post(nivelStudii, salarMinim);
		return postLiber;
	}
	
	@Override
	public Anunt creareAnunt(String denumirePost, Integer indexCOR,
			Date dataEmitere, Date dataExpirare, String cerintePost, Post postLiber) {
			
		Anunt anuntNou = new Anunt(denumirePost, indexCOR,dataEmitere, dataExpirare, cerintePost, postLiber);
		return anuntNou;
		
	}

	@Override
	public Anunt creareAnunt(Anunt anuntVechi) {
		Anunt anuntRepostat = new Anunt(anuntVechi);
		return anuntRepostat;
	}

	@Override
	public Candidat creareCandidat(String nume, String prenume, String adresa, String telefon, String email, Date dataNasterii,char sex){
		Candidat angajatPosibil = new Candidat(nume, prenume, adresa,telefon, email, dataNasterii, sex);
		return angajatPosibil;
	}
	
	@Override
	public CV creareCV(Candidat titular,
			Tuple<String, Date, Date> studiiAbsolvite,
			Tuple<String, Date, Date> functiiOcupate,
			DoubleParam<String, String> limbiStraine, String aptitudini) {
	
		CV cvNouAdaugat = new CV(titular,studiiAbsolvite,functiiOcupate,limbiStraine,aptitudini);
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
	public Interviu creareInterviu(Anunt titluAnunt,
			List<Angajat> numeEvaluatori, List<ProbaEvaluare> probeInterviu,
			Date dataInterviu) {
		
		Interviu interviuNou = new Interviu(titluAnunt, numeEvaluatori, probeInterviu,dataInterviu);
		return interviuNou;
	}
	

	@Override
	public Candidat stabilireAngajatiNoi(List<Interviu> interviuriEfectuate) {
		return null;
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
	public ProbaEvaluare creareProbaEvaluare(String numeProba) {
		 ProbaEvaluare proba = new ProbaEvaluare(numeProba);
		return proba;
	}

	@Override
	public Angajat creareAngajat() {
		Angajat angajatNou = new Angajat();
		return angajatNou;
	}
	
}
