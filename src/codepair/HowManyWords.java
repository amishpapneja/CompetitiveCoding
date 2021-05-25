package codepair;

public class HowManyWords {
    public static void main(String[] args) {
        String test1 = "he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?"; //21
        String test2 = ")}OJR 92ww. z )UPl 49e ]S  g. zrZEnQ  D. FoKp ]ow 1EceB 3oK }w ]CA? L 3LPbDN! trqJY 0sBmm. Nwn"; //8
        System.out.println(howMany(test1));

    }
    public static int howMany(String sentence) {
        int validWords = 0;
        int i = 0;
        int alphaCount = 0;
        int numCount = 0;
        int otherCount = 0;
        while(i<sentence.length()){
            while (i < sentence.length() && sentence.charAt(i)!= ' '){
                if(Character.isAlphabetic(sentence.charAt(i)) || sentence.charAt(i) == '-'){
                    alphaCount++;
                }
                else if(Character.isDigit(sentence.charAt(i))){
                    numCount++;
                }
                else{
                    if((sentence.charAt(i) == ',' ||
                            sentence.charAt(i) == '?' ||
                            sentence.charAt(i) == '.' ||
                            sentence.charAt(i) == '!') ) {
                    }
                    else{
                        otherCount++;
                    }
                }
                i++;
            }
            if(alphaCount >0 && numCount==0 && otherCount ==0){
                validWords++;
            }
            alphaCount = 0;
            otherCount = 0;
            numCount = 0;

            while(i < sentence.length() && sentence.charAt(i) == ' ') i++;
        }

        return validWords;

    }
}
