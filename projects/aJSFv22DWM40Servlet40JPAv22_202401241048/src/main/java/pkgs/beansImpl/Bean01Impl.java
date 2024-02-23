package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import pkgs.beansEspec.Bean01Espec;

@SessionScoped
public class Bean01Impl implements Serializable, Bean01Espec {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("Bean01Impl.static");
	}

	public Bean01Impl() {
		System.out.println("Bean01Impl.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean01Impl.postConstruct()[" + (this) + "]");
	}

	@Override
	public String getNome() {
		return "Bean01Impl";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean01Impl.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Bean01Impl.finalize()[" + (this) + "]");
		super.finalize();
	}

}
