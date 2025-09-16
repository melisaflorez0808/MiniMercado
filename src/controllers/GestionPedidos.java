package controllers;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Cliente;
import models.ItemPedido;
import models.Pedido;
import models.PedidoBuilder;


public class GestionPedidos {
	private ArrayList<Pedido> pedidos;

	
	public GestionPedidos(GestionClientes gestionClientes) {
		this.pedidos= new ArrayList<>();
	}
	
	public boolean crearPedido(String idPedido, LocalDate fecha, Cliente cliente) {
		PedidoBuilder pedidoBuilder = new PedidoBuilder(idPedido,fecha,cliente);
		pedidos.add(pedidoBuilder.build());
		return true;
	}
	
	public boolean crearPedidoCompleto(String idPedido, LocalDate fecha, Cliente cliente,String direccion,String notasEntrega,String codDescuento) {
		PedidoBuilder pedidoBuilder = new PedidoBuilder(idPedido,fecha,cliente)
				.withDireccion(direccion)
				.withNotasEntrega(notasEntrega)
				.withDireccion(direccion);
		pedidos.add(pedidoBuilder.build());
		return true;
	}
	
	public Pedido buscarPedido(String idPedido) {
		for(Pedido pedido : this.pedidos) {
			if(pedido.getIdPedido().equals(idPedido)) {
				return pedido;
			}
		}
		return null;
	}
	
	public boolean eliminarPedido(String idPedido) {
		Pedido pedidoHallado = buscarPedido(idPedido);
		if (pedidoHallado!=null) {
			this.pedidos.remove(pedidoHallado);
			return true;
		}
		return false;
	}
	
	public String mostrarPedidos() {
		if (this.pedidos.size()==0) {
			return "No hay pedidos registrados";
		}
		String mensaje="Los pedidos registrados son los siguientes:\n";
		for (Pedido pedido:this.pedidos) {
			mensaje+=pedido.toString();
		}
		return mensaje;
	}
	
	public String mostrarItemPedido(String idPedido) {
		String mensaje="Los items registrados del pedido son los siguientes:\n";
		Pedido pedidoHallado = buscarPedido(idPedido);
		if (pedidoHallado==null) {
			return "No hay pedidos registrados con ese id";
		}else {
		for (ItemPedido item: pedidoHallado.getItemsPedido()) {
			mensaje+=item.toString();
			}
		}
		return mensaje;
	}	
}
