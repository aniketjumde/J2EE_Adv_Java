
public class DemoThread
{
	public static void main(String args[])
	{
		Thread t1=Thread.currentThread();
		System.out.println(t1);
		t1.setName("Aniket"); // Set The Thread Name
		System.out.println(t1);
		System.out.println("Thread is Alive : "+t1.isAlive()); //this Function is give thread is close or live
		System.out.println("Thread Name     : "+t1.getName());
		System.out.println("Thread Priority : "+t1.getPriority());
		System.out.println("Thread Group    : "+t1.getThreadGroup());
	}	
	
}
