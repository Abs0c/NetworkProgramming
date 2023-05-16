package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class client {
    static clientFrame clientFrame;

    public client() {
        clientFrame = new clientFrame();
        readCoinInfoThread readCoinInfoThread = new readCoinInfoThread();
        readCoinInfoThread.run();
    }

    public static void main(String[] args) {
        new client();
    }
}