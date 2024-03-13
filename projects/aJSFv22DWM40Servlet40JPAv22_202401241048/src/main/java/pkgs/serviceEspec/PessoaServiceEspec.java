package pkgs.serviceEspec;

import java.util.List;

import pkgs.models.Pessoa;

public interface PessoaServiceEspec {

	Pessoa buscar(Integer idPessoa);
	List<Pessoa> listar();
	Pessoa salvar(Pessoa pessoa);
	void apagar(Pessoa pessoa);

}
