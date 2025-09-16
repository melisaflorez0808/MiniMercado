package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	private String idPedido;
	private LocalDate fecha;
	private Cliente cliente;
	private ArrayList<ItemPedido> itemsPedido;
	private String direccion;
	private String notasEntrega;
	private String codDescuento;
	
	public Pedido(PedidoBuilder builder) {
		this.idPedido=builder.idPedido;
		this.fecha=builder.fecha;
		this.cliente=builder.cliente;
		this.direccion=builder.direccion;
		this.notasEntrega=builder.notasEntrega;
		this.codDescuento=builder.codDescuento;
		this.itemsPedido=new ArrayList<>();
	}

	public String getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemPedido> getItemsPedido() {
		return this.itemsPedido;
	}

	public boolean addItemsPedido(Producto producto,int cantidad) {
		this.itemsPedido.add(new ItemPedido (producto,cantidad));
		return true;
	}
	
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNotasEntrega() {
		return this.notasEntrega;
	}

	public void setNotasEntrega(String notasEntrega) {
		this.notasEntrega = notasEntrega;
	}

	public String getCodDescuento() {
		return this.codDescuento;
	}

	public void setCodDescuento(String codDescuento) {
		this.codDescuento = codDescuento;
	}
	
	public double calcularPedido() {
		double valor = 0;
		for (ItemPedido item: this.itemsPedido) {
			valor+=item.calcularCosto();
		}
		return valor;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", cliente=" + getCliente().toString() + ", direccion=" + direccion + ", notasEntrega=" 
	+ notasEntrega + ", codDescuento="+ codDescuento + "]\n";
	}
	
	
}