package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.LinieOfertaAchizitie;

public class RegistruLinieOfertaAchizitie extends Registru{
	
	private static final String SQL_DEFAULT = "SELECT lo FROM LinieOfertaAchizitie lo ";

	public RegistruLinieOfertaAchizitie(EntityManager em) {
		super(em);

	}

	public List<LinieOfertaAchizitie> getOLinieferteAchizitieByOfertaAchizitie(Integer id_OfertaAchizitie) {
		return em.createNamedQuery("getOLinieferteAchizitieByOfertaAchizitie")
				.setParameter("id_OfertaAchizitie", id_OfertaAchizitie).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT + "OfertaAchizitie o WHERE lo.id_OfertaAchizitie = o.id_OfertaAchizitie AND o.statusOferta:=0" ).getResultList();
	}

}
