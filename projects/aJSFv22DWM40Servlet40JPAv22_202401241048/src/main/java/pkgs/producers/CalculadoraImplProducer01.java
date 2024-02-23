package pkgs.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import pkgs.beansEspec.CalculadoraEspec;

@ApplicationScoped
public class CalculadoraImplProducer01 implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	static {
		System.out.println("CalculadoraImplProducer01.static");
	}

	public CalculadoraImplProducer01() {
		System.out.println("CalculadoraImplProducer01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("CalculadoraImplProducer01.postConstruct()[" + (this) + "]");
	}

	@Produces
	@RequestScoped
	public CalculadoraEspec createInstance() {
		System.out.println("CalculadoraImplProducer01.createInstance()");

		CalculadoraEspec ce = createInstanceWithImplementation();

		System.out.println("     " + "[ce][" + ce.getClass() + "][" + ce + "]");

		return ce;
	}

	public CalculadoraEspec createInstanceWithImplementation() {
		System.out.println("CalculadoraImplProducer01.createInstanceWithImplementation()");

		return new CalculadoraEspec() {

			static {
				System.out.println("CalculadoraImpl100.static");
			}

			@PostConstruct
			public void postConstruct() {
				System.out.println("CalculadoraImpl100.postConstruct()[" + (this) + "]");
			}

			@Override
			public String getNome() {
				return "CalculadoraImpl100";
			}

			@PreDestroy
			public void preDestroy() {
				System.out.println("CalculadoraImpl100.preDestroy()[" + (this) + "]");
			}

			@SuppressWarnings("deprecation")
			@Override
			protected void finalize() throws Throwable {
				System.out.println("CalculadoraImpl100.finalize()[" + (this) + "]");
				super.finalize();
			}

		};

	}

	public void closeCalculadoraImplProducer01(@Disposes CalculadoraEspec calculadoraEspec) {
		System.out.println("CalculadoraImplProducer01.closeCalculadoraImplProducer01()");
		System.out.println("[calculadoraEspec=" + (calculadoraEspec) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CalculadoraImplProducer01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("CalculadoraImplProducer01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
