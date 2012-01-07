package org.open.erp.services.marketing;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import org.open.erp.services.nomgen.Produs;

@Entity
public class Promotie {
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
	
	Map<Produs,Discount>		listaProduse = new HashMap<Produs, Discount>();
	Map<Produs,List<Produs>>	listProduseAditionale = new HashMap<Produs, List<Produs>>();
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
	 * @return listaProduse
	 */
	public Map<Produs, Discount> getListaProduse() {
		return listaProduse;
	}
	/**
	 * @param listaProduse the listaProduse to set
	 */
	public void setListaProduse(Map<Produs, Discount> listaProduse) {
		this.listaProduse = listaProduse;
	}
	/**
	 * @return listProduseAditionale
	 */
	public Map<Produs, List<Produs>> getListProduseAditionale() {
		return listProduseAditionale;
	}
	/**
	 * @param listProduseAditionale the listProduseAditionale to set
	 */
	public void setListProduseAditionale(
			Map<Produs, List<Produs>> listProduseAditionale) {
		this.listProduseAditionale = listProduseAditionale;
	}

	public void adaugaProdusDiscount(Produs produs,Discount prodDisc){
		listaProduse.put(produs, prodDisc);
	}
	public void StergeProdusDiscount(Produs produs){
		listaProduse.remove(produs);
	}
	public void adaugaProdusAdiacent(Produs produs,List<Produs> prodAddiacent){
		this.listProduseAditionale.put(produs,prodAddiacent);
	}
	public void StergeProdusAdiacent(Produs produs){
		this.listProduseAditionale.remove(produs);
	}
	
	public float getPretByPretInitial(Produs produs, float pretInitial)
	{
		
		Discount   discount;
		if (this.tipPromotie == Promotie.DISCOUNT)
		{
			discount = this.listaProduse.get(produs);
			if (discount.getTipDiscount() == Discount.PROCENT)
				return pretInitial - (pretInitial * discount.getValoare()) / 100;
			else
				return pretInitial - discount.getValoare();
		}
		else
			return pretInitial;
	}
}
