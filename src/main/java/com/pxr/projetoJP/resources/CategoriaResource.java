package com.pxr.projetoJP.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxr.projetoJP.domain.Categoria; 

@RestController 
@RequestMapping(value = "/categorias") 
public class CategoriaResource { 
 
	@RequestMapping(method=RequestMethod.GET)  
	public List<Categoria> listar() {   
		Categoria cat1 = new Categoria(1, "Caixas de Presente");   
		Categoria cat2 = new Categoria(2, "Papeis de Presente");    
		Categoria cat3 = new Categoria(3, "Sacos Metalizados");   
		Categoria cat4 = new Categoria(4, "Sacolas Decorativas");   
		Categoria cat5 = new Categoria(5, "Sacolas Personalizadas");   
		Categoria cat6 = new Categoria(6, "Etiquetas");   
		Categoria cat7 = new Categoria(7, "Sacos de Alimentos");   
		Categoria cat8 = new Categoria(8, "Caixas de Pizza");   
		Categoria cat9 = new Categoria(9, "Caixas para Lanches");   
		Categoria cat10 = new Categoria(10, "Outros Produtos");   

		List<Categoria> lista = new ArrayList<>();   
		lista.add(cat1);   
		lista.add(cat2);  
		lista.add(cat3);   
		lista.add(cat4);   
		lista.add(cat5);   
		lista.add(cat6);   
		lista.add(cat7);   
		lista.add(cat8);   
		lista.add(cat9);   
		lista.add(cat10);   

		return lista;  
		}
	}
