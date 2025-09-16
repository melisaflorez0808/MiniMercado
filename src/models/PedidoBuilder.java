package models;


import java.time.LocalDate;

public class PedidoBuilder {
	public LocalDate fecha;
	public Cliente cliente;
	public String direccion;
	public String notasEntrega;
	public String codDescuento;
	
	public PedidoBuilder(LocalDate fecha, Cliente cliente) {
		this.fecha=fecha;
		this.cliente=cliente;
	}
	
	public PedidoBuilder withDireccion(String direccion) {
		this.direccion=direccion;
		return this;
	}
	
	public PedidoBuilder withNotasEntrega (String notasEntrega) {
		this.notasEntrega=notasEntrega;
		return this;
	}
	
	public PedidoBuilder withCodDescuento(String codDescuento) {
		this.codDescuento=codDescuento;
		return this;
	}
	
	public Pedido build() {
		return new Pedido(this);
	}

}
