package pkgs.serviceImpl;

import java.io.Serializable;

import javax.inject.Inject;

import pkgs.models.Pessoa;
import pkgs.repositoryJPA.PessoaRepositoryJPA;
import pkgs.serviceEspec.PessoaServiceEspec;

public class PessoaServiceImpl implements Serializable, PessoaServiceEspec {

	private static final long serialVersionUID = 20240221040802L;

	@Inject
	private PessoaRepositoryJPA pr;

	/*static {
		System.out.println("PessoaServiceImpl.static");
	}

	public PessoaServiceImpl() {
		System.out.println("PessoaServiceImpl.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PessoaServiceImpl.postConstruct()[" + (this) + "]");
	}*/

	public Pessoa salvar(Pessoa pessoa) {
		System.out.println("PessoaServiceImpl.salvar()[" + (this) + "]");

		pr.saveA01(pessoa);
		pr.saveA02(pessoa);
		pr.saveA03(pessoa);

		// pr.save0201(pessoa);
		// pr.save0202(pessoa);
		// pr.save0203(pessoa);

		// System.out.println("     " + "[pessoaRetornoSave][" + pessoaRetornoSave + "]");
		// System.out.println("     " + "[pessoaRetornoSave02][" + pessoaRetornoSave02 + "]");

		return null;
	}

	/*@PreDestroy
	public void preDestroy() {
		System.out.println("PessoaServiceImpl.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PessoaServiceImpl.finalize()[" + (this) + "]");
		super.finalize();
	}*/

}
