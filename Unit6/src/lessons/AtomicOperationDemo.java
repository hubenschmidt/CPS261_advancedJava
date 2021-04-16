package lessons;

/**
 * Two shoppers adding items to a shared notepad
 * Atomicity. Atomic operations are those operations that ALWAYS execute together. 
 * Either all of them execute together, or none of them executes. If an operation is atomic, 
 * then it cannot be partially complete, either it will be complete, or not start at all, 
 * but will not be incomplete.
 */

//https://howtodoinjava.com/java/multi-threading/atomicinteger-example/
import java.util.concurrent.atomic.AtomicInteger;

class Shopper2 extends Thread {

    static AtomicInteger garlicCount = new AtomicInteger(0);

    public void run() {
	for (int i = 0; i < 10_000_000; i++)
	    garlicCount.incrementAndGet();

    }
}

public class AtomicOperationDemo {
    public static void main(String[] args) throws InterruptedException {
	Thread barron = new Shopper2();
	Thread olivia = new Shopper2();
	barron.start();
	olivia.start();
	barron.join();
	olivia.join();
	System.out.println("We should buy " + Shopper2.garlicCount + " garlic.");
    }
}
