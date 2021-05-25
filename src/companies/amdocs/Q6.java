package companies.amdocs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 Example test:   [3, 2, -2, 5, -3]
 OK

 Example test:   [1, 1, 2, -1, 2, -1]
 OK

 Example test:   [1, 2, 3, -4]
 OK
 */
public class Q6 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length <=1) return 0;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int a : A){
            int num = Math.abs(a);
            if(max < num  && set.contains(a * -1)) {
                max = num;
            }
            else {
                set.add(a);
            }
        }
        return max == Integer.MIN_VALUE ? 0: Math.abs(max);

    }
}
