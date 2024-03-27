package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pkgs.specifications.CalculadoraSpec;

@Named
@ViewScoped
public class Controller01 implements Serializable {

	static {
		System.out.println("Controller01.static");
	}

	@Inject
	private CalculadoraSpec calculadora;

	private static final long serialVersionUID = 202403260935L;

	public Controller01() {
		System.out.println("Controller01.Controller01()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Controller01.postConstruct()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Controller01.preDestroy()");
	}

	public long getSerialversionuid() {
		return serialVersionUID;
	}

	public void mTst() {
		System.out.println("Controller01.mTst()");
		System.out.println("[" + (calculadora) + "][" + (calculadora.somar(7, 3)) + "]");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Controller01.finalize()");
		super.finalize();
	}

}
