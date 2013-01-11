package org.open.erp.services.finplati;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;

import org.open.erp.services.finplati.FurnizorContract;

@Entity
public class Contract {
	@Id @GeneratedValue
	Integer idContract;
	
	//@OneToMany
	FurnizorContract furnizor;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataContract;
	
	Double valoareContract;
	Double discountContract;
	
	Map<Integer, Plata> plati;
	//@OneToMany
	StatusContract statusContract;
	
	private static int nextIdContract = 1;

	public Contract() {
		idContract = nextIdContract++;
	}
	
	public Integer getIdContract() {
		return idContract;
	}
	public void setIdContract(Integer idContract) {
		this.idContract = idContract;
	}
	public FurnizorContract getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(FurnizorContract furnizor) {
		this.furnizor = furnizor;
	}
	public Date getDataContract() {
		return dataContract;
	}
	public void setDataContract(Date dataContract) {
		this.dataContract = dataContract;
	}
	public StatusContract getStatusContract() {
		return statusContract;
	}
	public void setStatusContract(StatusContract statusContract) {
		this.statusContract = statusContract;
	}
	public Double getValoareContract() {
		return valoareContract;
	}
	public void setValoareContract(double valoareContract) {
		this.valoareContract = valoareContract;
	}
	public Map<Integer, Plata> getPlati() {
		return plati;
	}
	public void setPlati(Map<Integer, Plata> plati) {
		this.plati = plati;
	}
	public void adaugaPlata(Plata plata) {
		if (plati == null)
			plati = new HashMap<Integer, Plata>();
		plati.put(plata.getId(), plata);
	}
	
	
	public Double getTotalPlati() {
		Double sumTotal = 0.0;
		Iterator<Entry<Integer,Plata>> platiIter = plati.entrySet().iterator();
		
		while (platiIter.hasNext()) {
			Plata p = platiIter.next().getValue();
			sumTotal += p.getValoarePlata();
		}
		return sumTotal;
	}
	public void setDiscountContract(Double discountContract) {
		this.discountContract = discountContract;
	}
	public Double getDiscountContract() {
		return (this.discountContract == null ? 0.0 : this.discountContract);
	}

	
	}

