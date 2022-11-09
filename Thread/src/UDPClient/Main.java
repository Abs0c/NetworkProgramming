package UDPClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    //DatagramSocket
    //DatagramPacket
    public static void main(String[] args) {
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              DatagramSocket socket = new DatagramSocket()){
            while(true) {
                String inputStr = br.readLine();
                if (inputStr == "-1"){
                    break;
                }
                byte[] buffer = inputStr.getBytes();
                InetAddress address = InetAddress.getByName("172.16.39.188"); //교수님 서버 주소
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
