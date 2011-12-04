package org.open.erp.services.ctbgen.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.Balanta;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.FisaCont;
import org.open.erp.services.ctbgen.InregistrareRJ;
import org.open.erp.services.ctbgen.LinieMaterialValoare;
import org.open.erp.services.ctbgen.LunaLucru;
import org.open.erp.services.ctbgen.RegBalanta;
import org.open.erp.services.ctbgen.RegInregistrareRJ;
import org.open.erp.services.ctbgen.RegTipMaterial;
import org.open.erp.services.ctbgen.RegTipuriContabile;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipContabil;
import org.open.erp.services.ctbgen.TipIncasare;
import org.open.erp.services.ctbgen.TipPlata;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.LunaLucru.StatusLuna;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.ctbgen.RegLuniLucru;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.nomgen.LinieDocument;
/**
 * 
 *@author Echipa9 Irimia, Iftimii, Sarbu, Ricea, Chiriac
 * 
 *@ApplicationServiceImplementation(ServiceAPI)
 * 
 */

public class ContabilizareSrvImpl implements ContabilizareSrv {
		
	//--------------------
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContabilizareSrvImpl.class.getName());
	
	@Override
	public Integer jurnalizareVanzare(Date data, Double valFact,Double tvaFact, Integer nrDoc,
			Integer idPartener, List<LinieDocument> listaLinMat,  StareDocument stareDocument,	Integer idInreg) throws CtbException {
		
		//construire linieMatVal
		List<LinieMaterialValoare> listaContMat= new ArrayList<LinieMaterialValoare>();
		RegTipuriContabile regTip =RegTipuriContabile.instantiaza();
		for (LinieDocument ld: listaLinMat){
			listaContMat.add(new LinieMaterialValoare(regTip.getTipDupaDen(ld.material.getTipContabil()),ld.cantitate*ld.pret));
		}

		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare vanzare noua");
				
			 Integer nrSabVanzare=4;
			 Integer nrSabConsum=5;
			int nrlin=1;
			
			InregistrareRJ inregVanzare = new InregistrareRJ(data, nrDoc,regLuniLucru.getOrCreateLunaLucru(data),idPartener);
			List<ArticolCtb> listaArtRJ= new ArrayList <ArticolCtb>();
			ArticolCtb articolVanzare = new ArticolCtb();
			
			logger.debug("Avem obiecte");
			
			//adaugam articolul de vanzare sablon(4);
			articolVanzare.setContCredit(regSabloanNC.getSablonDupaNr(nrSabVanzare).getContCredit());
			articolVanzare.setContDebit(regSabloanNC.getSablonDupaNr(nrSabVanzare).getContDebit());
			articolVanzare.setNrLinArt(nrlin);
			articolVanzare.setSumaDC(valFact);
			articolVanzare.setDenArt("inregistrare vanzare doc "+ nrDoc+"/"+data);
			listaArtRJ.add(articolVanzare);
			
			logger.debug("Avem articol vanzare clienti");
			//pt fiecare material scot articolul potrivit pentru scaderea din gestiune
		
			int idCont;
			for (LinieMaterialValoare l: listaContMat){
						
				//verific daca  mat e din clasa 2 sau 3 pentru scadere de gestiune si cautam
				//sablonul care are nr aferent consumului (5) si contul materialului pe credit 
				idCont = l.tipMaterial.getContProprietar().getIdCont();
				if (regConturi.getContDupaId(idCont).getClasaCont().equals("2")||
						regConturi.getContDupaId(idCont).getClasaCont().equals("3"))
					nrlin =nrlin +1;
				
					articolVanzare.setContDebit(regSabloanNC.getSablonConsum(nrSabConsum, regConturi.getContDupaId(idCont)).getContDebit());
					articolVanzare.setContCredit(regConturi.getContDupaId(idCont));
					articolVanzare.setNrLinArt(nrlin);
					articolVanzare.setSumaDC(l.valoare);
					articolVanzare.setDenArt("Scadere gestiune material "+l.tipMaterial.getDenumireTip());
				//adaugam articolul in lista
					listaArtRJ.add(articolVanzare);
					logger.info("Articol rezolvat: "+articolVanzare.getContDebit().getSimbolCont()+" | "+articolVanzare.getContCredit().getSimbolCont());		
				}
			
			inregVanzare.setArticoleRJ(listaArtRJ);
			inregVanzare.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem lista de articole");
			
			logger.debug("Avem o inregistrare jurnal de vanzare NOUA");
			//System.out.println("inregVanzare id:"+inregVanzare.getIdInregRJ());
			
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregVanzare);
			return inregVanzare.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO: cod
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
   //------------------------------------------------------------------------------
	@Override
	public Integer jurnalizareAchizitie(Date data, Double valFact, Double tvaFact, Integer nrDoc,
			Integer idPartener, List<LinieDocument> listaLinMat, StareDocument stareDocument,
			Integer idInreg) throws CtbException {
		//construire linieMatVal
				List<LinieMaterialValoare> listaContMat= new ArrayList<LinieMaterialValoare>();
				RegTipuriContabile regTip =RegTipuriContabile.instantiaza();
				for (LinieDocument ld: listaLinMat){
					listaContMat.add(new LinieMaterialValoare(regTip.getTipDupaDen(ld.material.getTipContabil()),ld.cantitate*ld.pret));
				}
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare achizitie noua");
			
			
			Integer nrSabAchizitie=6;
			int nrlin=1;
			
			InregistrareRJ inregAchizitie = new InregistrareRJ(data, nrDoc,regLuniLucru.getOrCreateLunaLucru(data),idPartener);
			List<ArticolCtb> listaArtRJ= new ArrayList <ArticolCtb>();
			ArticolCtb articolAchizitie = new ArticolCtb();
			
			logger.debug("Avem obiecte");
			
			//pt fiecare material scot articolul potrivit pentru scaderea din gestiune
		
			int idCont;
			for (LinieMaterialValoare l: listaContMat){
						
				//verific daca  mat e din clasa 2 sau 3  sau 6 intrarea in  gestiune si cautam
				//sablonul care are nr aferent achizitizi (6) si contul materialului pe debit 
				idCont = l.tipMaterial.getContProprietar().getIdCont();
				if (regConturi.getContDupaId(idCont).getClasaCont().equals("2")||
						regConturi.getContDupaId(idCont).getClasaCont().equals("3") ||
						regConturi.getContDupaId(idCont).getClasaCont().equals("6"))
					nrlin =nrlin +1;
				
					//System.err.println(regSabloanNC.getSablonConsum(nrSabAchizitie, regConturi.getContDupaId(idCont)).getContCredit().getSimbolCont());
					articolAchizitie.setContCredit(regSabloanNC.getSablonAchizitie(nrSabAchizitie, regConturi.getContDupaId(idCont)).getContCredit());
					articolAchizitie.setContDebit(regConturi.getContDupaId(idCont));
					articolAchizitie.setNrLinArt(nrlin);
					articolAchizitie.setSumaDC(l.valoare);
					articolAchizitie.setDenArt("achizitie material "+l.tipMaterial.getDenumireTip());
				//adaugam articolul in lista
					listaArtRJ.add(articolAchizitie);
					logger.info("Articol rezolvat: "+articolAchizitie.getContDebit().getSimbolCont()+" | "+articolAchizitie.getContCredit().getSimbolCont());		
	
				}
			
			inregAchizitie.setArticoleRJ(listaArtRJ);
			inregAchizitie.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem lista de articole");
			
					
			logger.debug("Avem o inregistrare jurnal de achizitie NOUA completa");
			//ar trebui urmate de cazurile de modificare sau update
			
			//System.out.println("inregAchizitie id:"+inregAchizitie.getIdInregRJ());
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregAchizitie);
			return inregAchizitie.getIdInregRJ();
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
  //---------------------------------------------------------------------------------
	@Override
	public Integer jurnalizareIncasare(Date data, Double valInc, Integer nrDoc,
			TipIncasare tipIncasare, Integer idPartener, Integer idCont,
			StareDocument stareDocument, Integer idInreg) throws CtbException{
		// TODO Auto-generated method stub
		
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare incasare noua");

			//TODO: doua variabile sabloane si if dupa tip tipinc
			Integer nrSabIncasare;
			if(tipIncasare==TipIncasare.CASA){
				nrSabIncasare=7;
			}else {
				nrSabIncasare=8;
			}
			
			int nrlin = 1;

			InregistrareRJ inregIncasare = new InregistrareRJ(data, nrDoc,
					regLuniLucru.getOrCreateLunaLucru(data), idPartener);
			List<ArticolCtb> listaArtRJ = new ArrayList<ArticolCtb>();
			ArticolCtb articolIncasare = new ArticolCtb();

			logger.debug("Avem obiecte");

			articolIncasare.setContDebit(regSabloanNC.getSablonIncasare(nrSabIncasare).getContDebit());
			articolIncasare.setContCredit(regConturi.getContDupaId(idCont));
			articolIncasare.setNrLinArt(nrlin);
			articolIncasare.setSumaDC(valInc);
			articolIncasare.setDenArt("Incasare document nr " + nrDoc);
			// adaugam articolul in lista
			listaArtRJ.add(articolIncasare);
			logger.info("Articol rezolvat: "
					+ articolIncasare.getContDebit().getSimbolCont() + " | "
					+ articolIncasare.getContCredit().getSimbolCont());
			
			inregIncasare.setArticoleRJ(listaArtRJ);
			inregIncasare.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem articol incasare ");
			
		
			logger.debug("Avem o inregistrare jurnal de incasare NOUA completa");
			//ar trebui urmate de cazurile de modificare sau update
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregIncasare);
			return inregIncasare.getIdInregRJ();
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
//------------------------------------------------------------------
	@Override
	public Integer jurnalizarePlata(Date data, Double valInc, Integer nrDoc,
			TipPlata tipPlata, Integer idPartener, Integer idCont,
			StareDocument stareDocument, Integer idInreg) throws CtbException{

		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare plata noua");

			//TODO: doua variabile sabloane si if dupa tip tipinc
			Integer nrSabPlata;
			if(tipPlata==TipPlata.CASA){
				nrSabPlata=9;
			}else {
				nrSabPlata=10;
			}
			
			int nrlin = 1;

			InregistrareRJ inregPlata = new InregistrareRJ(data, nrDoc,
			regLuniLucru.getOrCreateLunaLucru(data), idPartener);
			List<ArticolCtb> listaArtRJ = new ArrayList<ArticolCtb>();
			ArticolCtb articolIncasare = new ArticolCtb();

			logger.debug("Avem obiecte");

			articolIncasare.setContCredit(regSabloanNC.getSablonIncasare(nrSabPlata).getContCredit());
			articolIncasare.setContDebit(regConturi.getContDupaId(idCont));
			articolIncasare.setNrLinArt(nrlin);
			articolIncasare.setSumaDC(valInc);
			articolIncasare.setDenArt("Plata document nr " + nrDoc);
			// adaugam articolul in lista
			listaArtRJ.add(articolIncasare);
			logger.info("Articol rezolvat: "
					+ articolIncasare.getContDebit().getSimbolCont() + " | "
					+ articolIncasare.getContCredit().getSimbolCont());
			
			inregPlata.setArticoleRJ(listaArtRJ);
			inregPlata.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem articol plata ");
			
		
			logger.debug("Avem o inregistrare jurnal de plata NOUA completa");
			//ar trebui urmate de cazurile de modificare sau update
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregPlata);
			return inregPlata.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
  //--------------------------------------------------------------------
	@Override
	public Integer jurnalizareSalarii(Date data,Integer nrDoc, Double valBrut, Double sanatAng,
			Double somajAng, Double casAng, Double impAng, Double sanatFirma,
			Double somajFirma, Double casFirma, Double medicFirma,
			Double riscFirma, StareDocument stareDocument, Integer idInreg)throws CtbException {
		// TODO Auto-generated method stub
		
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		//RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare salarii noua");

			//TODO: doua variabile sabloane si if dupa tip tipinc
			List<Double> valImp=new ArrayList<Double>();
			valImp.add(valBrut);
			valImp.add(sanatAng);
			valImp.add(somajAng);
			valImp.add(casAng);
			valImp.add(impAng);
			valImp.add(sanatFirma);
			valImp.add(somajFirma);
			valImp.add(casAng);
			valImp.add(medicFirma);
			valImp.add(riscFirma);
			
						
			Integer nrSabSalarii=11;
					
			int nrlin = 1;

			InregistrareRJ inregPlata = new InregistrareRJ(data, nrDoc,	regLuniLucru.getOrCreateLunaLucru(data), null);
			List<ArticolCtb> listaArtRJ = new ArrayList<ArticolCtb>();
			ArticolCtb articolIncasare = new ArticolCtb();

			logger.debug("Avem obiecte");
			
			for ( int i=0;i<10; i++ ){
				articolIncasare.setContDebit(regSabloanNC.getSablonIncasare(nrSabSalarii).getContDebit());
				articolIncasare.setContCredit(regSabloanNC.getSablonIncasare(nrSabSalarii).getContCredit());
				articolIncasare.setNrLinArt(nrlin);
				articolIncasare.setSumaDC(valImp.get(i).doubleValue());
				articolIncasare.setDenArt("note salarii "+ nrDoc);
				nrlin=nrlin+1;
				nrSabSalarii=nrSabSalarii+1;
				// adaugam articolul in lista
				//System.out.println(articolIncasare.toString());
				listaArtRJ.add(articolIncasare);
				logger.info("Articol rezolvat: "+ articolIncasare.getContDebit().getSimbolCont() + " | "
					+ articolIncasare.getContCredit().getSimbolCont()+" | "+articolIncasare.getSumaDC());
			}
			
			
			inregPlata.setArticoleRJ(listaArtRJ);
			
			inregPlata.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem articole salarii ");
			
			//System.out.println(inregPlata.toString());
			
		
			logger.debug("Avem o inregistrare jurnal de salarii NOUA completa");
			
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregPlata);
			return inregPlata.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
  //-----------------------------------------------------
	@Override
	public Integer jurnalizareConsum(Date data, Integer nrDoc,
			List<LinieDocument> listaLinMat, StareDocument stareDocument,Integer idInreg) throws CtbException{
		//construire linieMatVal
				List<LinieMaterialValoare> listaContMat= new ArrayList<LinieMaterialValoare>();
				RegTipuriContabile regTip =RegTipuriContabile.instantiaza();
				for (LinieDocument ld: listaLinMat){
					listaContMat.add(new LinieMaterialValoare(regTip.getTipDupaDen(ld.material.getTipContabil()),ld.cantitate*ld.pret));
				}
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare consum noua");
				
			
			Integer nrSabConsum=5;
			int nrlin=1;
			
			InregistrareRJ inregConsum = new InregistrareRJ(data, nrDoc,regLuniLucru.getOrCreateLunaLucru(data),null);
			List<ArticolCtb> listaArtRJ= new ArrayList <ArticolCtb>();
			ArticolCtb articolVanzare = new ArticolCtb();
			
			logger.debug("Avem obiecte");
			
			//pt fiecare material scot articolul potrivit pentru scaderea din gestiune
		
			int idCont;
			for (LinieMaterialValoare l: listaContMat){
						
				//verific daca  mat e din clasa 2 sau 3 pentru scadere de gestiune si cautam
				//sablonul care are nr aferent consumului (5) si contul materialului pe credit 
				idCont = l.tipMaterial.getContProprietar().getIdCont();
				if (regConturi.getContDupaId(idCont).getClasaCont().equals("2")||
						regConturi.getContDupaId(idCont).getClasaCont().equals("3"))
					nrlin =nrlin +1;
				
					articolVanzare.setContDebit(regSabloanNC.getSablonConsum(nrSabConsum, regConturi.getContDupaId(idCont)).getContDebit());
					articolVanzare.setContCredit(regConturi.getContDupaId(idCont));
					articolVanzare.setNrLinArt(nrlin);
					articolVanzare.setSumaDC(l.valoare);
					articolVanzare.setDenArt("Consum material "+l.tipMaterial.getDenumireTip());
				//adaugam articolul in lista
					listaArtRJ.add(articolVanzare);
					logger.info("Articol rezolvat: "+articolVanzare.getContDebit().getSimbolCont()+" | "+articolVanzare.getContCredit().getSimbolCont());		
				}
			
			inregConsum.setArticoleRJ(listaArtRJ);
			inregConsum.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem lista de articole");
			
			logger.debug("Avem o inregistrare jurnal de consum NOUA");
			//System.out.println("inregConsum id:"+inregConsum.getIdInregRJ());
			
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregConsum);
			return inregConsum.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
