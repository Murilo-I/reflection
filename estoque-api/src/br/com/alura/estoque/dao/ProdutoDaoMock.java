package br.com.alura.estoque.dao;

import java.util.Arrays;
import java.util.List;

import br.com.alura.estoque.modelo.Produto;

public class ProdutoDaoMock implements ProdutoDao {
	private static final List<Produto> LISTA_PRODUTO = 
			Arrays.asList(new Produto("tenis", 199.90, "nike"),
					new Produto("tenis", 249.89, "nike"),
					new Produto("tenis", 239.90, "adidas"),
					new Produto("tenis", 359.79, "adidas"),
					new Produto("blusa", 259.99, "gucci"),
					new Produto("blusa", 269.59, "gucci"),
					new Produto("blusa", 399.99, "chanel"),
					new Produto("blusa", 419.49, "chanel"),
					new Produto("oculos", 600.0, "rayban"),
					new Produto("oculos", 800.0, "rayban"),
					new Produto("oculos", 900.0, "dior"),
					new Produto("oculos", 1200.0, "dior"),
					new Produto("bolsa", 3000.0, "prada"),
					new Produto("bolsa", 3500.0, "prada"),
					new Produto("bolsa", 4000.0, "armani"),
					new Produto("bolsa", 4500.0, "armani"));
	
	public List<Produto> lista() {
		return LISTA_PRODUTO;
	}
	
	public Produto getProduto(Integer id) {
		return LISTA_PRODUTO.get(id);
	}
}
