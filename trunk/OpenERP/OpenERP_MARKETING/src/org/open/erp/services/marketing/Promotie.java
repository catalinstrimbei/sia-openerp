package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
//import org.open.erp.services.nomgen.Produs;

@Entity
public class Promotie implements Serializable {
	public static final Integer DISCOUNT = 1; 
	public static final Integer PRODUSE_ADITIONALE = 2;
	@Id @GeneratedValue
	Integer						idPromotie;
	
	String						denumirePromotie;
	String						mesajPromotional;
	
	@Temporal(DATE)
	Date						dataStart;
	@Temporal(DATE)
	Date						dataSfarsit;
	
	Integer						tipPromotie = DISCOUNT;
	
	
	//Map<Produs,Discount>		listaProduse = new HashMap<Produs, Discount>();
	@OneToMany(mappedBy = "promotie",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<ProdusDiscount> listaProduseDiscount =  new ArrayList<ProdusDiscount>();	
	
	@OneToMany(mappedBy = "promotie" ,cascade = CascadeType.ALL)
	List<ProduseAditionale>	listProduseAditionale = new ArrayList<ProduseAditionale>();
	public Promotie() {
		super();
	}
	/**
	 * @return idPromotie
	 */
	public Integer getIdPromotie() {
		return idPromotie;
	}
	/**
	 * @param idPromotie the idPromotie to set
	 */
	public void setIdPromotie(Integer idPromotie) {
		this.idPromotie = idPromotie;
	}
	/**
	 * @return denumirePromotie
	 */
	public String getDenumirePromotie() {
		return denumirePromotie;
	}
	/**
	 * @param denumirePromotie the denumirePromotie to set
	 */
	public void setDenumirePromotie(String denumirePromotie) {
		this.denumirePromotie = denumirePromotie;
	}
	/**
	 * @return mesajPromotional
	 */
	public String getMesajPromotional() {
		return mesajPromotional;
	}
	/**
	 * @param mesajPromotional the mesajPromotional to set
	 */
	public void setMesajPromotional(String mesajPromotional) {
		this.mesajPromotional = mesajPromotional;
	}
	/**
	 * @return dataStart
	 */
	public Date getDataStart() {
		return dataStart;
	}
	/**
	 * @param dataStart the dataStart to set
	 */
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	/**
	 * @return dataSfarsit
	 */
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	/**
	 * @param dataSfarsit the dataSfarsit to set
	 */
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	/**
	 * @return tipPromotie
	 */
	public Integer getTipPromotie() {
		return tipPromotie;
	}
	/**
	 * @param tipPromotie the tipPromotie to set
	 */
	public void setTipPromotie(Integer tipPromotie) {
		this.tipPromotie = tipPromotie;
	}
	/**
	 * @return listaProduse
	 */
	
	/**
	 * @param idPromotie
	 * @param denumirePromotie
	 * @param mesajPromotional
	 * @param dataStart
	 * @param dataSfarsit
	 * @param tipPromotie
	 */
	public Promotie(Integer idPromotie, String denumirePromotie,
			String mesajPromotional, Date dataStart, Date dataSfarsit,
			Integer tipPromotie) {
		super();
		this.idPromotie = idPromotie;
		this.denumirePromotie = denumirePromotie;
		this.mesajPromotional = mesajPromotional;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.tipPromotie = tipPromotie;
	}
	

	/**
	 * @return the listaProduseDiscount
	 */
	public List<ProdusDiscount> getListaProduseDiscount() {
		return listaProduseDiscount;
	}
	/**
	 * @param listaProduseDiscount the listaProduseDiscount to set
	 */
	public void setListaProduseDiscount(List<ProdusDiscount> listaProduseDiscount) {
		this.listaProduseDiscount = listaProduseDiscount;
	}
	/**
	 * @return the listProduseAditionale
	 */
	public List<ProduseAditionale> getListProduseAditionale() {
		return listProduseAditionale;
	}
	/**
	 * @param listProduseAditionale the listProduseAditionale to set
	 */
	public void setListProduseAditionale(
			List<ProduseAditionale> listProduseAditionale) {
		this.listProduseAditionale = listProduseAditionale;
	}
	public void adaugaProdusDiscount(DummyProdus produs,Discount prodDisc){
		ProdusDiscount produseDiscount = new ProdusDiscount();
		produseDiscount.setProdus(produs);
		produseDiscount.setDiscount(prodDisc);
		this.listaProduseDiscount.add(produseDiscount);
	}
	public void StergeProdusDiscount(DummyProdus produs){
		Iterator<ProdusDiscount> produsDiscount = this.listaProduseDiscount.iterator();
		ProdusDiscount produsDisc;
		while (produsDiscount.hasNext())
		{
			produsDisc = produsDiscount.next();
			if(produsDisc.getProdus().equals(produs))
			{
				this.listaProduseDiscount.remove(produsDisc);
			}
		}
		
	}
	public void adaugaProdusAdiacent(DummyProdus produs,List<DummyProdus> prodAddiacent){
		ProduseAditionale produseAditionale = new ProduseAditionale();
		produseAditionale.setProdus(produs);
		produseAditionale.setProduseAditionale(prodAddiacent);
		this.listProduseAditionale.add(produseAditionale);
}
	public void StergeProdusAdiacent(DummyProdus produs){
		Iterator<ProduseAditionale>  produsaditional= this.listProduseAditionale.iterator();
		ProduseAditionale    produsAdd;
		while (produsaditional.hasNext())
		{
			produsAdd = produsaditional.next();
			if (produsAdd.getProdus().equals(produs))
			{
				this.listProduseAditionale.remove(produsAdd);
			}
		}
	}
	
	public void adaugaProdusAditionalLaProdus(DummyProdus produs, DummyProdus prodAdiacent)
	{
		Iterator<ProduseAditionale>  produsaditional= this.listProduseAditionale.iterator();
		ProduseAditionale    produsAdd;
		while (produsaditional.hasNext())
		{
			produsAdd = produsaditional.next();
			if (produsAdd.getProdus().equals(produs))
			{
				produsAdd.adaugaProdusAditional(prodAdiacent);
			}
		}
	}
	
	public void StergeProdusAditionaldinProdus(DummyProdus produs, DummyProdus prodAdiacent)
	{
		Iterator<ProduseAditionale>  produsaditional= this.listProduseAditionale.iterator();
		ProduseAditionale    produsAdd;
		while (produsaditional.hasNext())
		{
			produsAdd = produsaditional.next();
			if (produsAdd.getProdus().equals(produs))
			{
				produsAdd.stergeProdusAditional(prodAdiacent);
			}
		}
	}
	
	public float getPretByPretInitial(DummyProdus produs, float pretInitial)
	{
		
		Discount   discount;
		ProdusDiscount  produsDiscount;
		float pretFinal = 0;
		if (this.tipPromotie == Promotie.DISCOUNT)
		{
			Iterator<ProdusDiscount> iterator = this.listaProduseDiscount.iterator();
			while (iterator.hasNext())
			{
				produsDiscount = iterator.next();
				if (produsDiscount.getProdus().equals(produs))
				{
					discount = produsDiscount.getDiscount();
						if (discount.getTipDiscount() == Discount.PROCENT)
							pretFinal = pretInitial - (pretInitial * discount.getValoare()) / 100;
						else
							pretFinal = pretInitial - discount.getValoare();
				}
			}
		}
		else
			pretFinal = pretInitial;
		return pretFinal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPromotie == null) ? 0 : idPromotie.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotie other = (Promotie) obj;
		if (idPromotie == null) {
			if (other.idPromotie != null)
				return false;
		} else if (!idPromotie.equals(other.idPromotie))
			return false;
		return true;
	}
	
	
	

	
}
