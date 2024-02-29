package pkgs.interceptors;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = 20240228104000L;

	@Inject
	private EntityManager entityManager;

	static {
		System.out.println("TransactionalInterceptor.static");
	}

	public TransactionalInterceptor() {
		System.out.println("TransactionalInterceptor.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("TransactionalInterceptor.postConstruct()[" + (this) + "]");
	}

	@AroundInvoke
	private Object invoke(InvocationContext context) throws Exception {
		System.out.println("TransactionalInterceptor.invoke()");

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("[entityTransaction=" + (entityTransaction) + "]");

		boolean criador = false;

		try {
			if (!entityTransaction.isActive()) {
				entityTransaction.begin();
				entityTransaction.rollback();

				entityTransaction.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (entityTransaction != null && criador) {
				entityTransaction.rollback();
			}

			throw e;
		} finally {
			if (entityTransaction != null && entityTransaction.isActive() && criador) {
				entityTransaction.commit();
			}

		}
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("TransactionalInterceptor.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("TransactionalInterceptor.finalize()[" + (this) + "]");
		super.finalize();
	}

}
