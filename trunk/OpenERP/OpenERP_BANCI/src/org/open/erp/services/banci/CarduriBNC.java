package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Clienti;

public class CarduriBNC {
	private Integer contCard;
	private Date dataprimeiretrageri;
	private Date dataultimeiretrageri;
	private Date dataretrageriicurente;
	private Date dataprimeialimetaricard;
	private Date dataultimeialimentaricard;
	private Date datacurentaalimentarecard;
	private Date dataeliberarii; //cand se preda clientului
	private Date dataexpirarii;
	private Clienti client;
	private List<LiniiRetrageri> linieretragere;
	private List<LiniiAlimentare> liniealimentare;
	private Double valsoldinitial;
	private Double valsoldcurent;
	private Double comision;
	
	public Integer getContCard() {
		return contCard;
	}
	public void setContCard(Integer contCard) {
		this.contCard = contCard;
	}
	public Date getDataprimeiretrageri() {
		return  dataprimeiretrageri;
	}
	public void setDataprimeiretrageri(Date dataprimeiretrageri) {
		this.dataprimeiretrageri = dataprimeiretrageri;
	}
	public Date getDataultimeiretrageri() {
		return  dataultimeiretrageri;
	}
	public void setDataultimeiretrageri(Date dataultimeiretrageri) {
		this.dataultimeiretrageri = dataultimeiretrageri;
	}
	public Date getDataretrageriicurente() {
		return  dataretrageriicurente;
	}
	public void setDataretrageriicurente(Date dataretrageriicurente) {
		this.dataretrageriicurente = dataretrageriicurente;
	}
	public Date getDataprimeialimetaricard() {
		return  dataprimeialimetaricard;
	}
	public void setDataprimeialimetaricard(Date dataprimeialimetaricard) {
		this.dataprimeialimetaricard = dataprimeialimetaricard;
	}
	public Date getDataultimeialimentaricard() {
		return  dataultimeialimentaricard;
	}
	public void setDataultimeialimentaricard(Date dataultimeialimentaricard) {
		this.dataultimeialimentaricard = dataultimeialimentaricard;
	}	
	public Date getDatacurentaalimentarecard() {
		return  datacurentaalimentarecard;
	}
	public void setDatacurentaalimentarecard(Date datacurentaalimentarecard) {
		this.datacurentaalimentarecard = datacurentaalimentarecard;	
	}
	
	public Date getDataeliberarii() {
		return  dataeliberarii;
	}
	public void setdataeliberarii(Date dataeliberarii) {
		this.dataeliberarii = dataeliberarii;	
	}
		
	public Date getDataexpirarii() {
		return   dataexpirarii;
	}
	public void setDataexpirarii(Date  dataexpirarii) {
		this.dataexpirarii =  dataexpirarii;	
	}				
		
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client = client;
	}				
	
	public List<LiniiRetrageri> getlinieretragere() {
		return linieretragere;
	}
	public void setlinieretragere(List<LiniiRetrageri> linieretragere) {
		this.linieretragere = linieretragere;
	}
	public List<LiniiAlimentare> getliniealimentare() {
		return liniealimentare;
	}
	public void setliniealimentare(List<LiniiAlimentare> liniealimentare) {
		this.liniealimentare = liniealimentare;
	}
	
	public Double getValsoldinitial() {
		return valsoldinitial;
	}
	public void setValsoldinitial(Double valsoldinitial) {
		this.valsoldinitial = valsoldinitial;
	}
	
	public Double getValsoldcurent() {
		return valsoldcurent;
	}
	public void setValsoldcurent(Double valsoldcurent) {
		this.valsoldcurent = valsoldcurent;
	}
	
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	
	public CarduriBNC(Integer contCard,Date dataprimeiretrageri,Date dataultimeiretrageri,Date dataretrageriicurente,Date dataprimeialimetaricard,Date dataultimeialimentaricard,Date datacurentaalimentarecard, Date dataeliberarii,Date dataexpirarii,Clienti client,List<LiniiRetrageri> linieretragere,List<LiniiAlimentare> liniealimentare,Double valsoldinitial,Double valsoldcurent,Double comision) {
		super();
		this.contCard = contCard;
		this.dataprimeiretrageri = dataprimeiretrageri;
		this.dataultimeiretrageri = dataultimeiretrageri;
		this.dataretrageriicurente = dataretrageriicurente;
		this.dataprimeialimetaricard = dataprimeialimetaricard;
		this.dataultimeialimentaricard = dataultimeialimentaricard;
		this.datacurentaalimentarecard = datacurentaalimentarecard;	
		this.dataeliberarii = dataeliberarii;
		this.dataexpirarii =  dataexpirarii;	
		this.client = client;
		this.linieretragere = linieretragere;
		this.liniealimentare = liniealimentare;
		this.valsoldinitial = valsoldinitial;
		this.valsoldcurent = valsoldcurent;
		this.comision = comision;
	}
	
	public CarduriBNC() {
		super();
	}
	
}