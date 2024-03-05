package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import pkgs.managedBeans.Teste01ManagedBean;

@Named
// @javax.enterprise.context.RequestScoped
@javax.faces.view.ViewScoped
//@javax.enterprise.context.SessionScoped
//@javax.enterprise.context.ApplicationScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	// @Inject
	// private Teste01ManagedBean mb1;
	// @Inject
	// @Named("Teste01ManagedBean")
	// private Teste01ManagedBean mb2;
	// @Inject
	// @Named("teste01ManagedBean")
	// private Teste01ManagedBean mb3;
	// @Inject
	// @Named("#{teste01ManagedBean}")
	// private Teste01ManagedBean mb4;
	// @Inject
	// @Named("pkgs.managedBeans.Teste01ManagedBean")
	// private Teste01ManagedBean mb5;

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

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMethodWithFixedReturn01() {
		System.out.println("Teste01Controller.methodWithFixedReturn01()[" + (this) + "]");
		return "the methodWithFixedReturn01...";
	}

	public void method01() {
		System.out.println("Teste01Controller.method01()[" + (this) + "]");
		// System.out.println("[" + (mb1) + "]");
		// System.out.println("[" + (mb2) + "]");
		// System.out.println("[" + (mb3) + "]");
		// System.out.println("[" + (mb4) + "]");
		// System.out.println("[" + (mb5) + "]");
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