//-------------------------------------------------------
	@Override
	public Integer jurnalizareProductie(Date data, Integer nrDoc,
			List<LinieDocument> listaLinMat, StareDocument stareDocument,Integer idInreg) throws CtbException{
		// TODO Auto-generated method stub
		//construire linieMatVal
				List<LinieMaterialValoare> listaContMat= new ArrayList<LinieMaterialValoare>();
				RegTipuriContabile regTip =RegTipuriContabile.instantiaza();
				for (LinieDocument ld: listaLinMat){
					listaContMat.add(new LinieMaterialValoare(regTip.getTipDupaDen(ld.material.getTipContabil()),ld.cantitate*ld.pret));
				}
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare Productie noua");
				
			 
			Integer nrSabProductie=3;
			int nrlin=1;
			
			InregistrareRJ inregProductie = new InregistrareRJ(data, nrDoc,regLuniLucru.getOrCreateLunaLucru(data),null);
			List<ArticolCtb> listaArtRJ= new ArrayList <ArticolCtb>();
			ArticolCtb articolAchizitie = new ArticolCtb();
			
			logger.debug("Avem obiecte");
			
						
			//pt fiecare material scot articolul potrivit pentru productie din gestiune
		
			int idCont;
			for (LinieMaterialValoare l: listaContMat){
						
				//verific daca  mat e din clasa 2 sau 3  sau 6 intrarea in  gestiune si cautam
				//sablonul care are nr aferent achizitizi (6) si contul materialului pe debit 
				idCont = l.tipMaterial.getContProprietar().getIdCont();
				if (regConturi.getContDupaId(idCont).getClasaCont().equals("2")||
						regConturi.getContDupaId(idCont).getClasaCont().equals("3"))
					nrlin =nrlin +1;
				
					//System.err.println(regSabloanNC.getSablonConsum(nrSabAchizitie, regConturi.getContDupaId(idCont)).getContCredit().getSimbolCont());
					articolAchizitie.setContCredit(regSabloanNC.getSablonAchizitie(nrSabProductie, regConturi.getContDupaId(idCont)).getContCredit());
					articolAchizitie.setContDebit(regConturi.getContDupaId(idCont));
					articolAchizitie.setNrLinArt(nrlin);
					articolAchizitie.setSumaDC(l.valoare);
					articolAchizitie.setDenArt("productie material "+l.tipMaterial.getDenumireTip());
				//adaugam articolul in lista
					listaArtRJ.add(articolAchizitie);
					logger.info("Articol rezolvat: "+articolAchizitie.getContDebit().getSimbolCont()+" | "+articolAchizitie.getContCredit().getSimbolCont());		
	}
			
			inregProductie.setArticoleRJ(listaArtRJ);
			inregProductie.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem lista de articole");
			
			logger.debug("Avem o inregistrare jurnal de Productie NOUA");
			//System.out.println("inregProductie id:"+inregProductie.getIdInregRJ());
			
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregProductie);
			return inregProductie.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			return -1;
		} else {
			//TODO:
			return -1;
		}	
	}
