package org.open.erp.services.vanzari;

import java.util.Comparator;

public class FacturaVanzareComparator implements Comparator<FacturaVanzare> {

	@Override
	public int compare(FacturaVanzare o1, FacturaVanzare o2) {
		return o1.getData().compareTo(o2.getData());
	}

}
