package org.open.erp.services.achizitii.registri;



import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.stocuri.registri.Registru;

public class RegistruFactura extends Registru {

	private static final String SQL_DEFAULT = "SELECT f FROM Facturi f ";

	public RegistruFactura(EntityManager em) {
		super(em);

	}

	public List<Factura> getFacturiByFurnizor(Integer furnizor_id) {
		return em.createNamedQuery("getFacturiByFurnizor")
				.setParameter("furnizor_id", furnizor_id).getResultList();
	}
	
	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		return em.createQuery(SQL_DEFAULT ).getResultList();
	}

	
	
}