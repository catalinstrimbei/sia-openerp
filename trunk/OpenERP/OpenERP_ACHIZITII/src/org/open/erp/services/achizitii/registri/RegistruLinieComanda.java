package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieOfertaAchizitie;

public class RegistruLinieComanda extends Registru{
	
		
		private static final String SQL_DEFAULT = "SELECT lc FROM LinieComanda lc ";

		public RegistruLinieComanda(EntityManager em) {
			super(em);

		}

		public List<LinieComanda> getLinieComandaByComanda(Integer id_Comanda) {
			return em.createNamedQuery("getLinieComandaByComanda")
					.setParameter("id_Comanda", id_Comanda).getResultList();
		}
		
		@Override
		public <T> List<T> getListaByClasa(Class<T> clasa) {
			return em.createQuery(SQL_DEFAULT + ", Comanda o WHERE lo.id_Comanda = o.id_LinieComanda AND o.statusComanda:=0" ).getResultList();
		}

}
