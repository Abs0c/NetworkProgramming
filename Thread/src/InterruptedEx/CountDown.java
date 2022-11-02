package InterruptedEx;

public class CountDown extends Thread{
    public CountDown(String name){
        super(name);
    }
    @Override
    public void run() {
        int countDown = 10;
        Thread currentthread = Thread.currentThread();
        while(countDown != 0 && !isInterrupted()){
            System.out.println("Thread Name: " + currentthread.getName());
            System.out.println("ThreadGroup Name: " + currentthread.getThreadGroup());
            System.out.println(countDown--);
        }
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            interrupt(); //메인에서 CountDown 스레드를 인터럽트를 걸었을때 메인에서 isInterrupted가 true가 되지만
            //그 후에 countDown스레드로 넘어오므로 여기서의 isInterrupted는 false이므로 여기서 다시 interrupt를 해줘야한다.
        }
        System.out.println("Count Down 종료!");
    }
}
