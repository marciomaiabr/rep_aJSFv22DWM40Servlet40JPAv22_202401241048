package pkgs.mbs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pkgs.utils.JSFUtil;

@ManagedBean
@ViewScoped
public class Teste01MB {

	static {
		System.out.println("Teste01MB.static");
		System.out.println("[JSFUtil.getProjectStage()=" + JSFUtil.getProjectStage() + "]");
	}

	public Teste01MB() {
		System.out.println("Teste01MB.()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01MB.postConstruct()");
	}

	private void souts() {
		System.out.println("     " + "[this=" + this + "]");
	}

	public void methodViewAction() {
		System.out.println("Teste01MB.methodViewAction()");
	}

	public void methodTest() {
		System.out.println("Teste01MB.methodTest()");

		souts();
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");
	}

}
