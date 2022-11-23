package com.gmail.juyonglee0208.lifeCycle.sleep;

class MinusPrintOperation implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("-");
        }
        System.out.println("MinusPrintOperation Thread 종료");
    }
}
