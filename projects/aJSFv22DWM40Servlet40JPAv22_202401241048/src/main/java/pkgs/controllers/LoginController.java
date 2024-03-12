package pkgs.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkgs.models.Usuario;
import pkgs.utils.JSFUtil;

@Named
@javax.enterprise.context.SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 20240221040801L;
	private String email;

	static {
		System.out.println("LoginController.static");
	}

	public LoginController() {
		System.out.println("LoginController.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("LoginController.postConstruct()[" + (this) + "]");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void checkLoginOk() {
		System.out.println("LoginController.checkLoginOk()[" + (this) + "]");
		boolean invalid = JSFUtil.getRequest().getParameter("invalid") != null;
		System.out.println("[invalid=" + (invalid) + "]");
		if (invalid) {
			JSFUtil.addErrorMessageGlobal("Login inválido !");
		}
	}

	public void logOn() throws ServletException, IOException {
		System.out.println("LoginController.logOn()[" + (this) + "]");
		HttpServletRequest request = JSFUtil.getRequest();
		HttpServletResponse response = JSFUtil.getResponse();
		FacesContext facesContext = JSFUtil.getFacesContext();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/j_spring_security_check");
		requestDispatcher.forward(request, response);
		facesContext.responseComplete();
	}
	public Usuario getUsuarioLogado() {
		System.out.println("LoginController.getUsuarioLogado()");
		return JSFUtil.buscaUsuarioLogado();
	}

	public boolean isLogado() {
		System.out.println("LoginController.isLogado()");
		return getUsuarioLogado() != null;
	}

	public void logOff() {
		System.out.println("LoginController.logOff()[" + (this) + "]");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("LoginController.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("LoginController.finalize()[" + (this) + "]");
		super.finalize();
	}

}
