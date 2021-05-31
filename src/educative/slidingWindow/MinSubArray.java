package educative.slidingWindow;

import java.util.LinkedHashSet;

public class MinSubArray {
    public static void main(String[] args) {
//        System.out.println(findMinSubArray(new int[] {2, 1, 5, 2, 3, 2}, 7));
        System.out.println(findMinSubArray(new int[]{1, 2, 3, 4, 5}, 11));


    }

    public static int findMinSubArray(int[] arr, int S) {
        // @Author: papamish
        int len = arr.length;
        int k = len;
        int i = 0;
        int j = 0;
        int currentStum = 0;
        int minLen = len +1 ;
        while (j < len || i < len) {
            while (j - i + 1 <= k && currentStum < S && j<len) {
                currentStum += arr[j];
                j++;
            }
            if (currentStum >= S) {
                minLen = Math.min(minLen, j - i);
                k = minLen - 1;
            }
            if (i < len) {
                currentStum -= arr[i];
                i++;
            }
        }
        if(minLen == len+1) return 0;
        return minLen;
    }
}
