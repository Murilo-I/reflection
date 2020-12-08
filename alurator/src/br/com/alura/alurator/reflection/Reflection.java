package br.com.alura.alurator.reflection;

public class Reflection {

	public ClassHandler reflect(String fullyQualifiedName) {
		Class<?> classe = getClass(fullyQualifiedName);
		return new ClassHandler(classe);
	}

	public Class<?> getClass(String fullyQualifiedName) {
		try {
			Class<?> classe = Class.forName(fullyQualifiedName);
			return classe;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
