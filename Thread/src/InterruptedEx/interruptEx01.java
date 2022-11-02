package InterruptedEx;

public class interruptEx01 {
    public static void main(String[] args) {
        Thread countDownThread = new CountDown("[CountDown Thread]");
        countDownThread.start();
    }
}
