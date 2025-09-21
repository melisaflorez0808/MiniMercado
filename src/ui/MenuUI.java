package ui;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import services.GestionMiniMercado;

public class MenuUI {
	
	public GestionMiniMercado miniMercado;
	
	public MenuUI() {
		this.miniMercado=new GestionMiniMercado();
	}
	
	public void menuPrincipal() {
		String menu="(1) Gestión de Catálogo de Productos:\n(2) Gestión de Clientes:\n(3) Gestionar Pedidos:\n(4) Salir:\n";
		int opcion;
		do {
			opcion = Integer.parseInt(capturarDato(menu));
			validarMenuPrincipal(opcion);
		}while (opcion !=4);
	}
	
	public void validarMenuPrincipal(int opcion) {
		switch (opcion) {
		case 1:
			menuProductos();
			break;
		case 2:
			menuClientes();
			break;
		case 3:
			menuPedidos();
			break;
		case 4:
			mostrarMensaje("Saliendo...");
			break;
		default:
			mostrarMensaje("No ingresó ninguna opción válida");
			break;
		}
	}

	public void menuProductos() {
		String menu = "(1) Crear Producto\n(2) Eliminar Producto\n(3) Ver Catalogo de Productos\n(4) Volver al Menú Principal";
		int opcion;
		do {
			opcion= Integer.parseInt(capturarDato(menu));
			validarMenuProductos(opcion);
			}while (opcion!=4);
		}
	
	public void validarMenuProductos(int opcion) {
		switch (opcion) {
		case 1:
			crearProducto();
			break;
		case 2:
			eliminarProducto();
			break;
		case 3:
			mostrarProductos();
			break;
		case 4:
			break;
		default:
			mostrarMensaje("Opción invalida");
		}
	}
	
	public void menuClientes() {
		String menu = "(1) Crear Cliente\n(2) Eliminar Cliente\n(3) Ver Clientes\n(4) Volver al Menú Principal";
		int opcion;
		do {
			opcion= Integer.parseInt(capturarDato(menu));
			validarMenuClientes(opcion);
			}while (opcion!=4);
		}
	
	public void validarMenuClientes(int opcion) {
		switch (opcion) {
		case 1:
			crearCliente();
			break;
		case 2:
			eliminarCliente();
			break;
		case 3:
			mostrarClientes();
			break;
		case 4:
			break;
		default:
			mostrarMensaje("Opción invalida");
		}
	}
	
	public void menuPedidos() {
		String menu = "(1) Crear Nuevo Pedido\n(2) Ver Historial de Pedidos\n(3) Ver Items de un Pedido\n(4) Volver al Menú Principal";
		int opcion;
		do {
			opcion= Integer.parseInt(capturarDato(menu));
			validarMenuPedidos(opcion);
			}while (opcion!=4);
		}
	
	public void validarMenuPedidos(int opcion) {
		switch (opcion) {
		case 1:
			crearPedido();
			break;
		case 2:
			mostrarPedido();
			break;
		case 3:
			mostrarItemsPedido();
			break;
		case 4:
			break;
		default:
			mostrarMensaje("Opción invalida");
		}
	}
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	private String capturarDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	private void crearProducto() {
		boolean canCrear=miniMercado.getCatalogo().crearProducto(
				capturarDato("Ingrese el codigo sku del producto: "),
				capturarDato("Ingresar el nombre del producto: "),
				Integer.parseInt(capturarDato("Ingrese el precio del producto")));
		mostrarMensaje(canCrear?"Se creo el Producto":"No se pudo crear el Producto");
	}
	
	private void eliminarProducto() {
		boolean canEliminar=miniMercado.getCatalogo().eliminarProducto(capturarDato("Ingrese el código sku del producto a eliminar: "));
		mostrarMensaje(canEliminar?"Se eliminó el producto":"No se pudo eliminar el producto");
	}
	
	private void mostrarProductos() {
		mostrarMensaje(miniMercado.getCatalogo().mostrarProducto());
	}
	
