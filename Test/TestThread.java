package Test;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class TestThread implements Runnable{
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DatagramSocket socket = new DatagramSocket()
        ){
            String sendMessage = br.readLine();
            while(sendMessage != "종료"){
                byte[] buffer = sendMessage.getBytes();
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
