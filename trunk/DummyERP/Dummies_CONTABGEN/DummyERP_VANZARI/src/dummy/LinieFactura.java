package dummy;

import org.open.erp.services.nomgen.Linie;
import org.open.erp.services.nomgen.Material;

public class LinieFactura extends Linie{
	Double tvaLinie;

	public LinieFactura(Material materialLinie, Double valoareLinie, Double cantitate, Double tvaLinie) {
		super(materialLinie, valoareLinie, cantitate);
		this.tvaLinie = tvaLinie;
	}
	
}
