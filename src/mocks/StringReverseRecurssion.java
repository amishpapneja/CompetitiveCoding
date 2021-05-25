package mocks;

public class StringReverseRecurssion {
    public static void main(String[] args) {
        System.out.println(print("abc"));
        System.out.println(fact(3));

    }
    public static String print(String s){
        if(s.length() == 1) return s;
        return print(s.substring(0, s.length() -1));
    }


    public static int fact(int i){
        if( i == 0 ) return 1;
        return i * fact(i -1);
    }

}
