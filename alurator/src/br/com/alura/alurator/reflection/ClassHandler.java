package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;

public class ClassHandler {

	private Class<?> classe;
	
	public ClassHandler(Class<?> classe) {
		this.classe = classe;
	}
	
	public ConstructorHandler getConstructor() {
		try {
			Constructor<?> constructor = classe.getDeclaredConstructor();
			return new ConstructorHandler(constructor);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ObjectHandler newInstance() {
		Object instance = getConstructor().invoke();
		return new ObjectHandler(instance);
	}
}
