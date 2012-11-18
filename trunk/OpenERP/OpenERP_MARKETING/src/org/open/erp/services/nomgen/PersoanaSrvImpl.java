package org.open.erp.services.nomgen;


public class PersoanaSrvImpl implements PersoanaSrv{
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersoanaSrvImpl.class.getName());
	
	public PersoanaSrvImpl(){
		
	}

	@Override
	public Persoana crearePersoanaChestionata() {	
		logger.debug("1.1 Initiere/Creare persoana chestionata noua");
		
		Persoana persoanaChestionataNoua = new Persoana(1, "chestionata");
		return persoanaChestionataNoua;
	}

	@Override
	public Persoana crearePersoanaReclamanta() {
		logger.debug("1.1 Initiere/Creare persoana reclamanta nou");
		
		Persoana persoanaReclamantaNoua = new Persoana(2, "reclamanta");
		return persoanaReclamantaNoua;
	}

}
