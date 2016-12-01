package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.pk.PedidosPK;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidosPK pedidosPK;
	
	@Column(name="IDPEDIDO")
	private int idPedido;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATAPEDIDO")
	private Date dataPedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pedido")
	private Set<Item> itens = new LinkedHashSet<>();
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public PedidosPK getPedidosPK() {
		return pedidosPK;
	}
	public void setPedidosPK(PedidosPK pedidosPK) {
		this.pedidosPK = pedidosPK;
	}
	public Set<Item> getItens() {
		return itens;
	}
	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

}
