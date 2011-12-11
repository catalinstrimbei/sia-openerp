package org.open.erp.services.plati;

import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.plati.exceptions.PlatiExceptions;
//import org.open.erp.services.plati.impl.DocumentPlata;
import org.open.erp.services.plati.Factura;

public interface FinPlatiSrv {
	public Factura inregistrareFactura(String seriaNr, Date data, Double totalPlata, PersoanaJuridica furnizor, PersoanaJuridica client, List<Factura> facturi) throws PlatiExceptions;
	public void confirmarePlata(DocumentPlata doc) throws CtbException,PlatiExceptions;
	public boolean efectPlata(Double totplata);
	public Double compensariParteneri();
	public Double verificareSoldFurnizor();
	public Double plataAvans();
	public Double restPlata();
	public Double plataFactNumerar();

	}
