package lessons;

class Bucket {
	private int contents;
	private boolean fullFlag = false;
	
	public synchronized boolean get(int consumerNumber) {
		if (fullFlag) {
			System.out.println("Consumer " + consumerNumber + " Emptying Bucket " + contents);
			
			fullFlag = false;
			return true; //successful
		}
		return false; // unsuccessful
	}
	
	public synchronized boolean put(int value) {
		if (fullFlag) {
			System.out.println("Filling Bucket " + value);
			contents = value;
			fullFlag = true;
			return true; // successful
		}
		return false; // unsuccessful
	}
	
}

class Producer extends Thread {
	private Bucket bucket;
	private int number;
	
	public Producer(Bucket c, int number) {
		bucket = c;
		this.number = number;
	}
	
	public void run() {
		int numSuccess = 0;
		int numTries = 0;
		int fillValue;
		
		do {
			try {
				sleep((int)(Math.random()*2000));
				
			} catch (InterruptedException e) {}
			
			fillValue = numSuccess + number*100;
			numTries += 1;
			if (bucket.put(fillValue))
				numSuccess += 1;
			if (bucket.put(fillValue))
				numSuccess += 1;
		} while (numSuccess <10);
		System.out.println(number + " **** Terminating Producer " + numTries + " numTries");
	}
}

class Consumer extends Thread {
	private Bucket bucket;
	private int number;
	
	public Consumer(Bucket c, int number) {
		bucket = c;
		this.number = number;
	}
	
	public void run() {
		int numSuccess = 0;
		int numTries = 0;
		
		do {
			try {
				sleep((int)(Math.random()*20));
				
			} catch (InterruptedException e) {}
			
			numTries += 1;
			if (bucket.get(number))
				numSuccess += 1;
		
		} while (numSuccess <10);
		System.out.println(number + " **** Terminating Consumer " + numTries + " numTries");
	}
}

public class BusyLoop {
	public static void main(String[] args) {
		Bucket bucket = new Bucket();
		Producer p1 = new Producer(bucket,1);
		Consumer c1 = new Consumer(bucket,1);
		c1.start();
		p1.start();
		System.out.println("BusyLoop main will exit now");
	}
}


