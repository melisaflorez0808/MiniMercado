package services;

import factory.EnvioFactory;
import factory.NotificacionFactory;
import factory.PagoFactory;
import interfaces.CanalNotificacion;
import interfaces.MetodoPago;
import interfaces.TipoEnvio;

public class GestionMiniMercado {
	private GestionClientes gestionClientes;
	private CatalogoProductos catalogo;
	
	public GestionMiniMercado() {
		this.gestionClientes=new GestionClientes(this);
		this.catalogo= CatalogoProductos.getInstance();
	}

	public GestionClientes getGestionClientes() {
		return this.gestionClientes;
	}
	
	public CatalogoProductos getCatalogo() {
		return this.catalogo;
	}
	
	public void crearPago(String metodoPago,double monto) {
		MetodoPago pago=PagoFactory.crearMetodoPago(metodoPago);
		pago.procesarPago(monto);
	}
	
	public void seleccionarEnvio(String tipoEnvio) {
		TipoEnvio envio=EnvioFactory.crearEnvio(tipoEnvio);
		envio.definirEnvio();
	}
	public void enviarNotificacion(String tipoNotificacion) {
		CanalNotificacion notificacion=NotificacionFactory.crearNotificacion(tipoNotificacion);
		notificacion.notificar();
	}
}
	