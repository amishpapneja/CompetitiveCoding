package corejava.multithreading;

import java.util.Random;

public class SleepDemo implements Runnable {
    Thread t;

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "  " + i);
            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(new Random().nextInt(999));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new SleepDemo());

        // call run() function
        t.start();

        Thread t2 = new Thread(new SleepDemo());

        // call run() function
        t2.start();
    }
}
