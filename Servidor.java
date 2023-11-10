package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        // Se define el puerto del servidor
        final int PUERTO = 12000;
        //Buffer de almacenamiento de mensajes
        byte[] buffer = new byte[1024];

        try {
            //Inicio del servidor
            System.out.println("Servidor UDP encendido");
            //Creacion del socket
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            //Comenzando a atender peticiones
            while (true) {
                //Preparando la respuesta del servidor
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                //Recepcion del datagrama
                socketUDP.receive(peticion);

                //Impresion del mensaje recibido
                String mensaje = new String(peticion.getData());

                System.out.println(mensaje);
            }

        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
