package com.gmail.juyonglee0208.threadCreation.runnable;

public class CountDown implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
