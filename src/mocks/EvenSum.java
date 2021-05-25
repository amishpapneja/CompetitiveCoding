package mocks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvenSum {
    public static void main(String[] args) {
        //4,1,5,6,11,7,9
//        int[] arr1 = {4,1,5,6,11,7,9};
        // 11,9,7,6,5,4,1
//        System.out.println(evenSum(Arrays.asList(4,1,5,6,11,7,9),3));
//        System.out.println(revConditional("Be not afraid, of. the test ? where I am there. "));
        System.out.println("Amish".compareTo("Aamish"));
    }
    public static int evenSum(List<Integer> list, int k){
        Collections.sort(list, Collections.reverseOrder());
        // k values
        // all even
        // all odd
        // even - > all even, x even , odd %2,
        // ODD -> 11, 9, 7, 5
        // EVEN -> 6, 4
        // 11/6 -> 11,9, -> 6

        // CASE 1 -> all max sum equal even // general case 11,9,6 take out top 3 even
        // case 2 -> all odd sum is even // take top k odd
        // case 3 -> all even sum is even // take top k even
        // case 4 -> combination of even and odd sum is even //

        System.out.println(list);

        return 0;
    }
    // string -> String str =  "Be not afraid, of. the test ? where I am there. ";
    // of. _> fo. fo
    public static String revConditional(String str){
        // iterations -> stop -> " " || "special char"
        //
        // ->
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j<str.length()-1){
            if(Character.isAlphabetic(str.charAt(j+1))){
                j++;
            }
            else{
                StringBuilder inner = new StringBuilder(str.substring(i, j+1));
                sb.append(inner.reverse());
                //
                while(j+1< str.length() && (!Character.isAlphabetic(str.charAt(j+1)) || str.charAt(j+1) == ' ')){
                    sb.append(str.charAt(j));
                    j++;
                }
                i = j;
                // i -j reverse
            }
        }
        return sb.toString();

//        String[] arr = str.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for(String s: arr){
//            StringBuilder inner = new StringBuilder();
//            for()
//        }
//        int i=0;
//        while(i<str.length()){
//
//        }
    }
}
