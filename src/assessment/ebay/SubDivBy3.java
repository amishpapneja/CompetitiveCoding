package assessment.ebay;

import java.util.*;

class SubDivBy3 {



    // Returns count of subsequences of number
// divisible by n.
    static int countDivisibleSubseq(String number) {
        int len = number.length();
        int n = 3;

        // division by n can leave only n remainder
        // [0..n-1]. dp[i][j] indicates number of
        // subsequences in string [0..i] which leaves
        // remainder j after division by n.
        int dp[][] = new int[len][n];

        // Filling value for first digit in number
        dp[0][(number.charAt(0) - '0') % n]++;

        for (int i = 1; i < len; i++) {
            // start a new subsequence with index i
            dp[i][(number.charAt(i) - '0') % n]++;

            for (int j = 0; j < n; j++) {
                // exclude i'th character from all the
                // current subsequences of string [0...i-1]
                dp[i][j] += dp[i - 1][j];

                // include i'th character in all the current
                // subsequences of string [0...i-1]
                dp[i][(j * 10 + (number.charAt(i) - '0')) % n] += dp[i - 1][j];
            }
        }

        return dp[len - 1][0];
    }
    static HashSet<String> st = new HashSet<>();

    // Function computes all the subsequence of an string
    static void subsequence(String str)
    {

        // Iterate over the entire string
        for (int i = 0; i < str.length(); i++)
        {

            // Iterate from the end of the string
            // to generate substrings
            for (int j = str.length(); j > i; j--)
            {
                String sub_str = str.substring(i, j);

                if (!st.contains(sub_str)){
//                    if(sub_str.charAt(0)!='0' && sub_str.length()>1){
//                        break;
//
//                    }
                    st.add(sub_str);

                }

                // Drop kth character in the substring
                // and if its not in the set then recur
                for (int k = 1; k < sub_str.length() - 1; k++)
                {
                    StringBuffer sb = new StringBuffer(sub_str);

                    // Drop character from the string
                    sb.deleteCharAt(k);
                    if (!st.contains(sb));
                    subsequence(sb.toString());
                }
            }
        }
    }

    public static String subseq(String v, int z, int k, int i) {
        if(v.substring(z, k).charAt(0)!='0'){
            return(v.substring(z, k));
        }
        if (k < v.length()) {
            subseq(v, z + 1, k + 1, i);
        }
        else if (z > 0) {
            subseq(v, 0, 1 + i, i + 1);
        }
        return null;
    }


    // Driver code
    public static void main(String[] args) {
        String s = "6666";
        subsequence(s);
        int divs = 0;
        System.out.println(st);
        for(String num : st){
            if(num.length()>1 && num.charAt(0)=='0')divs--;
            Integer no = Integer.parseInt(num);
            if(no%3==0)divs++;
        }
        System.out.println(divs);
    }
}
// This code is contributed by 29AjayKumar

//public class SubDivBy3 {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        double mod = 1e9 + 7;//The result is the remainder
//        while (in.hasNext()) {
//            String str = in.nextLine();
//            int[][] dp = new int[51][3];//Because the array starts from 0, and i represents how many numbers there are, so the 50th number array represents 51
//            for (int i = 1; i <= str.length(); i++) {
//                int m = (str.charAt(i - 1) - '0') % 3;//Number modulo 3
//                for (int j = 0; j < 3; j++) {
//                    dp[i][j] = (int) ((dp[i - 1][j] + dp[i - 1][(j - m + 3) % 3]) % mod);//+3 means the result is non-negative
//
//                }
//                dp[i][m] = (int) ((dp[i][m] + 1) % mod);//The current number is incremented if it matches the modulus
//            }
//
//            System.out.println(dp[str.length()][0]);
//        }
//        in.close();
//    }
//
//}