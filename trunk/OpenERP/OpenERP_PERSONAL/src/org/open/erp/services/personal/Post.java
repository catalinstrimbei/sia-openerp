package org.open.erp.services.personal;

import org.open.erp.services.nomgen.Departament;

public class Post {
	String nivelStudii = null;
	int salarMinim = 0;
	Departament denDep = null;
	
	public Post(String studii, int salar,Departament dep){
		nivelStudii = studii;
		salarMinim = salar;
		denDep = dep;
	}
	public Post(){
		
	}
}
