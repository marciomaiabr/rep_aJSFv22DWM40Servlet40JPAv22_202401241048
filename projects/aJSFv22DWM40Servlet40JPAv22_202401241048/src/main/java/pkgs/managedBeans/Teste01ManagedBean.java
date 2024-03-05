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

	@ManagedProperty("#{teste01Controller}")
	private Teste01Controller nm;

	public Teste01Controller getNm() {
		return nm;
	}

	public void setNm(Teste01Controller nm) {
		this.nm = nm;
	}

	@ManagedProperty("#{teste02ManagedBean}")
	private Teste02ManagedBean t02mb;

	public Teste02ManagedBean getT02mb() {
		return t02mb;
	}

	public void setT02mb(Teste02ManagedBean t02mb) {
		this.t02mb = t02mb;
	}

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

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void method01() {
		System.out.println("Teste01ManagedBean.method01()[" + (this) + "]");

		System.out.println("[" + (nm) + "]");
		if (nm != null)
			System.out.println("[" + (nm.getNome()) + "]");

		System.out.println("[" + (t02mb) + "]");
		if (t02mb != null)
		System.out.println("[" + (t02mb.getNome()) + "]");
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
