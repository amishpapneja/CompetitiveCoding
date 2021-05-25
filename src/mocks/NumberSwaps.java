package mocks;

public class NumberSwaps {
    public static void main(String[] args) {
        System.out.println(maxSwap("7857621", 2));
        System.out.println(maxSwap("7857621", 1));
        System.out.println(maxSwap("987654", 2));



    }

    /**
     * Tme complexity O(2n)
     * Space Complexity O(n)
     * @param x
     * @param limit
     * @return
     */
    public static String maxSwap(String x, int limit){
        char[] val = x.toCharArray();
        for(int i = 0; i< val.length-2; i++){
            if(val[i+limit] > val[i]){
                //swap
                char temp = x.charAt(i);
                val[i] = x.charAt(i+limit);
                val[i+limit] = temp;
                break;//only single swap allowed

            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: val){
            sb.append(ch);
        }

        return sb.toString();
    }
}
