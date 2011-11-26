package org.open.erp.services.incasari;

public class Casa {
	private static Casa casa;
	private Double soldCurent = 0.00;

	public Double getSoldCurent() {
		return soldCurent;
	}

	public void setSoldCurent(Double soldCurent) {
		this.soldCurent = soldCurent;
	}

	private Casa() {
		// Optional Code
	}

	public static synchronized Casa getCasa() {
		if (casa == null) {
			casa = new Casa();
		}
		return casa;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
