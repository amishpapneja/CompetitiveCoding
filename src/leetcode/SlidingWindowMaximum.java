package leetcode;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr2 = {1,3,-1,-3,5,3,6,7};
        int[] arr3 = {1};
        int[] arr4 = {1,-1};
        int[] arr5 = {4,-2};
        int[] arr6 = {-7,-8,7,5,7,1,6,0};


//        System.out.println(max(arr, 3));
        System.out.println(max(arr2, 3));
        System.out.println(max(arr3, 1));
        System.out.println(max(arr4, 1));
        System.out.println(max(arr5, 2));
        System.out.println(max(arr6, 4));
//        maxSlidingWindow2(arr6,4);
//        max(arr,3);
    }

    /**
     * O(nk)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int[] result = new int[nums.length - k + 1];
        int pointer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        while (j < nums.length) {
            while (j - i + 1 <= k) {
                q.add(nums[j]);
                j++;
            }
            // System.out.println(q);
            result[pointer] = q.peek();
            pointer++;
            q.remove(nums[i]);
            i++;
        }
        return result;
    }

    public static int[] max(int[] nums, int k){
        Deque<Integer> deque
                = new LinkedList<Integer>();

        int i=0;
        int j=0;
        List<Integer> maxes = new ArrayList<>();
        int max = 0;
        while(j<nums.length){
            //calculations
            while (!deque.isEmpty() && deque.peekLast()<nums[j]){
                deque.pop();
            }
            deque.addLast(nums[j]);
            if(j-i <k){
                j++;
            }
            if(j-i == k){
                //ans and slide window
                maxes.add(deque.peekFirst());
                if(nums[i] > deque.peekFirst()){
                    deque.poll();
                }
                i++;
                j++;
            }
        }
        int[] arrResult = new int[maxes.size()];
        for(int l=0; l<arrResult.length; l++){
            arrResult[l] = maxes.get(l);
        }
        for(int ii: maxes){
            System.out.print(ii + " ");
        }
        return arrResult;
//        return null;
    }
    /*public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque
                = new LinkedList<Integer>();

        int j=0;
        List<Integer> maxes = new ArrayList<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            while(j-i+1 <= k && j< nums.length){
                if(deque.isEmpty()) max = nums[j];
                deque.add(nums[j]);
                max = Math.max(max, nums[j]);
                j++;
            }
            if(j-i == k){
                //window match
//                max = Math.max(Math.max(x,y),z)
                maxes.add(max);
                int firstOut = deque.removeFirst();
                if(firstOut == max && deque.size()!=0) {
                    max = Math.max(deque.peekFirst(), deque.peekLast());
                }
            }
        }
        System.out.println(maxes);
        int[] arrResult = new int[maxes.size()-1];
        for(int l=0; l<arrResult.length; l++){
            arrResult[l] = maxes.get(l);
        }

        return arrResult;
    }*/

    public static int[] maxSlidingWindow2(int[] a, int k) {
        int n = a.length;
        if(n<=1) return a;
        Deque<Integer> dq = new LinkedList<>();
        int ans[] = new int[n-k+1];

        int i = 0;
        for(; i<k; i++) {
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for(; i<n; i++) {
            ans[i-k] = a[dq.peekFirst()];

            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i-k] = a[dq.peekFirst()];

        for(int ii: ans){
            System.out.print(ii + " ");
        }
        return ans;


    }
}
