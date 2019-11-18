package br.ufsc.das;

import java.io.Serializable;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String cliente;
	private String endereco;
	private String estado;
	private String itensRobos;
	private String itensReator;
	private float total;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getItensRobos() {
		return itensRobos;
	}

	public void setItensRobos(String itensRobos) {
		this.itensRobos = itensRobos;
	}

	public String getItensReator() {
		return itensReator;
	}

	public void setItensReator(String itensReator) {
		this.itensReator = itensReator;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PedidoBean [codigo=" + codigo + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", estado=" + estado
				+ ", itensRobos=" + itensRobos + ", itensReator=" + itensReator
				+ ", total=" + total + "]";
	}

}
