package leetcode;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{{[]}}"));
        System.out.println(isValid("{"));
        System.out.println(isValid("))"));



    }

    /**
     * ACCEPTED
     * O(n)
     */
    protected static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for(int i=0; i<len; i++) {
            if (map.containsKey(s.charAt(i))) {
                //open case
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                else if (s.charAt(i) == map.get(stack.peek())) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

}
