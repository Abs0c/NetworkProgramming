package ThreadEx;

public class ThreadEx02 implements Runnable{
    Thread currentThread = Thread.currentThread();
    @Override
    public void run() {
        for (int i = 10; i > -1; i--){
            System.out.println(currentThread.getName() + ": " + i);
            //Thread의 static method 중 현재 사용하고 있는 Thread를 리턴해주는 currentThread를 이용하여
            //Thread 정보를 갖고와서 거기서 getName method를 사용함
            //Runnable 인터페이스넨 getName method가 없으니까..
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
