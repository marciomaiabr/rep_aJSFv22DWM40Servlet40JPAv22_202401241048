package pkgs.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import pkgs.models.Pessoa;
import pkgs.qualifiers.MyTransactional;
import pkgs.repositoryJPA.PessoaRepositoryJPA;
import pkgs.serviceEspec.PessoaServiceEspec;

@MyTransactional
public class PessoaServiceImpl implements Serializable, PessoaServiceEspec {

	private static final long serialVersionUID = 20240221040802L;

	@Inject
	private PessoaRepositoryJPA pr;

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
		return pr.get(idPessoa);
	}

	@Override
	public List<Pessoa> listar() {
		System.out.println("PessoaServiceImpl.listar()[" + (this) + "]");
		return pr.list();
	}

	public Pessoa salvar(Pessoa pessoa) {
		System.out.println("PessoaServiceImpl.salvar()[" + (this) + "]");
		return pr.save(pessoa);
	}

	@Override
	public void apagar(Pessoa pessoa) {
		System.out.println("PessoaServiceImpl.apagar()[" + (this) + "]");
		pr.delete(pessoa);
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
