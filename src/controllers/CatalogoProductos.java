package controllers;

import java.util.ArrayList;

import models.Producto;

public class CatalogoProductos {
	public static CatalogoProductos instance;
	public ArrayList<Producto> productos;
	
	private CatalogoProductos(){
		this.productos=new ArrayList<>();
	}
	
	public static CatalogoProductos getInstance() {
		if (instance==null) {
			instance=new CatalogoProductos();
		}
		return instance;
	}
	
	public boolean crearProducto(String sku, String nombre, int precio) {
		Producto productoHallado = buscarProducto(sku);
			if (productoHallado == null) {
				Producto nuevoProducto = new Producto(sku,nombre,precio);
				getInstance().addProducto(nuevoProducto);
				return true;
			}
			return false;
		}
	
	public boolean eliminarProducto(String sku) {
		Producto productoHallado=buscarProducto(sku);
		if (productoHallado!=null) {
			getInstance().getProductos().remove(productoHallado);
			return true;
		}
		return false;
	}
	
	public String mostrarProducto() {
		if (getInstance().getProductos().size()==0) {
			return "No hay productos en el catalogo";
		}
		String mensaje="Los productos del catálogo son los siguientes:\n";
		for (Producto producto:getInstance().getProductos()) {
			mensaje+=producto.toString()+"\n";
		}
		return mensaje;
	}
	
	public Producto buscarProducto(String sku) {
		for(Producto producto : getInstance().getProductos()) {
			if(producto.getSku().equals(sku)) {
				return producto;
			}
		}
		return null;
	}
	
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

}
