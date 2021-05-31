package mocks;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s1 = "forgeeksskeegfor"; //
        String s2 = "Geeks";
        System.out.println(longestPalindrome("Geeks"));
        System.out.println(longestPalindrome("forgeeksskeegfor"));
        System.out.println(longestPalindrome("xyzaabaayooa"));



    }


    /**
     * O(n_cube)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){
        String maxPalindrome = "";
        int end = s.length() -1;
        //o(n)
        for(int i =0; i<s.length(); i++){
            // traverse same char from last index and check palindrome
            end = s.length() -1;
            //o(n)
            for(int j = end; j>=i; j--){
                if(s.charAt(j) == s.charAt(i)){
                    String inner = s.substring(i,j+1);
                    if(isPalindrome(inner)){
                        if(inner.length() > maxPalindrome.length()){
                            maxPalindrome = inner;
                        }
                    }
                }
            }


    }
        return maxPalindrome;
    }
    public static boolean isPalindrome(String s){
        if(s.length() ==0) return false;
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
