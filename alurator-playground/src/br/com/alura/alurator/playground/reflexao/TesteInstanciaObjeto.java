package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjeto {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		Class<Controle> class1 = Controle.class;
		
		SubControle sb = new SubControle();
		Class<? extends Controle> class2 = sb.getClass();
		
		Class<?> class3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Controle object1 = class1.newInstance();
		Controle object2 = class2.newInstance();
		Object object3 = class3.newInstance();
		
		System.out.println(object1 instanceof Controle && 
				object2 instanceof Controle && object3 instanceof Controle);
		
		//formas de instanciar objetos pela classe Class
	}
}
