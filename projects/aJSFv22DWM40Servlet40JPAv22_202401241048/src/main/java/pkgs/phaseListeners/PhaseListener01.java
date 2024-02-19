package pkgs.phaseListeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListener01 implements PhaseListener {

	private static final long serialVersionUID = 20240219054100L;

	public PhaseListener01() {
		System.out.println("PhaseListener01.PhaseListener01()");
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		System.out.println("INICIANDO FASE: " + event.getPhaseId());
	}

	public void afterPhase(PhaseEvent event) {
		System.out.println("FINALIZANDO FASE: " + event.getPhaseId());
	}

}
