import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> set1;
        Set<String> set2;

        //Method 1,2
        set1 = SetUtils.readToSet();
        System.out.println(set1);
        set2 = SetUtils.readToSet();
        System.out.println(set2);
        System.out.println(SetUtils.isStrictSuperset(set1, set2));

        System.out.println();

        //Method 3
        set1 = SetUtils.readToSet();
        set2 = SetUtils.readToSet();
        Set<String> resultSet = SetUtils.symmetricDifference(set1, set2);
        System.out.println(String.join(" ", resultSet));

        //Method 4
        SetUtils.spellChecker();

        File inputTextFile = new File("CollectionsHWPart3\\src\\text.txt");
        File dictionaryFile = new File("CollectionsHWPart3\\src\\dictionary.txt");
        SetUtils.spellChecker(inputTextFile , dictionaryFile);
    }
}

class SetUtils {

    static Scanner scanner = new Scanner(System.in);

    public static Set<String> readToSet() {
        System.out.println("Enter strings:");
        Set<String> result = new HashSet<String>();
        String inputString = scanner.nextLine();
        String[] inputElements = inputString.split(" ");
        Collections.addAll(result, inputElements);
        return result;
    }

    public static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        return set1.containsAll(set2) || set2.containsAll(set1);
    }
    
    public static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        Set<String> concatedSet = new HashSet<String>();
        concatedSet.addAll(set1);
        concatedSet.addAll(set2);
        Set<String> result = new HashSet<String>();
        for (String element : concatedSet) {
            if (!(set1.contains(element) && set2.contains(element))) {
                result.add(element);
            }
        }
        return result;
    }

    public static void spellChecker() {
        System.out.println("Enter number of words:");
        Set<String> testWords = new HashSet<String>();
        

        int wordsNum = intScannerLooper();

        System.out.println("Enter words:");
        for (int i = 0; i < wordsNum; i++) {
            testWords.add(scanner.next().toLowerCase());
        }
        
        System.out.println("Enter number of strings:");

        int stringsNum = intScannerLooper();

        System.out.println("Enter strings:");
        Set<String> allWords = new HashSet<String>();
        String[] inputElements = {};
        String inputString = "";
        
        for (int i = 0; i <= stringsNum; i++) {
            inputString = scanner.nextLine();
            inputElements = inputString.split(" ");
            Collections.addAll(allWords, inputElements);
        }
        

        for (String element : allWords) {
            if (!(testWords.contains(element.toLowerCase()))) {
                System.out.println(element);
            }
        }
    }

    public static void spellChecker(File inputFile, File dictionaryFile) throws FileNotFoundException {
        Scanner input = new Scanner(inputFile);
        Scanner dictionary = new Scanner(dictionaryFile);
        Set<String> inputWords = new HashSet<String>();
        Set<String> dictionaryWords = new HashSet<String>();
        while (input.hasNext()) {
            inputWords.add(input.next());
        }
        while (dictionary.hasNext()) {
            dictionaryWords.add(dictionary.next());
        }
        for (String element : inputWords) {
            if (!(dictionaryWords.contains(element.toLowerCase()))) {
                System.out.println(element);
            }
        }
        input.close();
        dictionary.close();
    }

    public static int intScannerLooper() {
        boolean loop = true;
        int num = 0;
        while (loop) {
            try {
                num = scanner.nextInt();
                loop = false;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Wrong input");
                scanner.next();
            }
        }
        return num;
    }
}
