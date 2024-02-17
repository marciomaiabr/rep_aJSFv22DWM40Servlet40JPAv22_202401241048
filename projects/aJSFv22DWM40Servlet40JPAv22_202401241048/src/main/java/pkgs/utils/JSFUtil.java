package pkgs.utils;

import javax.faces.application.ProjectStage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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

}
