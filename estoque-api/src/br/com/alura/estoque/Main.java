package br.com.alura.estoque;

import java.util.Scanner;

import br.com.alura.alurator.Alurator;
import br.com.alura.estoque.dao.ProdutoDao;
import br.com.alura.estoque.dao.ProdutoDaoMock;

public class Main {

	/**
	 * Simula o navegador.
	 * recebe uma url dizendo o controller e o que deseja ser feito
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Casos possiveis teoria:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1
		 * /controlador/metodo?param1=valor1&param2=valor2
		 * 
		 * Casos possiveis pratica:
		 * /produto/listar
		 * /produto/filtra?
		 * 		nome=(tenis, blusa, oculos, bolsa)
		 * 		&marca=(nike, adidas, gucci, chanle, rayban, dior, prada, armani)
		 */
		
		try (Scanner s = new Scanner(System.in)) {
			String url = s.nextLine();
			
			Alurator alurator = new Alurator("br.com.alura.estoque.controle.");
			alurator.register(ProdutoDao.class, ProdutoDaoMock.class);
			
			while (!url.equals("exit")) {
				Object response = alurator.executa(url);
				
				System.out.println("Response: \n\n" + response);
				
				url = s.nextLine();
			}
		}
	}

}
