package org.open.erp.services.achizitii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class CerereAprov {
		private Integer nrCerereAprov;
		private Date dataCerereAprov;
		private List<LiniiCerereAprov> liniiCerereAprov = new ArrayList<LiniiCerereAprov>();
		//private Materiale material;

		
		public void addLinie(LiniiCerereAprov linie){
			this.liniiCerereAprov.add(linie);
		}

		public Integer getNrCerereAprov() {
			return nrCerereAprov;
		}
		public void setNrCerereAprov(Integer nrCerereAprov) {
			this.nrCerereAprov = nrCerereAprov;
		}
		public Date getDataCerereAprov() {
			return dataCerereAprov;
		}
		public void setDataCerereAprov(Date dataCerereAprov) {
			this.dataCerereAprov = dataCerereAprov;
		}
		public List<LiniiCerereAprov> getLiniiCerereAprov() {
			return liniiCerereAprov;
		}
		public void setLiniiCerereAprov(List<LiniiCerereAprov> liniiCerereAprov) {
			this.liniiCerereAprov = liniiCerereAprov;
		}

		public void adaugaLinieCerereAprov(LiniiCerereAprov liniiCerereAprov){
			this.liniiCerereAprov.add(liniiCerereAprov);
		}
		
		public void adaugaLinie(List<LiniiCerereAprov> linii){
			this.liniiCerereAprov.addAll(linii);
		}
		/*
		public Materiale getMaterial() {
			return material;
		}
		public void setMaterial(Materiale material) {
			this.material = material;
		}
		*/
		public CerereAprov(Integer nrCerereAprov, Date dataCerereAprov
				//Materiale material
				) {
			super();
			this.nrCerereAprov = nrCerereAprov;
			this.dataCerereAprov = dataCerereAprov;
			//this.material = material;
		}
		public CerereAprov() {
			super();
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((dataCerereAprov == null) ? 0 : dataCerereAprov
							.hashCode());
			result = prime
					* result
					+ ((liniiCerereAprov == null) ? 0 : liniiCerereAprov
							.hashCode());
			result = prime * result
					+ ((nrCerereAprov == null) ? 0 : nrCerereAprov.hashCode());
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
			CerereAprov other = (CerereAprov) obj;
			if (dataCerereAprov == null) {
				if (other.dataCerereAprov != null)
					return false;
			} else if (!dataCerereAprov.equals(other.dataCerereAprov))
				return false;
			if (liniiCerereAprov == null) {
				if (other.liniiCerereAprov != null)
					return false;
			} else if (!liniiCerereAprov.equals(other.liniiCerereAprov))
				return false;
			if (nrCerereAprov == null) {
				if (other.nrCerereAprov != null)
					return false;
			} else if (!nrCerereAprov.equals(other.nrCerereAprov))
				return false;
			return true;
		}

}
