package pkgs.repositoryJPA;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import pkgs.models.Empresa;
import pkgs.qualifiers.DefaultPersistenceQualifier;
import pkgs.repositoryEspec.EmpresaRepositoryEspec;

@DefaultPersistenceQualifier
public class EmpresaRepositoryJPA implements Serializable, EmpresaRepositoryEspec {

	private static final long serialVersionUID = 20240221040803L;

	@Inject
	private EntityManager em;

	static {
		System.out.println("EmpresaRepositoryJPA.static");
	}

	public EmpresaRepositoryJPA() {
		System.out.println("EmpresaRepositoryJPA.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("EmpresaRepositoryJPA.postConstruct()[" + (this) + "]");
	}

	@Override
	public Empresa get(Integer idEmpresa) {
		System.out.println("EmpresaRepositoryJPA.get()[" + (this) + "]");

		System.out.println("     " + "[em][" + (em != null ? em.getClass().toString() : "") + "][" + em + "]");

		return em.find(Empresa.class, idEmpresa);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("EmpresaRepositoryJPA.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EmpresaRepositoryJPA.finalize()[" + (this) + "]");
		super.finalize();
	}

}
