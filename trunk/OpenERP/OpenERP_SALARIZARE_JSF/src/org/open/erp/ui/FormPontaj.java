package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.SalarizareSrvLocal;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class FormPontaj {

	private Pontaj pontaj;
	private List<Pontaj> pontaje = new ArrayList<Pontaj>();
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	private Map<String, Integer> mapAni = new HashMap<String, Integer>();
	
	private static SalarizareLogger logger;
	
	@EJB(mappedName="SalarizareImpl/local", name="SalarizareImpl/local") 
	private SalarizareSrvLocal salarizareSrv;
	
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	@PostConstruct
	public void initFormPontaj() throws Exception{
		logger = new SalarizareLogger();
		//angajat = salarizareSrv.getAngajatById(1);
		pontaje = salarizareSrv.getPontajAnLuna(2011, 11);
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		if (!pontaje.isEmpty())
			pontaj = pontaje.get(0);
	}

	public Pontaj getPontaj() {
		return pontaj;
	}

	public void setPontaj(Pontaj pontaj) {
		this.pontaj = pontaj;
	}
	
	public Map<String, Integer> getMapLuni() {
		mapLuni.put("Ianuarie", 1);
		mapLuni.put("Februarie", 2);
		mapLuni.put("Martie", 3);
		mapLuni.put("Aprilie", 4);
		mapLuni.put("Mai", 5);
		mapLuni.put("Iunie", 6);
		
		mapLuni.put("Iulie", 7);
		mapLuni.put("August", 8);
		mapLuni.put("Septembrie", 9);
		mapLuni.put("Octombrie", 10);
		mapLuni.put("Noiembrie", 11);
		mapLuni.put("Decembrie", 12);
		
		return ImmutableSortedMap.copyOf(mapLuni, Ordering.natural().onResultOf(Functions.forMap(mapLuni)));
	}

	public void setMapLuni(Map<String, Integer> mapLuni) {
		this.mapLuni = mapLuni;
	}
	
	public Map<String, Angajat> getAngajati(){
		Map<String, Angajat> mapAngajati = new HashMap<String, Angajat>();
		for (Angajat a: angajati){
			mapAngajati.put(a.getNume() + " " + a.getPrenume() + " | " + a.getMarca(), a);
		}
		return mapAngajati;
	}
	
	public List<Angajat> getAngajatiList(){
		return this.angajati;
	}
}
