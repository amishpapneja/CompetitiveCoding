package assessment.square;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfStrings {
    public static void main(String[] args) {
        String a = "11";
        String b = "19";

//        String a = "99";
//        String b = "99";

        System.out.println(sumOfStrings(a,b));

    }
    public static String sumOfStrings(String a, String b){
        Stack<String> stack = new Stack<>();
        int aCount = a.length()-1;
        int bCount = b.length()-1;
        while(aCount>=0 || bCount>=0){
            int aValue = 0;
            int bValue = 0;
            int currSum = 0;
            if(aCount >= 0){
                aValue =Character.getNumericValue(a.charAt(aCount));
                aCount--;
            }
            if(bCount >= 0){
                bValue =Character.getNumericValue(b.charAt(bCount));
                bCount--;
            }
            currSum = aValue + bValue;
            stack.push(String.valueOf(currSum));

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
