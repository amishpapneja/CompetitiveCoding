package educative.slidingWindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
    }
    public static int findMaxSumSubArray(int[] arr, int k ) {
        int i=0;
        int j=0;
        int currSum = 0;
        int maxSum = 0;
        while(j< arr.length){
            if(j-i+1 <= k){
                currSum += arr[j];
                j++;
            }
            if(j-i == k){
                // System.out.println(arr[j]);
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[i];
                i++;
            }
        }
        return maxSum;
    }
}
