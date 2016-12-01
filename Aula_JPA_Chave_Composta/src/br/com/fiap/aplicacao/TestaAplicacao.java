package br.com.fiap.aplicacao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.VendasHelper;
import br.com.fiap.pk.PedidosPK;

public class TestaAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaVendas");
		EntityManager em = emf.createEntityManager();
		
		VendasHelper dao = new VendasHelper(em);
		
		try {
			Cliente cliente = new Cliente();
			cliente.setId(10);
			cliente.setEmpresa("Fiap");
			
			Endereco endereco = new Endereco();
			endereco.setRua("Lins de Vasconcelos");
			endereco.setCidade("São Paulo");
			endereco.setCep("01538-001");
			endereco.setCliente(cliente);
			
			PedidosPK pk = new PedidosPK();
			pk.setCategoria("Livros");
			pk.setNumPedido(100);
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setPedidosPK(pk);
			pedido.setDataPedido(new Date());
			pedido.setIdPedido(1010);
			
			Item item1 = new Item();
			item1.setQuantidade(2);
			item1.setPedido(pedido);
			
			Item item2 = new Item();
			item2.setQuantidade(3);
			item2.setPedido(pedido);
			
			pedido.getItens().add(item1);
			pedido.getItens().add(item2);
			
			cliente.getEnderecos().add(endereco);
			cliente.getPedidos().add(pedido);
			
			dao.salvar(cliente);
			JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
