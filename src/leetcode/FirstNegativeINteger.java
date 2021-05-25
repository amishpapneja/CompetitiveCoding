package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeINteger {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int[] arr2 = {12, -1, -7, 8, -15, 30, 16, 28};

        firstNegativeNumber(arr2, 3);

    }
    public static void firstNegativeNumber(int[] arr, int k){
        int i =0, j =0;
        int len = arr.length;
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while(j<len){
            if(arr[j] < 0){
//                q.add(arr[j]);
                list.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if((j-i+1) == k ){

                if(/*q.size()>0)*/ list.size()>0){
                    System. out.print(list.get(0) + " ");
//                    System. out.print(q.peek() + " ");
                    if(/*q.peek()*/ list.get(0) == arr[i]) {
//                        q.remove();
//                        list.remove();
                        list.remove(Integer.valueOf(arr[i]));
                    }
                }
                else {
                    System. out.print("0" + " ");
                }
                i++;
                j++;
                //slide the window
            }

        }
        System.out.println();
    }
}
