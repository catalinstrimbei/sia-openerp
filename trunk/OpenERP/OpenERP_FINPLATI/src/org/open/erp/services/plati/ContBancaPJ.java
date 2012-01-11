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

import org.open.erp.services.nomgen.PersoanaJuridica;

@Entity(name = "ContBancaPJ")
@DiscriminatorValue("ContBancaPJ")
public class ContBancaPJ implements Serializable{
			@Id
			private Integer idContBancaPJ;
			@ManyToOne
	        private PersoanaJuridica banca;
	        @ManyToOne
	        private PersoanaJuridica titularCont;

	        private String numarCont;

	        private String moneda;

	        private Double sold;
	        
	        public ContBancaPJ(PersoanaJuridica banca, PersoanaJuridica titularCont, String numarCont, String moneda, Double sold) {
	    		this.banca = banca;
	    		this.titularCont = titularCont;
	    		this.numarCont = numarCont;
	    		this.moneda = moneda;
	    		this.sold = sold;
	    	}

	        public Integer getIdContBancaPJ() {
				return idContBancaPJ;
			}

			public void setIdContBancaPJ(Integer idContBancaPJ) {
				this.idContBancaPJ = idContBancaPJ;
			}

			public PersoanaJuridica getBanca() {
	                return banca;
	        }

	        public void setBanca(PersoanaJuridica banca) {
	                this.banca = banca;
	        }

	        public PersoanaJuridica getTitularCont() {
	            return titularCont;
	        }

	    public void setTitularCont(PersoanaJuridica titularCont) {
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

	        public ContBancaPJ(){
	        	
	        }
	}
