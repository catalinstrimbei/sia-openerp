package org.open.erp.services.stocuri;

import org.open.erp.services.nommat.Material;

public interface StocuriSrv {
	
	public Double verificareStoc ( Material material );
	public void iesireStoc(Material material, Double cantitatea);
}
