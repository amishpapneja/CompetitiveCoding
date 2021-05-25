package companies.goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalancedArray {
    public static void main(String[] args) {
        List list = Arrays.asList(new int[]{1,2,3,4,6});

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(6);
        System.out.println(balancedSum(list2));


    }
    public static int balancedSum(List<Integer> list){
        int start = 0;
        int end = list.size() - 1;
        int leftSum = list.get(0);
        int rightSum = list.get(list.size() -1 );
        while (end > start ){
            if(leftSum < rightSum){
               leftSum += list.get(start);
               start++;
            }
            else {
                rightSum += list.get(end);
                end--;
            }
//            else if(leftSum == rightSum){
//                if(end - start == 2) return list.get(start+1);
//            }
        }
        if(leftSum == rightSum){
            if(end - start == 2) return list.get(start+1);
        }
        return 0;

    }
}
