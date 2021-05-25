package leetcode;

import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemove("lee(t(c))o)de)))"));
    }

    /**
     * Accepted O(n) -> 3 passes
     *
     * Runtime: 40 ms, faster than 11.77% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     * Memory Usage: 47.4 MB, less than 5.27% of Java online submissions for Minimum Remove to Make Valid
     * @param s
     * @return
     */
    public static String minRemove(String s ){
        Stack<Character> stack = new Stack<>();
        char [] array = s.toCharArray();
        for(int i = 0; i< array.length; i++){
            if(array[i] == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else {
                    array[i] = '#';
                }
            }
            else if(array[i] =='('){
                stack.push(array[i]);
            }
        }
        stack.clear();
        for(int i = array.length -1; i>=0; i--){
            char ch = array[i];
            if(ch == '('){
                if(!stack.isEmpty() && stack.peek() == ')'){
                    stack.pop();
                }
                else {
                    array[i] = '#';
                }
            }
            else if(ch ==')'){
                stack.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char ch: array){
            if(ch != '#'){
                res.append(ch);
            }
        }
        return res.toString();
    }


}
