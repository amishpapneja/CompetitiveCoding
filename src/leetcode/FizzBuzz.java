package leetcode;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzbuzzRecursive(1,50);
    }
    public static void fizzbuzz(int n){
        for(int i=1; i<=n; i++){
            String s = "";
            if(i%3 == 0) s += "Fizz";
            if(i%5 == 0) s += "Buzz";
            if(s.equals("")) System.out.println(i);
            else System.out.println(s);

        }
    }
    public static void fizzbuzzCounter(int n){
        int counter3 = 0;
        int counter5 = 0;
        for(int i=1; i<=n; i++){
            String s = "";
            counter3++;
            counter5++;
            if(counter3 == 3){
                s += "Fizz";
                counter3 = 0;
            }
            if(counter5 == 5){
                s += "Buzz";
                counter5 = 0;
            }
            if(s.equals("")) System.out.println(i);
            else System.out.println(s);
        }

    }
    public static void fizzbuzzRecursive(int n, int limit){
        if(limit < 1) return;
        String s = "";
        if(n%3 == 0) s += "Fizz";
        if(n%5 == 0) s += "Buzz";
        if(s.equals("")) System.out.println(n);
        else System.out.println(s);
        fizzbuzzRecursive(n + 1, limit -1);


    }
    public static void fizzBUzzOneModulo(int n){
        for(int i =1; i <= n; i++){


            switch (i % 15) {
                case 0:
                    System.out.println("FizzBuzz");
                    break;
                case 3:
                case 6:
                case 9:
                case 12:
                    System.out.println("Fizz");
                    break;
                case 5:
                case 10:
                    System.out.println("Buzz");
                    break;
                default:
                    System.out.println(i);

            }
        }
    }
}
