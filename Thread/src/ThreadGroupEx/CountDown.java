package ThreadGroupEx;

public class CountDown implements Runnable{
    @Override
    public void run() {
        Thread currentthread = Thread.currentThread();
        System.out.println("Thread Name: " + currentthread.getName());
        System.out.println("ThreadGroup Name: " + currentthread.getThreadGroup());
        for (int i = 10; i > -1; i--){
            System.out.println(currentthread.getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
