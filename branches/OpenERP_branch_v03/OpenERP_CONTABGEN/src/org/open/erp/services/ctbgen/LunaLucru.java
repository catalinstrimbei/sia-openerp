package org.open.erp.services.ctbgen;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class LunaLucru implements Comparable<LunaLucru> { 
	private Integer idLuna;
	private Integer luna;
	private Integer an;
	private String status;

	public enum StatusLuna { DESCHISA, INCHISA };

	public Integer getIdLuna() {
		return idLuna;
	}

	public void setIdLuna(Integer idLuna) {
		this.idLuna = idLuna;
	}

	public Integer getLuna() {
		return luna;
	}

	public void setLuna(Integer luna) {
		this.luna = luna;
	}

	public Integer getAn() {
		return an;
	}

	public void setAn(Integer an) {
		this.an = an;
	}

	public String getStatus() {
		return status;
	}

	public LunaLucru(Integer idLuna, Integer luna, Integer an) {
		super();
		this.idLuna = idLuna;
		this.luna = luna;
		this.an = an;
		this.status = StatusLuna.DESCHISA.toString();
	}
	
	public LunaLucru(Integer luna, Integer an) {
		super();
		this.idLuna = -1;
		this.luna = luna;
		this.an = an;
		this.status = StatusLuna.DESCHISA.toString();
	}

	public void inchideLuna() {
		this.status = StatusLuna.INCHISA.toString();
	}

	public void anuleazaInchidere() {
		this.status = StatusLuna.DESCHISA.toString();
	}

	@Override
	public int compareTo(LunaLucru comparaCU) {
		if(this.an>comparaCU.getAn()) return 1;
		else if(this.an<comparaCU.getAn()) return -1;
		else {
			if(this.luna>comparaCU.getLuna()) return 1;
			else if(this.luna<comparaCU.getLuna()) return -1;
			else {
				return 0;
			}
		}
	}

	public String toString() {
		return this.idLuna + "-" + this.luna+ "/" +this.an +" - "+this.status;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
            return true;
		}
		if (!(obj instanceof LunaLucru)) {
            return false; 
		}
		
		LunaLucru luna = (LunaLucru) obj;
		if(luna.an==this.an && luna.luna==this.luna)
			return true;
		return false;
	}
}
