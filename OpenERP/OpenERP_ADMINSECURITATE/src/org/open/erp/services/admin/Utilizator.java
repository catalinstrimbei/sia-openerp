package org.open.erp.services.admin;

import org.open.erp.services.personal.Angajat;




public class Utilizator extends Angajat{

	Integer IdUtilizator;
	String FunctiaUtilizator;
	String Utilizator;
	String ParolaUtilizator;
	Integer idGrup;
	Integer idRol;
	
	public Integer getIdUtilizator(){
		return IdUtilizator;	
	}
	
	public void setIdUtilizator(Integer IdUtilizator){
		this.IdUtilizator = IdUtilizator;
	}
	
	public String getFunctiaUtilizator(){
		return FunctiaUtilizator;
	}
	
	public void setFunctiaUtilizator(String FunctiaUtilizator){
		this.FunctiaUtilizator = FunctiaUtilizator;
	}
	
	public String getUtilizator() {
		return Utilizator;
	}
	
	public void setUtilizator(String  Utilizator) {
		this.Utilizator = Utilizator;
	}
	
	public String getParolaUtilizator() {
		return ParolaUtilizator;
	}
	
	public void setParolaUtilizator(String ParolaUtilizator) {
		this.ParolaUtilizator = ParolaUtilizator;
	}
	
	public Integer getidGrup() {
		return idGrup;
	}
	
	public void setidGrup(Integer idGrup) {
		this.idGrup = idGrup;
	}
	
	public Integer getidRol() {
		return idRol;
	}
	
	public void setidRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	
	public Utilizator (Integer IdUtilizator, String FunctiaUtilizator, String Utilizator, String ParolaUtilizator, Integer idGrup, Integer idRol) {
		super();
		this.IdUtilizator = IdUtilizator;
		this.FunctiaUtilizator = FunctiaUtilizator;
		this.Utilizator = Utilizator;
		this.ParolaUtilizator = ParolaUtilizator;
		this.idGrup = idGrup;
		this.idRol = idRol;
	}
	
	public Utilizator() {
		super();
	}
}
