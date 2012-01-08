package org.open.erp.services.vanzari;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.vanzari.Client;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class ContractVanzare extends Document implements Serializable {
	//@Id @GeneratedValue
	//Integer idContract;
	@OneToOne
	Client client;
	@Temporal(TIMESTAMP)
	Date dataInceputContract;
	@Temporal(TIMESTAMP)
	Date dataIncheireContract;
	
	public ContractVanzare(){super();}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDataInceputContract() {
		return dataInceputContract;
	}
	public void setDataInceputContract(Date dataInceputContract) {
		this.dataInceputContract = dataInceputContract;
	}
	public Date getDataIncheireContract() {
		return dataIncheireContract;
	}
	public void setDataIncheireContract(Date dataIncheireContract) {
		this.dataIncheireContract = dataIncheireContract;
	}

	
}
