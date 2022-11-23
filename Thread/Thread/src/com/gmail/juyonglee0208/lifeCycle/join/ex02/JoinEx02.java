package com.gmail.juyonglee0208.lifeCycle.join.ex02;

public class JoinEx02 {

    public static void main(String[] args) {
        MyGC myGC = new MyGC();
        myGC.setDaemon(true);
        myGC.start();

        int requiredMemory = 0;
        for (int i = 0; i < 20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;
            if (myGC.freeMemory() < requiredMemory || myGC.freeMemory() < myGC.totalMemory() * 0.4) {
                myGC.interrupt();
                try {
                    myGC.join(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            myGC.usedMemory += requiredMemory;
            System.out.println("UsedMemory: " + myGC.usedMemory);
        }
    }
}
