package org.open.erp.services.stocuri.impl;

import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.NotaReceptie;
import org.open.erp.services.stocuri.StocuriSrv;

public class StocuriDummyImpl implements StocuriSrv{

	@Override
	public void intrareInStoc(ArticolStoc articol, Double cantitate,Gestiune gestiune,
			 Depozit depozit) {
		articol.setStoc(cantitate);
		
	}

	@Override
	public void iesiredinStoc(ArticolStoc articol, Double cantitate,Gestiune gestiune,
			Depozit depozit) {
		articol.setStoc(-cantitate);
		
	}

}
