package com.gmail.juyonglee0208.lifeCycle.interrupt;

class CountDownRefactor extends Thread {

    public CountDownRefactor() {
    }

    public CountDownRefactor(String name) {
        super(name);
    }

    @Override
    public void run() {
        int countDowm = 10;
        while (!isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName() );
                System.out.println(countDowm--);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("Count Down 종료!");
    }
}

public class interruptEx02 {

    public static void main(String[] args) {
        Thread countDownThread = new CountDownRefactor("[CountDown Thread]");
        countDownThread.start();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownThread.interrupt();
        System.out.println(countDownThread.isInterrupted());
    }
}
