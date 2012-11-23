package org.open.erp.services.contabgen.impl;

import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.PlanConturi;
import org.open.erp.services.rapoarte.BilantContabil;
import org.open.erp.services.sabloane.Sablon;
import org.open.erp.services.tranzactii.Tranzactie;

public class ContabilitateGeneralaImpl implements ContabilitateGeneralaSrv{

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContabilitateGeneralaImpl.class.getName());
	
	@Override
	public boolean adaugaCont(Cont cont, Integer codClasa) {
		
		logger.info("1.1 Creare cont: " + cont.getDenumireCont());
		
		PlanConturi plan = new PlanConturi();
		
		logger.info("1.2 Verificare existenta clasa de conturi cu codul: " + codClasa);
		
		Clasa clasa = plan.getClasaByCod(codClasa);
		
		if(clasa == null)
			return false;
		
		logger.info("1.3 Verific daca exista contul: " + cont.getDenumireCont() + ", codul: " + cont.getCodCont());
		
		if(clasa.getContByCod(cont.getCodCont()) != null)
		{
			logger.info("1.3.1 Contul exista, nu este nevoie sa-l adaugam");
		}
		else
		{
			logger.info("1.4 Contul nu exista. Il adaugam");
			clasa.addCont(cont);
			
			return true;
		}
		
		return false;
	}

	@Override
	public Tranzactie creareTranzactie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sablon creareSablon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BilantContabil creareBilantContabil() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
