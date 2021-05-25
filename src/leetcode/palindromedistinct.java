package leetcode;// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class palindromedistinct {
    public static String solution(int N, int K) {
        // write your code in Java SE 8
        char[] str = new char[N];
        for(int i=0;i<N;i++){
            str[i] = 'a';
        }
        K--;
        //condition needed
        int start=1;
        int end=str.length-2;
        int count = 98;
        while(start<=end && K!=0){
            char ch= (char)count;
            str[start] = ch;
            str[end]=ch;
            start++;
            end--;
            K--;
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++)
        {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(solution(10,3));
    }
}
