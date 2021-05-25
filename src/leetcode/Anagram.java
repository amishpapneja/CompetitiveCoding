package leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("a","ab"));
        System.out.println(isAnagram("",""));

    }

    /**
     * ACCEPTED
     * O(3*n)
     */
    protected static boolean isAnagram(String s, String t){
        int[] count = new int[256];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); i++){
            count[t.charAt(i)]--;
        }
        for(int i = 0;i<256;i++){
            if(count[i]!=0)return false;
        }
        return true;

    }
}
