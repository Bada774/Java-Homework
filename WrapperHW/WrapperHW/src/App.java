import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(checkStringLenght(scanString()));
        checkNumbers("1test2String3.22");
    }

    public static void checkNumbers(String inputString) { 
        List<String> stringNumbers = Arrays.asList(inputString.replaceAll("[^-?0-9.?0-9]+", " ").trim().split(" ")); 
        int[] intNumbers= new int[stringNumbers.size()];
        int index = 0;
        for (String num : stringNumbers) {
            intNumbers[index] = Integer.parseInt(num);
            index++;
        }
        for(int i = 0; i < intNumbers.length; i++) {
            System.out.println(intNumbers[i]);
        }
    }

    public static boolean checkStringLenght(String inputString) {
        if (inputString.length() >= 20 & inputString.length() <= 100) {
            return true;
        } else {
            return false;
        }
    }


    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String outputString = scanner.nextLine();
        scanner.close();
        return outputString;
    }
}
