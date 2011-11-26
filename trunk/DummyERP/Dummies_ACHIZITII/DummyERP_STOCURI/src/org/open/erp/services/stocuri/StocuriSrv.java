package org.open.erp.services.stocuri;

public interface StocuriSrv {
	public void intrareInStoc(ArticolStoc articol,Double cantitate,Gestiune gestiune, Depozit depozit);
	public void iesiredinStoc(ArticolStoc articol,Double cantitate,Gestiune gestiune,  Depozit depozit);

}
