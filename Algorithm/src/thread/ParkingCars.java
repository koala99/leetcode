package thread;

/**
 * Created by lilei on 16/8/18.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ParkingCars {

    private static final int NUMBER_OF_CARS = 30;

    private static final int NUMBER_OF_PARKING_SLOT = 10;

    public static void main(String[] args) {

    /*
     * 采用FIFO, 设置true ,公平模式与非公平模式
     */
        Semaphore parkingSlot = new Semaphore(NUMBER_OF_PARKING_SLOT, false);
        ExecutorService service = Executors.newCachedThreadPool();
//        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PARKING_SLOT);


        for (int carNo = 1; carNo <= NUMBER_OF_CARS; carNo++) {
            service.execute(new Car(parkingSlot, carNo));
//            service.execute(new Car1(carNo));

        }

        sleep(3000);

        service.shutdown();

    /*
     * 输出还有几个可以用的资源数
     */
        System.out.println(parkingSlot.availablePermits() + " 个停车位可以用!");
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