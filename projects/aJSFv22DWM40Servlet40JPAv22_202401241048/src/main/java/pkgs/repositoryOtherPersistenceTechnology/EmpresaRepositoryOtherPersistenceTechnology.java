package pkgs.repositoryOtherPersistenceTechnology;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Alternative;

import pkgs.models.Empresa;
import pkgs.repositoryEspec.EmpresaRepositoryEspec;

@Alternative
public class EmpresaRepositoryOtherPersistenceTechnology implements Serializable, EmpresaRepositoryEspec {

	private static final long serialVersionUID = 20240221040803L;

	static {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.static");
	}

	public EmpresaRepositoryOtherPersistenceTechnology() {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.postConstruct()[" + (this) + "]");
	}

	@Override
	public Empresa get(Integer idEmpresa) {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.get()[" + (this) + "]");

		throw new UnsupportedOperationException("Método não implementado...");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EmpresaRepositoryOtherPersistenceTechnology.finalize()[" + (this) + "]");
		super.finalize();
	}

}
