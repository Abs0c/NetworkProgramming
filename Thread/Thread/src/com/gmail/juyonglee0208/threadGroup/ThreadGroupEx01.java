package com.gmail.juyonglee0208.threadGroup;

public class ThreadGroupEx01 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getThreadGroup().getName());
        System.out.println(thread.getThreadGroup().getParent());
        System.out.println(thread.getThreadGroup().getMaxPriority());
        System.out.println("");

        thread.getThreadGroup().list();
    }
}
