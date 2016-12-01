package br.com.fiap.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidosPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NUMPEDIDO")
	private int numPedido;

	@Column(name = "CATEGORIA")
	private String categoria;

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof PedidosPK){
			PedidosPK pk = (PedidosPK) o;
			if(this.getNumPedido() != pk.getNumPedido()){
				return false;
			}
			if(!this.getCategoria().equals(pk.getCategoria())){
				return false;
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return this.categoria.hashCode() + this.numPedido;
	}


}
