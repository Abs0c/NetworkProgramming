package server;

import client.Coin;

import javax.xml.crypto.Data;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server{
    public server(){
        try (DatagramSocket socket = new DatagramSocket(6001)) {
            Coin coin = new Coin(1L, "UDP Coin 1", "테스트 코인 1번");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(coin);
            objectOutputStream.flush();
            byte[] buffer = byteArrayOutputStream.toByteArray();
            InetAddress clientAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, clientAddress, 6000);
            socket.send(packet);
            System.out.println("packet send!");
            System.out.println(coin);
        } catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new server();
    }
}
