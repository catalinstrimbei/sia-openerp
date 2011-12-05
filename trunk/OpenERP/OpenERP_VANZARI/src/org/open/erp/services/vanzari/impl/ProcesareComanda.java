package org.open.erp.services.vanzari.impl;

/**
 * @author Irina Bogdan
 */

import java.util.Iterator;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.LinieComanda;
import org.open.erp.services.stocuri.impl.StocuriImpl;

public class ProcesareComanda {
	
	public StocuriSrv stocuriSrv = new StocuriImpl();
	
	public Comanda comanda;
	
	public LinieComanda gasesteProdusComandat(Produs produs){
		LinieComanda produsComandat = null;
		if( !comanda.getProduseComandate().isEmpty()){
			Iterator<LinieComanda> iterator = comanda.getProduseComandate().iterator();
			while(produsComandat == null && iterator.hasNext()){
				LinieComanda linie = iterator.next();
				if( linie.getProdus().equals(produs)){
					produsComandat = linie;
				}
			}
		}
		//System.out.println(produsComandat.toString());
		return produsComandat;
	}
	
	// Adauga produs nou sau incrementeaza cantitatea daca deja exista
	public boolean addProdusInComanda(Produs produs, Double cantitate){
		if( !this.checkDisponibilitateProdus(produs, cantitate))
			return false;
		else {
			LinieComanda produsComandat = this.gasesteProdusComandat(produs);
			if( produsComandat == null){
					LinieComanda linie = new LinieComanda(produs, cantitate);
					return comanda.getProduseComandate().add(linie);
			}
			else{
				//System.out.println("cantitate modif");
				double cant_ = produsComandat.getCantitate() + cantitate;
				//System.out.println(cant_);
				produsComandat.setCantitate(cant_);
				return true;
			}
		}
	}

	public boolean removeProdusDinComanda(Produs produs){
		LinieComanda produsComandat = this.gasesteProdusComandat(produs);
		if( produsComandat == null)
			return false;
		else
			return comanda.getProduseComandate().remove(produsComandat);
	}
	
	// update produs din comanda
	 public boolean updateProdusDinComanda(Produs produs, Double cantitate){
		 return this.addProdusInComanda(produs, cantitate);
	}
	
	// produsul se afla sau nu in stoc
	public boolean checkDisponibilitateProdus(Produs produs, Double cantitate){
		// conversie Produs catre Material
		Double cantDisponibila = stocuriSrv.verificareStocMaterial(produs);
		if( cantDisponibila <= cantitate)
			return true;
		else
			return false;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
}
