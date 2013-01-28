package org.open.erp.ui.finplati;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.FinanciarPlatiSrv;

@ManagedBean(name = "facturaStatusBean")
@javax.faces.bean.RequestScoped

public class FacturaStatusBean implements Serializable{
 
	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;

	private Integer NrFactura;
	private Date dataFactura;
	private String numeFurnizor;
	private Double valoareTotala;
	
	public FacturaStatusBean(){
	}
	
	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarPlatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarPlatiSrv) {
		this.financiarPlatiSrv = financiarPlatiSrv;
	}

	/*-*--------------------*/
public void seNrFactura(Integer nrFactura) {  /* ??? nu am alt set nr fact */
		this.NrFactura = nrFactura;
	}	
public Integer getNrFactura() {
		return this.NrFactura;
	}
	public void setDataFactura(Date dataFactura) {
		this.dataFactura = dataFactura;
	}
	public Date getDataFactura() {
		return this.dataFactura;
   }
	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}
	public String getNumeFurnizor() {
	return this.numeFurnizor;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public Double getValoareTotala() {
		return this.valoareTotala;
	}


	
	public String  adaugaFacturaStatus() throws Exception{
		
		 FacturaStatus facturaStatusNou = new FacturaStatus();
	facturaStatusNou.setNrFactura(NrFactura); /*---- aici nu stiu daca e corect---*/
	facturaStatusNou.setDataFactura(dataFactura);
	facturaStatusNou.setNumeFurnizor(numeFurnizor);
	facturaStatusNou.setValoareTotala(valoareTotala);
		
	   financiarPlatiSrv.adaugaFactura(facturaStatusNou);
		
		return "facturaStatusNou";
	}
	
}

