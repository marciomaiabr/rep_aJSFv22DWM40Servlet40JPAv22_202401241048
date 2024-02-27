package pkgs.beansImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Bean01NoEspec implements Serializable {

	private static final long serialVersionUID = 20240222085601L;

	static {
		System.out.println("Bean01NoEspec.static");
	}

	public Bean01NoEspec() {
		System.out.println("Bean01NoEspec.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean01NoEspec.postConstruct()[" + (this) + "]");
	}

	public String getNome() {
		return "Bean01NoEspec";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean01NoEspec.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Bean01NoEspec.finalize()[" + (this) + "]");
		super.finalize();
	}

}
