package companies.tusimple;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryMultiple {
    public static void main(String[] args) {
        //11 -> 11
        //2 -> 10
        //15 -> 1110
        System.out.println(multiple_01(2));
        System.out.println(multiple_01(15));
    }
    public static String multiple_01(int base_number) {
        Queue<String> queue = new LinkedList<String>();
        String t = "1";
        queue.add(t);
        while(!queue.isEmpty()){
            t= queue.remove();
            long rem = Long.valueOf(t) % base_number;
            if(rem == 0){
                return t;
            }
            queue.add(t + "0");
            queue.add(t + "1");
        }
        return "";

    }

}
