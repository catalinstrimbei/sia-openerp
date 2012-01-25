/*package org.open.erp.services.productie.impl;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.ProductieSrvLocal;

/**
 * Message-Driven Bean implementation class for: ReceptieComandaProductie
 * 
 */
/*
@MessageDriven(name = "MyQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/coadaProductie")

})
public class ReceptieComandaProductie implements MessageListener {
	@EJB
	private ProductieSrvLocal productieLocal;

	/**
	 * Default constructor.
	 */
	/*public ReceptieComandaProductie() {

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
		//@Override
		/*public void onMessage(Message message) {
		ObjectMessage oMsg = (ObjectMessage) message;
		Document docIn = (Document) oMsg;
		// voi aveti comanda productie... care ar trebui sa mosteneasca
		// Document(de la nomgen)
		// dak nu vreti sa o extindeti faceti o mapare din Document in
		for (LinieDocument l : docIn.getLiniiDocument()) {
			ComandaProductie c = new ComandaProductie((Produs) l.getMaterial(), l.getCantitate().intValue(),
					docIn.getDataDoc());

			try {
				productieLocal.lansareComandaProductie(c,
						(Produs) l.getMaterial());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

		