package models;

import javax.swing.JOptionPane;

import interfaces.TipoEnvio;

public class EnvioEstandar implements TipoEnvio {
	private int valor=7000;
	
	public EnvioEstandar() {
	}
	@Override
	public void definirEnvio() {
		JOptionPane.showMessageDialog(null,"Se ha elegido el envio Estandar por valor de $" +valor);
	}
}
