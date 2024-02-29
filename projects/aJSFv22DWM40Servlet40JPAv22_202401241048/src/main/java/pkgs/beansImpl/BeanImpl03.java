package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import pkgs.beansEspec.BeanEspec;

@SessionScoped
public class BeanImpl03 implements Serializable, BeanEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("BeanImpl03.static");
	}

	public BeanImpl03() {
		System.out.println("BeanImpl03.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("BeanImpl03.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "BeanImpl03";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("BeanImpl03.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("BeanImpl03.finalize()[" + (this) + "]");
		super.finalize();
	}

}
