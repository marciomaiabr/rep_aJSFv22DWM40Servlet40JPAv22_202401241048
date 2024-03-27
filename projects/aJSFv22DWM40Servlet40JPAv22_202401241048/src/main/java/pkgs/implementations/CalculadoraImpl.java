package pkgs.implementations;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import pkgs.specifications.CalculadoraSpec;

public class CalculadoraImpl implements Serializable, CalculadoraSpec {

	static {
		System.out.println("CalculadoraImpl.static");
	}

	private static final long serialVersionUID = 202403261015L;

	public CalculadoraImpl() {
		System.out.println("CalculadoraImpl.CalculadoraImpl()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("CalculadoraImpl.postConstruct()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CalculadoraImpl.preDestroy()");
	}

	public long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int somar(int n1, int n2) {
		System.out.println("CalculadoraImpl.somar()");
		return n1 + n2;
	}

	@Override
	public int multiplicar(int n1, int n2) {
		System.out.println("CalculadoraImpl.multiplicar()");
		return n1 * n2;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("CalculadoraImpl.finalize()");
		super.finalize();
	}

}
