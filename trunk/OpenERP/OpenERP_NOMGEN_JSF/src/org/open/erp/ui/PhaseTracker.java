package org.open.erp.ui;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.logger.NomgenLogger;

@SuppressWarnings("unused")
public class PhaseTracker implements javax.faces.event.PhaseListener {
	private static final long serialVersionUID = 1L;
	private static NomgenLogger logger = new NomgenLogger();
	
	public void afterPhase(PhaseEvent event) {
		logger.logDEBUG("AFTER - "+ event.getPhaseId());
	}
	public void beforePhase(PhaseEvent event) {
		logger.logDEBUG("BEFORE - "+ event.getPhaseId());
	}
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}