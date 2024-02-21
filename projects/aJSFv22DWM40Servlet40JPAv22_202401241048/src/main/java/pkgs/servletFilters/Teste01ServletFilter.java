package pkgs.servletFilters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import pkgs.utils.JSFUtil;

@WebFilter(servletNames = { "Faces Servlet" })
public class Teste01ServletFilter implements Filter {

	public Teste01ServletFilter() {
		System.out.println("Teste01ServletFilter.Teste01ServletFilter()");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Teste01ServletFilter.init()");
		System.out.println("[JSFUtil.getProjectStage()=" + JSFUtil.getProjectStage() + "]");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Teste01ServletFilter.doFilter()");

		chain.doFilter(request, response);

		System.out.println("/Teste01ServletFilter.doFilter()");
	}

	@Override
	public void destroy() {
		System.out.println("Teste01ServletFilter.destroy()");
	}

}
