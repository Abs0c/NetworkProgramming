package com.gmail.juyonglee0208.threadGroup;

class CountDown implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread Name: " + currentThread.getName());
            System.out.println("Thread Group: " + currentThread.getThreadGroup());
            System.out.println(i);
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
