package codepair;

public class CircularPrinter {
    public static void main(String[] args) {
        System.out.println(getTime("AZGB")); //13
        System.out.println(getTime("ZNMD")); //23

    }
    public static long getTime(String s) {
        // Write your code here
        int cost = 0;
        int curr = 'A';
        for(int i =0; i< s.length(); i++){
            if(curr == s.charAt(i)){
                continue;
            }
            else{
                cost += Math.min(
                        Math.abs( curr - s.charAt(i)),
                        26 - Math.abs( curr - s.charAt(i))
                );
            }
            curr = s.charAt(i);

        }
        return cost;

    }
}