//------------------------------------------------------------
	@Override
	public void jurnalizareNcDiversa( Date data, Integer nrInreg, Cont contd, Cont contc, Double suma, StareDocument stareDocument) throws CtbException{
		
		RegLuniLucru regLuniLucru =RegLuniLucru.instantiaza();
		//RegSablonNC regSabloanNC = RegSablonNC.instantiaza();
		//RegConturi regConturi = RegConturi.instantiaza();
		
		LunaLucru lunaLucru = regLuniLucru.getOrCreateLunaLucru(data);
		if(lunaLucru.getStatus().equals(StatusLuna.INCHISA.toString()))
			throw new CtbException("Luna este inchisa!! Nu puteti introduce documentul!");
		
		if (stareDocument==StareDocument.NOU) {
			logger.debug("Creare inregistrare diversa noua");
						 
			//Integer nrSabProductie=3;
			int nrlin=1;
			
			InregistrareRJ inregDiversa = new InregistrareRJ(data, nrInreg,regLuniLucru.getOrCreateLunaLucru(data),null);
			List<ArticolCtb> listaArtRJ= new ArrayList <ArticolCtb>();
			ArticolCtb articolAchizitie = new ArticolCtb();
			
			logger.debug("Avem obiecte");
			
					articolAchizitie.setContCredit(contc);
					articolAchizitie.setContDebit(contd);
					articolAchizitie.setNrLinArt(nrlin);
					articolAchizitie.setSumaDC(suma);
					articolAchizitie.setDenArt("NC nr "+nrInreg+"/"+data);
				//adaugam articolul in lista
					listaArtRJ.add(articolAchizitie);
					logger.info("Articol rezolvat: "+articolAchizitie.getContDebit().getSimbolCont()+" | "+articolAchizitie.getContCredit().getSimbolCont());		
				
		inregDiversa.setArticoleRJ(listaArtRJ);
		inregDiversa.setLunaCurs(regLuniLucru.getOrCreateLunaLucru(data));
			logger.debug("Avem lista de articole");
			
			logger.debug("Avem o inregistrare diversa NOUA");
			//System.out.println("inregVanzare id:"+inregDiversa.getIdInregRJ());
			
			RegInregistrareRJ.instantiaza().addInregistrareRJ(inregDiversa);
			//return inregDiversa.getIdInregRJ();
			
		} else if (stareDocument==StareDocument.MODIFICAT){
			//TODO:
			//return -1;
		} else {
			//TODO:
			//return -1;
		}	
	}
