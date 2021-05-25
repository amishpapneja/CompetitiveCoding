package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }

    /**
     *
     *
     * */
    public static int characterReplacement(String s, int k){
        int len = s.length();
        int maxWIndow = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int j=i;
            int currentWindow = 0;
            while(j<len ){
                if(s.charAt(i) == s.charAt(j) && j-i >= 2){
                    map.put(s.substring(i,j+1),j-i+1);
                    currentWindow = j - i + 1;
                }
                j++;
            }
            maxWIndow = Math.max(maxWIndow, currentWindow);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        return maxWIndow;
    }
}
