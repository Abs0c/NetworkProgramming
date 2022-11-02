package ThreadEx;

public class Main {
    public static void main(String[] args) {
        ThreadEx01 ex01 = new ThreadEx01("A1");
        ThreadEx01 ex02 = new ThreadEx01("B1");
        ThreadEx01 ex03 = new ThreadEx01("C1");

        ex01.start();
        ex02.start();
        ex03.start();

        Thread exex01 = new Thread(new ThreadEx02());
        Thread exex02 = new Thread(new ThreadEx02());
        Thread exex03 = new Thread(new ThreadEx02());

        exex01.start();
        exex02.start();
        exex03.start();
    }

    //이런 식으로 하면 동시에 3개가 실행되지만, 순서를 보장하진 못하는 상태.

    //ex01.run(); // 일회성으로 실행하고 죽어버리므로 얘를 쓰는게 아니라
    //ex01.start(); // 얘를 쓰는것
        /*
        countDown("A1");//얘가 끝나고
        countDown("B1");//얘가 실행되고 나서 얘가 끝나면
        countDown("C1");//얘가 실행되는..  동시에 실행되지 않고 차례를 기다리고 있음..
         */


    /*
    public static void countDown(String name){ //쓰레드에 있을때와 아닐때를 비교하기 위해 쓰레드에 넣은 함수를 그대로 가져와서 확인하려는 용도.
        for (int i = 10; i > -1; i--){
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     */
}
