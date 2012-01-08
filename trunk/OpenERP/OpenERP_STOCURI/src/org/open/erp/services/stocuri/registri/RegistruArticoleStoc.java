package org.open.erp.services.stocuri.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.stocuri.ArticolStoc;

public class RegistruArticoleStoc extends Registru {

	private static final String SQL_DEFAULT = "SELECT a FROM ArticolStoc a ";

	public RegistruArticoleStoc(EntityManager em) {
		super(em);

	}

	public List<ArticolStoc> getArticoleStocByGestiune(Integer idGest) {
		return em.createNamedQuery("getArticoleStocByGestiune")
				.setParameter("idGest", idGest).getResultList();
	}

	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT).getResultList();
	}

	public ArticolStoc getArticolByGestiuneAndMaterial(Integer idGest,
			Integer idMaterial) {
		return (ArticolStoc) em
				.createQuery(
						SQL_DEFAULT
								+ " WHERE a.gestiune.idGestiune := idGest AND a.material.idMaterial := idMaterial ")
				.setParameter("idGest", idGest)
				.setParameter("idMaterial", idMaterial).getSingleResult();
	}
}
