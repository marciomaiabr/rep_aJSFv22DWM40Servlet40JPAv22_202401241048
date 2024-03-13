package pkgs.utils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgs.models.Usuario;

public class JSFUtil {

	public static HttpServletRequest getRequest() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();

		return httpServletRequest;
	}

	public static HttpServletResponse getResponse() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext.getResponse();

		return httpServletResponse;
	}

	public static FacesContext getFacesContext() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		return facesContext;
	}

	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	public static Principal getUserPrincipal() {
		return getExternalContext().getUserPrincipal();
	}

	public static void addErrorMessageGlobal(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	public static ProjectStage getProjectStage() {
		ProjectStage projectStage = FacesContext.getCurrentInstance().getApplication().getProjectStage();

		return projectStage;
	}

	public static List<String> listCDIBeans() {
		System.out.println("JSFUtil.listCDIBeans()");

		List<String> listCDIBeansWithOutInstance = new ArrayList<>();
		List<String> listCDIBeansWithInstance = new ArrayList<>();
		List<String> listCDIBeans = new ArrayList<>();

		try {
			InitialContext initialContext = new InitialContext();
			BeanManager bm = (BeanManager) initialContext.lookup("java:comp/env/BeanManager");

			// Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(Object.class);
			Set<Bean<?>> beans = bm.getBeans(Object.class, new AnnotationLiteral<Any>() {
			});

			Iterator it = beans.iterator();

			while (it.hasNext()) {
				Object object = it.next();
				Bean bean = (Bean) object;
				// System.out.println("[object=" + (object) + "]");
				// System.out.println("[bean=" + (bean) + "]");
				CreationalContext creationalContext = bm.createCreationalContext(bean);
				// Get a reference to the Context for the scope of the Bean
				Context context = bm.getContext(bean.getScope());
				// Get a reference to the instantiated bean, or null if none exists
				Object instance = context.get(bean);
				if (bean.getClass().getName().startsWith("pkgs.")
						|| bean.getBeanClass().getName().startsWith("pkgs.")) {
					if (instance == null) {
						listCDIBeansWithOutInstance.add("[bean=" + (bean) + "]");
					} else {
						StringBuffer sb = new StringBuffer();
						sb.append("\n");
						sb.append("\n[bean=" + (bean) + "]");
						sb.append("\n[creationalContext=" + (creationalContext) + "]");
						sb.append("\n[context=" + (context) + "]");
						sb.append("\n[beanInstance=" + (instance) + "]");
						sb.append("\n");
						listCDIBeansWithInstance.add(sb.toString());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		listCDIBeans.add("CDIBeansWithInstance");
		listCDIBeans.addAll(listCDIBeansWithInstance);
		listCDIBeans.add("");
		listCDIBeans.add("CDIBeansWithOutInstance");
		listCDIBeans.addAll(listCDIBeansWithOutInstance);

		return listCDIBeans;
	}

	public static void invalidateSession() {
		System.out.println("JSFUtil.invalidateSession()");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		// return "Page02.xhtml?faces-redirect=true";
	}

	public static Usuario buscaUsuarioLogado() {
		System.out.println("JSFUtil.buscaUsuarioLogado()");

		Principal principal = JSFUtil.getUserPrincipal();
		System.out.println("[principal=" + (principal) + "]");
		if (principal != null) {
			if (principal.getClass().toString().toLowerCase().indexOf("springframework")>=0) {

			}
		}

		return null;
	}

}
