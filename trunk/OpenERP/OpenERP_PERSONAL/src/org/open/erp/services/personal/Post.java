package org.open.erp.services.personal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import org.open.erp.services.nomgen.Departament;


@Entity
public class Post {
	String nivelStudii = null;
	int salarMinim = 0;
	
	Departament denDep = null;
	@Id
	Integer id;
	public Post(Integer id,String studii, int salar,Departament dep){
		this.id=id;
		nivelStudii = studii;
		salarMinim = salar;
		denDep = dep;
	}
	
	void setNivelStudii(String nivelStudii){
		this.nivelStudii = nivelStudii;
	}
	
	void setSalarMinim(int salarMinim){
		this.salarMinim = salarMinim;
	}
	
	void setDenDep(Departament denDep){
		this.denDep = denDep;
	}
	public Post(){
		
	}
}
