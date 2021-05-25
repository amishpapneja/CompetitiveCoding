package companies.amdocs;

import java.util.HashSet;
import java.util.Set;

/**
 * Compilation successful.
 *
 * Example test:   [7]
 * OK
 *
 * Example test:   [4, 3]
 * OK
 *
 * Example test:   [11, 1, 8, 12, 14]
 * OK
 *
 * Example test:   [4, 10, 8, 5, 9]
 * OK
 *
 * Example test:   [5, 5, 5, 5, 5]
 * OK
 */
public class Q5 {
    public boolean solution(int[] A) {
        // write your code in Java SE 8
        if(A==null || A.length <= 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int a: A){
            if(set.contains(a-1) || set.contains(a+1)){
                return true;
            }
            set.add(a);
        }
        return false;
    }
}
