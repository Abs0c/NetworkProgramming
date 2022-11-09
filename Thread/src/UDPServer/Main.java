package UDPServer;

import java.io.IOException;
import java.net.*;

public class Main {
    //DatagramSocket
    //DatagramPacket
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(8080)) { //프로그램 사용 후에 자동으로 소켓 같은걸 닫아주는 구문
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                System.out.println("UDP Client Waitiing......");
                socket.receive(packet);
                byte[] receivedData = packet.getData();
                System.out.println("[Client] IP: " + packet.getAddress().getHostAddress() + ", Port:" + packet.getPort());
                System.out.println("offset: " + packet.getOffset() + ", Length: " + packet.getLength() + "\n");
                String message = new String(receivedData, packet.getOffset(), packet.getLength());
                System.out.println("[Message] " + message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
