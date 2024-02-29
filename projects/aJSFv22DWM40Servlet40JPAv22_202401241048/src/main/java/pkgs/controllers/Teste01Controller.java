package pkgs.controllers;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import pkgs.models.Pessoa;
import pkgs.serviceEspec.PessoaServiceEspec;

@Named
// @javax.enterprise.context.RequestScoped
@javax.faces.view.ViewScoped
//@javax.enterprise.context.SessionScoped
//@javax.enterprise.context.ApplicationScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	@Inject
	private PessoaServiceEspec ps;

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

	public String getMethodWithFixedReturn01() {
		System.out.println("Teste01Controller.methodWithFixedReturn01()[" + (this) + "]");
		return "the methodWithFixedReturn01...";
	}

	public void method01() {
		System.out.println("Teste01Controller.method01()[" + (this) + "]");
		System.out.println("[ps=" + (ps) + "]");
		Pessoa p01 = new Pessoa("Aninha " + LocalDateTime.now());
		System.out.println("[p01=" + (p01) + "]");
		Pessoa p02 = ps.salvar(p01);
		System.out.println("[p02=" + (p02) + "]");
	}

	public void reloadByControllerMethod() {
		System.out.println("Teste01Controller.reloadByControllerMethod()[" + (this) + "]");
	}

	public String gotoPage02ByControllerMethod() {
		System.out.println("Teste01Controller.gotoPage02ByControllerMethod()[" + (this) + "]");
		return "Page02";
	}

	public void invalidateSession() {
		System.out.println("Teste01Controller.invalidateSession()[" + (this) + "]");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	public String invalidateSessionWithOtherPage() {
		System.out.println("Teste01Controller.invalidateSessionWithOtherPage()[" + (this) + "]");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "Page02.xhtml?faces-redirect=true";
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
