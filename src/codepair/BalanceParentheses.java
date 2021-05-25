package codepair;

import java.util.Stack;

public class BalanceParentheses {
    public static void main(String[] args) {
        System.out.println(minimumSwaps("(()))(")); //1
        System.out.println(minimumSwaps("()())")); //- 1

    }
    public static int minimumSwaps(String brackets) {
        int extraClose=0;
        int extraOpen=0;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i< brackets.length(); i++){
            if(brackets.charAt(i) == '('){
                stack.push(brackets.charAt(i));
            }
            else if(brackets.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    extraClose++;
                }
            }
        }
        stack.clear();
        for(int i = brackets.length() - 1; i>=0; i--){
            if(brackets.charAt(i) == ')'){
                stack.push(brackets.charAt(i));
            }
            else{
                if(!stack.isEmpty() && stack.peek() == ')'){
                    stack.pop();
                }
                else{
                    extraOpen++;
                }
            }
        }
        if(extraClose == extraOpen){
            if(extraOpen % 2 != 0) return (extraOpen/2)+ 1;
            return extraOpen/2;
        }
        return -1;


    }
}
