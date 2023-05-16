package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class readCoinInfoThread implements Runnable{
    @Override
    public void run() {
        while(true){
            //서버에서 코인 정보 갱신 broadcastsocket.read를 통해 읽어오고
            try (DatagramSocket socket = new DatagramSocket(6000, InetAddress.getByName("localhost"))){
                byte[] receiveMessage = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveMessage, receiveMessage.length);
                socket.receive(receivePacket);
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new ByteArrayInputStream(receivePacket.getData()));
                Object object = objectInputStream.readObject();
                System.out.println(object);
                //읽어온 정보를 업데이트 시켜줌
                client.clientFrame.LabelUpdate((Coin) object);
            }catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
