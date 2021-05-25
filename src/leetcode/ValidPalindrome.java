package leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        /*System.out.println(isPalindromeAlphaNumeric("1A man, a plan, a canal: Panama1"));
        System.out.println(isPalindromeAlphaNumeric("race a car"));
        System.out.println(isPalindromeAlphaNumeric(""));
        System.out.println(isPalindromeAlphaNumeric("121:_"));
        System.out.println(isPalindromeAlphaNumeric("ab_a"));
        System.out.println(isPalindromeAlphaNumeric("__"));
        System.out.println(isPalindromeAlphaNumeric(" "));*/
        System.out.println(numberPalindrome(12221));


    }
    /*
        TODO: In place with O(1n) complexity
    */
    /**
     * ACCEPTED
     * O(2n)
     * Runtime: 3 ms, faster than 63.83% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39 MB, less than 73.29% of Java online submissions for Valid Palindrome.
     *
     */
    protected static boolean isPalindromeAlphaNumeric(String s){
        if(s.length()==0) return true;
        int i = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(i=0; i<len; i++){
            if( (s.charAt(i) >= 65 && s.charAt(i) <= 90) ||
                    (s.charAt(i) >= 97 && s.charAt(i) <= 122) ||
                    (s.charAt(i) >= 48 && s.charAt(i) <= 57)
            ) sb.append(Character.toLowerCase(s.charAt(i)));

        }
        return isPalindrome(sb.toString());

    }
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
    public static boolean numberPalindrome(int x){
        if(x<0) return false;
        int orig = x;
        int pop = 0;
        int reveresed = 0;
        while(x > reveresed){
            pop = x % 10;
            reveresed = (reveresed * 10) + pop;
            x /= 10;
        }

        return x == reveresed || x == reveresed/10;
    }
}
