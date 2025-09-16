package models;

public class ItemPedido {
	private Producto producto;
	private int cantidad;
	
	public ItemPedido(Producto producto, int cantidad) {
		this.producto=producto;
		this.cantidad=cantidad;
	}
	
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double calcularCosto() {
		return this.producto.getPrecio()*this.cantidad;
	}

	@Override
	public String toString() {
		return "\n\nProducto: " + this.producto.toString() + "Cantidad: " + this.cantidad + "\n";
	}
	
}
