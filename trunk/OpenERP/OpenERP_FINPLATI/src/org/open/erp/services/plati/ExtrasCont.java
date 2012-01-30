package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.open.erp.services.plati.Plata;

@Entity
public class ExtrasCont extends Plata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3011097509577930647L;
	/**
	 * 
	 */
	private Integer idExtrasCont;
	public ExtrasCont(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
	}

	public ExtrasCont() {
		super();
	}

	public Integer getIdExtrasCont() {
		return idExtrasCont;
	}

	public void setIdExtrasCont(Integer idExtrasCont) {
		this.idExtrasCont = idExtrasCont;
	}
}