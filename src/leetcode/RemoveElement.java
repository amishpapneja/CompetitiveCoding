package leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int [] arr2 = {3,2,2,3};
        int [] arr = {1,5};
        int [] arr3 = {0,1,2,2,3,0,4,2,5};


        int len = removeElement2(arr2,3);
        for(int i = 0; i < len; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println("");
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
    }
    public static  int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    public static int removeElement2(int[] nums, int val){
        if(nums.length ==1 && nums[0] == val) return 0;
        int i = 0;
        int j = nums.length ;
        for(;i<nums.length;i++){
            if(nums[i] == val && i<j){
                nums[i] = nums[j-1];
                j--;
            }
        }
        return j;
    }
}
