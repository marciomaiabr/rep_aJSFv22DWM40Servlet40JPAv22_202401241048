package pkgs.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pkgs.controllers.Teste01Controller;

@ManagedBean
@SessionScoped
public class Teste01ManagedBean implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	static {
		System.out.println("Teste01ManagedBean.static");
	}

	public Teste01ManagedBean() {
		System.out.println("Teste01ManagedBean.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01ManagedBean.postConstruct()[" + (this) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01ManagedBean.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Teste01ManagedBean.finalize()[" + (this) + "]");
		super.finalize();
	}

}
