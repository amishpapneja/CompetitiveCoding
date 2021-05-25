package mocks;

import jdk.swing.interop.SwingInterOpUtils;

public class StockMarket {
    public static void main(String[] args) {
        int[] arr = {10,6,11,5,19,29,10,40}; // 59
        int[] arr2 = {10,6,11,5,19,29,10,30}; //49
        int[] arr3 = {30,25,20,10,5,1}; //0
        int[] arr4 = {5,10,15,20,30,25,20,10,5,1}; //25
        System.out.println(stockMarket(arr4));

    }
    public static  int stockMarket(int[] arr){
        int start = arr[0];
        int end = arr[0];
        int profit = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < start ){
                start = arr[i];
            }
            if( arr[i] > end){
                end = arr[i];
                if( i != arr.length -1 && arr[i+1] <end){
                    profit += end - start;
                    start = arr[i];
                    end = -1;
                }
                else if(i == arr.length-1 ){
                    profit += end - start;
                }
            }

        }
        return profit;

    }
//    public static int stockMarket(int[] arr){
//        int currentStart = arr[0];
//        int profit = 0;
//        int sum = 0;
//        int futureWindow= arr[0];
//
//        for(int i = 0; i< arr.length; i++){
//            if(arr[i] < currentStart) futureWindow = arr[i];
//            if(i == arr.length-1){
//                profit = Math.max(profit, arr[i] - currentStart);
//                if(Math.max(profit, arr[i] - currentStart) > profit) sum = sum+ profit;
////                profit +=
//            }
//            else {
//                if(arr[i] > currentStart && arr[i+1] < arr[i] ){
//                    profit = Math.max(profit, arr[i] - currentStart);
//
//                    sum = sum+ profit;
////                    currentStart = arr[i+1];// last smallest update
////                i++;
//                    System.out.println("Window Changed to " + arr[i]);
//                    currentStart = arr[i];
//                }
//            }
//        }
//        return sum;
//    }
}
