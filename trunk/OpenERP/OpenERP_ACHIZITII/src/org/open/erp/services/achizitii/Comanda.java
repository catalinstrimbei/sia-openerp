package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Comanda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -898811753866457945L;
	public static final Integer FINALIZATA = 1;
	public static final Integer ANULATA = -1;
	public static final Integer IN_CURS = 0;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer idComanda;	
	@ManyToOne@JoinColumn(name="idFurnizor")
	private Furnizor furnizor;
	@Temporal(TemporalType.DATE)
	private Date dataComanda;
	private Integer statusComanda;
	@OneToOne@JoinColumn(name="idOfertaAchizitie_")
	private OfertaAchizitie ofertaAchizitie;
	public OfertaAchizitie getOfertaAchizitie() {
		return ofertaAchizitie;
	}

	public void setOfertaAchizitie(OfertaAchizitie ofertaAchizitie) {
		this.ofertaAchizitie = ofertaAchizitie;
	}

	public void setLiniiComanda(Collection<LinieComanda> liniiComanda) {
		this.liniiComanda = liniiComanda;
	}

	@OneToOne(mappedBy="comanda")
	private Factura factura;
	
	@OneToMany(mappedBy = "comanda",targetEntity=LinieComanda.class)
	private Collection<LinieComanda> liniiComanda;
	
	 public void addLinii(LinieComanda li) {
	        this.getLiniiComanda().add(li);	       
	    }
	
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
	public Integer getStatusComanda() {
		return statusComanda;
	}
	public void setStatusComanda(Integer statusComanda) {
		this.statusComanda = statusComanda;
	}
	public Comanda(Integer idComanda, Date dataComanda, Integer statusComanda) {
		super();
		this.idComanda = idComanda;
		this.dataComanda = dataComanda;
		this.statusComanda = statusComanda;
	}
	public Collection<LinieComanda> getLiniiComanda() {
		return liniiComanda;
	}
	public void setLiniiComanda(List<LinieComanda> liniiComanda) {
		this.liniiComanda = liniiComanda;
	}
	public Comanda(Furnizor furnizor, Date dataComanda, Integer statusComanda,
			List<LinieComanda> liniiComanda) {
		super();
		this.furnizor = furnizor;
		this.dataComanda = dataComanda;
		this.statusComanda = statusComanda;
		this.liniiComanda = liniiComanda;
	}
	public Comanda(Furnizor furnizor, Date dataComanda, Integer statusComanda) {
		super();
		this.furnizor = furnizor;
		this.dataComanda = dataComanda;
		this.statusComanda = statusComanda;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Furnizor getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Comanda() {
		super();
	}
	
	
	
	
	
}
