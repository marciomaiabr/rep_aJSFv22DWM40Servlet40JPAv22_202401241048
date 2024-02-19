package pkgs.mbs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Cidade;
import pkgs.models.Estado;
import pkgs.utils.JSFUtil;

@ManagedBean
@ViewScoped
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

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();

		estadoOK = (Estado) httpServletRequest.getAttribute("estado");
		cidadeOK = (Cidade) httpServletRequest.getAttribute("cidade");

		listarEstados();
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

	private Estado estadoOK;

	public Estado getEstadoOK() {
		return estadoOK;
	}

	private Cidade cidadeOK;

	public Cidade getCidadeOK() {
		return cidadeOK;
	}

	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		System.out.println("Teste01MB.setCidade()");
		System.out.println("     " + "[cidade=" + cidade + "][this.cidade=" + this.cidade + "]");

		this.cidade = cidade;
	}

	private void souts() {
		System.out.println("     " + "[this.estados=" + this.estados + "]");
		System.out.println("     " + "[this.estado=" + this.estado + "]");
		System.out.println("     " + "[this.cidade=" + this.cidade + "]");
	}

	public void methodViewAction() {
		System.out.println("Teste01MB.methodViewAction()");

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

		souts();
	}

	public void commandButtonEstadoActionListener() {
		System.out.println("Teste01MB.commandButtonEstadoActionListener()");

		souts();
	}

	public void commandButtonCidadeClick() {
		System.out.println("Teste01MB.commandButtonCidadeClick()");

		souts();
	}

	public void commandButtonCidadeAjaxListener() {
		System.out.println("Teste01MB.commandButtonCidadeAjaxListener()");

		souts();
	}

	public void commandButtonCidadeActionListener() {
		System.out.println("Teste01MB.commandButtonCidadeActionListener()");

		souts();
	}

	public void reload() {
		System.out.println("Teste01MB.reload()");

		souts();
	}

	public String confirmar() {
		System.out.println("Teste01MB.confirmar()");

		souts();

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();

		httpServletRequest.setAttribute("estado", estado);
		httpServletRequest.setAttribute("cidade", cidade);

		return "Page02.xhtml";
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");

		souts();
	}

}
