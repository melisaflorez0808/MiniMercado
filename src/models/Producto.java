package models;

public class Producto {
	private String sku;
	private String nombre;
	private double precio;
	
	public Producto(String sku, String nombre, float precio) {
		this.sku=sku;
		this.nombre=nombre;
		this.precio=precio;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "[Codigo sku=" + sku + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	

}
