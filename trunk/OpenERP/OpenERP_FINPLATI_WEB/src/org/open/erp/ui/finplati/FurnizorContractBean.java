package org.open.erp.ui.finplati;


import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.ManyToMany;

import org.open.erp.services.finplati.FurnizorContract;
import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.Plata;

@ManagedBean(name = "furnizorContractBean")
@javax.faces.bean.RequestScoped
public class FurnizorContractBean implements Serializable{

	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiSrvImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;

	private String numeFurnizor;
	private String adresaFurnizor;
	private String cuiFurnizor;
	//private Int plati;
	//private Date dataFinal;
	
	//Map<Integer,Plata> plati;
	
	public FurnizorContractBean(){
	}
	
	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarPlatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarPlatiSrv) {
		this.financiarPlatiSrv = financiarPlatiSrv;
	}

	public String getNumeFurnizor() {
	return numeFurnizor;
  }
	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}
	public String getAdresaFurnizor() {
		return adresaFurnizor;
	}
	public void setAdresaFurnizor(String adresaFurnizor) {
		this.adresaFurnizor = adresaFurnizor;
	}
	public String getCuiFurnizor() {
		return cuiFurnizor;
	}
	public void setCuiFurnizor(String cuiFurnizor) {
		this.cuiFurnizor = cuiFurnizor;
	}
	
	//public Map<Integer,Plata> getPlati() {
		//return plati;
	//}
	//public void setPlati(Map<Integer,Plata> plati) {
	//	this.plati = plati;
	//}  
	
	public String  adaugaFurnizorContract() throws Exception{
		
		 FurnizorContract furnizorContractNou = new FurnizorContract();
		//furnizorContractNou.adaugarePlata(plata);
		furnizorContractNou.setNumeFurnizor(numeFurnizor);
		furnizorContractNou.setAdresaFurnizor(adresaFurnizor);
		furnizorContractNou.setCuiFurnizor(cuiFurnizor);
	
		
	  //  financiarPlatiSrv.adaugaFurnizorContract(furnizorContractNou);
		
		return "furnizorContractNou";
	}
	
}
