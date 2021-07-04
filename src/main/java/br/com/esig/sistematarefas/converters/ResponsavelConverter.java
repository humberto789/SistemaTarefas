package br.com.esig.sistematarefas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.esig.sistematarefas.models.Responsavel;

@FacesConverter("responsavelConverter")
public class ResponsavelConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if(id == null || id.trim().isEmpty()) {
			return null;
		}
		System.out.println("Convertendo para Objeto: " + id);

		
		Responsavel responsavel = new Responsavel();
		responsavel.setId(Integer.valueOf(id));
		
		return responsavel;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object responsavelObject) {

		if(responsavelObject == null) {
			return null;
		}
		System.out.println("Convertendo para String: " + responsavelObject);
		
		Responsavel responsavel = (Responsavel) responsavelObject;
		
		return responsavel.getId().toString();
	}
}
