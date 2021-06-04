package corejava.multithreading;

import java.lang.*;

// MyThread extending Thread
class Demo extends Thread
{
    public void run()
    {
        for (int i=0; i<5 ; i++)
            System.out.println(Thread.currentThread().getName()
                    + " in control");
    }
}

// Driver Class
public class YieldDemo
{
    public static void main(String[]args)
    {
        Demo t = new Demo();
        t.setPriority(10);
        t.start();

        for (int i=0; i<5; i++)
        {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }
}

