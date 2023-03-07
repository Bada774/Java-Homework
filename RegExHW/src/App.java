import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        String secretString = "000111010001110001011000001110";
        System.out.println("\nInput string: " + secretString);
        System.out.printf("Founded parts: %d", countParts(secretString));
        checkParts();
        String[] wordArray = {"ATTRIBUTE", "BAT", "CAT", "CATEGORY"};
        findWordsWithoutClasses(wordArray);
        findWordsWithClasses("ATTRIBUTE, BAT, CAT, CATEGORY");
        System.out.printf("\nNumber of entries 'and?' pattern: %d", countWords("an","Humans are hardly the only interesting members of the animal kingdom. Research on the bodies and behaviors of our furry cousins can help scientists learn more about our own species' evolution and cognition. And even when they don't help unlock the ancient secrets of human ancestry, some animals are just too cute — or weird, or gross, or terrifying — not to get to know a little better."));
    }

    public static int countParts(String inputString) {
        Pattern pattern = Pattern.compile(".110");
        Matcher matcher = pattern.matcher(inputString);
        
        int counter = 0;
        while(matcher.find()) {
            counter++;
        }
        return counter;
    }

    public static void checkParts() {
        String regEx = "aa.c?";
        System.out.printf("\nString aabc: %s", "aabc".matches(regEx));
        System.out.printf("\nString aac: %s", "aac".matches(regEx));
        System.out.printf("\nString aa: %s", "aa".matches(regEx));
        System.out.printf("\nString ac: %s", "ac".matches(regEx));
        System.out.printf("\nString ccc: %s", "ccc".matches(regEx));
        System.out.printf("\nString aacc: %s\n", "aacc".matches(regEx));
    }

    public static void findWordsWithoutClasses(String[] inputWords) {
        System.out.println("\nWithout classes: \n" );
        List<String> outputArray = new ArrayList<String>();
        for (int i = 0; i < inputWords.length; i++) {
            if (inputWords[i].matches(".AT\\b")) { 
                outputArray.add(inputWords[i]);
            }
        }
        for (int i = 0; i < outputArray.size(); i++) {
            System.out.println(outputArray.get(i));
        }
    }

    public static void findWordsWithClasses(String inputString) {
        System.out.println("\nWith classes:" );
        Pattern pattern = Pattern.compile(".AT\\b");
        Matcher matcher = pattern.matcher(inputString);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static int countWords(String pattern, String inputString) {
        int counter = 0, 
        indexOfFounded = inputString.indexOf(pattern);
        if (indexOfFounded == -1) return 0;
        while (indexOfFounded != -1) {
            counter++;
            indexOfFounded += pattern.length();
            indexOfFounded = inputString.indexOf(pattern, indexOfFounded);
        }
        return counter;
    }
}