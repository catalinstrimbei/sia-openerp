package org.open.erp.services.stocuri.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.stocuri.Gestiune;

public class RegistruGestiune extends Registru {

	public RegistruGestiune(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public List<Gestiune> getGestiuniByDepozit(Integer idDepozit) {
		return em.createNamedQuery("getGestiuneByDepozit")
				.setParameter("idDepozit", idDepozit).getResultList();
	}

	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery("SELECT g FROM Gestiune g ").getResultList();
	}

}
