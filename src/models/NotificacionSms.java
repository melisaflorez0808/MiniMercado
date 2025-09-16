package models;

import javax.swing.JOptionPane;
import interfaces.CanalNotificacion;

public class NotificacionSms implements CanalNotificacion {
	public NotificacionSms() {
	}
	@Override
	public void notificar() {
		JOptionPane.showMessageDialog(null,"Notificando al cliente vía SMS");
	}
}
