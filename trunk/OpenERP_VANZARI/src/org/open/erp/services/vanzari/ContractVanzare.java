package org.open.erp.services.vanzari;
import java.util.Date;

import org.open.erp.services.vanzari.Client;

/*
 * @author Irina Bogdan
 */

public class ContractVanzare {
	Integer idContract;
	Client client;
	Date dataContract;
	
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
	public Date getDataContract() {
		return dataContract;
	}
	public void setDataContract(Date dataContract) {
		this.dataContract = dataContract;
	}
	
}
