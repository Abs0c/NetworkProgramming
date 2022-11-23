package com.gmail.juyonglee0208.daemon;

public class DaemonEx01 {

    public static void main(String[] args) {
        try {
            Thread notiThread = new Thread(new Notification() , "Noti Daemon Thread");
            notiThread.setDaemon(true);
            notiThread.start();
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            System.out.println("Daemon? " + notiThread.isDaemon());
            Thread.currentThread().getThreadGroup().list();
            Thread.sleep(10 * 1000);
            System.out.println("Main Thread End!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
