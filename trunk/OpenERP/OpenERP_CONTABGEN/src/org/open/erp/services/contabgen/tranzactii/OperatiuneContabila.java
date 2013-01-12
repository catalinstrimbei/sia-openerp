package org.open.erp.services.contabgen.tranzactii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OperatiuneContabila implements Serializable{

	@Id
	@GeneratedValue
	Integer idOperatiune;
	@Temporal(TemporalType.TIMESTAMP)
	Date dataOperatiune;
	String tipOperatiune;
	String descriereOperatiune;
	
    @OneToMany(cascade=CascadeType.ALL)
	private List<InregistrareOperatiuneContabila> inregistrari = new ArrayList<InregistrareOperatiuneContabila>();
	
	public OperatiuneContabila() {
	}
    public void setIdOperatiune(Integer idOperatiune) {
		this.idOperatiune = idOperatiune;
	}

	public Date getDataOperatiune() {
		return dataOperatiune;
	}

	public void setDataOperatiune(Date dataOperatiune) {
		this.dataOperatiune = dataOperatiune;
	}

	public String getTipOperatiune() {
		return tipOperatiune;
	}

	public void setTipOperatiune(String tipOperatiune) {
		this.tipOperatiune = tipOperatiune;
	}

	public String getDescriereOperatiune() {
		return descriereOperatiune;
	}

	public void setDescriereOperatiune(String descriereOperatiune) {
		this.descriereOperatiune = descriereOperatiune;
	}

	public List<InregistrareOperatiuneContabila> getInregistrari() {
		return inregistrari;
	}

	public void setInregistrari(List<InregistrareOperatiuneContabila> inregistrari) {
		this.inregistrari = inregistrari;
	}

	public Integer getIdOperatiune() {
		return idOperatiune;
	}
	
	public void addInregistrare(InregistrareOperatiuneContabila inregCont){
		this.inregistrari.add(inregCont);
	}

	public OperatiuneContabila(Date dataOperatiune, String tipOperatiune,
			String descriereOperatiune) {
		super();
		this.dataOperatiune = dataOperatiune;
		this.tipOperatiune = tipOperatiune;
		this.descriereOperatiune = descriereOperatiune;
	}
	
	
	

}
