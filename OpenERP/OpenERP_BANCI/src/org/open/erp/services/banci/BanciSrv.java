package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

public interface BanciSrv {
	public SchimbValBNC creareSchimbValBNC(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb,List<LiniiPlati> liniePlata);
}
