package DaemonThreadEx;

public class Notification implements Runnable{
    @Override
    public void run() {
        while (true){
            int meessage = (int) (Math.random()*10) + 1;
            try {
                System.out.println("Message Count: " + meessage);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
