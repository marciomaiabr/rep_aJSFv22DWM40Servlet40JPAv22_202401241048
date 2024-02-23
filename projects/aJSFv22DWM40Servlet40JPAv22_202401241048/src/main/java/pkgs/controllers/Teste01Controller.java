package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import pkgs.beansEspec.Bean01Espec;
import pkgs.beansImpl.Bean01NoEspec;

@Named
@RequestScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	@Inject
	private Bean01Espec b01e;

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

	@SessionScoped
	public void usingCalculadoraEspec() {
		System.out.println("Teste01Controller.usingCalculadoraEspec()[" + (this) + "]");
		System.out.println("[b01e=" + (b01e) + "][b01e.getClass()=" + (b01e.getClass()) + "]");
		System.out.println("[b01ne=" + (b01ne) + "][b01ne.getClass()=" + (b01ne.getClass()) + "]");
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
	    //return "Page02.xhtml?faces-redirect=true";  

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
