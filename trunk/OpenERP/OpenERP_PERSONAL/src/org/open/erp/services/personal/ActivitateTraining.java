package org.open.erp.services.personal;

import java.util.List;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class ActivitateTraining extends Activitate{
	//private ProbaEvaluare				probaEvaluare;
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
