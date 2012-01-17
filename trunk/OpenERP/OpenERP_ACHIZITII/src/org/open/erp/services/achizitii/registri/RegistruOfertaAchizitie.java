package org.open.erp.services.achizitii.registri;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.OfertaAchizitie;

public class RegistruOfertaAchizitie extends Registru{
	
	private static final String SQL_DEFAULT = "SELECT o FROM OfertaAchizitie o ";

	public RegistruOfertaAchizitie(EntityManager em) {
		super(em);

	}

	public List<OfertaAchizitie> getOferteAchizitieByFurnizor(Integer furnizor_id) {
		return em.createNamedQuery("getOferteAchizitieByFurnizor")
				.setParameter("furnizor_id", furnizor_id).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT + "WHERE o.statusOferta:=0" ).getResultList();
	}

}
