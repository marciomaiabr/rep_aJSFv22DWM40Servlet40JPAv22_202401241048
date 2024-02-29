package pkgs.repositoryJPA;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

		System.out.println("     " + "[em][" + (em != null ? em.getClass().toString() : "") + "][" + em + "]");

		Pessoa pessoa = em.find(Pessoa.class, idPessoa);

		if (pessoa != null)
			System.out.println("     " + "[pessoa][" + (pessoa.getClass()) + "][" + pessoa + "]");
		else
			System.out.println("     " + "[pessoa][" + pessoa + "]");

		return pessoa;
	}

	@Override
	public List<Pessoa> list() {
		System.out.println("PessoaRepositoryJPA.list()[" + (this) + "]");

		System.out.println("     " + "[em][" + (em != null ? em.getClass().toString() : "") + "][" + em + "]");

		return em.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

	@Override
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.save1()[" + (this) + "]");

		System.out.println("     " + "[em][" + (em != null ? em.getClass().toString() : "") + "][" + em + "]");

		if (pessoa != null)
			System.out.println("     " + "[pessoa][" + (pessoa.getClass()) + "][" + pessoa + "]");
		else
			System.out.println("     " + "[pessoa][" + pessoa + "]");

		Pessoa pessoaRetornoMerge = em.merge(pessoa);

		if (pessoaRetornoMerge != null)
			System.out.println("     " + "[pessoaRetornoMerge][" + (pessoaRetornoMerge.getClass()) + "][" + pessoaRetornoMerge + "]");
		else
			System.out.println("     " + "[pessoaRetornoMerge][" + pessoaRetornoMerge + "]");

		return pessoaRetornoMerge;
	}

	@Override
	public void delete(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.delete()[" + (this) + "]");

		System.out.println("     " + "[em][" + (em != null ? em.getClass().toString() : "") + "][" + em + "]");

		if (pessoa != null)
			System.out.println("     " + "[pessoa][" + (pessoa.getClass()) + "][" + pessoa + "]");
		else
			System.out.println("     " + "[pessoa][" + pessoa + "]");

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
