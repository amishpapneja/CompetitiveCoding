package companies.amdocs;

/**
 * Compilation successful.
 *
 * Example test:   (5, 2)
 * OK
 *
 * Example test:   (8, 3)
 * OK
 *
 * Example test:   (3, 2)
 * OK
 */
public class Q4 {
    public String solution(int N, int K) {
        // write your code in Java SE 8
        char[] str = new char[N];
        for(int i=0;i<N;i++){
            str[i] = 'a';
        }
        K--;
        //condition needed
        int start=1;
        int end=str.length-2;
        int count = 98;
        while(start<=end && K!=0){
            char ch= (char)count;
            str[start] = ch;
            str[end]=ch;
            start++;
            end--;
            K--;
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++)
        {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
