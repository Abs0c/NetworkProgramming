package UDP;

import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class UDPEchoClient {
    
    public static void main(String[] args) {

        System.out.println("UDP Echo Client Started");
        try {
            SocketAddress remote = new InetSocketAddress("127.0.0.1", 9000);
            DatagramChannel channel = DatagramChannel.open(); // 채널은 열고나서
            channel.connect(remote); // 클라이언트랑 서버에 각각 채널이 있으니 그걸 연결하겠다 가 아니라
            // 무전기의 주파수를 맞추는 느낌 => 채널을 맞추는 느낌
            
            String message = "The message";
            ByteBuffer buffer = ByteBuffer.allocate(message.length());
            buffer.put(message.getBytes());
            
            buffer.flip();
            channel.write(buffer);
            System.out.println("Sent: [" + message + "]");

            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            System.out.print("Received: [");
            while(buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            System.out.println("]");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("UDP Echo Client Terminated");
    }
}
