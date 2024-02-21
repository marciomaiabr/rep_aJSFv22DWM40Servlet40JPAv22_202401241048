package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pkgs.models.Empresa;
import pkgs.serviceEspec.EmpresaServiceEspec;

@Named
@ViewScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	private Empresa empresa;

	@Inject
	private EmpresaServiceEspec ese;

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

	public void methodViewAction() {
		System.out.println("Teste01Controller.methodViewAction()[" + (this) + "]");
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		System.out.println("Teste01Controller.setEmpresa()[" + (this) + "]");
		System.out.println("     " + "     " + "[empresa=" + (empresa) + "][this.empresa=" + (this.empresa) + "]");
		this.empresa = empresa;
	}

	public void methodTest() {
		System.out.println("Teste01Controller.methodTest()[" + (this) + "]");

		System.out.println("     " + "[ese][" + (ese != null ? ese.getClass().toString() : "") + "][" + ese + "]");

		System.out.println("     " + "     " + "[empresa=" + (ese.buscar(1)) + "]");
	}

	public String nextPage() {
		System.out.println("Teste01Controller.nextPage()[" + (this) + "]");

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
