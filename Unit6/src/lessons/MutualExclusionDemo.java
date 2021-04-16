package lessons;

/**
 * Two shoppers adding items to a shared notepad
 */

import java.util.concurrent.locks.*;

class Shopper1 extends Thread {

    static int garlicCount = 0;
    static Lock pencil = new ReentrantLock();

    public void run() {
//    	pencil.lock(); // setting lock here would define the program region that requires mutual exclusion to be too large
    	
        for (int i=0; i<5; i++) {
            pencil.lock();
            garlicCount++; // only need to protect this region which increments the garlic counter
            pencil.unlock();
            System.out.println(Thread.currentThread().getName() + " is thinking.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

public class MutualExclusionDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper1();
        Thread olivia = new Shopper1();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper1.garlicCount + " garlic.");
    }
}
