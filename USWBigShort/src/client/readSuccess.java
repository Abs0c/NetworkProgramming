package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class readSuccess implements Runnable{
    @Override
    public void run() {
        while(true){
            //서버에서 매수/매도 요청 받아오기
            try (DatagramSocket socket = new DatagramSocket(7000, InetAddress.getByName("localhost"))){
                byte[] receiveMessage = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveMessage, receiveMessage.length);
                socket.receive(receivePacket);
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new ByteArrayInputStream(receivePacket.getData()));
                Object object = objectInputStream.readObject();
                System.out.println(object);
                //받아온 정보 gui에 갱신
                client.clientFrame.LabelUpdate((Coin) object);
            }catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
