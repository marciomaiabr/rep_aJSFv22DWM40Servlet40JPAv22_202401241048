package pkgs.serviceImpl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import pkgs.models.Empresa;
import pkgs.qualifiers.DefaultPersistenceQualifier;
import pkgs.repositoryEspec.EmpresaRepositoryEspec;
import pkgs.serviceEspec.EmpresaServiceEspec;

public class EmpresaServiceImpl implements Serializable, EmpresaServiceEspec {

	private static final long serialVersionUID = 20240221040802L;

	@Inject @DefaultPersistenceQualifier
	private EmpresaRepositoryEspec ere;

	static {
		System.out.println("EmpresaServiceImpl.static");
	}

	public EmpresaServiceImpl() {
		System.out.println("EmpresaServiceImpl.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("EmpresaServiceImpl.postConstruct()[" + (this) + "]");
	}

	@Override
	public Empresa buscar(Integer idEmpresa) {
		System.out.println("EmpresaServiceImpl.buscar()[" + (this) + "]");

		System.out.println("     " + "[ere][" + (ere != null ? ere.getClass().toString() : "") + "][" + ere + "]");

		return ere.get(idEmpresa);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("EmpresaServiceImpl.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EmpresaServiceImpl.finalize()[" + (this) + "]");
		super.finalize();
	}

}
