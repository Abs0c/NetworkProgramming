import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()){
            socket.setBroadcast(true);//브로드캐스트 서버로 쓰겠다는 뜻
            InetAddress groupAddress = InetAddress.getByName("255.255.255.255");// 브로드캐스트 주소
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
                Thread.sleep(3000);
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
