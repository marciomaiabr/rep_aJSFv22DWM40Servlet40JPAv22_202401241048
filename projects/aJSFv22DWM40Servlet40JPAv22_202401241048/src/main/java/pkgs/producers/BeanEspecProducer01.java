package pkgs.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import pkgs.beansEspec.BeanEspec;

//@javax.enterprise.context.RequestScoped
//@javax.faces.view.ViewScoped
@javax.enterprise.context.SessionScoped
public class BeanEspecProducer01 implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	static {
		System.out.println("BeanEspecProducer01.static");
	}

	public BeanEspecProducer01() {
		System.out.println("BeanEspecProducer01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("BeanEspecProducer01.postConstruct()[" + (this) + "]");
	}

	@Produces
	@javax.faces.view.ViewScoped
	public BeanEspec createInstance() {
		System.out.println("BeanEspecProducer01.createInstance()");

		BeanEspec theInstance = createInstanceWithImplementation();

		System.out.println("     " + "[theInstance][" + theInstance.getClass() + "][" + theInstance + "]");

		return theInstance;
	}

	public BeanEspec createInstanceWithImplementation() {
		System.out.println("BeanEspecProducer01.createInstanceWithImplementation.()");

		return new BeanEspec() {

			private static final long serialVersionUID = 20240229034301L;

			static {
				System.out.println("BeanEspecProducer01.createInstanceWithImplementation().static");
			}

			@PostConstruct
			public void postConstruct() {
				System.out.println(
						"BeanEspecProducer01.createInstanceWithImplementation().postConstruct()[" + (this) + "]");
			}

			@Override
			public String getNome() {
				return "BeanEspecImpl";
			}

			@PreDestroy
			public void preDestroy() {
				System.out.println(
						"BeanEspecProducer01.createInstanceWithImplementation().preDestroy()[" + (this) + "]");
			}

			@SuppressWarnings("deprecation")
			@Override
			protected void finalize() throws Throwable {
				System.out
						.println("BeanEspecProducer01.createInstanceWithImplementation().finalize()[" + (this) + "]");
				super.finalize();
			}

		};

	}

	public void closeInstance(@Disposes BeanEspec theInstance) {
		System.out.println("BeanEspecProducer01.closeInstance()");
		System.out.println("[theInstance" + (theInstance) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("BeanEspecProducer01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("BeanEspecProducer01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
