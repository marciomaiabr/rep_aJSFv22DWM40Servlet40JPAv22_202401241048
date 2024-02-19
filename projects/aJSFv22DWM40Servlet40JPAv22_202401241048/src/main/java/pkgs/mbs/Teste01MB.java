package pkgs.mbs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;

import pkgs.utils.JSFUtil;

@ManagedBean
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

		souts();
	}

	private String texto01;
	private String texto02;
	private String texto03;
	private String texto04;

	public String getTexto01() {
		return texto01;
	}

	public void setTexto01(String texto01) {
		this.texto01 = texto01;
	}

	public String getTexto02() {
		return texto02;
	}

	public void setTexto02(String texto02) {
		this.texto02 = texto02;
	}

	public String getTexto03() {
		return texto03;
	}

	public void setTexto03(String texto03) {
		this.texto03 = texto03;
	}

	public String getTexto04() {
		return texto04;
	}

	public void setTexto04(String texto04) {
		this.texto04 = texto04;
	}

	private void souts() {
		System.out.println("     " + "[this.texto01=" + this.texto01 + "]");
		System.out.println("     " + "[this.texto02=" + this.texto02 + "]");
		System.out.println("     " + "[this.texto03=" + this.texto03 + "]");
		System.out.println("     " + "[this.texto04=" + this.texto04 + "]");
	}

	public void methodViewAction() {
		System.out.println("Teste01MB.methodViewAction()");

		souts();
	}

	public void commandButtonTexto01Click() {
		System.out.println("Teste01MB.commandButtonTexto01Click()");

		souts();
	}

	public void commandButtonTexto01AjaxListener() {
		System.out.println("Teste01MB.commandButtonTexto01AjaxListener()");

		souts();
	}

	public void commandButtonTexto01ActionListener() {
		System.out.println("Teste01MB.commandButtonTexto01ActionListener()");

		souts();
	}

	public void reload() {
		System.out.println("Teste01MB.reload()");

		souts();
	}

	public void confirmar() {
		System.out.println("Teste01MB.confirmar()");

		souts();
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");

		souts();
	}

}
