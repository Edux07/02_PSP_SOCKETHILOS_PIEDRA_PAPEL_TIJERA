package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketCliente extends Thread {
	
	public static final int PUERTO = 2077;
	public static final String IP_SERVER = "Localhost";
	
	public Socket Cliente1, Cliente2;
	public ObjectOutputStream o1, o2;
	public ObjectInputStream i1, i2;

	public SocketCliente(Socket cliente1, Socket cliente2) throws IOException {
		Cliente1 = cliente1;
		Cliente2 = cliente2;
		
		this.o1 = new ObjectOutputStream(Cliente1.getOutputStream());
		this.o2 = new ObjectOutputStream(Cliente2.getOutputStream());
		
		this.i1 = new ObjectInputStream(Cliente1.getInputStream());
		this.i2 = new ObjectInputStream(Cliente2.getInputStream());
	}
	
	@Override
	public void run() {
		try{	
			o1.writeObject("Esperando a que se conecte el Cliente 1");
			o2.writeObject("Esperando a que se conecte el Cliente 2");
			
			while(true) {
				
			}
			
			
		}catch (Exception e) {
		e.printStackTrace();
}
	
	}

}
