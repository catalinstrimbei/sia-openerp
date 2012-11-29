package org.open.erp.services.tranzactii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;

public class OperatiuneContabila {

	Integer idOperatiune;
	Date dataOperatiune;
	String tipOperatiune;
	String descriereOperatiune;
	
    private List<InregistrareOperatiuneContabila> inregistrari = new ArrayList<InregistrareOperatiuneContabila>();
	
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
