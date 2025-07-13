
class PrintThreads extends Thread
{
	String msg;
	int n;
	
	public PrintThreads(String msg,int n)
	{
		this.msg=msg;
		this.n=n;
	}
	
	public void run()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(this.getName()+" : "+msg);
		}
	}
}

public class PrintThread
{
	public static void main(String args[])
	{
		PrintThreads t1=new PrintThreads("IND",5);
		PrintThreads t2=new PrintThreads("AUS",5);
		PrintThreads t3=new PrintThreads("ENG",3);
		t1.start();
		t2.start();
		t3.start();

	}
}
