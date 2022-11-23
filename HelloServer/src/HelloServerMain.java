package HelloServer.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServerMain {
    //TCP Server
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void startServer(){
        try {
            serverSocket = new ServerSocket(3000); // 서버 소켓 만들고 포트 할당
            //serverSocket.bind(new InetSocketAddress(Inet4Address.getByName()))
            System.out.println("Listen.......");
            while (true){
                clientSocket = serverSocket.accept(); // 클라이어느 연결 들어오면 accept하고 상대방의 소켓을 얻음
                System.out.println("Accept.......");
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = in.readLine();
                System.out.println(message);
                if (message.equals("Hello Server!!!")){
                    out.println("Hello Client!!!");
                }
                else{
                    out.println("Get Out!!!");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stpoServer() throws IOException{
        in.close(); //
        out.close(); //스트림은 반드시 사용하고 닫아줘야한다.
        clientSocket.close(); // 획득해 온 클라이언트 소켓부터 끊고
        serverSocket.close(); // 그 다음에 서버 소켓 끊고
    }


    public static void main(String[] args) {
        HelloServerMain main = new HelloServerMain();
        main.startServer();
    }
}