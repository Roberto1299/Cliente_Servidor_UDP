package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Definiendo el puerto del servidor
        final int PUERTO_SERVIDOR = 12000;
        //Buffer donde se almacenaran los mensajes
        byte[] buffer = new byte[1024];
        
        try {
            //Definiendo la localizacion del servidor por nombre
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            
            //Se crea el socket UDP
            DatagramSocket socketUDP = new DatagramSocket();
            
            //Escrbiiendo el mensaje
            String mensaje = "¡¡¡HOLA MUNDO!!!";
            
            //Convirtiendo el mensaje a bytes para poder ser enviado por el canal
            buffer = mensaje.getBytes();
            
            //Creamos el datagrama
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            
            //Enviamos el datagrama
            socketUDP.send(pregunta);
            
            //Confirmación del envio del mensaje
            System.out.println("Se envío el mensaje");
            
            //Cerramos el socket
            socketUDP.close();

        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
