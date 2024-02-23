package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pkgs.beansEspec.CalculadoraEspec;

@Named
@SessionScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	@Inject @ViewScoped
	private CalculadoraEspec calculadoraEspec;

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

	public void usingCalculadoraEspec() {
		System.out.println("Teste01Controller.usingCalculadoraEspec()[" + (this) + "]");
		System.out.println("[calculadoraEspec=" + (calculadoraEspec) + "][calculadoraEspec.getClass()=" + (calculadoraEspec.getClass()) + "]");
	}

	public String gotoPage02ByControllerMethod() {
		System.out.println("Teste01Controller.gotoPage02ByControllerMethod()[" + (this) + "]");
		return "Page02";
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
