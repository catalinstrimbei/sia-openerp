package org.open.erp.ui;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.apache.log4j.Logger;

public class PhaseTracker implements javax.faces.event.PhaseListener {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(PhaseTracker.class.getPackage().getName());
	
	
	public void afterPhase(PhaseEvent event) {
		logger.debug("AFTER - "+ event.getPhaseId());
	}
	public void beforePhase(PhaseEvent event) {
		logger.debug("BEFORE - "+ event.getPhaseId());
	}
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}