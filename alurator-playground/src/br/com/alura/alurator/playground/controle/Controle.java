package br.com.alura.alurator.playground.controle;

import java.util.List;
import java.util.Random;

public class Controle {
	
	private List<String> lista = List.of("controlado 1", "controlado 2", "controlado 3");
	private Integer id = new Random().nextInt(10000);
	public String nomeControle = "Controle";
	public Boolean verifi = true;

	public Controle() {
		new Controle(verifi, id);
	}
	
	public Controle(String s) throws RuntimeException {
		throw new RuntimeException();
	}
	
	private Controle(Boolean b, Integer id) {
		this.verifi = b;
		this.id = id;
	}
	
	public List<String> getLista() {
		return lista;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void ctrl(String s) {
		System.out.println(s);
	}
	
	public void ctrl(String s, Integer i) {
		System.out.println(s +" - "+ i);
	}
}
