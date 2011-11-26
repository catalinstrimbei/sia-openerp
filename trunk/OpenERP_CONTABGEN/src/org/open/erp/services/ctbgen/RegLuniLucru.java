package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.LunaLucru.StatusLuna;
import org.open.erp.services.ctbgen.exceptii.CtbException;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegLuniLucru {
	private static RegLuniLucru singleReference;

	private RegLuniLucru() {
		listaLuni = new ArrayList<LunaLucru>();
	}

	public static RegLuniLucru instantiaza() {
		if (singleReference == null)
			singleReference = new RegLuniLucru();
		return singleReference;
	}

	private List<LunaLucru> listaLuni;
	
	public LunaLucru getOrCreateLunaLucru(Date data) throws CtbException {
		LunaLucru lunaGasita = getLunaLucruDupa(data, null);
		if(lunaGasita!=null){
			return lunaGasita; //luna lucru exista
		}else {
			int an = data.getYear()+1900;
			int luna = data.getMonth();
			
			if(lunaGasita==null && listaLuni.isEmpty()==false){ //consecutive
				LunaLucru ultimaLuna = getUltimaLuna();	
				if ((ultimaLuna.getLuna() + 1 == luna && ultimaLuna.getAn() == an) || (luna == 1 && ultimaLuna.getAn() == an + 1 && ultimaLuna.getLuna() == 12)) {
					LunaLucru lunaNoua = new LunaLucru(0, luna+1, an);
					addLuna(lunaNoua);
					return lunaNoua;
				} else {
					throw new CtbException("Documentul solicitat incearca sa creeze o luna neconsecutiva!!");
				}
			} else if(listaLuni.isEmpty()==true){ //e prima luna
				LunaLucru lunaNoua = new LunaLucru(1, luna, an);
				addLuna(lunaNoua);
				return lunaNoua;
			} else {
				//TODO: 
				throw new CtbException("TODO: Remove! N-ar trebui sa se ajunga aici!");
			}
		}
	}
	
	//set metode care doar cauta - prima generalizat, interna
	private LunaLucru getLunaLucruDupa(Date data, Integer idLuna){
		if(idLuna == null){
			for (LunaLucru l : this.listaLuni) {
				if (l.getAn() == data.getYear()+1900 && l.getLuna() == data.getMonth())
						return l;
			}
		} else{ 
			for (LunaLucru l : this.listaLuni) {
				if (l.getIdLuna() == idLuna)
					return l;
			}
		}
		return null;
	}
	
	public LunaLucru getLunaLucruDupa(Integer idLuna){
		return getLunaLucruDupa(null, idLuna);
	}
	
	public LunaLucru getLunaLucruDupa(Date data){
		return getLunaLucruDupa(data, null);
	}
	

	private void sorteazaLuni() {
		Collections.sort(listaLuni);
	}

	private static int contorId = 1;
	public void addLuna(LunaLucru luna) {
		if(luna.getIdLuna()==-1){
			luna.setIdLuna(contorId);
			contorId++;
		}
		
		if (!listaLuni.contains(luna)) {
			listaLuni.add(luna);
		}
	}

	public void removeLuna(LunaLucru luna) {
		listaLuni.remove(luna);
	}

	private LunaLucru getUltimaLuna() {
		sorteazaLuni();
		LunaLucru ultimaLuna = listaLuni.get(listaLuni.size() - 1);
		return ultimaLuna;
	}
	
	public LunaLucru getLunaAnterioara(LunaLucru luna){
		Calendar c = Calendar.getInstance();
		c.set(luna.getAn(), luna.getLuna(), 15);
		c.add(Calendar.MONTH, -1);
		Date lunaAnterioara_date = c.getTime();
		
		LunaLucru lunaAnterioara = RegLuniLucru.instantiaza().getLunaLucruDupa(lunaAnterioara_date);
		return lunaAnterioara;
	}
	
	public LunaLucru getUltimaLunaInchisa() {
		sorteazaLuni();
		for(int i=listaLuni.size()-1;i>=0;i--)
			if(listaLuni.get(i).getStatus().equals(StatusLuna.INCHISA.toString()))
					return listaLuni.get(i);
			
		return null;
	}
	
	public void anuleazaLunaLucru (LunaLucru luna){
		for (LunaLucru l : this.listaLuni) {
			if (l == luna)
				 l.anuleazaInchidere();
		}
	}
	//TODO: remove me
	public void printAll(){
		for(int i=0;i<listaLuni.size();i++){
			System.out.println(listaLuni.get(i).toString());
		}
	}

}
