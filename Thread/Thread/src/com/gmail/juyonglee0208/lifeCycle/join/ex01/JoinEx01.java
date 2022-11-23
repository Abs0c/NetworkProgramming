package com.gmail.juyonglee0208.lifeCycle.join.ex01;

public class JoinEx01 {

    public static void main(String[] args) {
        FileDownLoader downLoader01 = new FileDownLoader("Test.mp4", 10000);
        FileDownLoader downLoader02 = new FileDownLoader("Sample.mp4", 20000);
        downLoader01.start();
        downLoader02.start();
        try {
            downLoader01.join();
            downLoader02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread 종료");
    }
}
