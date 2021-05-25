package companies.bloomberg;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int windowLength = 0;
        List<List<Integer>> outer = new ArrayList<>();
        while(windowLength<nums.length){
            //(method of iterating the array with window of wl size)
            int i = 0;
            int j = windowLength;
            List<Integer> inner = new ArrayList<>();
            while(j<nums.length ){
                if(i ==0 && j==0)break;
                if(i == j){
                    i++;
                    j = j+windowLength;
                }
                if(j-1+1 == windowLength){
                    inner.add(nums[i]);
                    i++;
                }


            }
            windowLength++;
            outer.add(inner);

        }
        return outer;

    }
}
