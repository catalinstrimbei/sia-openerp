package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class ActivitateTraining extends Activitate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private ProbaEvaluare				probaEvaluare;
	@ManyToMany 
	@JoinTable(
			name = "InstructorTraining",
			joinColumns = @JoinColumn(name = "idActivitate"),
			inverseJoinColumns = @JoinColumn(name = "id"))
	private Collection<Instructor>	instructori;

	public Collection<Instructor> getInstructori() {
		return instructori;
	}

	public void setInstructori(Collection<Instructor> instructori) {
		this.instructori = instructori;
	}

	public ActivitateTraining(Collection<Instructor> instructori) {
		super();
		this.instructori = instructori;
	}

	public ActivitateTraining() {
		super();
		
	}
	
}
