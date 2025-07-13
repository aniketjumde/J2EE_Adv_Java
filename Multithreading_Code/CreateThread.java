
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


public class CreateThread
{
	public static void main(String args[])
	{
		IndiaThread t1=new IndiaThread();  //Thread-0
		AustraliaThread t2=new AustraliaThread();//Thread-1
		t1.setName("IND-Thread");
		t2.setName("AUS-Thread");
		t1.start();
		t2.start();
	}
}
