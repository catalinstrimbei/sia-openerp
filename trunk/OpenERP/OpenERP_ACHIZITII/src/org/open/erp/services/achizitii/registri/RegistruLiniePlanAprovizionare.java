package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.LiniePlanAprovizionare;
import org.open.erp.services.achizitii.PlanAprovizionare;

public class RegistruLiniePlanAprovizionare extends Registru {

	private static final String SQL_DEFAULT = "SELECT lpa FROM LiniePlanAprovizionare lpa ";

	public RegistruLiniePlanAprovizionare(EntityManager em) {
		super(em);

	}

	public List<LiniePlanAprovizionare> getLiniePlanAprovizionareBySaptAn(Integer idLiniePlanAprovizionare) {
		return em.createNamedQuery("getLiniePlanAprovizionareByPlan")
				.setParameter("idLiniePlanAprovizionare", idLiniePlanAprovizionare).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT).getResultList();

}
	
}
