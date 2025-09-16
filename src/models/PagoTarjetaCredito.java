package models;

import javax.swing.JOptionPane;

import interfaces.MetodoPago;

public class PagoTarjetaCredito implements MetodoPago {
	public PagoTarjetaCredito() {
	}
	@Override
	public void procesarPago(double monto) {
		JOptionPane.showMessageDialog(null,"Procesando pago en Tarjeta de Credito $ " +monto);
	}
}

