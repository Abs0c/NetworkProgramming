package com.gmail.juyonglee0208.lifeCycle.interrupt;

class interruptEx01 {

    public static void main(String[] args) {
        Thread countDownThread = new CountDown("[CountDown Thread]");
        countDownThread.start();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownThread.interrupt();
        System.out.println("isInterrupted: " + countDownThread.isInterrupted());
    }
}
