package org.open.erp.services.contabgest;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Temporal;



public interface ContabGestSrv {
	
	public DummyPersoana defDummyPersoana(	String  nume,
											String  prenume,
											String  formaAdresare
											) throws Exception;
	public ProdusFinit defProdusFinit(String den, Double procProfit) throws Exception;
	
	public DummyPersoana getPersoanaId(Integer idPersoana) throws Exception;
	
	
	
	
	
	
	public ProceseTehnicoEconomice defProceseTehnicoEconomice(String	denumireProces,
			String detaliiProces) throws Exception;
	
	public CentruCost defCentruCost(String denCentruCost, Date startCentruCost, Date sfarsitCentruCost, 
			ResponabilCentruCost responabilCentruCost, DummyFazaProductie dummyFazaProductie,
			ProceseTehnicoEconomice proceseTehnicoEconomice, ProdusFinit produsfinit) throws Exception;
	
	public 	CheltuieliFixe defCheltuieliFixe(String tipCheltuiala,
			String denCheltuiala, String delatiiCheltuiala, CentruCost centruCost) throws Exception;
	
	
	public CheltuieliVariabile defCheltuieliVariabile(String tipCheltuiala,
			String denCheltuiala, String delatiiCheltuiala,
			Integer CantitateCheltuiala, CentruCost centruCost) throws Exception;
	
	
	//public ResponabilCentruCost getIdResponsabilCentruCostdupaId(int idResponsabilCentruCost);
	
	
	public ResponabilCentruCost defResponabilCentruCost(String  nume, String  prenume, String  formaAdresare,
			Integer idResponsabilCentruCost, Date dataStartResponsabilitate,
			Date dataSfarsitResponsabilitate, String detaliiResponsabilitati) throws Exception;
	
	public ProdusFinit getProdusFinitById(Integer idProdusFinit_) throws Exception;
	
	public DummyFazaProductie getDummyFazaProductieById(Integer idFazaProductie_) throws Exception;
	
	public ResponabilCentruCost getResponabilCentruCostById(Integer idResponsabilCentruCost_) throws Exception;
	
	public ProceseTehnicoEconomice getProceseTehnicoEconomiceById(Integer idProceseTehnicoEconomice_) throws Exception;
	
	public CentruCost getCentruCostById(Integer idCentruCost_) throws Exception;
	
	public DummyFazaProductie defDummyFazaProductie(
			String denumireFazaProductie, Date incepereFazaProductie,
			Date sfarsitFazaProductie, Double costFazaProductie)throws Exception;
	
	
}
