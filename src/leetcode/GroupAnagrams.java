package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};
        String[] strs4 = {"",""};
        System.out.println(groupAnagramsBySort(strs));
        System.out.println(groupAnagramsBySort(strs2));
        System.out.println(groupAnagramsBySort(strs3));
        System.out.println(groupAnagramsBySort(strs4));
    }

    /**
     * ACCEPTED
     * 0(n * [klog(k)] )
     * where n is number of strings given and k is the length of maximum string
     */
    protected static List<List<String>> groupAnagramsBySort(String[] strs){
        Map<String,List<String>> anaMap = new HashMap<>();
        List<List<String>> anaGroups = new ArrayList<>();

        for(String str: strs){
            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            String sortedCurrent =  new String(tempArray);
            if(!anaMap.containsKey(sortedCurrent)){
                List<String> firstAnaFound = new ArrayList<>();
                firstAnaFound.add(str);
                anaMap.put(sortedCurrent, firstAnaFound);
            }
            else {
                anaMap.get(sortedCurrent).add(str);
            }
        }

        for (Map.Entry<String,List<String>> entry : anaMap.entrySet())
            anaGroups.add(entry.getValue());

        return anaGroups;
    }

    /**
     * TIME LIMIT EXCEED
     * Test Passed 111/ 114 - Time limit exceed
     * O(n_square)
     */
    protected static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> anaGroups = new ArrayList<>();
        List<String> allStrings = new ArrayList<>(Arrays.asList(strs));
        int[] doneGram = new int[allStrings.size()] ;

        int len = allStrings.size();
        for(int i : doneGram) i=0;
        for(int i =0 ; i< len; i++){
            String s = allStrings.get(i);
            if(doneGram[i] == 0) {
                List<String> currentAnas = new ArrayList<>();
                currentAnas.add(s);
                for (int j = 0; j < len; j++) {
                    String t = allStrings.get(j);
                    if (i != j && doneGram[j] == 0 && Anagram.isAnagram(s, t)) {
                        currentAnas.add(t);
                        doneGram[j]++;
                    }
                }
                anaGroups.add(currentAnas);
            }
        }

        return anaGroups;
    }
}
