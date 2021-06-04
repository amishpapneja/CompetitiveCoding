package corejava.multithreading;

import java.util.Random;

public class Multithreading extends Thread{
    int count = 0;
    public void run(){
        this.count++;
        System.out.println(this.count);
    }
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnableThread("Brock"));
        Thread t2 = new Thread(new MyRunnableThread("Undertaker"));
        Thread t3 = new Thread(new MyRunnableThread("HHH"));
        Thread t4 = new Thread(new MyRunnableThread("Kurt"));
        System.out.print(Thread.currentThread().getId());
        t1.start();
        t2.start();
        t3.start();
        t4.start();






//        for(int i = 0; i < 10; i++){
//            MyThread thread = new MyThread();
//            thread.start();
//        }
//        System.out.println("--");
//        for(int i = 0; i < 10; i++){
//            Thread thread = new Thread(new MyRunnableThread());
//            thread.start();
//        }
    }
}
class MyThread extends Thread{
    public void run(){
        try{
            System.out.println("Currently running thread id: " + Thread.currentThread().getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class MyRunnableThread implements Runnable{
    String name;
    int time;
    public MyRunnableThread(String name){
        this.name = name;
        time = new Random().nextInt(9999);
    }
    @Override
    public void run() {
        try{
            System.out.println("Thread name: " + this.name + " going to sleep for : "+ this.time);

            Thread.sleep(time);
            System.out.println("Thread "+ this.name + " is done");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

