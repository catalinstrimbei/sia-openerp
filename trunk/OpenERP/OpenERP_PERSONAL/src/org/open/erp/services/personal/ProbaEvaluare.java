package org.open.erp.services.personal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProbaEvaluare {
	String numeTest = null;
	@Id
	Integer id;
	public ProbaEvaluare(Integer id, String test){
		this.id=id;
		numeTest = test;
	}
	public String getNumeTest() {
		return numeTest;
	}
	public ProbaEvaluare(){
		
	}
	
}
