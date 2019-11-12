package com.pxr.projetoJP;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pxr.projetoJP.domain.Categoria;
import com.pxr.projetoJP.domain.Cidade;
import com.pxr.projetoJP.domain.Cliente;
import com.pxr.projetoJP.domain.Endereco;
import com.pxr.projetoJP.domain.Estado;
import com.pxr.projetoJP.domain.ItemPedido;
import com.pxr.projetoJP.domain.Pagamento;
import com.pxr.projetoJP.domain.PagamentoComBoleto;
import com.pxr.projetoJP.domain.PagamentoComCartao;
import com.pxr.projetoJP.domain.Pedido;
import com.pxr.projetoJP.domain.Produto;
import com.pxr.projetoJP.domain.enums.EstadoPagamento;
import com.pxr.projetoJP.domain.enums.TipoCliente;
import com.pxr.projetoJP.repositories.CategoriaRepository;
import com.pxr.projetoJP.repositories.CidadeRepository;
import com.pxr.projetoJP.repositories.ClienteRepository;
import com.pxr.projetoJP.repositories.EnderecoRepository;
import com.pxr.projetoJP.repositories.EstadoRepository;
import com.pxr.projetoJP.repositories.ItemPedidoRepository;
import com.pxr.projetoJP.repositories.PagamentoRepository;
import com.pxr.projetoJP.repositories.PedidoRepository;
import com.pxr.projetoJP.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoJpApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
		
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
		Produto p6 = new Produto(null, "Etiqueta2", "1 pacote com 1000un.", 30.00);
		Produto p7 = new Produto(null, "Caixa 15x15cm", "1 pacote com 100un.", 35.00);
		Produto p8 = new Produto(null, "Folha 30x30cm", "1 pacote com 500un.", 40.00);
		Produto p9 = new Produto(null, "Saco 20x20cm", "1 pacote com 500un.", 40.00);
		Produto p10 = new Produto(null, "Sacola 40x40cm", "1 pacotes com 500un.", 70.00);
		Produto p11= new Produto(null, "Etiqueta3", "1 pacote com 1000un.", 30.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p7));
		cat2.getProdutos().addAll(Arrays.asList(p2, p8));
		cat3.getProdutos().addAll(Arrays.asList(p3, p9));
		cat4.getProdutos().addAll(Arrays.asList(p4, p10));
		cat5.getProdutos().addAll(Arrays.asList(p4, p10));
		cat6.getProdutos().addAll(Arrays.asList(p5, p6, p11));
		cat7.getProdutos().addAll(Arrays.asList(p3, p9));
		cat8.getProdutos().addAll(Arrays.asList(p1, p7));
		cat9.getProdutos().addAll(Arrays.asList(p1, p7));
		cat10.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat8, cat9, cat10));
		p2.getCategorias().addAll(Arrays.asList(cat2, cat10));
		p3.getCategorias().addAll(Arrays.asList(cat3, cat7, cat10));
		p4.getCategorias().addAll(Arrays.asList(cat4, cat5, cat10));
		p5.getCategorias().addAll(Arrays.asList(cat6, cat10));
		p6.getCategorias().addAll(Arrays.asList(cat5, cat6, cat10));
		p7.getCategorias().addAll(Arrays.asList(cat1, cat8, cat9, cat10));
		p8.getCategorias().addAll(Arrays.asList(cat2, cat10));
		p9.getCategorias().addAll(Arrays.asList(cat3, cat10));
		p10.getCategorias().addAll(Arrays.asList(cat4, cat10));
		p11.getCategorias().addAll(Arrays.asList(cat5, cat6, cat10));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "Santa Catarina");
		Estado est3 = new Estado(null, "Rio Grande do Sul");
		
		Cidade cid1 = new Cidade(null, "Curitiba", est1);
		Cidade cid2 = new Cidade(null, "Joinville", est2);
		Cidade cid3 = new Cidade(null, "Blumenau", est2);
		Cidade cid4 = new Cidade(null, "São João Batista", est2);
		Cidade cid5 = new Cidade(null, "Florianopolis", est2);
		Cidade cid6 = new Cidade(null, "Criciuma", est2);
		Cidade cid7 = new Cidade(null, "Porto Alegre", est3);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3, cid4, cid5, cid6));
		est3.getCidades().addAll(Arrays.asList(cid7));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6, cid7));
		
		Cliente cli1 = new Cliente(null, "Mercado Puel", "puel@gmail.com", "31.051.290/0001-90", TipoCliente.PESSOAJURIDICA);
		Cliente cli2 = new Cliente(null, "Doguinho do Toni", "toni@gmail.com", "023.457.952-59", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("(48)3265 3323", "(48)99383 8393"));
		cli2.getTelefones().addAll(Arrays.asList("(48)99383 8393"));

		Endereco e1 = new Endereco(null, "Rua Zunino Neto", "300", "proximo da prefeitura", "Centro", "88240-000", cli1, cid4);
		Endereco e2 = new Endereco(null, "Praça dep Walter V Gomes", "sn", "frente do posto do Argeu", "Centro", "88240-000", cli2, cid4);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli2, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("11/10/2017 23:35"), cli2, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.CANCELADO, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		Pagamento pagto3 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped3, sdf.parse("21/10/2017 00:00"), null);
		ped3.setPagamento(pagto3);

		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped2, ped3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3));
		
		ItemPedido ip1 = new ItemPedido(ped1, p3, 60.00, 10, 540.00);
		ItemPedido ip2 = new ItemPedido(ped1, p5, 90.00, 30, 810.00);
		ItemPedido ip3 = new ItemPedido(ped2, p1, 0.00, 3, 210.00);
		ItemPedido ip4 = new ItemPedido(ped3, p1, 70.00, 10, 630.00);


		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		ped3.getItens().addAll(Arrays.asList(ip4));

		p1.getItens().addAll(Arrays.asList(ip3, ip4));
		p3.getItens().addAll(Arrays.asList(ip1));
		p5.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
	}
} 