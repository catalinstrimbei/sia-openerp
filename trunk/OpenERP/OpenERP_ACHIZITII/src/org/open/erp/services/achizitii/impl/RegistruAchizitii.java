package org.open.erp.services.achizitii.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.registri.Registru;

public class RegistruAchizitii extends Registru {

	public RegistruAchizitii(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> List<T> getListaByClasa(Class<T> clasa) {
		// TODO Auto-generated method stub
		return null;
	}

}
