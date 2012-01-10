package org.open.erp.services.incasari;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.TemporalType.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.open.erp.services.vanzari.FacturaEmisa;

@Entity
@Table(name = "Incasare")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tip_incasare")
public abstract class Incasare {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idIncasare;

	private String moneda;
	@Temporal(DATE)
	private Date dataEmiterii;

	private Boolean avans;
	@Temporal(DATE)
	private Date dataInregistrarii;

	private Double suma;

	private String sumaInLitere;

      @ManyToMany
	@JoinTable(name = "Incasari_Facturi", joinColumns = @JoinColumn(name = "idIncasare"), inverseJoinColumns = @JoinColumn(name = "idFactura"))
	private List<FacturaEmisa> facturi = new ArrayList<FacturaEmisa>();

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSumaInLitere() {
		return sumaInLitere;
	}

	public void setSumaInLitere(String sumaInLitere) {
		this.sumaInLitere = sumaInLitere;
	}

	private String seria;
	private Integer numar;
	private String locatie;

	public Date getData() {
		return dataEmiterii;
	}

	public void setData(Date data) {
		this.dataEmiterii = data;
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

	public Date getDataEmiterii() {
		return dataEmiterii;
	}

	public void setDataEmiterii(Date dataEmiterii) {
		this.dataEmiterii = dataEmiterii;
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

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public Incasare(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie) {
		super();
		this.dataEmiterii = dataEmiterii;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.sumaInLitere = sumaInLitere;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;

	}

	public Incasare(Integer idIncasare, Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie) {
		super();
		this.setIdIncasare(idIncasare);
		this.dataEmiterii = dataEmiterii;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.sumaInLitere = sumaInLitere;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;

	}

	public List<FacturaEmisa> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<FacturaEmisa> facturi) {
		this.facturi = facturi;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public Incasare() {
		super();
	}

	public Integer getIdIncasare() {
		return idIncasare;
	}

	public void setIdIncasare(Integer idIncasare) {
		this.idIncasare = idIncasare;
	}

}
