package com.gmail.juyonglee0208.lifeCycle.sleep;

public class sleepEx01 {

    public static void main(String[] args) {
        Thread plusPrintThread = new Thread(new PlusPrintOperation());
        Thread minusPrintThread = new Thread(new MinusPrintOperation());
        plusPrintThread.start();
        minusPrintThread.start();
        try {
            minusPrintThread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread 종료");
    }
}
