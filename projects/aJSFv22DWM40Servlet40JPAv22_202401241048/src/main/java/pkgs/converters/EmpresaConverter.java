package pkgs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pkgs.models.Empresa;
import pkgs.repositoryEspec.EmpresaRepositoryEspec;
import pkgs.repositoryJPA.EmpresaRepositoryJPA;
import pkgs.serviceEspec.EmpresaServiceEspec;
import pkgs.utils.CDIServiceLocator;
import pkgs.utils.JSFUtil;

@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	private EmpresaServiceEspec ese;

	public EmpresaConverter() {
		System.out.println("EmpresaConverter.EmpresaConverter()");
		ese = (EmpresaServiceEspec) CDIServiceLocator.getBean(EmpresaServiceEspec.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EmpresaConverter.getAsObject()");
		System.out.println("     " + "[value="+value+"]");
		System.out.println("     " + "[ese="+ese+"]");
		if(value != null) {

			Empresa empresa = ese.buscar(Integer.valueOf(value));

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
