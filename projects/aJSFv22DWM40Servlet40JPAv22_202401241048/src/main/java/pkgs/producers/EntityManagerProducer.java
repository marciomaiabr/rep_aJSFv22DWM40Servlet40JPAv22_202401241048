package pkgs.producers;

import java.io.Serializable;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pkgs.utils.JPAUtil;

//@javax.enterprise.context.ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 20240221040804L;

	private static EntityManagerFactory emf;

	static {
		System.out.println("EntityManagerProducer.static");
		emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
	}

	public EntityManagerProducer() {
		System.out.println("EntityManagerProducer.()[" + (this) + "]");
	}

	/*@PostConstruct
	public void postConstruct() {
		System.out.println("EntityManagerProducer.postConstruct()[" + (this) + "]");
	}*/

	@Produces
	@javax.enterprise.context.RequestScoped
	public EntityManager createEM() {
		System.out.println("[EntityManagerProducer.createEM()]");
		EntityManager em = emf.createEntityManager();
		System.out.println("     " + "[em][" + em + "][" + em.getTransaction() + "]");
		return em;
	}

	public void closeEM(@Disposes EntityManager em) {
		System.out.println("[EntityManagerProducer.closeEM()]");
		System.out.println("     " + "[em][" + em + "][" + em.getTransaction() + "]");
		em.close();
	}/*

	@PreDestroy
	public void preDestroy() {
		System.out.println("EntityManagerProducer.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EntityManagerProducer.finalize()[" + (this) + "]");
		super.finalize();
	}*/

}
