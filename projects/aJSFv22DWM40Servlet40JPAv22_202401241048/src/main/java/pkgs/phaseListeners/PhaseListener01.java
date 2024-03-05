package pkgs.phaseListeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pkgs.utils.JSFUtil;

public class PhaseListener01 implements PhaseListener {

	private static final long serialVersionUID = 20240219054100L;

	private static Log log = LogFactory.getLog(PhaseListener01.class);

	public PhaseListener01() {
		log.info("PhaseListener01.PhaseListener01()");
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		log.info("[INICIANDO FASE]" + "[" + (event.getPhaseId()) + "]");
	}

	public void afterPhase(PhaseEvent event) {
		log.info("[FINALIZANDO FASE]" + "[" + (event.getPhaseId()) + "]");
		if (event.getPhaseId() == PhaseId.RENDER_RESPONSE)
			JSFUtil.listCDIBeans().forEach(log::info);
	}

}