	private void crearCliente() {
		boolean canCrear=miniMercado.getGestionClientes().crearCliente(
				capturarDato("Ingrese el nombre del cliente: "),
				capturarDato("Ingrese el id del cliente: "), 
				capturarDato("Ingrese el email: "),
				capturarDato("Ingrese el teléfono: "));
		mostrarMensaje(canCrear?"Se creo el cliente":"No se pudo crear el cliente");	
	}
	
	private void eliminarCliente() {
		boolean canEliminar=miniMercado.getGestionClientes().eliminarCliente(capturarDato("Ingrese el id del cliente a eliminar: "));
		mostrarMensaje(canEliminar?"Se eliminó el cliente":"No se pudo eliminar el cliente");	
	}
	
	private void mostrarClientes() {
		mostrarMensaje(miniMercado.getGestionClientes().mostrarClientes());	
	}
	
	private void crearPedido() {
		String idCliente=capturarDato("Ingrese el id del cliente que va a realizar el pedido: ");
		if(miniMercado.getGestionClientes().buscarCliente(idCliente)==null){
			mostrarMensaje("No existe el cliente, debe crearlo en el menú de Gestion de Clientes");
			return;
		}

		String datosAdicionales=capturarDato("Desea ingresar información adicional (S/N): ");
		String idPedido;
		
		if (datosAdicionales.equalsIgnoreCase("n")) {
			idPedido=miniMercado.getGestionClientes().getGestionPedidos().crearPedido(LocalDate.now(),
					miniMercado.getGestionClientes().buscarCliente(idCliente)).getIdPedido();
			mostrarMensaje((idPedido!=null)?"Se creó el pedido":"No se pudo crear el pedido");
		}else{
			idPedido=miniMercado.getGestionClientes().getGestionPedidos().crearPedidoCompleto(LocalDate.now(),
					miniMercado.getGestionClientes().buscarCliente(idCliente),
					capturarDato("Ingrese la direccion: "),
					capturarDato("Ingrese notas adicionales: "),
					capturarDato("Ingrese el código de descuento (Si Aplica): ")).getIdPedido();
			mostrarMensaje((idPedido!=null)?"Se creó el pedido":"No se pudo crear el pedido");
		}
		
		if((idPedido)!=null) {
			boolean seguirAgregando=true;
			while (seguirAgregando) {
				mostrarMensaje(miniMercado.getCatalogo().mostrarProducto());
				boolean canAgregar=miniMercado.getGestionClientes().getGestionPedidos().agregarProducto(idPedido,
						capturarDato("Ingrese el codigo sku del producto que desea agregar: "),
						Integer.parseInt(capturarDato("Ingrese la cantidad: ")));
				mostrarMensaje(canAgregar?"Producto agregado con exito":"No se pudo agregar el producto, verifique el codigo");
				String mensaje=capturarDato("Desea ingresar mas productos (S/N)");
				if(mensaje.equalsIgnoreCase("n")) {
					seguirAgregando=false;
				}
			}
		}
		if(miniMercado.getGestionClientes().getGestionPedidos().buscarPedido(idPedido).getItemsPedido().size()==0) {
			miniMercado.getGestionClientes().getGestionPedidos().eliminarPedido(idPedido);
			mostrarMensaje("El pedido no tiene productos y se elimino");
		}else {
			mostrarMensaje("El valor total del pedido es:" + miniMercado.getGestionClientes().getGestionPedidos()
					.buscarPedido(idPedido).calcularPedido());
			miniMercado.crearPago(capturarDato("Ingrese el método de pago\n (1)TARJETA DE CREDITO\n (2)PSE"),
					miniMercado.getGestionClientes().getGestionPedidos().buscarPedido(idPedido).calcularPedido());
			miniMercado.seleccionarEnvio(capturarDato("Seleccione el tipo de envío\n (1)ESTANDAR\n (2)EXPRESS"));
			miniMercado.enviarNotificacion(capturarDato("Seleccione el tipo de notificación\n (1)EMAIL\n (2)SMS"));
		}
	}
	
	private void mostrarPedido() {
		mostrarMensaje(miniMercado.getGestionClientes().getGestionPedidos().mostrarPedidos());
	}
	
	private void mostrarItemsPedido() {
		mostrarMensaje(miniMercado.getGestionClientes().getGestionPedidos().mostrarItemPedido(capturarDato("Ingresar ID Pedido: ")));
	}

}
