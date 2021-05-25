package codepair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {
    public static void main(String[] args) {
        System.out.println(efficientJanitor(Arrays.asList(1.01f,1.01f, 1.01f, 1.4f, 2.4f))); //3
    }
    public static int efficientJanitor(List<Float> weight) {
        // Write your code here
        int trips = 0;
        Collections.sort(weight);
        int  i =0;
        int  j = weight.size() -1;
        while(i<=j){
            if(weight.get(i) + weight.get(j) <= 3.0f){
                i++;
                j--;
            }
            else{
                j--;
            }
            trips++;
        }
        return trips;
    }
}
