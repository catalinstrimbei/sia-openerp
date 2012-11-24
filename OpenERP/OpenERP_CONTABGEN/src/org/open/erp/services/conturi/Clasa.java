package org.open.erp.services.conturi;

import java.util.ArrayList;
import java.util.List;

public class Clasa {

	private String denumireClasa;
	private Integer codClasa;
	private List<Cont> conturi = new ArrayList<Cont>();

	public Integer getCodClasa() {
		return codClasa;
	}

	public void setCodClasa(Integer codClasa) {
		this.codClasa = codClasa;
	}

	public String getDenumireClasa() {
		return denumireClasa;
	}

	public void setDenumireClasa(String denumireClasa) {
		this.denumireClasa = denumireClasa;
	}

	public List<Cont> getConturi() {
		return conturi;
	}

	public void addCont(Cont cont) {
		this.conturi.add(cont);
	}

	public void removeCont(Cont cont) {
		this.conturi.remove(cont);
	}

	public Clasa(String denumireClasa) {
		super();
		this.denumireClasa = denumireClasa;
	}

	public Cont getContByCod(Integer cod) {
		for (Cont c : this.conturi) {
			if (c.getCodCont() == cod)
				return c;
		}

		return null;
	}

}
