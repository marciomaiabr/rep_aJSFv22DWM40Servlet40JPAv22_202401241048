package pkgs.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import pkgs.beansImpl.Bean01NoEspec;

public class Bean01NoEspecProducer01 implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	static {
		System.out.println("Bean01NoEspecProducer01.static");
	}

	public Bean01NoEspecProducer01() {
		System.out.println("Bean01NoEspecProducer01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean01NoEspecProducer01.postConstruct()[" + (this) + "]");
	}

	@Produces
	//@javax.enterprise.context.RequestScoped
	//@javax.faces.view.ViewScoped
	//@javax.enterprise.context.SessionScoped
	public Bean01NoEspec createInstance() {
		System.out.println("Bean01NoEspecProducer01.createInstance()");

		Bean01NoEspec bean = new Bean01NoEspec("QQC");

		System.out.println("     " + "[bean][" + bean.getClass() + "][" + bean + "]");

		return bean;
	}

	public void closeInstance(@Disposes Bean01NoEspec bean01NoEspec) {
		System.out.println("Bean01NoEspecProducer01.closeInstance()");
		System.out.println("[bean01NoEspec=" + (bean01NoEspec) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean01NoEspecProducer01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Bean01NoEspecProducer01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
