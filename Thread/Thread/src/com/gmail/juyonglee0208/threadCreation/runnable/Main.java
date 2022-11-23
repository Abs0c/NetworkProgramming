package com.gmail.juyonglee0208.threadCreation.runnable;

public class Main {

    public static void main(String[] args) {
        Thread a1 = new Thread(new CountDown());
        Thread b1 = new Thread(new CountDown());
        Thread c1 = new Thread(new CountDown());
        a1.start();
        b1.start();
        c1.start();
    }

}
