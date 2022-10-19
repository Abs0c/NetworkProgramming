import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;

public class Main {
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void serverConnection(){
        try {
            clientSocket = new Socket(Inet4Address.getByName("172.16.39.165"), 3000);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        out.println(message);
        try {
            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.serverConnection();
        main.sendMessage("Hello Server!!! 김동욱44");
    }
}