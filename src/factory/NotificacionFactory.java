package factory;

import interfaces.CanalNotificacion;
import models.NotificacionEmail;
import models.NotificacionSms;

public class NotificacionFactory {
	public static CanalNotificacion crearNotificacion(String tipo) {
		switch (tipo) {
		case "1":
			return new NotificacionEmail();
		case "2":
			return new NotificacionSms();
		default:
			return null;
		}
	}
}
