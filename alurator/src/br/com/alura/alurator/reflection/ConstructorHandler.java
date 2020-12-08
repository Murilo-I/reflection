package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorHandler {

	private Constructor<?> constructor;
	
	public ConstructorHandler(Constructor<?> constructor) {
		this.constructor = constructor;
	}
	
	public Object invoke() {
		try {
			return constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("Erro no construtor da classe!", e.getTargetException());
		}
	}
}
