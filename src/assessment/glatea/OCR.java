package assessment.glatea;

import java.util.ArrayList;
import java.util.List;

public class OCR {
    public static void main(String[] args) {
        String one = "3x2x";
        String two = "7";
        one = "ba1";
        two = "1Ad";
        one = "A2Le";
        two = "2pL1";
        one = "a1";
        two = "a01";
        one = "10a";
        two = "aaaaaaaaaaa";


        System.out.println(solution(one,two));

    }
    public static boolean solution(String S, String T){
        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();
        int number_1=0;
        for(int i=0;i<S.length();i++){
            if(Character.isDigit(S.charAt(i))){
                number_1 = number_1*10+(S.charAt(i)-'0');
            }
            else {

                    while(number_1>0){
                        first.add('?');
                        number_1--;
                    }

                first.add(S.charAt(i));
            }
        }
        while(number_1>0){
            first.add('?');
            number_1--;
        }
        int number_2 = 0;
        for(int i=0;i<T.length();i++){
            if(Character.isDigit(T.charAt(i))){
                number_2 = number_2*10+(T.charAt(i)-'0');
            }
            else {

                    while(number_2>0){
                        second.add('?');
                        number_2--;
                    }

                second.add(T.charAt(i));
            }
        }
        while(number_2>0){
            second.add('?');
            number_2--;
        }
        if(first.size() != second.size()) return false;
        for(int i =0; i<first.size(); i++){
            if(first.get(i)!= '?' && second.get(i)!= '?' && first.get(i) !=  second.get(i)) return false;

        }

        return true;
    }

}
