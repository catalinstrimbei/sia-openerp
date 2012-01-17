package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.stocuri.registri.Registru;

public class RegistruArticol extends Registru {

	private static final String SQL_DEFAULT = "SELECT a FROM Articol a ";

	public RegistruArticol(EntityManager em) {
		super(em);

	}

	public List<Articol> getArticoleByCategorie(Integer id) {
		return em.createNamedQuery("getArticoleByCategorie")
				.setParameter("id", id).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT).getResultList();
	}

	
	
}
