package org.open.erp.services.achizitii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CerereOferta {
	private Integer nrCerereOferta;
	private Date dataCerereOferta;
	private Furnizori furnizor;
	private List<LiniiCerereOferta> linieCerereOferta= new ArrayList<LiniiCerereOferta>();
	
	public void adaugaLinie(LiniiCerereOferta linie){
		this.linieCerereOferta.add(linie);
	}
	
	public Integer getNrCerereOferta() {
		return nrCerereOferta;
	}


	public void setNrCerereOferta(Integer nrCerereOferta) {
		this.nrCerereOferta = nrCerereOferta;
	}


	public Date getDataCerereOferta() {
		return dataCerereOferta;
	}


	public void setDataCerereOferta(Date dataCerereOferta) {
		this.dataCerereOferta = dataCerereOferta;
	}


	

	public Furnizori getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(Furnizori furnizor) {
		this.furnizor = furnizor;
	}

	public List<LiniiCerereOferta> getLinieCerereOferta() {
		return linieCerereOferta;
	}


	public void setLinieCerereOferta(List<LiniiCerereOferta> linieCerereOferta) {
		this.linieCerereOferta = linieCerereOferta;
	}


	public CerereOferta() {
		super();
	}
	

	public CerereOferta(Integer nrCerereOferta, Date dataCerereOferta
			//List<Furnizori> furnizor, //List<LiniiCerereOferta> linieCerereOferta
			) {
		super();
		this.nrCerereOferta = nrCerereOferta;
		this.dataCerereOferta = dataCerereOferta;
		//this.furnizor = furnizor;
//		this.linieCerereOferta = linieCerereOferta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataCerereOferta == null) ? 0 : dataCerereOferta.hashCode());
		result = prime * result
				+ ((furnizor == null) ? 0 : furnizor.hashCode());
		result = prime
				* result
				+ ((linieCerereOferta == null) ? 0 : linieCerereOferta
						.hashCode());
		result = prime * result
				+ ((nrCerereOferta == null) ? 0 : nrCerereOferta.hashCode());
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
		CerereOferta other = (CerereOferta) obj;
		if (dataCerereOferta == null) {
			if (other.dataCerereOferta != null)
				return false;
		} else if (!dataCerereOferta.equals(other.dataCerereOferta))
			return false;
		if (furnizor == null) {
			if (other.furnizor != null)
				return false;
		} else if (!furnizor.equals(other.furnizor))
			return false;
		if (linieCerereOferta == null) {
			if (other.linieCerereOferta != null)
				return false;
		} else if (!linieCerereOferta.equals(other.linieCerereOferta))
			return false;
		if (nrCerereOferta == null) {
			if (other.nrCerereOferta != null)
				return false;
		} else if (!nrCerereOferta.equals(other.nrCerereOferta))
			return false;
		return true;
	}
	
	
	
	

	
}
