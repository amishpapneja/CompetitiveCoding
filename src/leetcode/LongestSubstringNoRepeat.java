package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Longest Substring Without Repeating Characters
 */
public class LongestSubstringNoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("alilswsel"));


    }

    /**
     * ACCEPTED
     *
     * Runtime: 6 ms, faster than 64.15% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39 MB, less than 74.46% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * */
    public static int lengthOfLongestSubstring(String s) {
        if(s ==null || s.length() == 0) return 0;
        int i = 0;
        int j = 0;
        int len = s.length();
        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(j));

        while(j!=len-1){
            if(!set.contains(s.charAt(j+1))){
                //only move the window will if the upcoming char is not a part of the unique set
                j++;
                set.add(s.charAt(j));
                max = Math.max(max,j-i+1);
            }
            else{
                // if there is a match in front of j.
                // move the i pointer till the point where the duplicate element is removed
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;

    }
}
