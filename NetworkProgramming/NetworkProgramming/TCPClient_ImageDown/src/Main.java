import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class Main {

    static Socket clientSocket;
    static BufferedInputStream filein;
    static BufferedOutputStream fileout;

    public static void serverConnection() {
        try {
            clientSocket = new Socket(Inet4Address.getLoopbackAddress(), 3000);
            filein = new BufferedInputStream(clientSocket.getInputStream());
            // fileout = new BufferedOutputStream(new FileOutputStream("./test_copy.mp4"));
            fileout = new BufferedOutputStream(new FileOutputStream("./test_copy.jpg"));
            int data;
            System.out.println("File Copy Start!");
            while((data = filein.read()) != -1){
                fileout.write(data);
            }
            fileout.flush();
            System.out.println("File Copy Finish!"); // 이 문구가 안 뜬다면 파일이 커서 블라킹 당한것
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        serverConnection();
    }
}
