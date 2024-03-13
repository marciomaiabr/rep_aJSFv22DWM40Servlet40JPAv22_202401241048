package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import pkgs.models.Pessoa;
import pkgs.serviceEspec.PessoaServiceEspec;
import pkgs.utils.CDIServiceLocator;

@Named
// @javax.enterprise.context.RequestScoped
@javax.faces.view.ViewScoped
//@javax.enterprise.context.SessionScoped
//@javax.enterprise.context.ApplicationScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240313042500L;

	static {
		System.out.println("Teste01Controller.static");
	}

	public Teste01Controller() {
		System.out.println("Teste01Controller.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01Controller.postConstruct()[" + (this) + "]");
	}

	public long getSerialversionuid() {
		return serialVersionUID;
	}

	public void method01() {
		System.out.println("Teste01Controller.method01()[" + (this) + "]");
		PessoaServiceEspec ps = CDIServiceLocator.getBean(PessoaServiceEspec.class);
		ps.salvar(new Pessoa("Fulano " + java.time.LocalDateTime.now()));
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01Controller.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Teste01Controller.finalize()[" + (this) + "]");
		super.finalize();
	}

}
