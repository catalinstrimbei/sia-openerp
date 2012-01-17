package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.stocuri.registri.Registru;

public class RegistruPlanAprovizionare extends Registru {
	

		private static final String SQL_DEFAULT = "SELECT pa FROM PlanAprovizionare pa ";

		public RegistruPlanAprovizionare(EntityManager em) {
			super(em);

		}

		public List<PlanAprovizionare> getPlanAprovizionareBySaptAn(Integer saptAn) {
			return em.createNamedQuery("getPlanAprovizionareBySaptAn")
					.setParameter("saptAn", saptAn).getResultList();
		}
		
		@Override
		public <T> List<T> getListaByClasa(Class<T> clasa) {
			return em.createQuery(SQL_DEFAULT).getResultList();

}
		
}
