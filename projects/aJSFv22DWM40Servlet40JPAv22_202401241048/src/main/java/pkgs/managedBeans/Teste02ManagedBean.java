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
public class Teste02ManagedBean implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	static {
		System.out.println("Teste02ManagedBean.static");
	}

	public Teste02ManagedBean() {
		System.out.println("Teste02ManagedBean.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste02ManagedBean.postConstruct()[" + (this) + "]");
	}

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void method01() {
		System.out.println("Teste02ManagedBean.method01()[" + (this) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste02ManagedBean.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Teste02ManagedBean.finalize()[" + (this) + "]");
		super.finalize();
	}

}
