package leetcode;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','c','c','c'};
        int len = compressInPlace(chars);
        for(int i = 0; i< len; i++){
            System.out.print(chars[i] + " ");
        }
    }

    /**
     * ACCEPTED
     * Time Complexity O(n)
     * Space Complexity O(n)
     * Runtime: 1 ms, faster than 93.68% of Java online submissions for String Compression.
     * Memory Usage: 38.6 MB, less than 53.22% of Java online submissions for String Compression.
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        List<Character> compressed = new ArrayList<>();
        Queue<Character> q = new ArrayDeque<>();
        for(int i =0; i<chars.length; i++){
            char curr = chars[i];
            int till = i;
            int count = 0;
            while (till< chars.length && chars[till] == curr ){
                count++;
                till++;

            }
            compressed.add(curr);
            if(count > 9){
                for(char ch: String.valueOf(count).toCharArray()){
                    compressed.add(ch);
                }
            }
            else if(count == 1) continue;
            else compressed.add(Character.forDigit(count, 10));
            i = till-1;
        }

        for(int i = 0; i< compressed.size();i++){
            chars[i] = compressed.get(i);
        }
        return compressed.size();
    }

    public static int compressInPlace(char[] chars) {
        int  i= 0;
        int lastModify = 0;
        while (i<chars.length){
            char curr = chars[i];
            int till = i;
            int count = 0;
            while(till < chars.length && chars[till] == curr) {
                count++;
                till++;
            }
            if(count == 1){
                chars[lastModify] = curr;
                lastModify ++;
                i++;

            }
            else if(count > 9){
                chars[lastModify] = curr;
                for(char ch: String.valueOf(count).toCharArray()){
                    chars[++lastModify] = ch;
                }
                lastModify++;
                i = till;
            }
            else {
                chars[lastModify] = curr;
                chars[lastModify+ 1] = Character.forDigit(count, 10);
                lastModify = lastModify +2;
                i = till;
            }
        }
        return lastModify;
    }

}
