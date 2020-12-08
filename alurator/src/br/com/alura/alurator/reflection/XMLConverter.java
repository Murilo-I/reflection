package br.com.alura.alurator.reflection;

import java.lang.reflect.Field;
import java.util.Collection;

import br.com.alura.alurator.annotation.XMLTagName;

public class XMLConverter {

	public String convert(Object object) {		
		try {
			Class<?> classe = object.getClass();
			StringBuilder builder = new StringBuilder();

			if(object instanceof Collection) {
				Collection<?> c = (Collection<?>) object;
			
				builder.append("<produtos>\n");
				
				for(Object o : c) {
					String xml = convert(o);
					builder.append(xml);
				}

				builder.append("</produtos>\n");
			} else {
				XMLTagName tagName = classe.getDeclaredAnnotation(XMLTagName.class);
				String className = tagName == null
						? classe.getName()
						: tagName.value();
				
				builder.append("<"+className+">\n");
				
				for(Field f : classe.getDeclaredFields()) {
					f.setAccessible(true);
					
					String atributo = f.getName();
					Object value = f.get(object);
					
					builder.append("<"+atributo+">");
					builder.append(value);
					builder.append("</"+atributo+">\n");
				}
				
				builder.append("</"+className+">\n");
			}
			return builder.toString();
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException("Erro na geração do XML!", e);
		}
	}
}
