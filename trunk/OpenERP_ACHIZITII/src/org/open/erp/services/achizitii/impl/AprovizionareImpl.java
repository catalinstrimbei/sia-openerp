package org.open.erp.services.achizitii.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Contract;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.FacturaRetur;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieCerereOferta;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieFacturaRetur;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.ListaContMatVal;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.LinieCerereAprovizionare;

public class AprovizionareImpl implements AprovizionareSrv{
	public ContabilizareSrv contabilizareSrv = new ContabilizareSrvImpl();
	
	public AprovizionareImpl() {
	}	

	@Override
	public Furnizor creareFurnizor(Persoana persoana, Integer cont) {
		
		return new Furnizor("string","string","string","string",persoana,cont);
	}



	@Override
	public Factura creareFactura(Furnizor furnizor,
			String nrfact, Double valfact, Double TVATotal) {
		// TODO Auto-generated method stub
		return new Factura(valfact,TVATotal,nrfact,furnizor);
	}

	@Override
	public PlanAprovizionare inregistrareCerereAprovizionare(
			CerereAprovizionare cerereAprovizionare) {
		return PlanAprovizionare.getPlanAprovizionare();
		
	}

	/*@Override
	public void crearePlanAprovizionare(Date dataInceput, Date datasSarsit,
			Persoana persoana) {
		 TODO Auto-generated method stub
		
	}*/

	@Override
	public void updatePlanAprovizionare(PlanAprovizionare plan,
			LinieCerereAprovizionare linieCerereAprovizionare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creareCerereOferta(List<Furnizor> furnizori, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCerereOferta(LinieCerereOferta linieCerereOferta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trimitereCerereOferta(CerereOferta cerereOferta,
			List<Furnizor> furnizori) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,
			Furnizor furnizor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void analizaOferteAchizitie(List<OfertaAchizitie> oferteAchizitie,
			CerereOferta cerereOferta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comanda creareComanda(Furnizor furnizor, Date data,
			Contract contract, Persoana persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdatedComanda(LinieComanda linieComanda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int inregistrareFactura(Factura factura) {
		List<ListaContMatVal> lista = new LinkedList<ListaContMatVal>();
		return contabilizareSrv.jurnalizareAchizitie(factura.getDataDocument(), factura.getValFact(), 
				factura.getNrFact(), factura.getFurnizor().getIdPartener(), lista, (Integer)1, (Integer)1);
		
	}

	@Override
	public void creareNIR(Factura factura, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receptieMateriale(Date data, Comanda comanda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creareFacturaRetur(Factura factura, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFacturaRetur(FacturaRetur facturaRetur,
			LinieFacturaRetur linieFacturaRetur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returMateriale(FacturaRetur facturaRetur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void progresComanda(Comanda comanda) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
