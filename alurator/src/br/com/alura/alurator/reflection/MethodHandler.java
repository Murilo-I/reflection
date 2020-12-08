package br.com.alura.alurator.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MethodHandler {

	private Method method;
	private Object objectInstance;
	private Map<String, Object> params;
	
	public MethodHandler(Object instance, Method method, Map<String, Object> params) {
		this.method = method;
		this.objectInstance = instance;
		this.params = params;
	}
	
	public Object invoke() {
		try {
			List<Object> parameters = new ArrayList<>();
			
			Stream.of(method.getParameters()).forEach(p -> parameters.add(params.get(p.getName())));
			//iterando os parâmetros e os colocando numa lista que é adicionada no invoke 
			
			return method.invoke(objectInstance, parameters.toArray());
		} catch (IllegalAccessException | IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("Erro no método passado!", e.getTargetException());
		}
	}
}
