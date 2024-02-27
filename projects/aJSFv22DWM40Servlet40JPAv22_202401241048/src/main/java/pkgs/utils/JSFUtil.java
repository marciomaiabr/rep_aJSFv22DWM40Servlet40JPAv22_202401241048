package pkgs.utils;

import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.application.ProjectStage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

public class JSFUtil {

	public static HttpServletRequest getRequest() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();

		return httpServletRequest;
	}

	public static ProjectStage getProjectStage() {
		ProjectStage projectStage = FacesContext.getCurrentInstance().getApplication().getProjectStage();

		return projectStage;
	}

	public static void writeCDIBeans() {
		System.out.println("JSFUtil.writeCDIBeans()");

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
						System.out.println("[bean=" + (bean) + "]");
					} else {
						System.out.println();
						System.out.println("[bean=" + (bean) + "]");
						System.out.println("[creationalContext=" + (creationalContext) + "]");
						System.out.println("[context=" + (context) + "]");
						System.out.println("[beanInstance=" + (instance) + "]");
						System.out.println();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
