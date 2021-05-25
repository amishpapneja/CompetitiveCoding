package companies.saggezza;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Seconds {
    public static void main(String[] args) {
        System.out.println(totalSeconds("1:05:10"));

    }
    public static int totalSeconds(String time) {
        String[] arr = time.split(":");
        return (Integer.parseInt(arr[0])*60*60) + (Integer.parseInt(arr[1])*60) + Integer.parseInt(arr[2]);

        // Write a single line code using
        // streams, map, reduce & lambda expression to
        // find the total number of seconds in given time (format HH:MM:SS)

//        return Arrays.stream(time.split(":"))
//                .map(elem -> Integer.parseInt(elem))// add code here)
//                .reduce(System.out.println();// code);
//        Stream.of(time.split(":")).map(elem -> System.out.println(elem)).collect(Collectors.toList());

    }
}
