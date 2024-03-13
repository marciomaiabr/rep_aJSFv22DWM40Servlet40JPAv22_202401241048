package pkgs.controllers;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

@Named
// @javax.enterprise.context.RequestScoped
@javax.faces.view.ViewScoped
//@javax.enterprise.context.SessionScoped
//@javax.enterprise.context.ApplicationScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	static {
		System.out.println("Teste01Controller.static");
	}

	public Teste01Controller() {
		System.out.println("Teste01Controller.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01Controller.postConstruct()[" + (this) + "]");
	}

	public LocalDateTime getAtualLocalDateTime() {
		return LocalDateTime.now();
	}

	public String goLogadoOff01() {
		return "LogadoOff01";
	}

	public String goLogadoOff02() {
		return "LogadoOff02?faces-redirect=true";
	}

	public String goLogadoOn01() {
		//qdo não usa "faces-redirect=true" ele redireciona para o xhtml e não dá erro de acesso
		//só dá o erro qdo exeuta alguma ação na página
		return "LogadoOn01";
	}

	public String goLogadoOn02() {
		return "LogadoOn02";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01Controller.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Teste01Controller.finalize()[" + (this) + "]");
		super.finalize();
	}

}
