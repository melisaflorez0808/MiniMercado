package controllers;

import java.util.ArrayList;

import models.Cliente;

public class GestionClientes {
	private ArrayList<Cliente> clientes;
	
	public GestionClientes(GestionMiniMercado miniMercado) {
		this.clientes= new ArrayList<>();
	}
	
	public boolean crearCliente(String nombre, String id, String email,String telefono) {
		Cliente clienteHallado = buscarCliente(id);
			if (clienteHallado == null) {
				Cliente nuevoCliente = new Cliente(nombre,id,email,telefono);
				this.clientes.add(nuevoCliente);
				return true;
			}
			return false;
		}
	
	public boolean eliminarCliente(String id) {
		Cliente clienteHallado = buscarCliente(id);
		if (clienteHallado!=null) {
			this.clientes.remove(clienteHallado);
			return true;
		}
		return false;
	}
	
	public String mostrarClientes() {
		if (this.clientes.size()==0) {
			return "No hay clientes registrados";
		}
		String mensaje="Los clientes registrados son los siguientes:\n";
		for (Cliente cliente:this.clientes) {
			mensaje+=cliente.toString();
		}
		return mensaje;
	}
	
	public Cliente buscarCliente(String id) {
		for(Cliente cliente: this.clientes) {
			if(cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
}