package companies.fabtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        File file = new File("C:\\Users\\amish\\IdeaProjects\\CompetitiveProgramming\\src\\companies\\fabtime\\File12.txt");
        File file2 = new File("C:\\Users\\amish\\IdeaProjects\\CompetitiveProgramming\\src\\companies\\fabtime\\FIle2.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));

        String first;
        String second;
        first = br.readLine();
        second = br2.readLine();

        while (first != null || second != null) {
            if (first != null && second != null) {
                if ((first.compareTo(second) <= 0)) {
                    System.out.println(first);
                    first = br.readLine();
                } else {
                    System.out.println(second);
                    second = br2.readLine();

                }
            } else if (second != null) {
                System.out.println(second);
                second = br2.readLine();
            } else {
                System.out.println(first);
                first = br2.readLine();
            }

        }

    }
}
