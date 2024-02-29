package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import pkgs.beansEspec.BeanEspec;

@SessionScoped
public class BeanImpl01 implements Serializable, BeanEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("BeanImpl01.static");
	}

	public BeanImpl01() {
		System.out.println("BeanImpl01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("BeanImpl01.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "BeanImpl01";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("BeanImpl01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("BeanImpl01.finalize()[" + (this) + "]");
		super.finalize();
	}

}
