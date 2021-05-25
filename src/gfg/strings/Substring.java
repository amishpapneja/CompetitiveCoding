package gfg.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Substring {
    public static void main(String[] args) {
        System.out.println(findAllSubstrings("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abrexrzx"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * All Substrings (n_square)
     */
    public static List<String> findAllSubstrings(String s) {
        List<String> list =new ArrayList<>();
        int len = s.length();
        for(int i =0; i<len; i++){
            for(int j = i; j < len; j++){
                list.add(s.substring(i,j+1));
            }
        }
        return list;
    }

    /**
     * Longest Substring Without Repeating Characters
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int len = s.length();
        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(j));

        while(j!=len-1){
            if(!set.contains(s.charAt(j+1))){
                j++;
                set.add(s.charAt(j));
                max = Math.max(max,j-i+1);
            }
            else{
                set.remove(s.charAt(i++));
//                i++;
            }
        }
        return max;
//        while(i < len){
//
//            while(!set.contains(s.charAt(j))){
//                set.add(s.charAt(j));
//                j++;
//            }
//
//            if(max < (j - i) ) max = j - i;
//            set.remove(s.charAt(i));
//            i++;
//            if(set.contains(s.charAt(j)) && i<j)j--;
////            if(set.contains(s.charAt(j)))j--;
//
//        }
//        return max;



//        int start = 0;
//        int end = s.length()-1;
//        int max = 0;
//        while (true){
//            boolean noRepetition = true;
//            for(int i = end; i>start; i--){
//                if(s.charAt(i) == s.charAt(start)){
//                    noRepetition = false;
//                    if( i - start > end -i+1 ){
////                            s.substring(start,i).length() > s.substring(i,s.length()-1).length() ){
//                        //left is bigger
//                        end = i+1;
//
//                    }
//                    else {
//                        start = i;
//                    }
//                }
//            }
//            max = end - start;
////            System.out.println(s.substring(start,end -1));
//            if(noRepetition || max == 1) break;
//        }
//        return max;
//        for(int i = end; i>start; i--){
//            if(s.charAt(i) == s.charAt(start)){
//                if( s.substring(start,i).length() > s.substring(i,s.length()-1).length()){
//                    //left is bigger
//                    end = i;
//                }
//                else start = i;
//            }
//        }
//        if(s.equals(""))return 0;
//        int max = 0;
//        for(int i=0;i<s.length();i++){
//            HashSet<Character> set = new HashSet<>();
//            for(int j = i; j<s.length();j++){
//                if(!set.contains(s.charAt(j))){
//                    set.add(s.charAt(j));
//                    if(j-i>max)max = j-i;
//                }
//                else{
//                    break;
//                }
//            }
//
//        }
//        return max+1;


    }

}
