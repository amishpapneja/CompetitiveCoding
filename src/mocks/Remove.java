package mocks;

public class Remove {
    public static void main(String[] args) {
        System.out.println(removeDups("aaaabbccdd"));

        String s = "hHHHavnvnvnnnnnnqqqqqHello00vnavnadvnvnnvnvnvnqqq";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            char curr = s.charAt(i);
            sb.append(curr);
            while (i< s.length() && s.charAt(i) == curr ){
                i++;
                continue;
            }
        }
        System.out.println(sb.toString());

    }
    public static String removeDups(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            char curr = s.charAt(i);
            sb.append(curr);
            while (i< s.length() && s.charAt(i) == curr ){
                i++;
            }
        }
        return sb.toString();
    }
    ;
}
