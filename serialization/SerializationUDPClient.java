package serialization;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SerializationUDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(3000);){
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
            Object object = objectInputStream.readObject();
            System.out.println(object.toString());
        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
