package pkgs.ws;

import java.io.Serializable;

import javax.jws.WebService;

import pkgs.models.Pessoa;

@WebService(endpointInterface = "pkgs.ws.PessoaWSEspec")
public class PessoaWSImpl implements Serializable, PessoaWSEspec {

	private static final long serialVersionUID = 20240221040802L;

	static {
		System.out.println("PessoaWSImpl.static");
	}

	public PessoaWSImpl() {
		System.out.println("PessoaWSImpl.()[" + (this) + "]");
	}

	/*@PostConstruct
	public void postConstruct() {
		System.out.println("PessoaWSImpl.postConstruct()[" + (this) + "]");
	}*/

	@Override
	public Pessoa buscar(Integer idPessoa) {
		System.out.println("PessoaWSImpl.buscar()[" + (this) + "]");
		return null;//pr.get(idPessoa);
	}

	/*@Override
	public List<Pessoa> listar() {
		System.out.println("PessoaWSImpl.listar()[" + (this) + "]");
		return pr.list();
	}*/

	public Pessoa salvar(Pessoa pessoa) {
		System.out.println("PessoaWSImpl.salvar()[" + (this) + "]");
		return null;//pr.save(pessoa);
	}

	@Override
	public void apagar(Pessoa pessoa) {
		System.out.println("PessoaWSImpl.apagar()[" + (this) + "]");
		//pr.delete(pessoa);
	}

	/*@PreDestroy
	public void preDestroy() {
		System.out.println("PessoaWSImpl.preDestroy()[" + (this) + "]");
	}*/

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PessoaWSImpl.finalize()[" + (this) + "]");
		super.finalize();
	}

}
