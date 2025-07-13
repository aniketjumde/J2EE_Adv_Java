import java.io.*;
import java.util.*;

class SumThread extends Thread
{
	int a[];
	int start;
	int end;
	int sum;
	
	public SumThread(int a[],int start,int end)
	{
		this.a=a;
		this.start=start;
		this.end=end;
		this.sum=0;		
	}
	
	public void run()
	{
		for(int i=start ;i<=end;i++)
		{
			sum=sum+a[i];
		}
	}
}
 
public class SumOFThread 
{	
	public static void main(String args[]) throws Exception
	{
		int n=100;
		int a[]=new int[n];
		Random r=new Random();
		
		
		
		for(int i=0;i<n;i++)
		{
			a[i]=r.nextInt(1000);
			//a[i]=i+1;
		}
		
		System.out.println("OUTPUT : "+Arrays.toString(a));
		
		Sum t1=new Sum(a,0,19);
		Sum t2=new Sum(a,20,39);
		Sum t3=new Sum(a,40,59);
		Sum t4=new Sum(a,60,79);
		Sum t5=new Sum(a,80,99);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		int total=t1.sum+t2.sum+t3.sum+t4.sum+t5.sum;
		
		System.out.println("Sum of Nth Number : "+total);
		
	}
}
