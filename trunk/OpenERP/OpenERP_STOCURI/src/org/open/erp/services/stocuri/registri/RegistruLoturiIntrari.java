package org.open.erp.services.stocuri.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.stocuri.LoturiIntrari;

public class RegistruLoturiIntrari extends Registru {

	private static final String SQL_DAFAULT = "SELECT l FROM LoturiIntrari l ";

	public RegistruLoturiIntrari(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DAFAULT).getResultList();
	}

	public List<LoturiIntrari> getLoturiByArticol(Integer idArticol) {
		return em
				.createQuery(
						SQL_DAFAULT
								+ " WHERE l.articol.idArticolStoc := idArticol ")
				.setParameter("idArticol", idArticol).getResultList();
	}
}
