package org.open.erp.services.achizitii;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Persoana;

public class PlanAprovizionare {
	private static PlanAprovizionare planAprovizionare;
	public static final Integer FINALIZAT = 1;
	public static final Integer IN_CURS = 0;
	private Integer saptAn;	
	private Integer an;
	public Integer getSaptAn() {
		return saptAn;
	}
	public void setSaptAn(Integer saptAn) {
		this.saptAn = saptAn;
	}
	private Integer idPlan;
	private Date dataStart;
	private Date dataFinal;
	private Persoana persoana;
	private Integer statusPlan;
	private List<LiniePlanAprovizionare> liniiPlan = new LinkedList<LiniePlanAprovizionare>();
	
	private PlanAprovizionare(Integer saptAn, Integer an,Date dataStart,Date dataFinal) {
		super();
		this.saptAn = saptAn;		
		this.an = an;
	}
	//Va exista cate un singur plan de aprovizionare de-a lungul unei saptamani din an.
	public static  PlanAprovizionare getPlanAprovizionare() {
        if ((planAprovizionare==null)||(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) != planAprovizionare.getSaptAn())||           
           (Calendar.getInstance().get(Calendar.YEAR) != planAprovizionare.getAn()))
          {        	
        	Calendar c = Calendar.getInstance();
     	    Date date = new Date();
     	    c.setTime(date);
     	    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			planAprovizionare = new PlanAprovizionare(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)					
					,Calendar.getInstance().get(Calendar.YEAR)
					,Calendar.getInstance().getTime()
					,c.getTime());
        }
        return planAprovizionare;
}
    public void addLiniePlan(LiniePlanAprovizionare li) {
        this.getLiniiPlan().add(li);
        li.setPlanAprovizionare(this);
    }

    public void removeLiniePlan(LiniePlanAprovizionare li) {
        this.getLiniiPlan().remove(li);
        li.setPlanAprovizionare(null);
    }
    public LiniePlanAprovizionare existaArticolInLiniiPlan(Material articol){    	
    	for (LiniePlanAprovizionare liniePlan : getLiniiPlan()) {
            if (articol.equals(liniePlan.getArticol())){            	 
            	return liniePlan;
            }
        }
    	return null; 	
    }	
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}	
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
