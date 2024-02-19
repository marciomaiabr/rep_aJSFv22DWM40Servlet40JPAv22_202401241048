package pkgs.mbs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Estado;
import pkgs.utils.JSFUtil;

@ManagedBean
public class Teste01MB {

	static {
		System.out.println("Teste01MB.static");
		System.out.println("[JSFUtil.getProjectStage()=" + JSFUtil.getProjectStage() + "]");
	}

	public Teste01MB() {
		System.out.println("Teste01MB.()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01MB.postConstruct()");

		souts();
	}

	private List<Estado> estados;

	public List<Estado> getEstados() {
		System.out.println("Teste01MB.getEstados()");
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		System.out.println("Teste01MB.setEstados()");
		this.estados = estados;
	}

	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		System.out.println("Teste01MB.setEstado()");
		System.out.println("     " + "[estado=" + estado + "][this.estado=" + this.estado + "]");
		this.estado = estado;
	}

	private void souts() {
		System.out.println("     " + "[this.estado=" + this.estado + "]");
		System.out.println("     " + "[this.estados=" + this.estados + "]");
	}

	public void methodViewAction() {
		System.out.println("Teste01MB.methodViewAction()");

		listarEstados();

		souts();
	}

	public void listarEstados() {
		System.out.println("Teste01MB.listarEstados()");

		souts();

		HttpServletRequest request = JSFUtil.getRequest();

		EntityManager em = (EntityManager) request.getAttribute("entityManager");

		this.estados = em.createQuery("from Estado", Estado.class).getResultList();
	}

	public void commandButtonEstadoClick() {
		System.out.println("Teste01MB.commandButtonEstadoClick()");

		souts();
	}

	public void commandButtonEstadoAjaxListener() {
		System.out.println("Teste01MB.commandButtonEstadoAjaxListener()");

		listarEstados();

		souts();
	}

	public void commandButtonEstadoActionListener() {
		System.out.println("Teste01MB.commandButtonEstadoActionListener()");

		souts();
	}

	public void reload() {
		System.out.println("Teste01MB.reload()");

		souts();
	}

	public void confirmar() {
		System.out.println("Teste01MB.confirmar()");

		souts();
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");

		souts();
	}

}
