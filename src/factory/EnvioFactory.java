package factory;

import interfaces.TipoEnvio;
import models.EnvioEstandar;
import models.EnvioExpress;

public class EnvioFactory {
	public static TipoEnvio crearEnvio(String tipo) {
		switch (tipo) {
		case "1":
			return new EnvioEstandar();
		case "2":
			return new EnvioExpress();
		default:
			return null;
		}
	}
}
