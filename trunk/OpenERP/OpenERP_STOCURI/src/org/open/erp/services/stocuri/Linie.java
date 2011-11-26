package org.open.erp.services.stocuri;

import org.open.erp.services.nomenclatoare.Material;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Linie {

	private Integer idLinie;
	private Material material;
	private Document document;
	private Double pret = 0.0;
	private Integer cantitate;

	public Linie() {
		super();
	}

	public Linie(Integer idLinie, Material material,
			Document document, Double pret, Integer cantitate) {
		super();
		this.idLinie = idLinie;
		this.material = material;
		this.document = document;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public void incementeazaPret(Double pretNou) {
		pretNou = (pret == null) ? 0.0 : pretNou;

		this.pret += pretNou;
	}

	public Double getPret() {
		return pret;
	}

	public void setPret(Double pret) {
		this.pret = pret;
	}

	public Integer getIdLinie() {
		return idLinie;
	}

	public void setIdLinie(Integer idLinie) {
		this.idLinie = idLinie;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Integer getCantitate() {
		return cantitate;
	}

	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}

}
