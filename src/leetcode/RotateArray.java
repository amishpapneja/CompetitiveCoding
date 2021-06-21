package leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3%7);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 4);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 5);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 6);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 7);
        //same array
        // 8 and 1 are same, 9 and 2 are same
        // 8 % 7 ==> 1
        // 9 % 7 ==> 2
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 8%7);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 9%7);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 10%7);

    }

    /**
     * Runtime: 1 ms, faster than 63.43% of Java online submissions for Rotate Array.
     * Memory Usage: 56.4 MB, less than 25.11% of Java online submissions for Rotate Array.
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7] k =3. Right rotate.
        // reverse first n -k elements
        // [4,3,2,1,  5,6,7]
        // reverse n-k to n elements
        // [4,3,2,1,  7,6,5]
        // reverse entire array
        // [5,6,7,1,2,3,4]
        int n = nums.length;
        k = k % n;
        if(n == 1) return;
        rev(nums, 0, n-k-1); // 0 to 3
        rev(nums, n-k, n-1); // 4 to 6
        rev(nums, 0, n-1); // 0 to 6
        for(int i: nums) System.out.print(i + " ");
        System.out.println();

    }
    public static void rev(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }

    }
}
