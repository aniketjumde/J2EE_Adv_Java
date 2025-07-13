
class Resource 
{
	int count=0;
	
	public synchronized void increment()
	{
		count++;
	}
}

class AddThread extends Thread
{
	Resource r;
	public AddThread(Resource r)
	{
		this.r=r;
	}
	
	public void run()
	{
		for(int i=1;i<=5000;i++)
		{
			r.increment();
		}
	}

}

public class SynchronizationInThread
{
	public static void main(String args[]) throws Exception
	{
		Resource r=new Resource();
	
		AddThread t1=new AddThread(r);
		AddThread t2=new AddThread(r);	

		t1.start();
		t2.start();
	
		t1.join();
		t2.join();
	
		System.out.println("Resource :"+r.count);
	}
}
