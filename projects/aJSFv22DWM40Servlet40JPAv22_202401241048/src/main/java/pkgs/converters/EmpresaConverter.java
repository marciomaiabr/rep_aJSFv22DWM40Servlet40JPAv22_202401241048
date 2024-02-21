package pkgs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Empresa;
import pkgs.utils.JSFUtil;

@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EmpresaConverter.getAsObject()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			HttpServletRequest request = JSFUtil.getRequest();

			EntityManager em = (EntityManager) request.getAttribute("entityManager");

			Empresa empresa = em.find(Empresa.class, Integer.valueOf(value));

			return empresa;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("EmpresaConverter.getAsString()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			Empresa empresa = (Empresa) value;
			return empresa.getIdEmpresa().toString();
		}
		return null;
	}

}
