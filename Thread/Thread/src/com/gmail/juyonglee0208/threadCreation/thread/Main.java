package com.gmail.juyonglee0208.threadCreation.thread;

public class Main {

    public static void main(String[] args) {
        ThreadEx01 a1 = new ThreadEx01("A1");
        ThreadEx01 b1 = new ThreadEx01("B1");
        ThreadEx01 c1 = new ThreadEx01("C1");
        a1.start();
        b1.start();
        c1.start();
    }
    
}
