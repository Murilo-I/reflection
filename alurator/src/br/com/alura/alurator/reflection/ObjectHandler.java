package br.com.alura.alurator.reflection;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ObjectHandler {

	private Object instance;

	public ObjectHandler(Object instance) {
		this.instance = instance;
	}

	public MethodHandler getMethod(String methodName, Map<String, Object> params) {

		Method selectedMethod = Stream.of(instance.getClass().getDeclaredMethods())
				.filter(method -> method.getName().equals(methodName)
						&& method.getParameterCount() == params.values().size()
						&& Stream.of(method.getParameters())
								.allMatch(parameter -> params.keySet().contains(parameter.getName())
										&& params.get(parameter.getName()).getClass().equals(parameter.getType())))
				.findFirst().orElseThrow(() -> new RuntimeException("Method not found"));
		/**
		 * filtrando a url do usuário pra ter certeza de qual método ele chamou
		 * 1° verifica se o método passado pelo usuário está presente na classe controle 
		 * 		com os determinados parâmetros
		 * 2° verifica se os parâmetros estão corretos, em nome e tipo
		 */

		return new MethodHandler(instance, selectedMethod, params);
	}
}
