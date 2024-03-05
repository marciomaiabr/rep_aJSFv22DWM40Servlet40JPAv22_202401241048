package pkgs.interceptors;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pkgs.qualifiers.MyTransactional01;

@Interceptor
@MyTransactional01
public class TransactionalInterceptor01 implements Serializable {

	private static final long serialVersionUID = 20240228104000L;

	@Inject
	private EntityManager em;

	/*static {
		System.out.println("TransactionalInterceptor01.static");
	}

	public TransactionalInterceptor01() {
		System.out.println("TransactionalInterceptor01.()[" + (this) + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("TransactionalInterceptor01.postConstruct()[" + (this) + "]");
	}*/

	@AroundInvoke
	private Object invoke(InvocationContext context) throws Exception {
		System.out.println("TransactionalInterceptor01.invoke()");

		EntityTransaction et = em.getTransaction();

		System.out.println("[TransactionalInterceptor01.invoke()][em=" + (em) + "][et=" + (et) + "]");

		boolean criador = false;

		try {
			System.out.println("TransactionalInterceptor01.invoke().try");
			if (!et.isActive()) {
				System.out.println("TransactionalInterceptor01.invoke().try.if");
				et.begin();
				et.rollback();

				et.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			System.out.println("TransactionalInterceptor01.invoke().catch");
			if (et != null && criador) {
				System.out.println("[TransactionalInterceptor01.invoke().catch.rollback()][em=" + (em) + "][et=" + (et) + "]");
				et.rollback();
			}

			throw e;
		} finally {
			System.out.println("TransactionalInterceptor01.invoke().finally");
			if (et != null && et.isActive() && criador) {
				System.out.println("[TransactionalInterceptor01.invoke().commit()][em=" + (em) + "][et=" + (et) + "]");
				et.commit();
			}

		}
	}

	/*@PreDestroy
	public void preDestroy() {
		System.out.println("TransactionalInterceptor01.preDestroy()[" + (this) + "]");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		System.out.println("TransactionalInterceptor01.finalize()[" + (this) + "]");
		super.finalize();
	}*/

}
