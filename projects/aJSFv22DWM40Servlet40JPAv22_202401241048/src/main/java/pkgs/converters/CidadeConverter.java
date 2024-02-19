package pkgs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Cidade;
import pkgs.utils.JSFUtil;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("CidadeConverter.getAsObject()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			HttpServletRequest request = JSFUtil.getRequest();

			EntityManager em = (EntityManager) request.getAttribute("entityManager");

			Cidade cidade = em.find(Cidade.class, Integer.valueOf(value));

			return cidade;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("CidadeConverter.getAsString()");
		System.out.println("     " + "[value="+value+"]");
		if(value != null) {
			Cidade cidade = (Cidade) value;
			return cidade.getIdCidade().toString();
		}
		return null;
	}

}
