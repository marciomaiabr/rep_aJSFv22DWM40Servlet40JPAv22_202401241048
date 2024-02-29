package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;

import pkgs.beansEspec.BeanEspec;

@SessionScoped
@Priority(1)
@Alternative
public class BeanImpl02 implements Serializable, BeanEspec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("BeanImpl02.static");
	}

	public BeanImpl02() {
		System.out.println("BeanImpl02.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("BeanImpl02.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "BeanImpl02";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("BeanImpl02.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("BeanImpl02.finalize()[" + (this) + "]");
		super.finalize();
	}

}
