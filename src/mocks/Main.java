package mocks;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        maxRepeatingString("hdhdkabaka");
    }
    public static String maxRepeatingString(String str){
        String maxString = "";
        for(int i=0; i< str.length();i++){
            Set<Character> set = new HashSet<>();
//            set.add(str.charAt(i));
            for(int j=i; j<str.length();j++){
                if(!set.contains(str.charAt(j))){
                    set.add(str.charAt(j));
                }else{
                    if(set.size() > maxString.length()){
                        maxString = str.substring(i,j);

                    }
                    break;
                }
            }
        }
        return maxString;

        /*int i=0;
        int j=0;
        int len = str.length();
        int max = 0;
        String maxString = "";
        Set<Character> set = new HashSet<>();

        while (j < len){
            if(!set.contains(str.charAt(j)) ){
                set.add(str.charAt(j));
                j++;
                max = Math.max(max, j -1 +1);
            }
            else if(set.contains(str.charAt(j))){
                set.remove(j);
                if(j - i +1 > max){
                    maxString = str.substring(i,j);
                }
                i = j;

            }
//            j++;
        }

        return maxString;*/
    }
}
