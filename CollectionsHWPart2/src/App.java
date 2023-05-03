import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        readingAndPrintingString();
    }

    public static void readingAndPrintingString() {
        Scanner scanner = new Scanner (System.in);
        List<String> list = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        System.out.println(list);
    }
}
