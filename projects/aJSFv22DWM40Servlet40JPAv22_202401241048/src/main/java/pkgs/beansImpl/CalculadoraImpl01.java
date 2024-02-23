package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;

import pkgs.beansEspec.CalculadoraEspec;

@ViewScoped
public class CalculadoraImpl01 implements Serializable, CalculadoraEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("CalculadoraImpl01.static");
	}

	public CalculadoraImpl01() {
		System.out.println("CalculadoraImpl01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("CalculadoraImpl01.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "CalculadoraImpl01";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CalculadoraImpl01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("CalculadoraImpl01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
