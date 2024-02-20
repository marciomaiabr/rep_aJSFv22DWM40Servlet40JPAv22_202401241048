package pkgs.mbs;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pkgs.utils.JSFUtil;

@Named
@ViewScoped
public class Teste01MB implements Serializable {

	private static final long serialVersionUID = 202402200415L;

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

	public String nextPage() {
		System.out.println("Teste01MB.nextPage()");

		souts();

		return "Page02";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");
	}

}
