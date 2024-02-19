package pkgs.servletFilters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import pkgs.utils.JPAUtil;

@WebFilter(servletNames = { "Faces Servlet" })
public class Teste01ServletFilter implements Filter {

	private EntityManagerFactory entityManagerFactory;

	public Teste01ServletFilter() {
		System.out.println("Teste01ServletFilter.Teste01ServletFilter()");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Teste01ServletFilter.init()");
		entityManagerFactory = JPAUtil.criaEntityManagerFactoryWithCreateNone();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Teste01ServletFilter.doFilter()");

		EntityManager entityManager = null;
		EntityTransaction et = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			et = entityManager.getTransaction();
			et.begin();

			request.setAttribute("entityManager", entityManager);

			chain.doFilter(request, response);

			et.commit();
		} catch (Exception exception1) {
			System.out.println("exception1...");
			exception1.printStackTrace();
			try {
				et.rollback();
			} catch (Exception e) {
			}
		} finally {
			try {
				entityManager.close();
			} catch (Exception e) {
			}
		}

		System.out.println("/Teste01ServletFilter.doFilter()");
	}

	@Override
	public void destroy() {
		System.out.println("Teste01ServletFilter.destroy()");
		try {
			entityManagerFactory.close();
		} catch (Exception e) {
		}
	}

}
