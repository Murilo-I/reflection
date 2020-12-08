package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Container {

	private Map<Class<?>, Class<?>> typeMap = new HashMap<>();
	
	public Object getInstance(Class<?> source) {
		
		Class<?> recipient = typeMap.get(source);
		
		if(recipient != null) {
			return getInstance(recipient);
		}
		
		Optional<Constructor<?>> oc = Stream.of(source.getConstructors())
				.filter(constructor -> constructor.getParameterCount() == 0).findFirst();
		
		try {
			
			if(oc.isPresent()) {
				Object instance = oc.get().newInstance();
				return instance;
			} else {
				Constructor<?> constructor = source.getDeclaredConstructors()[0];
				List<Object> params = new ArrayList<>();
				
				for(Parameter p : constructor.getParameters()) {
					Class<?> parameterType = p.getType();
					params.add(getInstance(parameterType));
				}
				return constructor.newInstance(params.toArray());
			}
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public <T, K extends T> void register(Class<T> source, Class<K> recipient) {
//		boolean compatible = verifi(source, recipient); 
//		
//		if(!compatible) throw new ClassCastException("Type "+ source.getName() 
//				+ " is not compatible with type " + recipient.getName());
		
		typeMap.put(source, recipient);
	}

//	private boolean verifi(Class<?> source, Class<?> recipient) {
//		verificando a compatibilidade na mão:
		
//		boolean isCompatible;
//		
//		if(source.isInterface()) {
//			isCompatible = Stream.of(recipient.getInterfaces()).anyMatch(recipientInterfaces -> 
//				recipientInterfaces.equals(source));
//		} else {
//			isCompatible = recipient.getSuperclass().equals(source)
//					|| recipient.equals(source);
//		}
//		
//		return isCompatible;
		
//		easy way using reflection:
		
//		return source.isAssignableFrom(recipient);
//	}
}
