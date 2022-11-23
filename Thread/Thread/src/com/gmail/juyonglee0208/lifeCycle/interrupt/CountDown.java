package com.gmail.juyonglee0208.lifeCycle.interrupt;

class CountDown extends Thread {

    public CountDown() {
    }

    public CountDown(String name) {
        super(name);
    }

    @Override
    public void run() {
        int countDowm = 10;
        while (countDowm != 0 && !isInterrupted()) {
            System.out.println(isInterrupted());
            System.out.println(Thread.currentThread().getName());
            System.out.println(countDowm--);
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("일어났다!!");
            }
        }

    }
}
