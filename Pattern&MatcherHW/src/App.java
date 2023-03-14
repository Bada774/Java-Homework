import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        // System.out.println("Enter number: ");
        // String number = scanner.nextLine();
        // System.out.printf("String contains number: %s\n", checkNumber(number));
        
        // System.out.println("\nEnter code: ");
        // String code = scanner.nextLine();
        // System.out.printf("Code matches the pattern: %s\n", checkCode(code));

        // System.out.println("\nEnter time: ");
        // String time = scanner.nextLine();
        // System.out.printf("Time format is correct: %s\n", checkTime(time));

        System.out.println("\nEnter card number: ");
        String cardNumber = scanner.nextLine();
        scanner.close();
        checkCard(cardNumber);
    }

    public static boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile("+?[1-6]\\d[\\dA-F]\\d{9}");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

    public static boolean checkCode(String code) {
        Pattern pattern = Pattern.compile("+?3[4567][1-9]");
        Matcher matcher = pattern.matcher(code);
        return matcher.find();
    }

    public static boolean checkTime(String time) {
        Pattern pattern = Pattern.compile("^[0-2][0-9]:[0-5][0-9]$");
        Matcher matcher = pattern.matcher(time);
        return matcher.find();
    }

    public static void checkCard(String cardNumber) {
        while (cardNumber.contains(" ")) {
            cardNumber = cardNumber.replace(" ", "");
        }
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(cardNumber);
        switch (cardNumber.length()) {
            case 15:
                    pattern = Pattern.compile("^(34|37)\\d{13}$");
                    matcher = pattern.matcher(cardNumber);
                    if (matcher.find()) System.out.println("Card type is American Express.");
                break;

            case 16:
                pattern = Pattern.compile("^4\\d{15}$");
                matcher = pattern.matcher(cardNumber);
                if (matcher.find()) {
                    System.out.println("Card type is Visa.");
                    break;
                } else {
                    pattern = Pattern.compile("^(?:222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720|5[1-5]\\d{2})\\d{12}$");
                    matcher = pattern.matcher(cardNumber);
                    if (matcher.find()) {
                        System.out.println("Card type is Mastercard.");
                        break;
                    } 
                }
                break;
            default:
                System.out.println("Card number doesn't exist.");
        }
    }
}
