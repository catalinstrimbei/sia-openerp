package org.open.erp.services.nomgen.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;


@SuppressWarnings("deprecation")
public class TestNomGenImpl{
	
DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
NomenclatoareDummyImpl NGService = new NomenclatoareDummyImpl();

	
	
	
Collection<Persoana> ListaPersoana = new ArrayList<Persoana>();
	Collection<Persoana> ListaPersoane1 = new ArrayList<Persoana>();
	Collection<Persoana> ListaPersoane2 = new ArrayList<Persoana>();
	Collection<Persoana> ListaPersoane3 = new ArrayList<Persoana>();
	Collection<PersoanaFizica> ListaPF = new ArrayList<PersoanaFizica>();
	public Collection<PersoanaJuridica> ListaPJ = new ArrayList<PersoanaJuridica>();
	Collection<Partener> ListaParteneri = new ArrayList<Partener>();
	Collection<Departament> ListaDepartamente = new ArrayList<Departament>();
	Collection<Departament> ListaDepartamente1 = new ArrayList<Departament>();
	Collection<Departament> ListaDepartamente2 = new ArrayList<Departament>();
	Collection<Divizie> ListaDivizii1 = new ArrayList<Divizie>();
	Collection<Divizie> ListaDivizii2 = new ArrayList<Divizie>();
	
	
	//Persoane
	Persoana persoana1 = new Persoana();
	Persoana persoana2 = new Persoana(2, "adresa2");
	Persoana persoana5 = new Persoana(5, "adresa5");
	Persoana persoana6 = new Persoana(6, "adresa6");
	Persoana persoana7 = new Persoana(7, "adresa7");
	Persoana persoana8 = new Persoana(8, "adresa8");
	Persoana persoana9 = new Persoana(9, "adresa9");
	

	
	//Departamente
	Departament dep1 = new Departament();
	Departament dep2 = new Departament(2, "departament2", "atributii2");
	Departament dep3 = new Departament(3, "departament3", "atributii3");
	Departament dep5 = new Departament(5, "departament5", "atributii5");
	Departament dep6 = new Departament(6, "departament6", "atributii6");
	Persoana persoana3 = new Persoana( 3, dep2, "adresa3",new ArrayList<String>(Arrays.asList("Tel1", "Tel2", "Tel3")) , new ArrayList<String>(Arrays.asList("email1", "email2", "email3")) );
	Persoana persoana4 = new Persoana( 3, dep2, "adresa3",new ArrayList<String>(Arrays.asList("Tel1", "Tel2", "Tel3")) , new ArrayList<String>(Arrays.asList("email1", "email2", "email3")) );
	
	 void AdaugaeListaPersoaneDepartamente() {
		 dep3.setPers(ListaPersoane1);
		 dep5.setPers(ListaPersoane2);
		 dep6.setPers(ListaPersoane3);
		 dep1.setPers(ListaPersoane1);
		 dep2.setPers(ListaPersoane2);
		 
	 }
	//Divizii
		Divizie div1 = new Divizie();
		
		Divizie div2 = new Divizie(dep2, "divizie2", "atribDiv2");
		Divizie div3 = new Divizie("Divizie3", "atribDiv3", persoana2);

		
		
		
	//Persoane fizice
		PersoanaFizica pf1 = new PersoanaFizica("Popescu", "Ioel", "dnul", 'M', "2222222");
		
		PersoanaFizica pf2 = new PersoanaFizica("Abajaiu", "Vilion", "dnul", 'M', "4444444");
		PersoanaFizica pf3 = new PersoanaFizica("Ugadi", "Ruel", "dnul", 'M', "5555555");

		//persoane juridice
		
		PersoanaJuridica pj1 = new PersoanaJuridica("pj1", "cdFisc1", "NRJ/123", "AtrFisc1");
		PersoanaJuridica pj2 = new PersoanaJuridica("pj2", "cdFisc2", "NRJ/124", "AtrFisc2");
		PersoanaJuridica pj3 = new PersoanaJuridica("pj3", "cdFisc3", "NRJ/125", "AtrFisc3");
	
		//Parteneri
		
		Partener part1 = new Partener(persoana3, new Date("01/08/2010"), 5);
		Partener part2 = new Partener(persoana5, new Date("01/09/2010"), 6);
		Partener part3 = new Partener(persoana6, new Date("01/07/2010"), 7);
		
		void generareListaParteneri(){
			
			ListaParteneri.add(part1);
			ListaParteneri.add(part2);
			ListaParteneri.add(part3);
			
		}
		
		
		
		void generareListaDepartamente(){
			
	ListaDepartamente1.add(dep1);
	ListaDepartamente1.add(dep2);
	ListaDepartamente1.add(dep6);
	
	ListaDepartamente2.add(dep3);
	ListaDepartamente2.add(dep5);
	
	
	ListaDepartamente.add(dep1);
	ListaDepartamente.add(dep2);
	ListaDepartamente.add(dep3);
	ListaDepartamente.add(dep5);
	ListaDepartamente.add(dep6);
	
	
		}
	
	void generarePersoane() {
		
		ListaPersoane1.add(persoana1);
		ListaPersoane2.add(persoana3);
		ListaPersoane2.add(persoana4);
		ListaPersoane1.add(persoana2);
		
		
		ListaPersoane3.add(persoana7);
		ListaPersoane3.add(persoana8);
		
		
		
		ListaPersoana.add(persoana1);
		ListaPersoana.add(persoana2);
		ListaPersoana.add(persoana3);
		ListaPersoana.add(persoana4);
		ListaPersoana.add(persoana5);
		ListaPersoana.add(persoana6);
		ListaPersoana.add(persoana7);
		ListaPersoana.add(persoana8);
		ListaPersoana.add(persoana9);
		
	}
	
	
	void AdaugarePersoanePF(){
		
		pf1.setP(persoana4);
		pf2.setP(persoana5);
		pf3.setP(persoana6);
		
		ListaPF.add(pf1);
		ListaPF.add(pf2);
		ListaPF.add(pf3);
	}
	
	void AdaugarePersoanePJ() {
		
		pj1.setP(persoana7);
		pj2.setP(persoana8);
		pj3.setP(persoana9);
		
		ListaPJ.add(pj1);
		ListaPJ.add(pj2);
		ListaPJ.add(pj3);
	}
	
	
	
	
	void generareListDivizii() {
		
		ListaDivizii1.add(div1);
		ListaDivizii2.add(div3);
		ListaDivizii2.add(div2);
	}
	
	
	
	void adaugareListaPersoanaDepartamentDivizie() {
		div1.setId(1);
		div1.setDenumire("div1");
		div1.setDivDepartament(ListaDivizii2);
		div1.setPers(ListaPersoane1);
		div2.setPers(ListaPersoane1);
		div3.setDivDepartament(ListaDivizii2);
		
	}
	
	
	


}
