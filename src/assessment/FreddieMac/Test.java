package assessment.FreddieMac;

import java.net.Socket;

public class Test {
    public static void main(String[] args) {
        // we have ana array of n digits. we delete one of them ,
        //need to find teh misisng value
        //size 10
        int [] input = {1,2,3,5,6,7,8,9,10}; //9 // n+1
        System.out.println(whichDeleted(input));



    }
    public static int whichDeleted(int[] arr){
        boolean[] check = new boolean[arr.length+2];
        for(int i: arr){
            check[i] = true;
        }
        for(int i=0; i< check.length; i++){
            System.out.print(i + " " + check[i] + " \n" );
        }
        for(int i = 1; i< check.length; i++){
            if(!check[i]) return i;
        }
        return -1;
    }

}
