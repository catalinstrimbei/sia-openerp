package org.open.erp.services.tranzactii;

import java.util.Date;

import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.conturi.Cont;

public class InregistrareOperatiuneContabila {
	Integer idOperatiune;
	Date dataOperatiune;
	String tipOperatiune;
	String descriereOperatiune;
	Document document;

	protected double suma;
	
	protected InregistrareOperatiune debit;
	protected InregistrareOperatiune credit;

	public Integer getIdOperatiune() {
		return idOperatiune;
	}

	public void setIdOperatiune(Integer idOperatiune) {
		this.idOperatiune = idOperatiune;
	}

	public Date getDataOperatiune() {
		return dataOperatiune;
	}

	public void setDataOperatiune(Date dataOperatiune) {
		this.dataOperatiune = dataOperatiune;
	}

	public String getTipOperatiune() {
		return tipOperatiune;
	}

	public void setTipOperatiune(String tipOperatiune) {
		this.tipOperatiune = tipOperatiune;
	}

	public String getDescriereOperatiune() {
		return descriereOperatiune;
	}

	public void setDescriereOperatiune(String descriereOperatiune) {
		this.descriereOperatiune = descriereOperatiune;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public InregistrareOperatiune getDebit() {
		return debit;
	}

	public void setDebit(InregistrareOperatiune debit) {
		this.debit = debit;
	}

	public InregistrareOperatiune getCredit() {
		return credit;
	}

	public void setCredit(InregistrareOperatiune credit) {
		this.credit = credit;
	}

	public InregistrareOperatiuneContabila() {
		this(new Date(), null, "", 0.0);
	}

	public InregistrareOperatiuneContabila(Date data, Document document, String descriere,
			double suma) {
		this(data, document, descriere, suma, new InregistrareOperatiune(null,
				null, InregistrareOperatiune.Tip.DEBIT, 0.0),
				new InregistrareOperatiune(null, null,
						InregistrareOperatiune.Tip.CREDIT, 0.0));
	}

	public InregistrareOperatiuneContabila(Date data, Document document, String descriere,
			double suma, InregistrareOperatiune intrareDebit,
			InregistrareOperatiune intrareCredit) {
		adaugaProprietati(data, document, descriere, suma, intrareDebit,
				intrareCredit);
	}

	public static InregistrareOperatiuneContabila creazaOperatiune() {
		InregistrareOperatiuneContabila tran = new InregistrareOperatiuneContabila();
		tran.debit.setInregistrare(tran);
		tran.credit.setInregistrare(tran);

		return tran;
	}

	public static InregistrareOperatiuneContabila creazaOperatiune(Date data, Document document,
			String descriere, double suma, InregistrareOperatiune intrareDebit,
			InregistrareOperatiune intrareCredit) {
		InregistrareOperatiuneContabila tran = new InregistrareOperatiuneContabila(data, document, descriere, suma,
				intrareDebit, intrareCredit);
		tran.debit.setInregistrare(tran);
		tran.debit.setInregistrare(tran);

		return tran;
	}

	public Cont getContCredit() {
		return debit.getTransferCont();
	}

	public Cont getDebitCont() {
		return credit.getTransferCont();
	}

	protected void adaugaProprietati(Date data, Document document,
			String descriere, double suma, InregistrareOperatiune intrareDebit,
			InregistrareOperatiune intrareCredit) {
		this.dataOperatiune = data;
		this.document = document;
		this.descriereOperatiune = descriere;
		this.suma = suma;
		this.debit = intrareDebit;
		this.credit = intrareCredit;
	}

	protected void adaugaProprietati(Date data, Document document,
			String descriere, double suma) {
		this.dataOperatiune = data;
		this.document = document;
		this.descriereOperatiune = descriere;
		this.suma = suma;
	}

	public void adaugaOperatiune() throws ExceptieContNetranzactionabil {
		ataseazaIntrariConturilor();
	}

	public void stergeOperatiune() throws ExceptieContNetranzactionabil {
		stergeIntrarileAferenteConturilor();
	}

	protected void stergeIntrarileAferenteConturilor()
			throws ExceptieContNetranzactionabil {
		getDebitCont().stergeIntrare(debit);
		getContCredit().stergeIntrare(credit);
	}

	protected void ataseazaIntrariConturilor()
			throws ExceptieContNetranzactionabil {
		getDebitCont().adaugaIntrare(debit);
		getContCredit().adaugaIntrare(credit);
	}

}
