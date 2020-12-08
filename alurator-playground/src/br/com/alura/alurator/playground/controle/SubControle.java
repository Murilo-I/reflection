package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {

	public String nome = nomeControle;
	
	public SubControle() {}

	@SuppressWarnings("unused")
	private SubControle(String s) {
		this.nome = s;
	}
	
	public void metodo1() {
		System.out.println("Executando metodo1()");
	}
	
	@SuppressWarnings("unused")
	private String metodo2() {
		return "Retornando resultado do metodo2()";
	}
}
