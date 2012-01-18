package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.NotNull;


@Entity
public class Intrebare implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer					idIntrebare;
	String					textIntrebare;
	String					tipIntrebare;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idChestionar")
	Chestionar				chestionar;
	
	@OneToMany(mappedBy = "intrebare",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@IndexColumn(name="IdRaspunsIntrebare")
	List<RaspunsIntrebare> raspunsuri;
	//Map<Integer, String> 	optiuniRaspuns = new HashMap<Integer,String>();

	public Intrebare() {
		super();
	}
	public Integer getIdIntrebare() {
		return idIntrebare;
	}
	public String getTextIntrebare() {
		return textIntrebare;
	}
	public void setTextIntrebare(String textIntrebare) {
		this.textIntrebare = textIntrebare;
	}
	public String getTipIntrebare() {
		return tipIntrebare;
	}
	public void setTipIntrebare(String tipIntrebare) {
		this.tipIntrebare = tipIntrebare;
	}
	//public Map<Integer, String> getRaspunsuri() {
	//	return optiuniRaspuns;
	//}
	//public void setRaspunsuri(Map<Integer, String> raspunsuri) {
	//	this.optiuniRaspuns = raspunsuri;
	//}
	public void setIdIntrebare(Integer idIntrebare) {
		this.idIntrebare = idIntrebare;
	}
	public Intrebare(String textIntrebare, String tipIntrebare) {
		super();
		this.textIntrebare = textIntrebare;
		this.tipIntrebare = tipIntrebare;
	}
	/**
	 * @return the chestionar
	 */
	public Chestionar getChestionar() {
		return chestionar;
	}
	/**
	 * @param chestionar the chestionar to set
	 */
	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}
	
	//public void adaugaRaspuns(Integer nrRaspuns, String textRaspuns){
	//	if(optiuniRaspuns == null)
	//		optiuniRaspuns = new HashMap<Integer,String>();
	//	optiuniRaspuns.put(nrRaspuns, textRaspuns);
	//}
	//public String getRaspuns(Integer nrRaspuns){
	//	return optiuniRaspuns.get(nrRaspuns);
	//}
	
}
