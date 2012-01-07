package org.open.erp.services.marketing;
/*
 * test
 * test MR
 */
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Echipa.Marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Campanie {
	public static final Integer NE_PORNITA = -1; 
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINATA = 2; 
	
	private Integer idCampanie;
	private String denumireCampanie;
	private Date dataStart;
	private Date dataSfarsit;
	private Integer status = NE_PORNITA;
	Responsabil responsabil;
	private List<PersoanaTinta> PersoaneTinta;

	
	public Campanie() {
		super();
	}
	public Campanie(Integer idCampanie, String denumireCampanie, Date dataStart, Date dataSfarsit,
		 Responsabil responsabil)
		{
			super();
			this.idCampanie = idCampanie;
			this.denumireCampanie = denumireCampanie;
			this.dataStart = dataStart;
			this.dataSfarsit = dataSfarsit;
			this.responsabil = responsabil;
		}
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public String getDenumireCampanie() {
		return denumireCampanie;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getIdCampanie() {
		return idCampanie;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public static Integer getTerminat() {
		return TERMINATA;
	}
	public static Integer getNePornita() {
		return NE_PORNITA;
	}
	public static Integer getInCurs() {
		return IN_CURS;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public void setIdCampanie(Integer idCampanie) {
		this.idCampanie = idCampanie;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	public void setDenumireCampanie(String denumireCampanie) {
		this.denumireCampanie = denumireCampanie;
	}
	/**
	 * @return the persoaneTinta
	 */
	public List<PersoanaTinta> getPersoaneTinta() {
		return PersoaneTinta;
	}
	/**
	 * @param persoaneTinta the persoaneTinta to set
	 */
	public void setPersoaneTinta(List<PersoanaTinta> persoaneTinta) {
		PersoaneTinta = persoaneTinta;
	}
	/**
	 * @param Persoana tinta care se doreste a fi adaugata
	 */
	public void adaugaPersoaneTinta(PersoanaTinta persoanaTinta){
		this.PersoaneTinta.add(persoanaTinta);
	}
	public void stergePersoaneTinta(PersoanaTinta persoanaTinta){
		this.PersoaneTinta.remove(persoanaTinta);
	}
	}
