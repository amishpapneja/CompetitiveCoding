package assessment.goldman;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Umbrella {
    public static void main(String[] args) {
        int[] arr = {4,3,3};


//        System.out.println(getMinCount(arr,10f));
        System.out.println(getUmbrellas(10,Arrays.asList(4,3,3)));


    }
    public static int getUmbrellas(int requirement, List<Integer> sizes){

        if (sizes == null || sizes.size() == 0 || requirement < 1)
            return -1;
        int i = sizes.size()- 1;
        Collections.sort(sizes);
        int count = 0;
        while (requirement >= 0 && i >= 0) {
            count += requirement / sizes.get(i);
            requirement = requirement % sizes.get(i);
            i--;
        }
        if(requirement!=0) return -1;
        else return count;
    }

    private static int getMinCount(int[] arr, int n) {
        if (arr == null || arr.length == 0 || n < 1)
            return -1;
        int i = arr.length - 1;
        Arrays.sort(arr);
        int count = 0;
        while (n >= 0 && i >= 0) {
            count += n / arr[i];
            n = n % arr[i];
            i--;
        }
        return n != 0 ? -1 : count;
    }
}
