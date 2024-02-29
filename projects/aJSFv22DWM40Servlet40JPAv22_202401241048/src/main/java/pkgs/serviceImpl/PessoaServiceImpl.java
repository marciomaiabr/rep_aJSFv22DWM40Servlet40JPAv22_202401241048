package pkgs.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import pkgs.models.Pessoa;
import pkgs.qualifiers.Transactional;
import pkgs.repositoryEspec.PessoaRepositoryEspec;
import pkgs.serviceEspec.PessoaServiceEspec;

public class PessoaServiceImpl implements Serializable, PessoaServiceEspec {

	private static final long serialVersionUID = 20240221040802L;

	@Inject
	private PessoaRepositoryEspec pre;

	static {
		System.out.println("PessoaServiceImpl.static");
	}

	public PessoaServiceImpl() {
		System.out.println("PessoaServiceImpl.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PessoaServiceImpl.postConstruct()[" + (this) + "]");
	}

	@Override
	public Pessoa buscar(Integer idPessoa) {
		System.out.println("PessoaServiceImpl.buscar()[" + (this) + "]");

		System.out.println("     " + "[pre][" + (pre != null ? pre.getClass().toString() : "") + "][" + pre + "]");

		Pessoa pessoa = pre.get(idPessoa);

		if (pessoa != null)
			System.out.println("     " + "[pessoa][" + (pessoa.getClass()) + "][" + pessoa + "]");
		else
			System.out.println("     " + "[pessoa][" + pessoa + "]");

		return pessoa;
	}

	@Override
	public List<Pessoa> listar() {
		System.out.println("PessoaServiceImpl.listar()[" + (this) + "]");

		System.out.println("     " + "[pre][" + (pre != null ? pre.getClass().toString() : "") + "][" + pre + "]");
		return pre.list();
	}

	@Override
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		System.out.println("PessoaServiceImpl.salvar()[" + (this) + "]");

		System.out.println("     " + "[pre][" + (pre != null ? pre.getClass().toString() : "") + "][" + pre + "]");

		if (pessoa != null)
			System.out.println("     " + "[pessoa][" + (pessoa.getClass()) + "][" + pessoa + "]");
		else
			System.out.println("     " + "[pessoa][" + pessoa + "]");

		Pessoa pessoaRetornoSave = pre.save(pessoa);

		if (pessoaRetornoSave != null)
			System.out.println("     " + "[pessoaRetornoSave][" + (pessoaRetornoSave.getClass()) + "][" + pessoaRetornoSave + "]");
		else
			System.out.println("     " + "[pessoaRetornoSave][" + pessoaRetornoSave + "]");

		return pessoaRetornoSave;
	}

	@Override
	public void apagar(Pessoa pessoa) {
		System.out.println("PessoaServiceImpl.apagar()[" + (this) + "]");

		System.out.println("     " + "[pre][" + (pre != null ? pre.getClass().toString() : "") + "][" + pre + "]");

		pre.delete(pessoa);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("PessoaServiceImpl.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PessoaServiceImpl.finalize()[" + (this) + "]");
		super.finalize();
	}

}
