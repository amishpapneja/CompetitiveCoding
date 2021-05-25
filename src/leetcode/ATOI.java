package leetcode;

public class ATOI {
    public static void main(String[] args) {
//        System.out.println(myAtoi("   "));
//        System.out.println(myAtoi("  121"));
//        System.out.println(myAtoi("-121aa"));
//        System.out.println(myAtoi("000121"));
//        System.out.println(myAtoi("  -1200"));
//        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("21474836460"));
        System.out.println(myAtoi("00000-42a1234"));





//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);




//        System.out.println("asas");




    }
    public static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int i = 0;
        boolean positiveFlag = true;
        if(s.charAt(i) == '-'){
            positiveFlag = false;
        }
        long value = 0;
        long place = 1;
        i = s.length() - 1;
        for(int j =0;j<s.length();j++){
            char curr = s.charAt(j);
//            if((curr == '+' || curr == '-' )&& j+1 <s.length()) {
//                curr = s.charAt(++j);
//            }
            if ((curr <48 || curr >57) && j != 0) {
                i = j -1;
                break;
            }
        }
        while(i>=0 ){
            if(value > Integer.MAX_VALUE && positiveFlag) return Integer.MAX_VALUE;
            if(value > Integer.MAX_VALUE && !positiveFlag) return Integer.MIN_VALUE;
            if(s.charAt(i) == '-') return (int)value * -1;
            if(s.charAt(i) == '+') return (int)value;
            value = value + (s.charAt(i) - 48) * place;
            place *= 10;
            i--;
        }
        if(value > Integer.MAX_VALUE && positiveFlag) return Integer.MAX_VALUE;
        if(value > Integer.MAX_VALUE && !positiveFlag) return Integer.MIN_VALUE;
        return (int)value;
    }
}
