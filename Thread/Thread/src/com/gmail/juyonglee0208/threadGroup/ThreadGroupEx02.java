package com.gmail.juyonglee0208.threadGroup;

public class ThreadGroupEx02 {

    public static void main(String[] args) throws SecurityException {
        ThreadGroup timer = new ThreadGroup("Timer");
        System.out.println(timer.getMaxPriority());
        ThreadGroup suwon = new ThreadGroup(timer, "Suwon Timer");
        suwon.setMaxPriority(1);
        ThreadGroup jeju = new ThreadGroup(timer, "Jeju Timer");
        jeju.setMaxPriority(10);
        Thread suwonCountDown = new Thread(suwon, new CountDown(), "Suwon CountDown");
        Thread jejuCountDown = new Thread(jeju, new CountDown(), "Jeju CountDown");
        suwonCountDown.start();
        try {
            suwonCountDown.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jejuCountDown.start();
    }
}
