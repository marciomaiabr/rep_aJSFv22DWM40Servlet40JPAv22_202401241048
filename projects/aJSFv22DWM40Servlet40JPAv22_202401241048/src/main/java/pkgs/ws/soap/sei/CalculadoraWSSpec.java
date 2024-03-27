package pkgs.ws.soap.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CalculadoraWSSpec {

	@WebMethod
	int somar(int n1, int n2);

}
