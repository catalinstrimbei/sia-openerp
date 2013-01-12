package org.open.erp.services.contabgen.conturi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.open.erp.services.contabgen.impl.ContabilitateGeneralaImpl;

@Entity
public class PlanConturi implements Serializable{

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PlanConturi.class.getName());
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany
	private List<Clasa> planConturi = new ArrayList<Clasa>();

	public List<Clasa> getPlanConturi() {
		return planConturi;
	}

	public void addClasa(Clasa clasa) {
		this.planConturi.add(clasa);
	}
	
	public void removeClasa(Clasa clasa) {
		this.planConturi.remove(clasa);
	}
	
	public Clasa getClasaByCod(Integer cod){
		for(Clasa c : this.planConturi)
		{
			if(c.getCodClasa() == cod)
				return c;
		}
		
		return null;
	}

	public PlanConturi() {
		super();
		
		Clasa clasaTest1 = new Clasa("Conturi 1");
		clasaTest1.setCodClasa(1);
		
		Clasa clasaTest2 = new Clasa("Conturi 2");
		clasaTest2.setCodClasa(2);
		
		this.addClasa(clasaTest1);
		this.addClasa(clasaTest2);
		
	}

	public void setPlanConturi(List<Clasa> planConturi) {
		this.planConturi = planConturi;
	}
	
}
