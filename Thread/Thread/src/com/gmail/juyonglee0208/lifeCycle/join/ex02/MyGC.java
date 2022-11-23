package com.gmail.juyonglee0208.lifeCycle.join.ex02;

class MyGC extends Thread {

    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupt Call!");
            }
            gc();
            System.out.println("[Garbage Collected] Free Memory: " + freeMemory());
        }
    }

    public void gc() {
        usedMemory -= 300;
        if (usedMemory < MAX_MEMORY) {
            usedMemory = 0;
        }
    }

    public int totalMemory() {
        return MAX_MEMORY;
    }

    public int freeMemory() {
        return MAX_MEMORY - usedMemory;
    }
}
