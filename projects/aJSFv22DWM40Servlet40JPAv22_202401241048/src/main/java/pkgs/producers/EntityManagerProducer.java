package pkgs.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pkgs.utils.JPAUtil;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	private EntityManagerFactory emf;

	static {
		System.out.println("EntityManagerProducer.static");
	}

	public EntityManagerProducer() {
		System.out.println("EntityManagerProducer.()[" + (this) + "]");

		emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("EntityManagerProducer.postConstruct()[" + (this) + "]");
	}

	@Produces
	@RequestScoped
	public EntityManager createEM() {
		System.out.println("EntityManagerProducer.createEM()");
		System.out.println("     " + "[emf][" + (emf != null ? emf.getClass().toString() : "") + "][" + emf + "]");
		return emf.createEntityManager();
	}

	public void closeEM(@Disposes EntityManager entityManager) {
		System.out.println("EntityManagerProducer.closeEM()");
		System.out.println("     " + "[emf][" + (emf != null ? emf.getClass().toString() : "") + "][" + emf + "]");
		entityManager.close();
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("EntityManagerProducer.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EntityManagerProducer.finalize()[" + (this) + "]");
		super.finalize();
	}

}
