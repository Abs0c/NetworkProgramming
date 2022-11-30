package Project1116Client.src;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try (MulticastSocket socket = new MulticastSocket(4000)) {
            InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
            socket.joinGroup(groupAddress); //멀티캐스트 사용시 소켓을 MulticastSocket으로 만들고 joinGroup
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while(true){
                socket.receive(packet);
                byte[] receiveData = packet.getData();
                String data = new String(receiveData, 0, packet.getLength());
                System.out.println(data);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
