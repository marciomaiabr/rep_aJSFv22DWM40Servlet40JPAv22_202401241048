package pkgs.repositoryHibernate;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Alternative;

import pkgs.models.Empresa;
import pkgs.repositoryEspec.EmpresaRepositoryEspec;

@Alternative
public class EmpresaRepositoryHibernate implements Serializable, EmpresaRepositoryEspec {

	private static final long serialVersionUID = 20240221040803L;

	static {
		System.out.println("EmpresaRepositoryHibernate.static");
	}

	public EmpresaRepositoryHibernate() {
		System.out.println("EmpresaRepositoryHibernate.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("EmpresaRepositoryHibernate.postConstruct()[" + (this) + "]");
	}

	@Override
	public Empresa get(Integer idEmpresa) {
		System.out.println("EmpresaRepositoryHibernate.get()[" + (this) + "]");

		throw new UnsupportedOperationException("Método não implementado...");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("EmpresaRepositoryHibernate.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EmpresaRepositoryHibernate.finalize()[" + (this) + "]");
		super.finalize();
	}

}
