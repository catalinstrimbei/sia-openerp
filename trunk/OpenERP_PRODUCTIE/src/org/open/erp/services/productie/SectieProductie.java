package org.open.erp.services.productie;


import org.open.erp.services.nomgen.Departament;


/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class SectieProductie extends Departament{

	String denSectie;

	public SectieProductie(Integer id, String denumire, String denSectie) {
		super(id, denumire);
		this.denSectie = denSectie;
	}

	public SectieProductie(){
		super();
	}

	public String getDenSectie() {
		return denSectie;
	}

	public void setDenSectie(String denSectie) {
		this.denSectie = denSectie;
	}
	
	
}