//--------------------------------------------------------------
	@Override
	public String verificaLunaInchisa(Date data) {
		RegLuniLucru reg=RegLuniLucru.instantiaza();
		LunaLucru lunaLucru = reg.getLunaLucruDupa(data);
		if(lunaLucru==null)
			return StatusLuna.INCHISA.toString();
		else
			return lunaLucru.getStatus();
	}
//----------------------------------------------------------------
	@Override
	public Integer getidLunaDoc(Date data) {
		RegLuniLucru reg=RegLuniLucru.instantiaza();
		LunaLucru lunaLucru = reg.getLunaLucruDupa(data);
		if(lunaLucru==null)
			return -1;
		else
			return lunaLucru.getIdLuna();
	}
//-------------------------------------------------------------
	@Override
	public int getIdCont(Cont cont) {
		return cont.getIdCont(); //TODO: are vreun sens methoda pt vro echipa?
	}
//---------------------------------------------------------
	
	@Override
	public Cont crearePlanCont(String denCont, String simbolCont, String clasaCont, StatusSintetic tipSintetic, 
			Cont contParinte, TipCont tipCont) {
		return new Cont(denCont, simbolCont, clasaCont, tipSintetic, contParinte, tipCont);
	}
//------------------------------------------------------
	@Override
	public SablonNC creareSablonNC(Integer nrSablon, Cont contDebit, Cont contCredit) {
		return new SablonNC(nrSablon, contDebit, contCredit);
	}
