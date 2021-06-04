package corejava.multithreading;

import java.util.Scanner;

class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer started and waiting");
            wait();
            System.out.println("Producer Completed");

        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner s = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Inside Consumer");
            s.nextLine();
            notifyAll();

        }
    }
}

public class Concurrency {
    public static int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static int[] arr2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    static class Thread1 implements Runnable {
        Processor p;

        public Thread1(Processor p) {
            this.p = p;
        }

        @Override
        public void run() {
            try {
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Thread2 implements Runnable {
        Processor p;

        public Thread2(Processor p) {
            this.p = p;
        }

        @Override
        public void run() {
            try {
                p.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        Processor p = new Processor();
        Thread t1 = new Thread(new Thread1(p));
        Thread t2 = new Thread(new Thread2(p));
        t1.start();
        t2.start();


    }


}
