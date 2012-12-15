package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nommat.Material;


public class Semifabricat extends Produs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer idSemifabricat;
	
	String semifabricat;
	
	private List<Material> listaMateriale = new ArrayList<Material>();
	
	Semifabricat semifabricatContinut;

	public Integer getIdSemifabricat() {
		return idSemifabricat;
	}

	public void setIdSemifabricat(Integer idSemifabricat) {
		this.idSemifabricat = idSemifabricat;
	}

	public String getSemifabricat() {
		return semifabricat;
	}

	public void setSemifabricat(String semifabricat) {
		this.semifabricat = semifabricat;
	}

	public List<Material> getListaMateriale() {
		return listaMateriale;
	}

	public void setListaMateriale(List<Material> listaMateriale) {
		this.listaMateriale = listaMateriale;
	}

	public Semifabricat getSemifabricatContinut() {
		return semifabricatContinut;
	}

	public void setSemifabricatContinut(Semifabricat semifabricatContinut) {
		this.semifabricatContinut = semifabricatContinut;
	}

	public Semifabricat(Integer idSemifabricat,
			String semifabricat, List<Material> listaMateriale,
			Semifabricat semifabricatContinut) {
		super();
		this.idSemifabricat = idSemifabricat;
		this.semifabricat = semifabricat;
		this.listaMateriale = listaMateriale;
		this.semifabricatContinut = semifabricatContinut;
	}

	public Semifabricat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semifabricat(Integer idProdus, String denumire, String categorie,
			String unitateMasura, Date dataFabricatiei,
			Integer termenValabilitate, Double pretVanzare, Float procentTVA,
			List<LinieDocument> liniiDocumente) {
		super(idProdus, denumire, categorie, unitateMasura, dataFabricatiei,
				termenValabilitate, pretVanzare, procentTVA, liniiDocumente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idSemifabricat == null) ? 0 : idSemifabricat.hashCode());
		result = prime * result
				+ ((listaMateriale == null) ? 0 : listaMateriale.hashCode());
		result = prime * result
				+ ((semifabricat == null) ? 0 : semifabricat.hashCode());
		result = prime
				* result
				+ ((semifabricatContinut == null) ? 0 : semifabricatContinut
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Semifabricat other = (Semifabricat) obj;
		if (idSemifabricat == null) {
			if (other.idSemifabricat != null)
				return false;
		} else if (!idSemifabricat.equals(other.idSemifabricat))
			return false;
		if (listaMateriale == null) {
			if (other.listaMateriale != null)
				return false;
		} else if (!listaMateriale.equals(other.listaMateriale))
			return false;
		if (semifabricat == null) {
			if (other.semifabricat != null)
				return false;
		} else if (!semifabricat.equals(other.semifabricat))
			return false;
		if (semifabricatContinut == null) {
			if (other.semifabricatContinut != null)
				return false;
		} else if (!semifabricatContinut.equals(other.semifabricatContinut))
			return false;
		return true;
	}
	
	
}
