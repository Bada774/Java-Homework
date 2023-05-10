import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Waiting for integers...\n");
        System.out.println("Collection of Integer elements: " + collectInteger());
        System.out.println("\nWaiting for doubles...");
        System.out.println("Collection of Double elements: " + collectDouble());
        System.out.println("\nWaiting for String...");
        System.out.println("Collection of String elements: " + collectString());
        System.out.println("\n---\n");
        System.out.println("Joint ArrayList is " + concatPositiveNumbers(new Integer[]{8, 11, -2, -3, 14, 15}, new Integer[]{-1, 33, 12, -3, -5}));
    }

    public static ArrayList<Integer> collectInteger() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        boolean running = true;
        while(running) {
            int number;
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                running = false;
                break;
            }
            list.add(number);
        }
        scanner.close();
        return list;
    }

    public static ArrayList<Double> collectDouble() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        boolean running = true;
        while(running) {
            Double number;
            try {
                number = scanner.nextDouble();
            } catch (Exception e) {
                running = false;
                break;
            }
            list.add(number);
        }
        scanner.close();
        return list;
    }

    public static ArrayList<String> collectString() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean running = true;
        while(running) {
            String input;
            try {
                input = scanner.nextLine();
            } catch (Exception e) {
                running = false;
                break;
            }
            list.add(input);
        }
        scanner.close();
        return list;
    }

    public static ArrayList<Integer> concatPositiveNumbers(Integer[] firstList, Integer[] secondList) {
        ArrayList<Integer> outputList = new ArrayList<>(Arrays.asList(firstList));
        outputList.addAll(Arrays.asList(secondList));
        ArrayList<Integer> holderList = new ArrayList<>();
        outputList.sort(null);
        for (Integer number : outputList) {
            if (number < 0) {
                holderList.add(number);
            }
        }
        outputList.removeAll(holderList);
        return outputList;
    }
}
