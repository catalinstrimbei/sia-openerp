

package org.open.erp.services.finplati;


//import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.FurnizorContract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
@Entity
public class SituatieFinanciara implements Serializable{
	@Id
	@GeneratedValue
	Integer idSitFit;
	
	Double valoarePlatiRestante;
	Double bugetDatorii;
	
	//@OneToOne
	@ManyToMany @JoinTable(name="sitf_plata")
	Map<Integer,Plata> plati;
	
	@ManyToMany @JoinTable(name="sitf_fac")
	Map<Integer,FacturaStatus> factura;
	
	@ManyToMany @JoinTable(name="sitf_contr")
	Map<Integer,Contract> contracte;

	public Map<Integer, FacturaStatus> getFactura() {
		return factura;
	}

	public void setFactura(Map<Integer, FacturaStatus> factura) {
		this.factura = factura;
	}

	public void setResponsabil(ResponsabilPlata responsabil) {
		this.responsabil = responsabil;
	}

	@ManyToMany @JoinTable(name="sitf_pers")
	Map<Integer,Persoana> personal;
	
	@OneToOne @JoinTable(name="sitf_resp")
	ResponsabilPlata responsabil;
	
	public SituatieFinanciara() {
		plati = new HashMap<Integer,Plata>();
		factura = new HashMap<Integer, FacturaStatus>();
		contracte = new HashMap<Integer, Contract>();
		personal = new HashMap<Integer, Persoana>();
	}
	
	public Integer getIdSitFit() {
		return idSitFit;
	}
	public void setIdSitFit(Integer idSitFit) {
		this.idSitFit = idSitFit;
	}
	public Double getValoarePlatiRestante() {
		return valoarePlatiRestante;
	}
	public void setValoarePlatiRestante(Double valoarePlatiRestante) {
		this.valoarePlatiRestante = valoarePlatiRestante;
	}
	public void setBugetDatorii(Double bugetDatorii) {
		this.bugetDatorii = bugetDatorii;
	}
	public Double getBugetDatorii() {
		return this.bugetDatorii;
	}
	public Map<Integer,Contract> getContracte() {
		return contracte;
	}
	public void setContracte(Map<Integer,Contract> contracte) {
		this.contracte = contracte;
	}
	public void adaugareContract(Contract contract) {
		this.contracte.put(contract.getIdContract(), contract);
	}
	public void setPersonal(Map<Integer,Persoana> personal) {
		this.personal = personal;
	}
	public Map<Integer,Persoana> getPersonal() {
		return this.personal;
	}
	public void adaugarePersonal(Persoana persoana) {
		this.personal.put(persoana.getIdPersoana(), persoana);
	}
	public Map<Integer,Plata> getPlati() {
		return plati;
	}
	public void setPlati(Map<Integer,Plata> plati) {
		this.plati = plati;
	}
	public ChitantaPlata adaugarePlata(Plata plata) {
		plati.put(plata.getId(), plata);
		
		ChitantaPlata chitanta = new ChitantaPlata(plata);
		return chitanta;
	}
	public void adaugareFactura(FacturaStatus fact) {
		factura.put(fact.getNrFactura(), fact);
	}
	public void setfactura(Map<Integer,FacturaStatus> factura) {
		this.factura = factura;
	}
	public Map<Integer,FacturaStatus> getfactura() {
		return this.factura;
	}
	public ResponsabilPlata getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Persoana persoana) {
		this.responsabil = new ResponsabilPlata(persoana);
	}
	public Double getTotalPlati(Date... reqDate) {
		Date dateVal;
		if (reqDate == null || reqDate.length > 0)
			dateVal = new Date();
		else
			dateVal = reqDate[0];
		
		Double sumTotal = 0.0;
		Iterator<Entry<Integer, Plata>> platiIter = plati.entrySet().iterator();
		while (platiIter.hasNext()) {
			Plata p = platiIter.next().getValue();
			if (p.getDataPlatii().after(dateVal))
				break;
			
			sumTotal += p.getValoarePlata();
		}
		
		return sumTotal;
	}
	
	public Double getSoldurifactura() {
		Double sumTotal = 0.0;
		Iterator<Entry<Integer,FacturaStatus>> factIter = factura.entrySet().iterator();
		
		while (factIter.hasNext()) {
			FacturaStatus f = factIter.next().getValue();
			sumTotal += f.getValoareTotala() - f.getValoareAchitata();
		}
		return sumTotal;
	}

	public List<Persoana> getListaPersonal() {
		List<Persoana> listaPersonal = new ArrayList<Persoana>();
		Iterator<Entry<Integer,Persoana>> personalIter = personal.entrySet().iterator();
		
		while (personalIter.hasNext()) {
			Persoana p = personalIter.next().getValue();
			listaPersonal.add(p);
		}
		return listaPersonal;
	}
}
