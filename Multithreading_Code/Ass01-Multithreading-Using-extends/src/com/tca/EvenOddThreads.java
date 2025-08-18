package com.tca;
class EvenPrinter extends Thread 
{
    public void run() 
    {
        for (int i = 2; i <= 20; i += 2) 
        {
            System.out.println("Even: " + i);
            try 
            {
                Thread.sleep(100);
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

class OddPrinter extends Thread 
{
    public void run() 
    {
        for (int i = 1; i <= 19; i += 2) 
        {
            System.out.println("Odd: " + i);
            try 
            {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

public class EvenOddThreads 
{
    public static void main(String[] args) 
    {
        Thread evenThread = new Thread(new EvenPrinter());
        Thread oddThread = new Thread(new OddPrinter());

        evenThread.start();
        oddThread.start();
    }
}