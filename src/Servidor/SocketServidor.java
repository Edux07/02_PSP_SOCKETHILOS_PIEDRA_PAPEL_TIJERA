package Servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import Cliente.SocketCliente;

public class SocketServidor {

	public static final int PUERTO = 2077;

	public static void main(String[] args) {
		System.out.println("      APLICACION DE SERVIDOR DEL VIDEOJUEGO     ");
		System.out.println("------------------------------------------------");

		int peticion = 0;
		try (ServerSocket servidor = new ServerSocket()) {
			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);

			System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
			while (true) {
				Socket socketAlCliente = servidor.accept();
				Socket socketAlCliente1 = servidor.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				new SocketCliente(socketAlCliente, socketAlCliente1);
			}
			

		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error");
			e.printStackTrace();
		}
	}
}
