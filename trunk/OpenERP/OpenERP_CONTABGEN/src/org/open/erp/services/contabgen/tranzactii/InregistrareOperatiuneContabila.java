package org.open.erp.services.contabgen.tranzactii;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.open.erp.exceptii.CodEroare;
import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.nomgen.Document;

@Entity
@Table(name="INREG_OP_CONTAB")
public class InregistrareOperatiuneContabila implements Serializable{

	private static Logger logger = Logger
			.getLogger(InregistrareOperatiuneContabila.class.getName());

	@Id
	@GeneratedValue
	Integer idOperatiune;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataOperatiune;
	String tipOperatiune;
	String descriereOperatiune;
	
	@OneToOne(cascade=CascadeType.ALL)
	Document document;

	protected double suma;

	@OneToOne(mappedBy="inregistrare", cascade=CascadeType.ALL)
	protected InregistrareOperatiune debit;

	@OneToOne(mappedBy="inregistrare", cascade=CascadeType.ALL)
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

	public InregistrareOperatiuneContabila(Date data, Document document,
			String descriere, double suma) {
		this(data, document, descriere, suma, new InregistrareOperatiune(null,
				null, InregistrareOperatiune.Tip.DEBIT, 0.0),
				new InregistrareOperatiune(null, null,
						InregistrareOperatiune.Tip.CREDIT, 0.0));
	}

	public InregistrareOperatiuneContabila(Date data, Document document,
			String descriere, double suma, InregistrareOperatiune intrareDebit,
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

	public static InregistrareOperatiuneContabila creazaOperatiune(Date data,
			Document document, String descriere, double suma,
			InregistrareOperatiune intrareDebit,
			InregistrareOperatiune intrareCredit) {
		InregistrareOperatiuneContabila tran = new InregistrareOperatiuneContabila(
				data, document, descriere, suma, intrareDebit, intrareCredit);
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

	public Map<String, CodEroare> modificaInregOpCtb(Date data,
			Document document, String descriere, double suma, Cont debitCont,
			Cont creditCont) {
		Map<String, CodEroare> rErrors = valideazaInregistrareOpCtb(suma,
				debitCont, creditCont);

		if (rErrors.isEmpty()) {
			try {
				if (getContCredit() != null && getDebitCont() != null) {
					renuntaLaInreg();
				}

				adaugaProprietati(data, document, descriere, suma);
				debit.setTransferCont(creditCont);
				credit.setTransferCont(debitCont);
				ataseazaInreg();

			} catch (ExceptieContNetranzactionabil ex) {

				logger.error(InregistrareOperatiuneContabila.class.getName());
			}
		}

		return rErrors;
	}

	public static Map<String, CodEroare> valideazaInregistrareOpCtb(
			double amount, Cont debitCont, Cont creditCont) {
		Map<String, CodEroare> rErrors = new HashMap<String, CodEroare>();

		if (amount < 0)
			rErrors.put("suma", CodEroare.SUMA_TRANZATIE_NEGATIVA);
		if (!debitCont.isTranzactionabil())
			rErrors.put("debitCont", CodEroare.CONT_NETRANZACTIONABIL);
		if (!creditCont.isTranzactionabil())
			rErrors.put("creditCont", CodEroare.CONT_NETRANZACTIONABIL);

		return rErrors;
	}

	public void ataseazaInreg() throws ExceptieContNetranzactionabil {
		adaugaIntrari();
	}

	public void renuntaLaInreg() throws ExceptieContNetranzactionabil {
		stergeInregistrarileAferenteConturilor();
	}

	protected void stergeInregistrarileAferenteConturilor()
			throws ExceptieContNetranzactionabil {
		getDebitCont().stergeIntrare(debit);
		getContCredit().stergeIntrare(credit);
	}

	protected void adaugaIntrari() throws ExceptieContNetranzactionabil {
		getDebitCont().adaugaIntrare(debit);
		getContCredit().adaugaIntrare(credit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOperatiune == null) ? 0 : idOperatiune.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InregistrareOperatiuneContabila other = (InregistrareOperatiuneContabila) obj;
		if (idOperatiune == null) {
			if (other.idOperatiune != null)
				return false;
		} else if (!idOperatiune.equals(other.idOperatiune))
			return false;
		return true;
	}

}