//-------------------------------------------------------
	@Override
	public void inchideLuna(LunaLucru luna) throws CtbException {
		LunaLucru lunaAnterioara = RegLuniLucru.instantiaza().getLunaAnterioara(luna);
		//boolean notAnterioara;
		
		if(lunaAnterioara!=null){
			if(lunaAnterioara.getStatus().equals(StatusLuna.DESCHISA.toString()))
					throw new CtbException("Luna anterioara este deschisa! Nu puteti inchide luna ceruta");
		}
		//else{
		//	notAnterioara=true;
		//}

		List<Balanta> balLunaAnt = RegBalanta.instantiaza().getBalantaLunaAnterioare(luna);
		List<Balanta> balDeInchis = RegBalanta.instantiaza().getBalantaLunaDeInchis(luna);
		List<Balanta> balDeUpdate = new ArrayList<Balanta>();
		List<Balanta> balNoi = new ArrayList<Balanta>();
		
		List<InregistrareRJ> inregRJ = RegInregistrareRJ.instantiaza().getInregistrariLunaDeInchis(luna);
		List<Cont> planCont= RegConturi.instantiaza().getPlanConturi();
		
		double sid,sic, rad,rac, rcd,rcc, tsd,tsc, sfd,sfc;
		boolean existaBalanta=false;
		
		//pentru fiecare cont caut in balAanterioare si in balanteCurente(de inchis)
		for (Cont c:planCont){
			rcd=0.0;
			rcc=0.0;
			sfd=0.0;
			sfc=0.0;
			sid=0.0;
			sic=0.0;
			rad=0.0;
			rac=0.0;
			
			//System.out.println("fiecare cont"+ c.getSimbolCont());
			
			//mai trebuie un if  verificat daca e luna ianuarie caci se scimba 
			for(int i=0;i<balLunaAnt.size();i++){
				if(balLunaAnt.get(i).getContB().equals(c)){
					sid=balLunaAnt.get(i).getSlodInD();
					sic=balLunaAnt.get(i).getSlodInC();
					rad=balLunaAnt.get(i).getTotalSumD()-sid;
					rac=balLunaAnt.get(i).getTotalSumC()-sic;
					//System.out.println("luna ianuarie");
					break;
					
				}
			}
			//System.out.println(inregRJ.size());
			for (InregistrareRJ irj : inregRJ) {
				//System.out.println(irj.);
				for (ArticolCtb art : irj.getArticoleRJ()) {
					//art.toString();
					if (art.getContDebit() == c) {// sau poate vrea equals
						rcd = rcd + art.getSumaDC();
						//System.out.println("RJ contine contul pe debit");
					}
					if (art.getContCredit() == c) {
						rcc = rcc + art.getSumaDC();
						//System.out.println("RJ contine contul pe credit");
					}
				}
			}
			
			tsd = rad + rcd;
			tsc = rac + rcc;
			//System.out.println("am facut total "+tsd+"/"+tsc);
			if (tsd > tsc) {
				sfd = tsd - tsc;
			} else {
				sfc = tsc - tsd;
			}	
			//System.out.println("am facut sold final "+sfd+"/"+sfc);
			
			if (sid>0.0 || sic>0.0 || rad>0.0 || rac>0.0 || rcd>0.0 || rcc>0.0 || 
					tsd>0.0 || tsc>0.0 || sfd>0.0 || sfc>0.0){
						
			for(int i=0;i<balDeInchis.size();i++){
				if(balDeInchis.get(i).getContB().equals(c)){
					Balanta bl= balDeInchis.get(i);
					balDeUpdate.add(new Balanta(bl.getId(),bl.getLunaB(), bl.getContB(), sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false));
					existaBalanta=true;
					//System.out.println("am updatat o bal existenta");
					break;
				} 
			}
			
			if(existaBalanta==false){
				Balanta bal= new Balanta(luna, c, sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false);
				balNoi.add(bal);
				//System.out.println("am facut  si adaugat bal noua; am size "+ balNoi.size());
				logger.info("Am facut linieBalanta cont "+c.getSimbolCont()+" / "+bal.toString());
				//System.out.println("Am facut linieBalanta cont "+c.getSimbolCont()+" / "+bal.toString());
			}
		}
		}
		if (balNoi.size()>0) {
			RegBalanta.instantiaza().addAll(balNoi);
		}
		//System.out.println("am gatat cu toate conturile");
		
		//RegBalanta.instantiaza().printAll();
		luna.inchideLuna();
		
		//cred ca am uitat sa stergem balantele din (luna), cu true care nu se mai utilizeaza
	}
