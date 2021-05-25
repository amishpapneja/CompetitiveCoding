package companies.amdocs;
/*
Example test:   ('Wed', 2)
OK

Example test:   ('Sat', 23)
OK
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }
    public String solution(String S, int K) {
        // write your code in Java SE 8
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Mon",0);
        map.put("Tue",1);
        map.put("Wed",2);
        map.put("Thu",3);
        map.put("Fri",4);
        map.put("Sat",5);
        map.put("Sun",6);
        int index  = map.get(S);

        int result = index + K;

        result = result % 7;
        String temp = "";
        for(Map.Entry<String,Integer> e : map.entrySet())
        {
            if(e.getValue() == result)
            {
                temp = e.getKey();
                break;
            }
        }
        return temp;
    }
}
