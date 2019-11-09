package com.pxr.projetoJP;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pxr.projetoJP.domain.Categoria;
import com.pxr.projetoJP.domain.Produto;
import com.pxr.projetoJP.repositories.CategoriaRepository;
import com.pxr.projetoJP.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoJpApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Caixas de Presente");   
		Categoria cat2 = new Categoria(null, "Papeis de Presente");    
		Categoria cat3 = new Categoria(null, "Sacos Metalizados");   
		Categoria cat4 = new Categoria(null, "Sacolas Decorativas");   
		Categoria cat5 = new Categoria(null, "Sacolas Personalizadas");   
		Categoria cat6 = new Categoria(null, "Etiquetas");   
		Categoria cat7 = new Categoria(null, "Sacos de Alimentos");   
		Categoria cat8 = new Categoria(null, "Caixas de Pizza");   
		Categoria cat9 = new Categoria(null, "Caixas para Lanches");   
		Categoria cat10 = new Categoria(null, "Outros Produtos");   
		
		Produto p1 = new Produto(null, "Caixa 30x30cm", "1 pacote com 100un.", 70.00);
		Produto p2 = new Produto(null, "Folha 50x60cm", "1 pacote com 500un.", 50.00);
		Produto p3 = new Produto(null, "Saco 50x20cm", "1 pacote com 500un.", 60.00);
		Produto p4 = new Produto(null, "Sacola 60x70cm", "1 pacotes com 500un.", 90.00);
		Produto p5 = new Produto(null, "Etiqueta", "1 pacote com 1000un.", 30.00);

		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p3));
		cat4.getProdutos().addAll(Arrays.asList(p4));
		cat5.getProdutos().addAll(Arrays.asList(p4));
		cat6.getProdutos().addAll(Arrays.asList(p5));
		cat7.getProdutos().addAll(Arrays.asList(p3));
		cat8.getProdutos().addAll(Arrays.asList(p1));
		cat9.getProdutos().addAll(Arrays.asList(p1));
		cat10.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat8, cat9, cat10));
		p2.getCategorias().addAll(Arrays.asList(cat2, cat10));
		p3.getCategorias().addAll(Arrays.asList(cat3, cat7, cat10));
		p4.getCategorias().addAll(Arrays.asList(cat4, cat5, cat10));
		p5.getCategorias().addAll(Arrays.asList(cat6, cat10));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
} 