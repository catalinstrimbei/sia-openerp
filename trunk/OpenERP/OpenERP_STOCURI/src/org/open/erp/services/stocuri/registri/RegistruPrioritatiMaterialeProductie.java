package org.open.erp.services.stocuri.registri;

import java.util.List;

import javax.persistence.EntityManager;

public class RegistruPrioritatiMaterialeProductie extends Registru {

	public RegistruPrioritatiMaterialeProductie(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {

		return em
				.createQuery(
						"SELECT p FROM PrioritateMaterialeProductie p where p.inchisa :='N' order by p.dataDocument desc ")
				.getResultList();
	}

}
