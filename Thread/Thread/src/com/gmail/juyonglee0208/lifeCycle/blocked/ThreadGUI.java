package com.gmail.juyonglee0208.lifeCycle.blocked;

import javax.swing.JOptionPane;

public class ThreadGUI extends Thread {

    public static void main(String[] args) {
        ThreadGUI threadGUI = new ThreadGUI();
        threadGUI.start();
        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        System.out.println("안녕하세요! " + name + "님");
    }

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.printf("Count: %d\n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
