package mocks;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Optional;

public class FIrstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqueIgnoreCase("sTrseSS"));
        System.out.println(firstUniqueIgnoreCase("sTrseStS"));


    }
    public static Optional<Character> firstUniqueIgnoreCase(String s){
        LinkedHashSet<Character> set = new LinkedHashSet<>();


        System.out.println((int)'A' );
        System.out.println((int)'a' );
        for(int i = 0; i< s.length(); i++){
//            if(s.charAt(i) >= 97 &&){
//                if(!set.contains(s.charAt(i)) || !set.contains(s.charAt(i) - 32) ){
//                    set.add(s.charAt(i));
//                }
//
//            }
//            else if (s.charAt(i) >= 65 && s.charAt(i)<= 91){
//
//            }
//
            if(!set.contains(String.valueOf(s.charAt(i)).toUpperCase().toCharArray()[0]) || !set.contains(String.valueOf(s.charAt(i)).toLowerCase().toCharArray()[0])){
                set.add(s.charAt(i));
            }
            else{
                set.remove(s.charAt(i));
            }


        }

        return  set.stream().findFirst();
    }
}
