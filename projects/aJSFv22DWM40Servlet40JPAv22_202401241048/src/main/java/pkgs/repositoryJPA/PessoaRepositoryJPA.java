package pkgs.repositoryJPA;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import pkgs.models.Pessoa;

public class PessoaRepositoryJPA implements Serializable {

	private static final long serialVersionUID = 20240221040803L;

	@Inject
	private EntityManager emP;
	// @Inject
	// private EntityManager emS;

	/*static {
		System.out.println("PessoaRepositoryJPA.static");
	}

	public PessoaRepositoryJPA() {
		System.out.println("PessoaRepositoryJPA.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PessoaRepositoryJPA.postConstruct()[" + (this) + "]");
	}*/

	public Pessoa saveA01(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.saveA01()[" + (this) + "]");
		System.out.println("     " + "[saveA01][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]");
		return emP.merge(new Pessoa("[saveA01][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]"));
	}

	public Pessoa saveA02(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.saveA02()[" + (this) + "]");
		System.out.println("     " + "[saveA02][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]");
		return emP.merge(new Pessoa("[saveA02][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]"));
		// throw new RuntimeException("TesteMM...");
	}

	public Pessoa saveA03(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.saveA03()[" + (this) + "]");
		System.out.println("     " + "[saveA03][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]");
		return emP.merge(new Pessoa("[saveA03][emP][" + (emP.getClass()) + "][" + emP + "][" + emP.getTransaction() + "]"));
	}

	/*@PreDestroy
	public void preDestroy() {
		System.out.println("PessoaRepositoryJPA.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PessoaRepositoryJPA.finalize()[" + (this) + "]");
		super.finalize();
	}*/

}
