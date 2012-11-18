package org.open.erp.services.nomgen;

public class PersoanaSrvImpl implements PersoanaSrv{

	@Override
	public Persoana crearePersoanaChestionata() {
		Persoana persoanaChestionataNoua = new Persoana();
		return persoanaChestionataNoua;
	}

	@Override
	public Persoana crearePersoanaReclamanta() {
		Persoana persoanaReclamantaNoua = new Persoana();
		return persoanaReclamantaNoua;
	}

}
