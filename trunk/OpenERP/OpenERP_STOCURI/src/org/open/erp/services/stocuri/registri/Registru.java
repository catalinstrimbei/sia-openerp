package org.open.erp.services.stocuri.registri;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class Registru {

	protected EntityManager em;

	public Registru(EntityManager em) {
		super();
		this.em = em;
	}

	public void saveEntity(Object entitate) {
		if (!em.contains(entitate)) {
			em.persist(entitate);
		} else {
			em.merge(entitate);
		}
	}

	public void removeEntity(Object entitate) {
		if (em.contains(entitate)) {
			em.remove(entitate);
		} else {
			em.merge(entitate);
			em.remove(entitate);
		}
	}

	public <T> T getEntityById(Integer id, Class<T> clasa) {
		return em.find(clasa, id);
	}

	public abstract <T> List<T> getListaByClasa(Class<T> clasa);

}
