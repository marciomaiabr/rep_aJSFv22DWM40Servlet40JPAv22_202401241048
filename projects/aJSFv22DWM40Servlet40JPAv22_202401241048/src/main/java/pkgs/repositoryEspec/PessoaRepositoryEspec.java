package pkgs.repositoryEspec;

import java.util.List;

import pkgs.models.Pessoa;

public interface PessoaRepositoryEspec {

	Pessoa get(Integer idPessoa);
	List<Pessoa> list();
	Pessoa save(Pessoa pessoa);
	void delete(Pessoa pessoa);

}
