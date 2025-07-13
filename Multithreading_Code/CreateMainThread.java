class IndiaThread extends Thread
{
	public void run()
	{
	  try
	  {
	  	for(int i=0;i<5;i++)
	  	{
	  		System.out.println(getName()+" : IND");
	  		Thread.sleep(1000);
	  	}
	  }
	  catch(Exception e)
	  {
	  	e.printStackTrace();
	  }
	}
}

class AustraliaThread extends Thread
{
	public void run()
	{
	  try
	  {
	  	for(int i=0;i<5;i++)
	  	{
	  		System.out.println(getName()+" : AUS");
	  		Thread.sleep(1000);
	  	}
	  }
	  catch(Exception e)
	  {
	  	e.printStackTrace();
	  }
	}
} 


public class CreateMainThread
{
	public static void main(String args[])
	{
		
		Thread t1=new Thread(new IndiaThread());
		Thread t2=new Thread(new AustraliaThread());
		t1.start();
		t2.start();
		
		try
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("Main-Thread");
				Thread.sleep(1000);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}



