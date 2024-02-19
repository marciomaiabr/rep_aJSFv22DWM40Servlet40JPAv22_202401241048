package pkgs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Estado;
import pkgs.utils.JSFUtil;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EstadoConverter.getAsObject()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			HttpServletRequest request = JSFUtil.getRequest();

			EntityManager em = (EntityManager) request.getAttribute("entityManager");

			Estado estado = em.find(Estado.class, Integer.valueOf(value));

			return estado;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("EstadoConverter.getAsString()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			Estado estado = (Estado) value;
			return estado.getIdEstado().toString();
		}
		return null;
	}

}
