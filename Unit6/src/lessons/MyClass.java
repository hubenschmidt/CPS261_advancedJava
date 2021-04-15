package lessons;

import java.util.Date;

//any class can implement runnable.
public class MyClass implements Runnable{
	
	public void run () {
		while (true)
		{
			try {
				Thread.sleep(1000);
				Date d = new Date();
				System.out.println("Date = " + d);
			}
			catch (InterruptedException e) {
				
			}
		}
	}

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		Thread t = new Thread(mc);
		t.start();
		   for (int count = 1, row = 1; row < 20; row++, count++)
		   {
		        for (int i = 0; i < count; i++)
		             System.out.print ('*');
		        System.out.print ('\n');
		   }
		System.out.println("Exiting main thread");

	}

}
