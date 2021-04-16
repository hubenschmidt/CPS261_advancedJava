package SyncSum;

class MySum extends Thread {
    static int sum = 0;

    synchronized private static void increaseSum(Thread t) {
	try {
	    Thread.sleep(100);
	    sum++;

	    System.out.println(t.getName() + " sum is: " + sum);

	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

    public void run() {

	for (int i = 0; i < 10; i++) {
	    Thread t = new Thread();
	    increaseSum(t);

	}

    }

}

public class SyncSum {

    public static void main(String[] args) {
	MySum mySum = new MySum();
	mySum.start();

    }

}
