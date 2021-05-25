package gfg.strings;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome("ABA"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abbccbba"));
        System.out.println(isPalindrome("geeks"));

        System.out.println(rotateString("qwertyu", 2, "right"));
        System.out.println(rotateString("GeeksForGeeks", "GeeksForGeeks".length()-1, "left"));

        System.out.println(isRotationOfPalindrome("aaaad"));
        System.out.println(isRotationOfPalindrome("abcde"));
        System.out.println(isRotationOfPalindrome("aab"));
    }

    /**
     * https://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
     * Check if a given string is a rotation of a palindrome
     */
    public static boolean isPalindrome(String s){
        int len = s.length();
        int i = 0;
        int j = len-1;
        for(; i<len/2;i++,j-- ){
            if(s.charAt(i) != s.charAt(j) && i!=j){
                return false;
            }
        }
        return true;
    }

    /**
     * https://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
     * Check if a given string is a rotation of a palindrome
     */
    public static boolean isRotationOfPalindrome(String s){
        // O(n_square)
        List<String> allRotations= allRotations(s); //n_square
        System.out.println(allRotations);
        for (String rotatedString: allRotations){ // O(m) m is length of all rotations
            if(isPalindrome(rotatedString)) {
                System.out.println("Palindrome is "+ rotatedString);
                return true;
            }
        }
        return false;

    }
    public static List<String> allRotations(String s){
        // O(n_square)
        int len = s.length();
        List<String> list =new ArrayList<>();
        for(int i = 1; i < len; i++ ){
            list.add(rotateString(s, i, "left"));
            list.add(rotateString(s, i, "right"));
        }
        return list;
    }
    public static String rotateString(String s, int offset, String direction){
        // O(n)
        if(direction.equalsIgnoreCase("right")){
            int len = s.length();
            int start =  len - offset;
            StringBuilder stringBuilder = new StringBuilder("");
            for(int i = start; i<len;i++){
                stringBuilder.append(s.charAt(i));
            }
            for(int i = 0; i<start;i++){
                stringBuilder.append(s.charAt(i));
            }
            return stringBuilder.toString();
        }
        else if(direction.equalsIgnoreCase("left")){
            String ans = s.substring(offset) + s.substring(0, offset);
            return ans;
        }
    return null;
    }
}
