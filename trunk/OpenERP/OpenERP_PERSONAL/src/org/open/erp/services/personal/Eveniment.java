package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Eveniment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEveniment;
	private String tipEveniment;
	private Double sumaAlocata;
	private String statusEveniment;
	@OneToMany(mappedBy = "eveniment" , cascade = CascadeType.ALL)	
	private Collection<Activitate> activitati;//NMV >> adaugat Lista de activiati la eneniment
	
	
	private static Collection<Eveniment> evenimente = new ArrayList<Eveniment>();//NMV >> Lista cu evenimente pentru a simula persistenta
	
	
	
	public String getStatusEveniment() {
		return statusEveniment;
	}
	public void setStatusEveniment(String statusEveniment) {
		this.statusEveniment = statusEveniment;
	}
	public Collection<Activitate> getActivitati() {
		return activitati;
	}
	public void setActivitati(Collection<Activitate> activitati) {
		this.activitati = activitati;
	}
	public Integer getIdEveniment() {
		return idEveniment; 
	}
	public void setIdEveniment(Integer idEveniment) {
		this.idEveniment = idEveniment;
	}
	public String getTipEveniment() {
		return tipEveniment;
	}
	public void setTipEveniment(String tipEveniment) {
		this.tipEveniment = tipEveniment;
	}
	public Double getSumaAlocata() {
		return sumaAlocata;
	}
	public void setSumaAlocata(Double sumaAlocata) {
		this.sumaAlocata = sumaAlocata;
	}
	/**
	 * @param idEveniment
	 * @param tipEveniment
	 * @param sumaAlocata
	 */
	public Eveniment(Integer idEveniment, String tipEveniment, Double sumaAlocata) {
		super();
		this.idEveniment = idEveniment;
		this.tipEveniment = tipEveniment;
		this.sumaAlocata = sumaAlocata;		
		this.statusEveniment = "Neaprobat";//NMV>>Valoare default evenimentul este neaprobat
		evenimente.add(this);
	}
	/**
	 * 
	 */
	public Eveniment() {
		super();
		evenimente.add(this);
		// TODO Auto-generated constructor stub
	}
	
	public boolean AddActivitate(Activitate _activitate) throws Exception //throws Exception//NMV >>adaugare activitate in Lista activitati
	{
		boolean ret = false;
		if(this.activitati == null)
		{
			this.activitati = new ArrayList<Activitate>(); 
		}
		
		if(_activitate !=null & (_activitate.getEveniment().equals(this) || _activitate.getEveniment()==null))
		{
			if(this.getTipEveniment()=="TeamBuilding")
			{
				//System.out.println("Object's Class name =>"+  _activitate.getClass().getName());
				if( _activitate.getClass().getName().indexOf("ActivitateTeamBuilding")>0)
				{
					this.activitati.add(_activitate);
					ret = true;			
				}
				else
				{					
					//ret = false;
					throw new Exception("Pentru eveniment teambuilding se poate adauga doar actvitate teambuilding");
				}
			}
			if(this.getTipEveniment()=="Training")
			{
				if(_activitate.getClass().getName().indexOf("ActivitateTraining")>0)
				{
					this.activitati.add(_activitate);
					ret = true;			
				}
				else
				{					
					//ret = false;
					throw new Exception("Pentru eveniment Training se poate adauga doar actvitate training");
				}
			}
			
		}
		return ret;	
	}
	
	public static Collection<Eveniment> getEvenimente()
	{			
		return evenimente;
	}		
}
