package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;

import pkgs.controllers.CalculadoraEspec;

@ViewScoped
public class CalculadoraImpl02 implements Serializable, CalculadoraEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("CalculadoraImpl02.static");
	}

	public CalculadoraImpl02() {
		System.out.println("CalculadoraImpl02.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("CalculadoraImpl02.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "CalculadoraImpl02";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CalculadoraImpl02.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("CalculadoraImpl02.finalize()[" + (this) + "]");
		super.finalize();
	}

}
