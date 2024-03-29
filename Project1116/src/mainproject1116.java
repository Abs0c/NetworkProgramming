package Project1116.src;

import java.io.IOException;
import java.net.*;

public class mainproject1116 {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()){
            //socket.setBroadcast(true);//브로드캐스트 서버로 쓰겠다는 뜻
            InetAddress groupAddress = InetAddress.getByName("224.0.0.1");// 브로드캐스트 주소
            while(true){
                int a = ((int)(Math.random() * 9)  + 1);
                int b = ((int)(Math.random() * 9)  + 1);
                String message = a + " + " + b + " = " + (a+b) + "   "
                        + a + " - " + b + " = " + (a-b) + "   "
                        + a + " * " + b + " = " + (a*b) + "   "
                        + a + " / " + b + " = " + (a/b);
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, 4000);
                socket.send(packet);
                Thread.sleep(1000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
