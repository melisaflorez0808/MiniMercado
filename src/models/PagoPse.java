package models;

import javax.swing.JOptionPane;

import interfaces.MetodoPago;

public class PagoPse implements MetodoPago {
	public PagoPse() {
	}
	@Override
	public void procesarPago(double monto) {
		JOptionPane.showMessageDialog(null,"Procesando pago en PSE por valor de $ " +monto);
	}
}
