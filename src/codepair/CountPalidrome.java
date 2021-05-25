package codepair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CountPalidrome {
    public static void main(String[] args) {
        System.out.println(countPalindromes("tacocat")); //10
        System.out.println(countPalindromes("aaa")); //6

    }

    /**
     * Brute Force - O(n_cube)
     * Time limit exceeded - 12/13 Cases passed
     * DP required with O(n_square)
     *
     * @param s
     * @return
     */
    public static int countPalindromes(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            if(!map.containsKey(s.charAt(i)) ){
                TreeSet<Integer> indexes = new TreeSet<>();
                indexes.add(i);
                map.put(s.charAt(i), indexes);
            }
            else{
                map.get(s.charAt(i)).add(i);
            }

        }
        int count = 0;
        for(Map.Entry<Character,TreeSet<Integer>> entry: map.entrySet()){
            if(entry.getValue().size()> 1){
                Integer[] indeces =  entry.getValue().toArray(new Integer[entry.getValue().size()]);
                for(int i = 0; i< indeces.length; i++){
                    for(int j = i+1; j< indeces.length; j++){
                        if( isPalindrome(s.substring(indeces[i], indeces[j] +1))) count++;

                    }
                }
            }
        }
        return count + s.length();

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
}
