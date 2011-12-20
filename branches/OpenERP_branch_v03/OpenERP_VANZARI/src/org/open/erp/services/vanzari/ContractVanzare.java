package org.open.erp.services.vanzari;
import java.util.Date;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.vanzari.Client;

/**
 * @author Irina Bogdan
 */

public class ContractVanzare extends Document {
	Integer idContract;
	Client client;
	Date dataInceputContract;
	Date dataIncheireContract;
	
	public Integer getIdContract() {
		return idContract;
	}
	public void setIdContract(Integer idContract) {
		this.idContract = idContract;
	}
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
