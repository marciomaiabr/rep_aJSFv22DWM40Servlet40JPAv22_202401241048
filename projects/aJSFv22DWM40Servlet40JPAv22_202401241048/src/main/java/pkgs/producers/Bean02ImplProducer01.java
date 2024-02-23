package pkgs.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import pkgs.beansEspec.Bean02Espec;

@ApplicationScoped
public class Bean02ImplProducer01 implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	static {
		System.out.println("Bean02ImplProducer01.static");
	}

	public Bean02ImplProducer01() {
		System.out.println("Bean02ImplProducer01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean02ImplProducer01.postConstruct()[" + (this) + "]");
	}

	@Produces
	@RequestScoped
	public Bean02Espec createInstance() {
		System.out.println("Bean02ImplProducer01.createInstance()");

		Bean02Espec b02e = createInstanceWithImplementation();

		System.out.println("     " + "[b02e][" + b02e.getClass() + "][" + b02e + "]");

		return b02e;
	}

	public Bean02Espec createInstanceWithImplementation() {
		System.out.println("Bean02ImplProducer01.createInstanceWithImplementation()");

		return new Bean02Espec() {

			static {
				System.out.println("Bean02ImplProducer01.createInstanceWithImplementation().static");
			}

			@PostConstruct
			public void postConstruct() {
				System.out.println(
						"Bean02ImplProducer01.createInstanceWithImplementation().postConstruct()[" + (this) + "]");
			}

			@Override
			public String getNome() {
				return "Bean02EspecImpl";
			}

			@PreDestroy
			public void preDestroy() {
				System.out.println(
						"Bean02ImplProducer01.createInstanceWithImplementation().preDestroy()[" + (this) + "]");
			}

			@SuppressWarnings("deprecation")
			@Override
			protected void finalize() throws Throwable {
				System.out
						.println("Bean02ImplProducer01.createInstanceWithImplementation().finalize()[" + (this) + "]");
				super.finalize();
			}

		};

	}

	public void closeInstance(@Disposes Bean02Espec bean02Espec) {
		System.out.println("Bean02ImplProducer01.closeInstance()");
		System.out.println("[bean02Espec=" + (bean02Espec) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean02ImplProducer01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Bean02ImplProducer01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
