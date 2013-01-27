package org.open.erp.services.contabgen.conturi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.open.erp.exceptii.CodEroare;
import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cont implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Cont.class.getName());

	public static enum Tip {
		ACTIV, PASIV, CHELTUIELI, VENITURI
	}

	@Id
	private Integer codCont;
	private String denumireCont;

	protected String descriere;
	protected double sold;
	@Transient
	protected Tip tip;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Clasa clasa;
	/**
	 * flag care indica daca soldul acestui cont poate fi modificat in cadrul
	 * inregistrarilor
	 */
	protected boolean tranzactionabil;

	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	protected List<InregistrareOperatiune> intrari=new ArrayList<InregistrareOperatiune>();

	public Cont() {
		this(-1, "", "", 0.0, true);
	}

	public Integer getCodCont() {
		return codCont;
	}

	public void setCodCont(Integer codCont) {
		this.codCont = codCont;
	}

	public String getDenumireCont() {
		return denumireCont;
	}

	public void setDenumireCont(String denumireCont) {
		this.denumireCont = denumireCont;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public boolean isTranzactionabil() {
		return tranzactionabil;
	}

	public void setTranzactionabil(boolean tranzactionabil) {
		this.tranzactionabil = tranzactionabil;
	}

	public List<InregistrareOperatiune> getIntrari() {
		return intrari;
	}

	public void setIntrari(List<InregistrareOperatiune> intrari) {
		this.intrari = intrari;
	}

	
	
	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	public Cont(Integer codCont, String denumireCont) {
		super();
		this.codCont = codCont;
		this.denumireCont = denumireCont;
	}

	public Cont(Integer codCont, String denumireCont, String descriere,
			double sold, boolean soldModificabil) {
		super();
		this.codCont = codCont;
		this.denumireCont = denumireCont;
		this.descriere = descriere;
		this.sold = sold;
		this.tranzactionabil = soldModificabil;
	}

	public Cont(Integer codCont, String denumireCont, String descriere,
			double sold, boolean soldModificabil, Tip tip,
			List<InregistrareOperatiune> intrari) {
		adaugaProprietati(codCont, denumireCont, descriere, sold, tip,
				soldModificabil, intrari);
	}

	public void adaugaProprietati(int codCont, String denumireCont,
			String descriere, double sold, Tip tip, boolean tranzactionabil,
			List<InregistrareOperatiune> intrari) {
		if (intrari != null && !tranzactionabil && intrari.size() > 0) {
			logger.warn(this.getClass().getName()
					+ "Incercare de a seta intrari pentru un cont netranzactionabil"
					+ " cont: " + denumireCont);
			intrari = new ArrayList<InregistrareOperatiune>();
		}
		this.codCont = codCont;
		this.denumireCont = denumireCont;
		this.descriere = descriere;
		this.sold = sold;
		this.tip = tip;
		this.tranzactionabil = tranzactionabil;
		this.intrari = intrari;
	}

	public void adaugaProprietati(int codCont, String denumire, String descriere) {
		this.codCont = codCont;
		this.denumireCont = denumire;
		this.descriere = descriere;
	}

	public List<InregistrareOperatiuneContabila> getinregistrariCont() {
		List<InregistrareOperatiuneContabila> inregistrari = new ArrayList<InregistrareOperatiuneContabila>();
		InregistrareOperatiune intrare;
		ListIterator it = intrari.listIterator();

		while (it.hasNext()) {
			intrare = (InregistrareOperatiune) it.next();
			inregistrari.add(intrare.getInregistrare());
		}

		return inregistrari;
	}

	public Map<String, CodEroare> modificaCont(int codCont, String denumire,
			String descriere) {
		Map<String, CodEroare> erori = valideaza(codCont, denumire, descriere);

		if (erori.isEmpty()) {
			adaugaProprietati(codCont, denumire, descriere);
		}
		return erori;
	}

	public static Map<String, CodEroare> valideaza(int codCont,
			String denumire, String descriere) {
		Map<String, CodEroare> erori = new HashMap<String, CodEroare>();

		if (codCont < -1) {
			erori.put("codCont", CodEroare.COD_CONT_INVALID);
		}
		if (denumire.length() <= 0) {
			erori.put("denumireCont", CodEroare.NUME_CONT_GOL);
		}

		return erori;
	}

	public void adaugaIntrare(InregistrareOperatiune intrare)
			throws ExceptieContNetranzactionabil {
		if (!tranzactionabil)
			throw new ExceptieContNetranzactionabil();
		// cauta indexul primei intrati a carei data este mai mare decat intrarea curenta
		int index = gasesteIndexulPrimeiIntrariMaiMariDecat(intrare);

		if (index != -1) {
			intrari.add(index, intrare);
		} else {
			intrari.add(intrare);
			index = 0;
		}
		recalculeazaSoldul(index);
	}

	protected void recalculeazaSoldul(int index) {
		ListIterator it;

		if (index > 0) {
			it = intrari.listIterator(index - 1);
			sold = ((InregistrareOperatiune) it.next()).getSoldCont();
		} else {
			it = intrari.listIterator(index);
			sold = 0.0;
		}

		while (it.hasNext()) {
			adaugaIntrarePeSold((InregistrareOperatiune) it.next());
		}
	}

	protected void adaugaIntrarePeSold(InregistrareOperatiune intrare) {
		double suma = intrare.getInregistrare().getSuma();

		switch (intrare.getTip()) {
		case DEBIT:
			modificaDebit(suma);
			break;
		case CREDIT:
			modificaCredit(suma);
			break;
		}

		intrare.setSoldCont(sold);
	}

	protected  void modificaDebit(double suma) {
	}

	protected  void modificaCredit(double suma) {
	}

	public void stergeIntrare(InregistrareOperatiune intrare)
			throws ExceptieContNetranzactionabil {
		if (!tranzactionabil)
			throw new ExceptieContNetranzactionabil();

		int index = intrari.indexOf(intrare);

		if (intrari.remove(intrare)) {
			if (index > 0)
				index--;

			recalculeazaSoldul(index);
		}
	}

	protected int gasesteIndexulPrimeiIntrariMaiMariDecat(Date data) {
		int index = -1;
		int indexCurent = -1;
		boolean exista = false;
		InregistrareOperatiune intrare;
		ListIterator it = intrari.listIterator();

		while (!exista && it.hasNext()) {
			indexCurent++;
			intrare = (InregistrareOperatiune) it.next();
			if (intrare.getInregistrare().getDataOperatiune().after(data)) {
				index = indexCurent;
				exista = true;
			}
		}

		return index;
	}

	protected int gasesteIndexulPrimeiIntrariMaiMariDecat(
			InregistrareOperatiune intrare) {
		return gasesteIndexulPrimeiIntrariMaiMariDecat(intrare.getInregistrare()
				.getDataOperatiune());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCont == null) ? 0 : codCont.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cont other = (Cont) obj;
		if (codCont == null) {
			if (other.codCont != null)
				return false;
		} else if (!codCont.equals(other.codCont))
			return false;
		return true;
	}

	
	
	

}