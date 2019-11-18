package br.ufsc.das;

import java.util.LinkedList;
import java.util.List;

public class ObterPedidos {

	public List<Pedido> obterPedidos() {

		List<Pedido> pedidos = new LinkedList<Pedido>();

		Pedido pedido1 = new Pedido();
		pedido1.setCodigo(1);
		pedido1.setCliente("Roque");
		pedido1.setEndereco("Lauro Linhares 1230");
		pedido1.setEstado("SC");
		pedido1.setItensReator("Reator Ark=3;Reator Solar=2");
		pedido1.setItensRobos("Robo Domestico=2");
		pedidos.add(pedido1);

		Pedido pedido2 = new Pedido();
		pedido2.setCodigo(2);
		pedido2.setCliente("Rafael");
		pedido2.setEndereco("Maria Patrocinio Coelho 103");
		pedido2.setEstado("SC");
		pedido2.setItensReator("Reator Ark=2;Reator Solar=5");
		pedido2.setItensRobos("Robo Domestico=4");
		pedidos.add(pedido2);

		return pedidos;
	}

}
