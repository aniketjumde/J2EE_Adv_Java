
class IndiaThread implements Runnable 
{
	public void run()
	{
		try
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("IND");
				Thread.sleep(100);
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	
	}

}

class AustraliaThread implements Runnable 
{
	public void run()
	{
		try
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("AUS");
				Thread.sleep(100);
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	
	}

}

public class CreateThreadUsingRunnable
{
	public static void main(String args[])
	{
		/*IndiaThread t1=new IndiaThread();
		Thread tob1=new Thread(t1);
		
		AustraliaThread t2=new AustraliaThread();
		Thread tob2=new Thread(t2);
		
		
		tob1.start();
		tob2.start();
		*/
		
		Thread t1=new Thread(new IndisThread());
		Thread t2=new Thread(new AustraliaThraed());
		t1.start();
		t2.start()
		
		
	
	}
}



