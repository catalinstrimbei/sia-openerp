package org.open.erp.services.personal;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Anunt {
	String denPost = null;
	@Id
	Integer id;
	Integer indexCOR = 0;
	Date dataPostareAnunt = null;
	Date dataExpirareAnunt = null;
	String cerintePost = null;
	Post postDisponibil = null;
	
	public Anunt(Integer id, String titlu, Integer codPost, Date dataPostare, Date dataExpirare, String cerinte, Post postLiber){
		this.id = id;
		denPost = titlu;
		indexCOR = codPost;
		dataPostareAnunt = dataPostare;
		dataExpirareAnunt = dataExpirare;
		cerintePost = cerinte;
		postDisponibil = postLiber;
	}
	
	public Anunt(Anunt anuntAnterior){
		this.id = anuntAnterior.id;
		this.denPost = anuntAnterior.denPost;
		this.indexCOR = anuntAnterior.indexCOR;
		this.dataPostareAnunt = anuntAnterior.dataPostareAnunt;
		this.dataExpirareAnunt = anuntAnterior.dataExpirareAnunt;
		this.cerintePost = anuntAnterior.cerintePost;
	}

	public Anunt(){
		
	}
	
	public String getDenumirePost() {
		return denPost;
	}

	public void setDenumirePost(String denumirePost) {
		this.denPost = denumirePost;
	}

	public Integer getIndexCOR() {
		return indexCOR;
	}

	public void setIndexCOR(Integer indexCOR) {
		this.indexCOR = indexCOR;
	}

	public Date getDataPostareAnunt() {
		return dataPostareAnunt;
	}

	public void setDataPostareAnunt(Date dataPostareAnunt) {
		this.dataPostareAnunt = dataPostareAnunt;
	}

	public Date getDataExpirareAnunt() {
		return dataExpirareAnunt;
	}

	public void setDataExpirareAnunt(Date dataExpirareAnunt) {
		this.dataExpirareAnunt = dataExpirareAnunt;
	}

	public String getCerintePost() {
		return cerintePost;
	}

	public void setCerintePost(String cerintePost) {
		this.cerintePost = cerintePost;
	}
	
	
}
