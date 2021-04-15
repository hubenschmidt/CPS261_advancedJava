package lessons;
import java.util.Date;

public class MyThread1 extends Thread{
	
	public void run() {
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				Date d = new Date();
				System.out.println("Date = " + d);
			}
			catch (InterruptedException e) {
				System.out.print(e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 mt = new MyThread1();
		mt.start();
		   for (int count = 1, row = 1; row < 20; row++, count++)
		   {
		        for (int i = 0; i < count; i++)
		             System.out.print ('*');
		        System.out.print ('\n');
		   }
		System.out.println("Exiting main thread");

	}

}
