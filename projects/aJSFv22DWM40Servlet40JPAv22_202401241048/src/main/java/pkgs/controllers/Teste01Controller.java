package pkgs.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pkgs.beansImpl.CalculadoraImpl01;
import pkgs.beansImpl.CalculadoraImpl02;
import pkgs.beansImpl.CalculadoraImpl03;
import pkgs.utils.CDIServiceLocator;

@Named
@ViewScoped
public class Teste01Controller implements Serializable {

	private static final long serialVersionUID = 20240221040801L;

	private CalculadoraEspec calculadoraEspec;

	static {
		System.out.println("Teste01Controller.static");
	}

	public Teste01Controller() {
		System.out.println("Teste01Controller.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01Controller.postConstruct()[" + (this) + "]");
	}

	public void setCalculadoraImpl01() {
		System.out.println("Teste01Controller.setCalculadoraImpl01()[" + (this) + "]");
		CalculadoraImpl01 calculadoraImpl01 = CDIServiceLocator.getBean(CalculadoraImpl01.class);
		System.out.println("[calculadoraImpl01=" + (calculadoraImpl01) + "][calculadoraImpl01.getClass()=" + (calculadoraImpl01.getClass()) + "]");
		calculadoraEspec = (CalculadoraEspec) calculadoraImpl01;
	}

	public void setCalculadoraImpl02() {
		System.out.println("Teste01Controller.setCalculadoraImpl02()[" + (this) + "]");
		CalculadoraImpl02 calculadoraImpl02 = CDIServiceLocator.getBean(CalculadoraImpl02.class);
		System.out.println("[calculadoraImpl02=" + (calculadoraImpl02) + "][calculadoraImpl02.getClass()=" + (calculadoraImpl02.getClass()) + "]");
		calculadoraEspec = (CalculadoraEspec) calculadoraImpl02;
	}

	public void setCalculadoraImpl03() {
		System.out.println("Teste01Controller.setCalculadoraImpl03()[" + (this) + "]");
		CalculadoraImpl03 calculadoraImpl03 = CDIServiceLocator.getBean(CalculadoraImpl03.class);
		System.out.println("[calculadoraImpl03=" + (calculadoraImpl03) + "][calculadoraImpl03.getClass()=" + (calculadoraImpl03.getClass()) + "]");
		calculadoraEspec = (CalculadoraEspec) calculadoraImpl03;
	}

	public void calcula() {
		System.out.println("Teste01Controller.calcula()[" + (this) + "]");
		System.out.println("[calculadoraEspec=" + (calculadoraEspec) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01Controller.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Teste01Controller.finalize()[" + (this) + "]");
		super.finalize();
	}

}
