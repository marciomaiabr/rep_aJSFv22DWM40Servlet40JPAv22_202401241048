package pkgs.repositoryJPA;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import pkgs.models.Pessoa;
import pkgs.repositoryEspec.PessoaRepositoryEspec;

public class PessoaRepositoryJPA implements Serializable, PessoaRepositoryEspec {

	private static final long serialVersionUID = 20240221040803L;

	@Inject
	private EntityManager em;

	static {
		System.out.println("PessoaRepositoryJPA.static");
	}

	public PessoaRepositoryJPA() {
		System.out.println("PessoaRepositoryJPA.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PessoaRepositoryJPA.postConstruct()[" + (this) + "]");
	}

	@Override
	public Pessoa get(Integer idPessoa) {
		System.out.println("PessoaRepositoryJPA.get()[" + (this) + "]");
		return em.find(Pessoa.class, idPessoa);
	}

	@Override
	public List<Pessoa> list() {
		System.out.println("PessoaRepositoryJPA.list()[" + (this) + "]");
		return em.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

	public Pessoa save(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.save()[" + (this) + "]");
		return em.merge(pessoa);
	}

	@Override
	public void delete(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.delete()[" + (this) + "]");
		em.remove(pessoa);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("PessoaRepositoryJPA.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PessoaRepositoryJPA.finalize()[" + (this) + "]");
		super.finalize();
	}

}
