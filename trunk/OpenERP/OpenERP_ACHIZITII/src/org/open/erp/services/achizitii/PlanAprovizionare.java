package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Persoana;
import static javax.persistence.CascadeType.ALL;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class PlanAprovizionare implements Serializable  {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9111074543290370000L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlanAprovizionare_gen;
    private long idPlanAprovizionare;
	
	/*public static void setPlanAprovizionare(PlanAprovizionare planAprovizionare) {
		PlanAprovizionare.planAprovizionare = planAprovizionare;
	}*/
	/*private static PlanAprovizionare planAprovizionare;*/
	public static final Integer FINALIZAT = 1;
	public static final Integer IN_CURS = 0;
	private Integer saptAn;	
	private Integer an;
	@Temporal(TemporalType.DATE)
	private Date dataStart;
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	@OneToOne@JoinColumn(name="idPersoana")
	private Persoana persoana;
	private Integer statusPlan;
	@OneToMany(mappedBy="planAprovizionare", cascade = ALL)
	private List<LiniePlanAprovizionare> liniiPlan = new LinkedList<LiniePlanAprovizionare>();
	
	public Integer getSaptAn() {
		return saptAn;
	}
	public void setSaptAn(Integer saptAn) {
		this.saptAn = saptAn;
	}
	
	public PlanAprovizionare() {
		super();
	}
	public PlanAprovizionare(Integer saptAn, Integer an,Date dataStart,Date dataFinal) {
		super();
		this.saptAn = saptAn;		
		this.an = an;
		this.dataStart=dataStart;
		this.dataFinal=dataFinal;
	}
	//Va exista cate un singur plan de aprovizionare de-a lungul unei saptamani din an.
	/*public static  PlanAprovizionare getPlanAprovizionare() {
        if ((planAprovizionare==null)||(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) != planAprovizionare.getSaptAn())||           
           (Calendar.getInstance().get(Calendar.YEAR) != planAprovizionare.getAn()))
          { 
        	if (planAprovizionare!=null){
        		planAprovizionare.setStatusPlan(FINALIZAT);
        	}
        	Calendar c = Calendar.getInstance();
     	    Date date = new Date();
     	    c.setTime(date);
     	    c.setFirstDayOfWeek(Calendar.MONDAY);
     	    c.set(Calendar.DAY_OF_WEEK,  Calendar.SUNDAY);
			planAprovizionare = new PlanAprovizionare(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)					
					,Calendar.getInstance().get(Calendar.YEAR)
					,Calendar.getInstance().getTime()
					,c.getTime());			
			planAprovizionare.setStatusPlan(IN_CURS);
        }
        return planAprovizionare;
}*/
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
	public long getIdPlanAprovizionare() {
		return idPlanAprovizionare;
	}
	public void setIdPlanAprovizionare(long idPlanAprovizionare) {
		this.idPlanAprovizionare = idPlanAprovizionare;
	}
	public PlanAprovizionare(long idPlanAprovizionare, Integer saptAn,
			Integer an, Date dataStart, Date dataFinal, Integer statusPlan) {
		super();
		this.idPlanAprovizionare = idPlanAprovizionare;
		this.saptAn = saptAn;
		this.an = an;
		this.dataStart = dataStart;
		this.dataFinal = dataFinal;
		this.statusPlan = statusPlan;
	}
	

}
