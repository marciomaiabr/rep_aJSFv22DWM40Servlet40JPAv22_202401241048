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

	public Teste01ServletFilter() {
		System.out.println("Teste01ServletFilter.Teste01ServletFilter()");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Teste01ServletFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Teste01ServletFilter.doFilter()");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Teste01ServletFilter.destroy()");
	}

}
