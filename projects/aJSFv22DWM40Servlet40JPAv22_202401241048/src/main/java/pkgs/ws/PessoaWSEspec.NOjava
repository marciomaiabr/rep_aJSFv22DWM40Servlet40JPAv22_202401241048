package pkgs.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import pkgs.models.Pessoa;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PessoaWSEspec {

	@WebMethod Pessoa buscar(Integer idPessoa);
	// @WebMethod List<Pessoa> listar();
	@WebMethod Pessoa salvar(Pessoa pessoa);
	@WebMethod void apagar(Pessoa pessoa);

}
