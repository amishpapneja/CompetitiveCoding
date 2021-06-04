package corejava.multithreading;

import java.util.Random;

public class SameVariableAccess {
    public static int count = 0;

    static class Incrementer implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(9999));
//                System.out.println("The value of count is " + count);
                count++;
                System.out.println("Incremented by 1: " + count);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Decrementer implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(9999));
//                System.out.println("The value of count is " + count);
                count--;
                System.out.println("Decremented by 1: " + count);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i< 10; i++){
            Thread t= new Thread(new Incrementer());
            Thread t2= new Thread(new Decrementer());
            t.start();
            t.join();
            t2.start();
            t2.join();
        }

    }
}
