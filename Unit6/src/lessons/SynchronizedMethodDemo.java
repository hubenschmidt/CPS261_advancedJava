package lessons;

/**
 * Two shoppers adding items to a shared notepad
 */

class Shopper3 extends Thread {

    static int garlicCount = 0;

    private static synchronized void addGarlic() {
	garlicCount++;
    }

    // method without synchronized declaration produces a data race:
//    private static void addGarlic() {
//	garlicCount++;
//    }

    public void run() {
	for (int i = 0; i < 10_000_000; i++)
	    addGarlic();
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) throws InterruptedException {
	Thread barron = new Shopper3();
	Thread olivia = new Shopper3();
	barron.start();
	olivia.start();
	barron.join();
	olivia.join();
	System.out.println("We should buy " + Shopper3.garlicCount + " garlic.");
    }
}
