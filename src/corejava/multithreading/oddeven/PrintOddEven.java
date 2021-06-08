package corejava.multithreading.oddeven;

public class PrintOddEven {

    int i = 1;
    boolean check = false;
    public static void main(String[] args) {

        PrintOddEven oddEven = new PrintOddEven();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEven.printOdd();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"odd");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEven.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"even");

        t1.start();
        t2.start();

    }

    protected synchronized void printEven() throws InterruptedException {
        while(i <= 10) {
            if(check) {
                System.out.println(Thread.currentThread().getName() + " " + i++);
                check = false;
                notify();
            }
            else
                wait();
        }
    }

    protected synchronized void printOdd() throws InterruptedException {
        while(i <= 10) {
            if(!check) {
                System.out.println(Thread.currentThread().getName() + " " + i++);
                check = true;
                notify();
            }
            else
                wait();
        }
    }

}

