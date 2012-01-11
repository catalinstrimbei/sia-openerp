package org.open.erp.services.ctbgen;



import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.LunaLucru;
import org.open.erp.services.ctbgen.LunaLucru.StatusLuna;
import org.open.erp.services.ctbgen.exceptii.CtbException;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegLuniLucru extends Registru{
	private static RegLuniLucru singleReference;

	private RegLuniLucru() {
		sqlDefaultText = "SELECT o FROM LunaLucru o";
	}

	public static RegLuniLucru instantiaza() {
		if (singleReference == null)
			singleReference = new RegLuniLucru();
		return singleReference;
	}
	
	public List<LunaLucru> getLuniLucru() {
		@SuppressWarnings("unchecked")
		List<LunaLucru> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}

	public LunaLucru getOrCreateLunaLucru(Date data) throws CtbException {
		LunaLucru lunaGasita = getLunaLucruDupa(data, null);
		List<LunaLucru> listaLuni = getLuniLucru();
		
		if(lunaGasita!=null){
			return lunaGasita; //luna lucru exista
		}else {
			//int an = data.getYear()+1900;
			//int luna = data.getMonth();
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int an = cal.get(Calendar.YEAR);
			int luna =cal.get(Calendar.MONTH)+1;
			if(lunaGasita==null && listaLuni.isEmpty()==false){ //consecutive
				LunaLucru ultimaLuna = getUltimaLuna();	
				if ((ultimaLuna.getLuna() + 1 == luna && ultimaLuna.getAn() == an) || (luna == 1 && ultimaLuna.getAn() == an + 1 && ultimaLuna.getLuna() == 12)) {
					LunaLucru lunaNoua = new LunaLucru( luna, an);//LunaLucru(0, luna, an);
					addLuna(lunaNoua);
					return lunaNoua;
				} else {
					throw new CtbException("Documentul solicitat incearca sa creeze o luna neconsecutiva!!");
				}
			} else if(listaLuni.isEmpty()==true){ //e prima luna
				LunaLucru lunaNoua = new LunaLucru( luna, an);//LunaLucru(1, luna, an);
				addLuna(lunaNoua);
				//System.out.println(luna+ " - " +an);
				return lunaNoua;
			} else {
				//TODO: 
				throw new CtbException("TODO: Remove! N-ar trebui sa se ajunga aici!");
			}
		}
	}
	
	//set metode care doar cauta - prima generalizat, interna
	private LunaLucru getLunaLucruDupa(Date data, Integer idLuna){
		List<LunaLucru> listaLuni = getLuniLucru();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		int an = cal.get(Calendar.YEAR);
		int luna =cal.get(Calendar.MONTH)+1;
		if(idLuna == null){
			for (LunaLucru l : listaLuni) {
				if (l.getAn() == an && l.getLuna() == luna)
						return l;
			}
		} else{ 
			for (LunaLucru l : listaLuni) {
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
	

	
	public void addLuna(LunaLucru luna) {
		if (em.contains(luna))
			em.merge(luna);
		else
			em.persist(luna);
	
		synchronize();
	}

	public void removeLuna(LunaLucru luna) {
		em.remove(luna);
		
		synchronize();
	}
	
	public LunaLucru getLunaAnLuna(int luna, int an){
		List<LunaLucru>listaLuni = getLuniLucru();
		for(int i=listaLuni.size()-1;i>=0;i--)
			if(listaLuni.get(i).getIdLuna()==luna & listaLuni.get(i).getAn()==an){
				//System.out.println(listaLuni.get(i).toString());
					return listaLuni.get(i);
			}
		return null;
	}
	
	

	public LunaLucru getUltimaLuna() { //sau se putea in querry cu max luna?
		List<LunaLucru>listaLuni = getLuniLucru();
		Collections.sort(listaLuni);
		LunaLucru ultimaLuna = listaLuni.get(listaLuni.size() - 1);
		return ultimaLuna;
	}
	
	public LunaLucru getLunaAnterioara(LunaLucru luna){
				
		Calendar c = Calendar.getInstance();
		c.set(luna.getAn(), luna.getLuna()-1, 15);
		c.add(Calendar.MONTH,-1);
		
		Date lunaAnterioara_date = c.getTime();
		//System.out.println("voi returna luna pt data:"+lunaAnterioara_date);
		LunaLucru lunaAnterioara = RegLuniLucru.instantiaza().getLunaLucruDupa(lunaAnterioara_date);
	
		return lunaAnterioara;
	}
	
//	public LunaLucru getLunaAnterioara(LunaLucru luna){
//		List<LunaLucru>listaLuni = getLuniLucru();
//		System.out.println("ln"+luna.getLuna());
//		System.out.println("an"+luna.getAn());
//		int lln= luna.getIdLuna()-1;
//		int aan= luna.getAn();
//		System.out.println(lln+aan);
//		for(int i=listaLuni.size()-1;i>=0;i--)
//			if(listaLuni.get(i).getIdLuna()==lln && listaLuni.get(i).getAn()==aan){
//				System.out.println("?"+listaLuni.get(i).toString());
//				return listaLuni.get(i);
//			}
//		return null;
//	}
	
	public LunaLucru getUltimaLunaInchisa() {
		List<LunaLucru>listaLuni = getLuniLucru();
		Collections.sort(listaLuni);
		for(int i=listaLuni.size()-1;i>=0;i--)
			if(listaLuni.get(i).getStatus().equals(StatusLuna.INCHISA.toString()))
					return listaLuni.get(i);
			
		return null;
	}
	
	public void anuleazaLunaLucru (LunaLucru luna){
		List<LunaLucru>listaLuni = getLuniLucru(); //astea provin din un querry deci is managed deci syncronised de la final le ia in calcul
		
		for (LunaLucru l : listaLuni) {
			if (l == luna)
				 l.anuleazaInchidere();
		}
		
		synchronize();
	}
	
	public void inchideLunaLucru (int idd){
		List<LunaLucru>listaLuni = getLuniLucru(); 
		for(int i=listaLuni.size()-1;i>=0;i--)
			if(listaLuni.get(i).getIdLuna()==idd){
				listaLuni.get(i).inchideLuna();
			}
				
		synchronize();
	}
	
	//TODO: remove me
	public void printAll(){
		List<LunaLucru>listaLuni = getLuniLucru();
		for(int i=0;i<listaLuni.size();i++){
			System.out.println(listaLuni.get(i).toString());
		}
	}

	

}
