package pkgs.ws.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import pkgs.specifications.CalculadoraSpec;

@Path("calcRest")
public class CalculadoraRest {

	@Inject
	private CalculadoraSpec calculadora;

	@GET
	@Path("/multiplicar/{n1}/{n2}")
	public int multiplicar(@PathParam("n1") final int n1, @PathParam("n2") final int n2) {
		System.out.println("CalculadoraRest.multiplicar()");
		return calculadora.multiplicar(n1, n2);
	}

}
