package pkgs.ws.soap.sib;

import javax.inject.Inject;
import javax.jws.WebService;

import pkgs.specifications.CalculadoraSpec;
import pkgs.ws.soap.sei.CalculadoraWSSpec;

@WebService(endpointInterface = "pkgs.ws.soap.sei.CalculadoraWSSpec")
public class CalculadoraWSImpl implements CalculadoraWSSpec {

	@Inject
	private CalculadoraSpec calculadora;

	@Override
	public int somar(int n1, int n2) {
		System.out.println("CalculadoraWSImpl.somar()");
		return calculadora.somar(n1, n2);
	}

}

/*
http://localhost:8080/aJSFv22DWM40Servlet40JPAv22_202401241048/CalculadoraWSImpl?wsdl
*/
