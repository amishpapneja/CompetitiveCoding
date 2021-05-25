package companies.ebay;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortedSet {
    public static void main(String[] args) {
        String a[]
            = new String[] { "L", "L", "C0", "L", "C3" };
        List<String> list = Arrays.asList(a);
        operateString("0000000000",list);
    }
    public static String operateString(String a, List<String> operations){
        TreeSet<Integer> indexesForZero = new TreeSet<>();
        char[] str = a.toCharArray();

        for( int i =0;i< a.length();i++){
            indexesForZero.add(i);
        }
        for(String oper: operations){
            if(oper.equals("L") && !indexesForZero.isEmpty()){
                str[indexesForZero.pollFirst()] = '1';
            }
            else{
                str[oper.charAt(1)-48] = '0';
                if(!indexesForZero.contains(oper.charAt(1)-48)){
                    indexesForZero.add(oper.charAt(1)-48);
                }
            }
        }
        for(char ch: str){
            System.out.print(ch);
        }
        return str.toString();

    }
}
