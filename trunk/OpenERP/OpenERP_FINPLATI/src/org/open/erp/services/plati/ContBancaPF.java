package org.open.erp.services.plati;

import org.open.erp.services.nomgen.PersoanaFizica;

public class ContBancaPF {

	private PersoanaJuridica banca;
    
    private PersoanaFizica titularCont;

    private String numarCont;

    private String moneda;

    private Double soldCurent;

    public PersoanaJuridica getBanca() {
            return banca;
    }

    public void setBanca(PersoanaJuridica banca) {
            this.banca = banca;
    }

    public PersoanaFizica getTitularCont() {
        return titularCont;
}

public void setTitularCont(PersoanaFizica titularCont) {
        this.titularCont = titularCont;
    }

    public String getNumarCont() {
            return numarCont;
    }

    public void setNumarCont(String numarCont) {
            this.numarCont = numarCont;
    }

    public String getMoneda() {
            return moneda;
    }

    public void setMoneda(String moneda) {
            this.moneda = moneda;
    }

    public Double getSoldCurent() {
            return soldCurent;
    }

    public void setSoldCurent(Double soldCurent) {
            this.soldCurent = soldCurent;
    }

}