package mocks.multithreading;


class MyThread implements Runnable {
    int i = 1;

    @Override
    public void run() {

        System.out.println("Thread:" + Thread.currentThread().getName());

        for (; i <= 10; i++) {
            synchronized (this) {
                System.out.println(i);
//                i++;
            }

        }


    }
}

public class Mock {
    public static void main(String[] args) throws InterruptedException {
        MyThread m = new MyThread();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.start();
//        t1.join();
        t2.start();

    }
}
