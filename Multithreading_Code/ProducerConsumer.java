import java.util.*;
class Resource
{
	LinkedList<Integer> buffer=new LinkedList<>();
	int capacity=5;
	
	public void produce() throws InterruptedException
	{
		int value=0;
		while(true)
		{
			synchronized(this)
			{
				while(buffer.size()==capacity)
				{
					wait();
				}
				System.out.println("Producer Produce : "+value);
				value++;
				buffer.add(value);
				
				notify();
				
				Thread.sleep(1000);
				
			}
			
		}
	}
	
	public void consume() throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				while(buffer.size()==0)
				{
					wait();
				}
				
				int value=buffer.removeFirst();
				System.out.println("Consumer consume : "+value);
				
				notify();
				Thread.sleep(1000);
			
			}
		}
	}


}


class ProducerThread extends Thread
{
	Resource resourceob; 
	
	public ProducerThread(Resource resourceob)
	{
		this.resourceob=resourceob;
	}
	
	public void run()
	{
		try
		{
			resourceob.produce();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}

class ConsumerThread extends Thread
{
	Resource resourceob; 
	
	public ConsumerThread(Resource resourceob)
	{
		this.resourceob=resourceob;
	}
	
	public void run()
	{
		try
		{
			resourceob.consume();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}


public class ProducerConsumer
{
	public static void main(String args[])
	{
		Resource r=new Resource();
	
		ProducerThread t1=new ProducerThread(r);
		ConsumerThread t2=new ConsumerThread(r);
	
		t1.start();
		t2.start();
	}

}
