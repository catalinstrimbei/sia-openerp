package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;

@Entity(name = "ContBancaPF")
@DiscriminatorValue("ContBancaPF")
public class ContBancaPF implements Serializable{

	@Id
	private Integer idContBancaPF;
	@ManyToOne
	private PersoanaJuridica banca;
	@ManyToOne
    private PersoanaFizica titularCont;

    private String numarCont;

    private String moneda;

    private Double sold;

    public PersoanaJuridica getBanca() {
            return banca;
    }

    public Integer getIdContBancaPF() {
		return idContBancaPF;
	}

	public void setIdContBancaPF(Integer idContBancaPF) {
		this.idContBancaPF = idContBancaPF;
	}

	public void setBanca(PersoanaJuridica banca) {
            this.banca = banca;
    }

    public PersoanaFizica getTitularCont() {
        return titularCont;
    }

    public void setTitularCont(PersoanaFizica titularCont) {
        this.titularCont = titularCont;
    }

    public String getNumarCont() {
            return numarCont;
    }

    public void setNumarCont(String numarCont) {
            this.numarCont = numarCont;
    }

    public String getMoneda() {
            return moneda;
    }

    public void setMoneda(String moneda) {
            this.moneda = moneda;
    }

    public Double getSold() {
            return sold;
    }

    public void setSold(Double sold) {
            this.sold = sold;
    }

    public ContBancaPF(){
    	
    }
}