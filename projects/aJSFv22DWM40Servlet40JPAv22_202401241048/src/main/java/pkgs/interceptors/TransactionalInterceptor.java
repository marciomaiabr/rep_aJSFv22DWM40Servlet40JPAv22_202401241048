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

import pkgs.qualifiers.MyTransactional;

@Interceptor
@MyTransactional
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
		System.out.println("[entityManager=" + (entityManager) + "]");

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("[entityTransaction=" + (entityTransaction) + "]");

		boolean criador = false;

		try {
			System.out.println("TransactionalInterceptor.invoke().try");
			if (!entityTransaction.isActive()) {
				System.out.println("TransactionalInterceptor.invoke().try.if");
				entityTransaction.begin();
				entityTransaction.rollback();

				entityTransaction.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			System.out.println("TransactionalInterceptor.invoke().catch");
			if (entityTransaction != null && criador) {
				System.out.println("TransactionalInterceptor.invoke().catch.rollback");
				entityTransaction.rollback();
			}

			throw e;
		} finally {
			System.out.println("TransactionalInterceptor.invoke().finally");
			if (entityTransaction != null && entityTransaction.isActive() && criador) {
				System.out.println("TransactionalInterceptor.invoke().commit");
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
