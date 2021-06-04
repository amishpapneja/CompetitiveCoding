package corejava.multithreading.oddeven;


class Printer {
    int i = 0;

    public void printEven(int num) throws InterruptedException {
        synchronized (this) {
            if (num % 2 != 0) {
                wait();
            }
            System.out.println(num);
            notify();
        }

    }

    public void printOdd(int num) throws InterruptedException {
        synchronized (this) {
            if (num % 2 == 0) {
                wait();
            }
            System.out.println(num);
            notify();


        }
    }
}

public class OddEven {
    static class OddPrinter implements Runnable {
        int max = 10;
        int num;
        Printer p;

        public OddPrinter(Printer p, int num) {
            this.p = p;
            this.num = num;
        }

        @Override
        public void run() {
            while (num < max) {
                try {
                    p.printOdd(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num += 2;
            }

        }

    }


    static class EvenPrinter implements Runnable {
        Printer p;
        int num;
        int max = 10;

        public EvenPrinter(Printer p, int num) {
            this.p = p;
            this.num = num;
        }

        @Override
        public void run() {
            while (num < max){
                try {
                    p.printEven(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num +=2;
            }

        }

    }

    public static void main(String[] args) {
        Printer p = new Printer();
        Thread odd = new Thread(new OddPrinter(p,1));
        Thread even = new Thread(new EvenPrinter(p,2));
        odd.start();
        even.start();
//        for(int i=0;i<10;i++){
//
//            odd.start();
//            even.start();
//        }


    }
}
