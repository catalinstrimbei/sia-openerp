package org.open.erp.services.vanzari;

import java.util.ArrayList;
import org.open.erp.services.nomgen.Produs;

/**
 * @author Irina Bogdan
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 * 
 * @Dependente: StocuriSrv, NomenclatoareSrv, ContabilitateSrv
 * 
 * @EntitatiNomGen: Produs, Persoana, Document, LinieDocument 
 * 
 * @EntitatiStocuri: ArticolStoc
 * 
 * @EntitatiLocale: Client, FacturaEmisa, Comanda, Vanzator
 */

public interface VanzariSrv {
	/**
	 * Crearea unei noi comenzi
	 * 
	 * @param produs 	Vector de produse ce vor face parte din comanda
	 * @param cant		Vector de cantitati aferente fiecarui produs
	 * @param client	Clientul pentru care se inregistreaza comanda
	 * @return			o noua comanda
	 */
	public Comanda inregistrareComanda(Produs[] produs, Double[] cant, Client client);
	//public boolean procesareComanda(Comanda comanda);
	//public Comanda getComenziClient(Integer idClient);
	
	//public FacturaEmisa facturareProduse(Produs[] produs, Double[] cant, Client client, Vanzator vanzator);
	/**
	 * Crearea unei noi facturi
	 * 
	 * @param comanda	o comanda inregistrata
	 * @param client	clientul pentru care se factureaza produsele
	 * @param vanzator	Vanzatorul care realizeaza factura
	 * @return			o noua factura
	 */
	public FacturaEmisa facturareProduse(Comanda comanda, Client client, Vanzator vanzator);
	
	/**
	 * Inregistrarea facturii, crearea documentului contabil
	 * 
	 * @param factura factura penrtu care se realizeaza inregistrarea 
	 */
	public void inregistrareFactura(FacturaEmisa factura);
	
	/**
	 * Actualizarea stocului in momentul emiterii facturii
	 * 
	 * @param mod 		1 - iesire din gestiune; 2- intrare in gestiune 
	 * @param factura 	factura cu produsele care vor fi actulizate
	 */
	public void actulizareStoc(Integer mod, FacturaEmisa factura);
	
	/**
	 * Modificarea soldului clientului dupa emiterea unei noi facturi
	 * 
	 * @param factura	Factura din care se va prelua valoarea
	 * @param client	Clientul pentru care se va modifica soldul
	 */
	public void actualizeazaSoldClient(FacturaEmisa factura, Client client);
	
	/**
	 * Afisarea unei liste cu facturi emise unui client
	 * @param client	Clientul pentru care se cauta facturi
	 * @return
	 */
	public ArrayList<FacturaEmisa> getFacturiClient(Client client);
	
	//public void incheiereContract(Client client);
	
	/**
	 * Realizare retur produse
	 * @param factura	Factura cu produsele care vor fi returnate 
	 */
	public void returProduse(FacturaEmisa factura);
	//public boolean livrareProduse();
	//public void getVanzariLunare(String luna, String an);
}
