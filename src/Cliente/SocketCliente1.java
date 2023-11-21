package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente1 {

	public static final int PUERTO = 2081;

	public int victoriasCliente = 0;
	public int victoriasCliente1 = 0;

	public static void main(String[] args) throws IOException {

		SocketCliente1 socketcliente = new SocketCliente1();
		Socket socketServer = new Socket();
		try (ServerSocket servidor = new ServerSocket(); Scanner sc = new Scanner(System.in)) {

			System.out.println("-------- Juego de Piedra-Papel-Tijera. Jugador2(Cliente-Server) --------");

			InetSocketAddress direccionServer = new InetSocketAddress(PUERTO);
			servidor.bind(direccionServer);

			socketServer = servidor.accept();

			PrintStream salida = new PrintStream(socketServer.getOutputStream());
			InputStreamReader entrada = new InputStreamReader(socketServer.getInputStream());
			BufferedReader bf1 = new BufferedReader(entrada);

			while (socketcliente.victoriasCliente < 3 || socketcliente.victoriasCliente1 < 3) {
				System.out.println("Ingresa tu elección (piedra, papel, tijera): ");

				String miEleccion = sc.nextLine();

				String eleccionCliente = bf1.readLine();

				System.out.println("Elección del cliente: " + eleccionCliente);

				System.out.println("Elección del servidor: " + miEleccion);

				String resultado = decidirGanador(eleccionCliente, miEleccion);
				System.out.println("Resultado de la ronda: " + resultado);

				salida.println(resultado);

			}

		} catch (UnknownHostException e) {
			System.err.println("No se puede conectar al servidor en la dirección ");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error -> " + e);
			e.printStackTrace();

		}
	}

	private static String decidirGanador(String eleccionCliente, String eleccionCliente1) {
		if (eleccionCliente.equals(eleccionCliente1)) {
			return "Empate";

		} else if ((eleccionCliente.equals("piedra") && eleccionCliente1.equals("tijera"))
				|| (eleccionCliente.equals("papel") && eleccionCliente1.equals("piedra"))
				|| (eleccionCliente.equals("tijera") && eleccionCliente1.equals("papel"))) {

			return "Ganaste";

		} else {
			return "Perdiste";
		}
	}
}
