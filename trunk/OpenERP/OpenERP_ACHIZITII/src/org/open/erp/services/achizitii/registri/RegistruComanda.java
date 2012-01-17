package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Comanda;

public class RegistruComanda extends Registru{
	
	private static final String SQL_DEFAULT = "SELECT c FROM Comanda c ";

	public RegistruComanda(EntityManager em) {
		super(em);

	}

	public List<Comanda> getComandaByFurnizor(Integer furnizor_id) {
		return em.createNamedQuery("getOferteAchizitieByFurnizor")
				.setParameter("furnizor_id", furnizor_id).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT).getResultList();
	}

}
