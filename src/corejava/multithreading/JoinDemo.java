package corejava.multithreading;

public class JoinDemo implements Runnable
{
    public void run()
    {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " +
                Thread.currentThread().getName());
        System.out.println("Is T Alive? "
                + t.isAlive());
        for(int i=0;i<3;i++){
            try {
                System.out.println("Running: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String args[]) throws Exception
    {
        Thread t = new Thread(new JoinDemo());
        t.start();

        // Waits for 1000ms this thread to die.
        System.out.println("Waiting on T thread by calling join for 5000 millis");
        t.join(5000);

        System.out.println("\nWaiting done, now joining main thread after 5000"+
                " mili seconds: \n");
        System.out.println("Current thread: " +
                Thread.currentThread().getName());


        // Checks if this thread is alive
        System.out.println("Is T alive? " + t.isAlive());
    }
}
