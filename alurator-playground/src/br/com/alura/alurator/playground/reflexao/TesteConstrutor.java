package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import br.com.alura.alurator.playground.controle.SubControle;

public class TesteConstrutor {

	public static void main(String[] args) {
		
		try {
			Class<SubControle> subControle1 = SubControle.class;
			
			Constructor<SubControle> constructor1 = subControle1.getConstructor();
			SubControle scInstance1 = constructor1.newInstance();
			//criando um objeto corretamente, getConstructor só funciona com construtores publicos
			
			Constructor<SubControle> constructor2 = subControle1.getDeclaredConstructor(String.class);
			constructor2.setAccessible(true);
			SubControle scInstance2 = constructor2.newInstance("passando uma string");
			//em caso de construores privados é preciso usar o declaredConstructor e torna-lo acessível
			
			System.out.println(constructor1);
			System.out.println(constructor2);
			System.out.println(scInstance1);
			System.out.println(scInstance2);
			
			
			Class<?> controle1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
			controle1.getDeclaredConstructor(String.class).newInstance("passando uma string");
			//o newIntance de Contructor é melhor que o de Class, 
			//pois ele acusa os erros e permite passar parâmetros
			
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
