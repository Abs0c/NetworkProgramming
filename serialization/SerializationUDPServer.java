package serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SerializationUDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000);){
            User user = new User(1L, "UDP Client 1", "1234");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            byte[] buffer = byteArrayOutputStream.toByteArray();
            InetAddress clientAddress = InetAddress.getByName("172.16.39.153");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, clientAddress, 3000);
            socket.send(packet);
            System.out.println("packet send!");
        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
