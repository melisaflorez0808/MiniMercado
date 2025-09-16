package models;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String id;
	private String email;
	private String telefono;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(String nombre, String id, String email, String telefono) {
		this.nombre=nombre;
		this.id=id;
		this.email=email;
		this.telefono=telefono;
		this.pedidos=new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return this.pedidos;
	}

	public boolean addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", id=" + id + ", email=" + email + ", telefono=" + telefono + "]\n";
	}
	
	

}
