import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String inputString = scanString();
        System.out.println("Input string: " + inputString);
        System.out.println("String lenght >20 & <100: " + checkStringLenght(inputString));
        countNumbers(inputString);
        rowNumsSum(inputString);
    }

    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String outputString = scanner.nextLine();
        scanner.close();
        return outputString;
    }

    public static boolean checkStringLenght(String inputString) {
        if (inputString.length() >= 20 & inputString.length() <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public static void countNumbers(String inputString) { 
        int numCounter = 0, numSum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c)) {
                numSum += Character.getNumericValue(c);
                numCounter++;
            }
        }
        System.out.printf("Nums in string: %d\nSum of nums: %d\n", numCounter, numSum);
    }

    public static void rowNumsSum(String inputString) {
        int numSum = 0, sumStorage = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c)) {
                numSum += Character.getNumericValue(c);
                if (numSum > sumStorage) sumStorage = numSum;
            } else {
                numSum = 0;
            }
        }
        System.out.printf("\nBiggest sum of nums: %d\n", sumStorage);
    }
}
