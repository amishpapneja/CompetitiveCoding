package companies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cisco {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String stream = br.readLine();
        System.out.println(stream.split(" ").length);
    }

}
