package ThreadEx;

public class ThreadEx01 extends Thread{
    public ThreadEx01(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 10; i > -1; i--){
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
