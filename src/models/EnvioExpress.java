package models;

import javax.swing.JOptionPane;
import interfaces.TipoEnvio;

public class EnvioExpress implements TipoEnvio {
	private int valor=15000;
	
	public EnvioExpress() {
	}

	@Override
	public void definirEnvio() {
		JOptionPane.showMessageDialog(null,"Se ha elegido el envio Express por valor de $" +valor);
	}
}