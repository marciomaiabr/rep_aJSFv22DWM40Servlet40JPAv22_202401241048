package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import pkgs.beansImpl.Bean01NoEspec;

@Named
// @javax.enterprise.context.RequestScoped
// @javax.faces.view.ViewScoped
// @javax.enterprise.context.SessionScoped
@javax.enterprise.context.ApplicationScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	@Inject
	private Bean01NoEspec b01ne;

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

	public void usingBean() {
		System.out.println("Teste01Controller.usingBean()[" + (this) + "]");
		System.out.println("[b01ne=" + (b01ne) + "]");
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
