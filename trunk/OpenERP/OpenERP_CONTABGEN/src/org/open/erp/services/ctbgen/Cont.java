package org.open.erp.services.ctbgen;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Cont {
	private int idCont;
	private String denCont;
	private String simbolCont;
	private String clasaCont;
	private String tipSintetic;
	private Cont contParinte;
	private TipCont tipCont;

	public enum StatusSintetic { SINTETIC, ANALITIC, SINTETIC_PARINTE,ANALITIC_PARINTE };
	
	public enum TipCont { PASIV, ACTIV };

	public int getIdCont() {
		return idCont;
	}

	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}

	public String getDenCont() {
		return denCont;
	}

	public void setDenCont(String denCont) {
		this.denCont = denCont;
	}

	public String getSimbolCont() {
		return simbolCont;
	}

	public void setSimbolCont(String simbolCont) {
		this.simbolCont = simbolCont;
	}

	public String getTipSintetic() {
		return tipSintetic;
	}

	public void setTipSintetic(StatusSintetic tipSintetic) {
		this.tipSintetic = tipSintetic.toString();
	}

	public Cont getContParinte() {
		return contParinte;
	}

	public void setContParinte(Cont contParinte) {
		this.contParinte = contParinte;
	}

	public String getTipCont() {
		return tipCont.toString();
	}

	public void setTipCont(TipCont tipCont) {
		this.tipCont = tipCont;
	}

	public String getClasaCont() {
		return clasaCont;
	}

	public void setClasaCont(String clasaCont) {
		this.clasaCont = clasaCont;
	}

	public Cont(int idCont, String denCont, String simbolCont, String clasaCont, 
				StatusSintetic tipSintetic, Cont contParinte, TipCont tipCont) {
		super();
		this.idCont = idCont;
		this.denCont = denCont;
		this.simbolCont = simbolCont;
		this.clasaCont = clasaCont;
		this.tipSintetic = tipSintetic.toString();
		this.contParinte = contParinte;
		this.tipCont = tipCont;
	}

	public Cont(int idCont, String denCont, String simbolCont, 
				String clasaCont, StatusSintetic tipSintetic, TipCont tipCont) {
		super();
		this.idCont = idCont;
		this.denCont = denCont;
		this.simbolCont = simbolCont;
		this.clasaCont = clasaCont;
		this.tipSintetic = tipSintetic.toString();
		this.tipCont = tipCont;
	}
	
	public Cont(String denCont, String simbolCont, String clasaCont, StatusSintetic tipSintetic, 
				Cont contParinte, TipCont tipCont) {
		super();
		this.idCont=-1;
		this.denCont = denCont;
		this.simbolCont = simbolCont;
		this.clasaCont = clasaCont;
		this.tipSintetic = tipSintetic.toString();
		this.contParinte = contParinte;
		this.tipCont = tipCont;
	}

	public Cont() {
		super();
	}

	public boolean getContUtilizabilil() {
		//TODO: e corect?
		return ((this.tipSintetic.equals(StatusSintetic.SINTETIC.toString()) ||
				(this.tipSintetic.equals(StatusSintetic.ANALITIC.toString())) ? true: false));
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
            return true;
		}
		if (!(obj instanceof Cont)) {
            return false; 
		}
		
		Cont cont = (Cont) obj;
		if(cont.getIdCont()==this.idCont)
			return true;
		return false;
	}

}
