package thread;

import java.util.concurrent.Semaphore;

public class Car1 implements Runnable {

    private int carNo;

    public Car1(int carNo) {
        this.carNo = carNo;
    }

    public void run() {

        try {
            parking();
            sleep(300);
            leaving();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void parking() {
        System.out.println(String.format("%d号车泊车", carNo));
    }

    private void leaving() {
        System.out.println(String.format("%d号车离开车位", carNo));
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

}


