package factory;

import interfaces.MetodoPago;
import models.PagoPse;
import models.PagoTarjetaCredito;


public class PagoFactory {
	public static MetodoPago crearMetodoPago(String tipo) {
		switch (tipo) {
		case "1":
			return new PagoTarjetaCredito();
		case "2":
			return new PagoPse();
		default:
			return null;
		}
	}
}
