package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import org.hibernate.validator.NotNull;


@Entity
public class Intrebare implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	Integer					idIntrebare;
	String					textIntrebare;
	String					tipIntrebare;
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
	
	//public void adaugaRaspuns(Integer nrRaspuns, String textRaspuns){
	//	if(optiuniRaspuns == null)
	//		optiuniRaspuns = new HashMap<Integer,String>();
	//	optiuniRaspuns.put(nrRaspuns, textRaspuns);
	//}
	//public String getRaspuns(Integer nrRaspuns){
	//	return optiuniRaspuns.get(nrRaspuns);
	//}
}
