package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static javax.persistence.CascadeType.ALL;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class LinieOfertaAchizitie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2811436293697742002L;

	@Id
   /* @GeneratedValue(strategy = GenerationType.AUTO)
	private long idLinieOfertaAchizitie_gen;*/
    private long idLinieOfertaAchizitie;
	
	@ManyToOne/*(cascade = ALL)*/@JoinColumn(name="id_OfertaAchizitie")
	private OfertaAchizitie oferta;
	
	public long getIdLinieOfertaAchizitie() {
		return idLinieOfertaAchizitie;
	}
	public void setIdLinieOfertaAchizitie(long idLinieOfertaAchizitie) {
		this.idLinieOfertaAchizitie = idLinieOfertaAchizitie;
	}
	@ManyToOne
	private Articol articol;
	private Double cantitate;
	private Integer linie;
	private Double pret;
	
	public LinieOfertaAchizitie() {
		super();
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public OfertaAchizitie getOferta() {
		return oferta;
	}
	public void setOferta(OfertaAchizitie oferta) {
		this.oferta = oferta;
	}
	public LinieOfertaAchizitie(OfertaAchizitie oferta, Articol articol,
			Double cantitate, Integer linie) {
		super();
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public Articol getArticol() {
		return articol;
	}
	public void setArticol(Articol articol) {
		this.articol = articol;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Integer getLinie() {
		return linie;
	}
	public void setLinie(Integer linie) {
		this.linie = linie;
	}
	public LinieOfertaAchizitie(OfertaAchizitie oferta, Articol articol,
			Double cantitate, Integer linie, Double pret) {
		super();
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
		this.pret = pret;
	}
	public LinieOfertaAchizitie(long idLinieOfertaAchizitie,
			OfertaAchizitie oferta, Articol articol, Double cantitate,
			Integer linie, Double pret) {
		super();
		this.idLinieOfertaAchizitie = idLinieOfertaAchizitie;
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
		this.pret = pret;
	}	
	

}
