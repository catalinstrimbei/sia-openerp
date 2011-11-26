package org.open.erp.services.achizitii;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.Persoana;

public class PlanAprovizionare {
	private static PlanAprovizionare planAprovizionare;
	
	public static final Integer APROBATA = 1;
	public static final Integer RESPINSA = -1;
	public static final Integer IN_CURS = 0;
	public Integer saptLuna;
	public Integer luna ;
	public Integer an;
	public Integer idPlan;
	public Date dataStart;
	public Date dataFinal;
	public Persoana persoana;
	public Integer statusPlan;
	
	private PlanAprovizionare(Integer saptLuna, Integer luna, Integer an) {
		super();
		this.saptLuna = saptLuna;
		this.luna = luna;
		this.an = an;
	}
	public static synchronized PlanAprovizionare getPlanAprovizionare() {
        if ((planAprovizionare==null)||(Calendar.getInstance().get(Calendar.WEEK_OF_MONTH) != planAprovizionare.getSaptLuna())||
           (Calendar.getInstance().get(Calendar.MONTH) != planAprovizionare.getLuna())||
           (Calendar.getInstance().get(Calendar.YEAR) != planAprovizionare.getAn()))
          {        	
			planAprovizionare = new PlanAprovizionare(Calendar.getInstance().get(Calendar.WEEK_OF_MONTH)
					,Calendar.getInstance().get(Calendar.MONTH)
					,Calendar.getInstance().get(Calendar.YEAR));
        }
        return planAprovizionare;
}
	
	public Integer getSaptLuna() {
		return saptLuna;
	}
	public void setSaptLuna(Integer saptLuna) {
		this.saptLuna = saptLuna;
	}
	public Integer getLuna() {
		return luna;
	}
	public void setLuna(Integer luna) {
		this.luna = luna;
	}
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}

	public List<LiniePlanAprovizionare> liniiPlan = new LinkedList<LiniePlanAprovizionare>();
	
	public Integer getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Persoana getPersoana() {
		return persoana;
	}
	public void setPersoana(Persoana persoana) {
		this.persoana = persoana;
	}
	public Integer getStatusPlan() {
		return statusPlan;
	}
	public void setStatusPlan(Integer statusPlan) {
		this.statusPlan = statusPlan;
	}
	public List<LiniePlanAprovizionare> getLiniiPlan() {
		return liniiPlan;
	}
	public void setLiniiPlan(List<LiniePlanAprovizionare> liniiPlan) {
		this.liniiPlan = liniiPlan;
	}
	

}
