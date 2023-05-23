import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Method 1
        System.out.println("Method 1:");
        readingAndPrintingString();

        //Method 2
        System.out.println("Method 2:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        String[] str1 = scanner.nextLine().split("\\s+");
        String[] str2 = scanner.nextLine().split("\\s+");
        for (String str: str1) {
            list1.add(Integer.parseInt(str));
        }
        for (String str: str2) {
            list2.add(Integer.parseInt(str));
        }
        System.out.println(checkTheSameNumberOfTimes(n, list1, list2));

        //Method 3
        System.out.println("Method 3:");
        List<String> list3 = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        changeList(list3);
        System.out.println(list3);

        System.out.println("Method 4:");
        List<Integer> list = new ArrayList<>();
        String[] str3 = scanner.nextLine().split("\\s+");
        int subListSize = Integer.parseInt(scanner.nextLine());
        for (String str: str3) {
            list.add(Integer.parseInt(str));
        }
        System.out.println(splitListIntoSubLists(list, subListSize));
    }

    public static void readingAndPrintingString() {
        List<String> list = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        System.out.println(list);
    }

    public static boolean checkTheSameNumberOfTimes(int n, List<Integer> list1, List<Integer> list2) {
        int firstCounter = 0, secondCounter = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == n) {
                firstCounter++;
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i) == n) {
                secondCounter++;
            }
        }
        return firstCounter == secondCounter;
    }

    public static void changeList(List<String> list1) {
        int lenghtHolder = 0;
        String stringHolder = "", inputString = "";
        for (int i = 0; i < list1.size(); i++) {
            inputString = list1.get(i);
            if (lenghtHolder < inputString.length()) {
                stringHolder = inputString;
                lenghtHolder = inputString.length();
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, stringHolder);
        }
    }

    public static <T> List<List<T>> splitListIntoSubLists(List<T> inputList, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();
        List<T> sublist = new ArrayList<>();
        int length = inputList.size() / subListSize;
        for (int i = 0; i < length; i++) {
            sublist.clear();
            for (int j = 0; j < subListSize; j++) {
                sublist.add(j, inputList.get(0));
                inputList.remove(0);
            }
            sublists.add(sublist);
        }
        sublists.add(inputList);

        return sublists;
    }
}
