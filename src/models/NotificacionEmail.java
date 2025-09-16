package models;

import javax.swing.JOptionPane;
import interfaces.CanalNotificacion;

public class NotificacionEmail implements CanalNotificacion {
	public NotificacionEmail() {
	}
	@Override
	public void notificar() {
		JOptionPane.showMessageDialog(null,"Notificando al cliente vía Email");
	}
}

