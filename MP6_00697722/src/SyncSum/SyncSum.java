package SyncSum;

class MySum {
    static int sum = 0;

//    synchronized private static void increaseSum() { // method sync
    public void increaseSum() {
	try {

	    /*
	     * use with method sync or with unsynchronized demo:
	     */
//	    Thread.sleep(100);
//	    sum++;
//	    System.out.println(Thread.currentThread().getName() + " sum is: " + sum);

	    synchronized (this) { // block sync
		Thread.sleep(100);
		sum++;
		System.out.println(Thread.currentThread().getName() + " sum is: " + sum);
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

}

public class SyncSum {
    static int numThreads = 100;

    public static void main(String[] args) {
	MySum mySum = new MySum();
	for (int i = 0; i < numThreads; i++) {
	    Runnable runnable = () -> {
		mySum.increaseSum();
	    };
	    Thread t = new Thread(runnable);

	    t.start();

	}

    }

}
