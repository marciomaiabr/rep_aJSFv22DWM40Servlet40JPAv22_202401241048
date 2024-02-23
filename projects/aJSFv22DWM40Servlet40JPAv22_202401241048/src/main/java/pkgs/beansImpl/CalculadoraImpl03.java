package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;

import pkgs.beansEspec.CalculadoraEspec;

@ViewScoped
public class CalculadoraImpl03 implements Serializable, CalculadoraEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("CalculadoraImpl03.static");
	}

	public CalculadoraImpl03() {
		System.out.println("CalculadoraImpl03.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("CalculadoraImpl03.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "CalculadoraImpl03";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CalculadoraImpl03.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("CalculadoraImpl03.finalize()[" + (this) + "]");
		super.finalize();
	}

}
