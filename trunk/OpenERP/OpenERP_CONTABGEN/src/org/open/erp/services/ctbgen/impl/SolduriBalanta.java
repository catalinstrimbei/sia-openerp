package org.open.erp.services.ctbgen.impl;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.Balanta;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.InregistrareRJ;
import org.open.erp.services.ctbgen.LunaLucru;
import org.open.erp.services.ctbgen.RegBalanta;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegInregistrareRJ;


public class SolduriBalanta {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContabilizareSrvImpl.class.getName());
	//vom face toate soldurile la egalitatile din balanta pentru inregistrarile din registru aferente lunii date
	
	public SolduriBalanta(LunaLucru luna){
		
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
			//daca cont parinte e null , adica c.getTipSintetic()==StatusSintetic.SINTETIC) || (c.getTipSintetic()==StatusSintetic.ANALITIC){
			if (c.getContParinte()== null) {
				
			
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
			
				for (ArticolCtb art : irj.getArticoleRJ()) {
				
					if (art.getContDebit() == c) {
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
					balDeUpdate.add(new Balanta(bl.getLunaB(), bl.getContB(), sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false));
					existaBalanta=true;
					//System.out.println("am updatat o bal existenta");
					break;
				} 
			}
			
			if(existaBalanta==false){
				Balanta bal= new Balanta(luna, c, sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false);
				balNoi.add(bal);
				//System.out.println("am facut  si adaugat bal noua; am size "+ balNoi.size());
				logger.info("Am facut linieBalanta cont analitic/sintetic "+c.getSimbolCont()+" / "+bal.toString());
				//System.out.println("Am facut linieBalanta cont "+c.getSimbolCont()+" / "+bal.toString());
			}
		}
			}//de la if
		//gata cu for c	
		}
		
		
		// for pentru conturile analitice_parinte----------------------------------------------------
		
		for (Cont c:planCont){
			if (c.getTipSintetic()== StatusSintetic.ANALITIC_PARINTE.toString()){
			List<Balanta> balCont = RegBalanta.instantiaza().getBalantaContParinte(c);
			rcd=0.0;
			rcc=0.0;
			sfd=0.0;
			sfc=0.0;
			sid=0.0;
			sic=0.0;
			rad=0.0;
			rac=0.0;
			tsd=0.0;
			tsc=0.0;
			
			for (Balanta b : balCont) {
				sid=sid+b.getSlodInD();
				sic=sic+b.getSlodInC();
				rad=rad+b.getRulajAnD();
				rac=rac+b.getRulajAnC();
				rcd=rcd+b.getRulajCurD();
				rcc=rcc+b.getRulajCurC();
				tsd=tsd+b.getTotalSumD();
				tsc=tsc+b.getTotalSumC();
			}
						
			if (tsd > tsc) {
				sfd = tsd - tsc;
			} else {
				sfc = tsc - tsd;
			}	
			
			if (sid>0.0 || sic>0.0 || rad>0.0 || rac>0.0 || rcd>0.0 || rcc>0.0 || 
					tsd>0.0 || tsc>0.0 || sfd>0.0 || sfc>0.0){
						
			for(int i=0;i<balDeInchis.size();i++){
				if(balDeInchis.get(i).getContB().equals(c)){
					Balanta bl= balDeInchis.get(i);
					balDeUpdate.add(new Balanta(bl.getLunaB(), bl.getContB(), sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false));
					existaBalanta=true;
					//System.out.println("am updatat o bal existenta");
					break;
				} 
			}
			
			if(existaBalanta==false){
				Balanta bal= new Balanta(luna, c, sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false);
				balNoi.add(bal);
				//System.out.println("am facut  si adaugat bal noua; am size "+ balNoi.size());
				logger.info("Am facut linieBalanta cont analitic_parinte "+c.getSimbolCont()+" / "+bal.toString());
				//System.out.println("Am facut linieBalanta cont "+c.getSimbolCont()+" / "+bal.toString());
			}
		}
			}//de la if
		
		}//gata cu for 	
		// apoi for pentru conturile sintetice_parinte
		for (Cont c:planCont){
			if (c.getTipSintetic()== StatusSintetic.SINTETIC_PARINTE.toString()){
			List<Balanta> balCont = RegBalanta.instantiaza().getBalantaContParinte(c);
			rcd=0.0;
			rcc=0.0;
			sfd=0.0;
			sfc=0.0;
			sid=0.0;
			sic=0.0;
			rad=0.0;
			rac=0.0;
			tsd=0.0;
			tsc=0.0;
			
			for (Balanta b : balCont) {
				sid=sid+b.getSlodInD();
				sic=sic+b.getSlodInC();
				rad=rad+b.getRulajAnD();
				rac=rac+b.getRulajAnC();
				rcd=rcd+b.getRulajCurD();
				rcc=rcc+b.getRulajCurC();
				tsd=tsd+b.getTotalSumD();
				tsc=tsc+b.getTotalSumC();
			}
						
			if (tsd > tsc) {
				sfd = tsd - tsc;
			} else {
				sfc = tsc - tsd;
			}	
			
			if (sid>0.0 || sic>0.0 || rad>0.0 || rac>0.0 || rcd>0.0 || rcc>0.0 || 
					tsd>0.0 || tsc>0.0 || sfd>0.0 || sfc>0.0){
						
			for(int i=0;i<balDeInchis.size();i++){
				if(balDeInchis.get(i).getContB().equals(c)){
					Balanta bl= balDeInchis.get(i);
					balDeUpdate.add(new Balanta(bl.getLunaB(), bl.getContB(), sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false));
					existaBalanta=true;
					//System.out.println("am updatat o bal existenta");
					break;
				} 
			}
			
			if(existaBalanta==false){
				Balanta bal= new Balanta(luna, c, sid, sic, rad, rac, rcd, rcc, tsd, tsc, sfd, sfc, false);
				balNoi.add(bal);
				//System.out.println("am facut  si adaugat bal noua; am size "+ balNoi.size());
				logger.info("Am facut linieBalanta cont sintetic_parinte "+c.getSimbolCont()+" / "+bal.toString());
				//System.out.println("Am facut linieBalanta cont "+c.getSimbolCont()+" / "+bal.toString());
			}
		}
			}//de la if
		
		}//gata cu for 	
		
		//update  de balante noi, cele vechi au fost rescrise in registru
		if (balNoi.size()>0) {
			RegBalanta.instantiaza().addAll(balNoi);
		}
	}
	
}
