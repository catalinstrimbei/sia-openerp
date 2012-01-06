package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	@OneToMany
	private List<InstructorTraining>	instructori;

	public List<InstructorTraining> getInstructori() {
		return instructori;
	}

	public void setInstructori(List<InstructorTraining> instructori) {
		this.instructori = instructori;
	}

	public ActivitateTraining(List<InstructorTraining> instructori) {
		super();
		this.instructori = instructori;
	}

	public ActivitateTraining() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