//-------------------------------------------------------
	@Override
	public void anuleazaInchidere(LunaLucru luna) {
		// TODO Auto-generated method stub
		
		RegBalanta.instantiaza().anuleazaBalanta(luna);
		RegLuniLucru.instantiaza().anuleazaLunaLucru(luna);
		
	}
//---------------------------------------------
	@Override
	public RegConturi getPlanConturi() {
		return RegConturi.instantiaza();
	}
//-------------------------------------------------
	@Override
	public boolean getContDisponibil(Cont cont) {
		if(cont.getContParinte()==null) return false; //e parinte->nu permite inregistrari
		else return cont.getContUtilizabilil();
		//aici verifica disponibilitatea tip de sintetic si analitic daca este tranzactional, adica daca are copii
		//tipul sintetic  parinte nu permite inregistrari
	}
//----------------------------------------------------------------
	public LinieMaterialValoare creareLinieMaterialValoare(TipContabil tipMaterial, Double valoare) {
		return new LinieMaterialValoare(tipMaterial, valoare);
	}
	public TipContabil creareTipMaterial(Integer idTip, String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire){
		return new TipContabil(idTip, denumireTip, contProprietar, contIntrare, contIesire);
	}
	public RegConturi getRegConturi(){
		return RegConturi.instantiaza();
	}
	public RegTipMaterial getRegTipMaterial(){
		return RegTipMaterial.instantiaza();
	}
	public RegSablonNC getRegSablonNC(){
		return RegSablonNC.instantiaza();
	}	
	public RegLuniLucru getRegLuniLucru(){
		return RegLuniLucru.instantiaza();
	}
	
	//------------------------------------------
	
	public List<FisaCont> creazaFisaCont(Cont cont) {
		List<FisaCont> listFC = new ArrayList<FisaCont>();
		List<InregistrareRJ> inregRJ = RegInregistrareRJ.instantiaza()
				.getListaInreg();
		// Integer idfc=1;
		double sold = 0.0;

		// trebuie luat d>c ca as dea sd sau invers sc dar,....
		for (InregistrareRJ irj : inregRJ) {
			for (ArticolCtb art : irj.getArticoleRJ()) {
				if (art.getContDebit() == cont) {
					listFC.add(new FisaCont(irj.getLunaCurs(), irj.getDataInregRJ(), art.getDenArt(), art.getSumaDC(), null, art.getContCredit()));
					sold = sold + art.getSumaDC();
					// idfc=idfc+1;
				}
				if (art.getContCredit() == cont) {
					listFC.add(new FisaCont(irj.getLunaCurs(), irj.getDataInregRJ(), art.getDenArt(), null, art.getSumaDC(), art.getContDebit()));
					sold = sold - art.getSumaDC();
					// idfc=idfc+1;
				}
			}
		}
		return listFC;
	}
	public List<FisaCont> creazaFisaContPartener (Cont cont, Integer idPart){
		List<FisaCont> listFC= new  ArrayList<FisaCont>();
		List<InregistrareRJ> inregRJ =  RegInregistrareRJ.instantiaza().getListaInreg();
		//Integer idfc=1;
		double sold=0.0;
		
		
		//!!!trebuie luat d>c ca as dea sd sau invers sc dar,....
		for (InregistrareRJ irj : inregRJ) {
			
			if (irj.getIdPartener()==idPart){
			for (ArticolCtb art : irj.getArticoleRJ()) {
				
				if (art.getContDebit() == cont ) {
					listFC.add(new FisaCont(irj.getLunaCurs(),irj.getDataInregRJ(),art.getDenArt(), art.getSumaDC(), null, art.getContCredit()));
					sold = sold + art.getSumaDC();
					//idfc=idfc+1;
					
				}
				if (art.getContCredit() == cont) {
					listFC.add(new FisaCont(irj.getLunaCurs(),irj.getDataInregRJ(),art.getDenArt(),null, art.getSumaDC(),  art.getContDebit()));
					sold = sold - art.getSumaDC();
					//idfc=idfc+1;
				}
			}
			}
		}
		return listFC;
	}
	
	
	public List<String> getTipuriContabile(){
		
		return null;//de pus get dun RegTipuriContabile
	};
}
