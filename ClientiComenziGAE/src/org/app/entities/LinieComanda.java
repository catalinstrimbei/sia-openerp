package org.app.entities;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class LinieComanda implements Serializable{
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "codpr", referencedColumnName = "cod")
	private Produs produs;
	
	private Double cantitate;
	
	@ManyToOne
	private Comanda comanda;
	
	// Constructori
		public LinieComanda(Integer id, Produs produs, Double cantitate,
				Comanda comanda) {
			this.id = id;
			this.produs = produs;
			this.cantitate = cantitate;
			this.comanda = comanda;
		}
		public LinieComanda(){}
		
		// Getteri si setteri
		public Comanda getComanda() {
			return comanda;
		}
		public void setComanda(Comanda comanda) {
			this.comanda = comanda;
		}
		
		public LinieComanda(Integer id, Produs produs, Double cantitate) {
			this.id = id;
			this.produs = produs;
			this.cantitate = cantitate;
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Produs getProdus() {
			return produs;
		}
		public void setProdus(Produs produs) {
			this.produs = produs;
		}
		public Double getCantitate() {
			return cantitate;
		}
		public void setCantitate(Double cantitate) {
			this.cantitate = cantitate;
		}
		public Double getValoareProdus(){
			if (produs == null || cantitate == null)
				return 0.0;
			
			return produs.getPretUnitar() * cantitate;
		}

		
		
		// Operatii specifice logicii modelului afacerii
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((cantitate == null) ? 0 : cantitate.hashCode());
			result = prime * result
					+ ((comanda == null) ? 0 : comanda.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((produs == null) ? 0 : produs.hashCode());
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
			LinieComanda other = (LinieComanda) obj;
			if (cantitate == null) {
				if (other.cantitate != null)
					return false;
			} else if (!cantitate.equals(other.cantitate))
				return false;
			if (comanda == null) {
				if (other.comanda != null)
					return false;
			} else if (!comanda.equals(other.comanda))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (produs == null) {
				if (other.produs != null)
					return false;
			} else if (!produs.equals(other.produs))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "ArticolComanda: id:" + id + ", " + produs
					+ ", cantitate:" + cantitate + ", valoare Articol:"
					+ getValoareProdus();
		}	
		
	}

