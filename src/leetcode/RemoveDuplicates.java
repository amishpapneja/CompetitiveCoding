package leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(removeDuplicates(arr));

    }
    public static int removeDuplicates(int[] nums) {
        int reduction = 0;
        int i =0;
        while (i < nums.length){
            int dup =0;
            while (nums[i + 1] == nums[i] ) {
                dup++;
                reduction++;
            }
            i = i + dup;
        }
        return reduction;
        }

    }

