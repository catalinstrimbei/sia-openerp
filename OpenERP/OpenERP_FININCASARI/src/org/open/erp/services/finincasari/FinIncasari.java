package org.open.erp.services.finincasari;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import org.open.erp.services.vanzari.FacturaEmisa;


public abstract class FinIncasari implements Serializable {

	

	private static final long serialVersionUID = 1L;

	private Integer idFinIncasari;
	
	private String moneda;

	private Date dataEmitere;
	
	private Boolean avans;
	
	private Date dataInregistrarii;
	
	private Double suma;
	
	private String sumaInLitere;
	
	private String seria;
	
	private Integer numar;
	
	private String locatie;
	
	private List<FacturaEmisa> facturi = new ArrayList<FacturaEmisa>();

	
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Date getData() {
		return dataEmitere;
	}

	public void setData(Date data) {
		this.dataEmitere = data;
	}


	public Date getDataEmitere() {
		return dataEmitere;
	}

	public void setDataEmitere(Date dataEmitere) {
		this.dataEmitere = dataEmitere;
	}

	public Boolean getAvans() {
		return avans;
	}

	public void setAvans(Boolean avans) {
		this.avans = avans;
	}

	public Date getDataInregistrarii() {
		return dataInregistrarii;
	}

	public void setDataInregistrarii(Date dataInregistrarii) {
		this.dataInregistrarii = dataInregistrarii;
	}

	

	public String getSumaInLitere() {
		return sumaInLitere;
	}

	public void setSumaInLitere(String sumaInLitere) {
		this.sumaInLitere = sumaInLitere;
	}

	public String getSeria() {
		return seria;
	}

	public void setSeria(String seria) {
		this.seria = seria;
	}

	public Integer getNumar() {
		return numar;
	}

	public void setNumar(Integer numar) {
		this.numar = numar;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	
	
	public FinIncasari(Date dataEmitere, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie) {
		super();
		this.dataEmitere = dataEmitere;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.sumaInLitere = sumaInLitere;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;
	}

	
	public FinIncasari(Integer idFinIncasari,  Date dataEmitere,
			Boolean avans, Date dataInregistrarii, Double suma,
			String sumaInLitere, String seria, Integer numar, String locatie) {
		super();
		this.setIdFinIncasari(idFinIncasari);
		this.dataEmitere = dataEmitere;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.sumaInLitere = sumaInLitere;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avans == null) ? 0 : avans.hashCode());
		result = prime * result
				+ ((dataEmitere == null) ? 0 : dataEmitere.hashCode());
		result = prime
				* result
				+ ((dataInregistrarii == null) ? 0 : dataInregistrarii
						.hashCode());
		result = prime * result + ((facturi == null) ? 0 : facturi.hashCode());
		result = prime * result
				+ ((idFinIncasari == null) ? 0 : idFinIncasari.hashCode());
		result = prime * result + ((locatie == null) ? 0 : locatie.hashCode());
		result = prime * result + ((moneda == null) ? 0 : moneda.hashCode());
		result = prime * result + ((numar == null) ? 0 : numar.hashCode());
		result = prime * result + ((seria == null) ? 0 : seria.hashCode());
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
		result = prime * result
				+ ((sumaInLitere == null) ? 0 : sumaInLitere.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinIncasari other = (FinIncasari) obj;
		if (avans == null) {
			if (other.avans != null)
				return false;
		} else if (!avans.equals(other.avans))
			return false;
		if (dataEmitere == null) {
			if (other.dataEmitere != null)
				return false;
		} else if (!dataEmitere.equals(other.dataEmitere))
			return false;
		if (dataInregistrarii == null) {
			if (other.dataInregistrarii != null)
				return false;
		} else if (!dataInregistrarii.equals(other.dataInregistrarii))
			return false;
		if (facturi == null) {
			if (other.facturi != null)
				return false;
		} else if (!facturi.equals(other.facturi))
			return false;
		if (idFinIncasari == null) {
			if (other.idFinIncasari != null)
				return false;
		} else if (!idFinIncasari.equals(other.idFinIncasari))
			return false;
		if (locatie == null) {
			if (other.locatie != null)
				return false;
		} else if (!locatie.equals(other.locatie))
			return false;
		if (moneda == null) {
			if (other.moneda != null)
				return false;
		} else if (!moneda.equals(other.moneda))
			return false;
		if (numar == null) {
			if (other.numar != null)
				return false;
		} else if (!numar.equals(other.numar))
			return false;
		if (seria == null) {
			if (other.seria != null)
				return false;
		} else if (!seria.equals(other.seria))
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		if (sumaInLitere == null) {
			if (other.sumaInLitere != null)
				return false;
		} else if (!sumaInLitere.equals(other.sumaInLitere))
			return false;
		return true;
	}
	
	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public Integer getIdFinIncasari() {
		return idFinIncasari;
	}

	public void setIdFinIncasari(Integer idFinIncasari) {
		this.idFinIncasari = idFinIncasari;
	}

	
	public FinIncasari(){
		super();
	}

	public List<FacturaEmisa> getFacturi() {
		// TODO Auto-generated method stub
		return facturi;
	}
	
	public void setFacturi(List<FacturaEmisa> facturi) {
		this.facturi = facturi;
	}
	
}