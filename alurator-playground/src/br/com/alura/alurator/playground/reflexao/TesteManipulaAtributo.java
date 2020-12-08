package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Field;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteManipulaAtributo {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Controle controle = new Controle();
		Class<?> classe = controle.getClass();
		
		for(Field f : classe.getDeclaredFields()) {
			f.setAccessible(true);
			System.out.println(f.getName() +" - "+ f.get(controle));
		}
	}
}
