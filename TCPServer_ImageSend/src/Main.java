import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    // TCP Server
    static ServerSocket serverSocket;
    static Socket clientSocket;
    static BufferedInputStream filein;
    static BufferedOutputStream fileout;

    public static void startServer() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(Inet4Address.getLocalHost(), 3000));
            System.out.println("Listen......");
            clientSocket = serverSocket.accept();
            System.out.println("Accept");
            fileout = new BufferedOutputStream(clientSocket.getOutputStream());
            filein = new BufferedInputStream(new FileInputStream("C:\\Users\\qjfjr\\Desktop\\test\\test.jpg"));
            int data;
            System.out.println("File Copy Start!");
            while((data = filein.read()) != -1){
                fileout.write(data);
            }
            System.out.println("File Copy Finish!"); // 이 문구가 안 뜬다면 파일이 커서 블라킹 당한것
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer(){
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServer();
        //main.stopServer();
    }
}



