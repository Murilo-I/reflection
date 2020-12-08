package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Method;

public class TesteMetodo {

	public static void main(String[] args) throws Exception {
		
		Class<?> subCtrl = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		for(Method m : subCtrl.getMethods()) {
			System.out.println(m);
		}
		//retorna os métodos publicos da classe, super classe e interfaces
		
		System.out.println();
		for(Method m : subCtrl.getDeclaredMethods()) {
			System.out.println(m);
		}
		//retorna todos os métodos da classe em questão
		
		System.out.println();
		Method method = subCtrl.getDeclaredMethod("metodo2");
		method.setAccessible(true);
		System.out.println(method.invoke(subCtrl.getConstructor().newInstance()));
		
		System.out.println();
		Class<?> ctrl = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		Method metodo = ctrl.getDeclaredMethod("ctrl", String.class, Integer.class);
		System.out.println(metodo.invoke(ctrl.getConstructor().newInstance(), "uber", 99));
	}
}
