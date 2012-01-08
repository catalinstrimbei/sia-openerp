package org.open.erp.services.stocuri.impl;

import java.util.TreeSet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.registri.RegistruLoturiIntrari;

/**
 * 
 * @BusinessObject(Service)
 * 
 */
@Stateless
public class AplicarePret {

	private final EntityManager em;

	public enum METODE {
		LIFO, FIFO, CMP
	}

	public static METODE metodaCurenta = METODE.FIFO;

	/**
	 * Default constructor.
	 */
	public AplicarePret(EntityManager em) {
		this.em = em;
	}

	public Double getPretProdLot(ArticolStoc articolStoc)
			throws StocuriExceptions {
		Double pret = 0.0;
		switch (metodaCurenta) {
		case LIFO:
			pret = getLoturiOrdonateCronologic(articolStoc).last()
					.getPretIntrare();
			break;
		case FIFO:
			pret = getLoturiOrdonateCronologic(articolStoc).first()
					.getPretIntrare();
			break;
		case CMP:
			pret = 999.99;
			break;

		default:
			throw new StocuriExceptions(
					"Metoda de cost curenta nu este valida!! ar trebui sa fie una dintre (FIFO, LIFO sau CMP) ");

		}
		return pret;
	}

	public TreeSet<LoturiIntrari> getLoturiOrdonateCronologic(
			ArticolStoc articolStoc) {
		TreeSet<LoturiIntrari> loturiOrdonateCronologic = new TreeSet<LoturiIntrari>();
		RegistruLoturiIntrari regLot = new RegistruLoturiIntrari(em);
		for (LoturiIntrari l : regLot.getLoturiByArticol(articolStoc
				.getIdArticolStoc())) {
			loturiOrdonateCronologic.add(l);
		}

		return loturiOrdonateCronologic;
	}

	public METODE getMetodaCurenta() {
		return metodaCurenta;
	}

	public void setMetodaCurenta(METODE metodaCurenta) {
		AplicarePret.metodaCurenta = metodaCurenta;
	}

}
