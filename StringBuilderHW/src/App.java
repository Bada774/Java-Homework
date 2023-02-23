import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("---First---\n");

        scanNumbers();

        System.out.println("\n---Second---\n");

        System.out.println(studentInfo("Gandalf", 100, "OOP-Java"));

        System.out.println("\n---Third---\n");

        String inputString = "Object-oriented programming is a programming paradigm based on the concept of 'objects', which can contain data, in the form of fields (often known as attributes or properties), and code, in the form of procedures (often known as methods). A feature of objects is an object's procedures that can access and often modify the data fields of the object with which they are associated (objects have a notion of 'this' or 'self'). In object-oriented programming, computer programs are designed by making them out of objects that interact with one another. Object-oriented programming languages are diverse, but the most popular ones are class-based, meaning that objects are instances of classes, which also determine their types. Object-oriented programming uses objects, but not all of the associated techniques and structures are supported directly in languages that claim to support object-oriented programming. The features listed below are common among languages considered to be strongly class- and object-oriented (or multi-paradigm with OOP support), with notable exceptions mentioned.";
        System.out.println("Input string:\n" + inputString);
        System.out.println("\nOutput string:\n" + changeTextInString(inputString,
        "object-oriented programming",
        "OOP"));

    }


    //first
    public static void scanNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int firstNum = 0, secondNum = 0;
        try {
            firstNum = scanner.nextInt();
            secondNum = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid numbers. Enter numbers again.");
            scanNumbers();
        }
        scanner.close();
        StringBuilder sumString = new StringBuilder();
        StringBuilder differenceString = new StringBuilder();
        StringBuilder multiplyString = new StringBuilder();
        sumString.append(String.format("%d + %d = %d", firstNum, secondNum, firstNum + secondNum));
        differenceString.append(String.format("%d - %d = %d", firstNum, secondNum, firstNum - secondNum));
        multiplyString.append(String.format("%d * %d = %d", firstNum, secondNum, firstNum * secondNum));

        System.out.printf("\n%s \n%s \n%s \n", sumString, differenceString, multiplyString);

        sumString = sumString.insert(sumString.indexOf("="), "equals");
        sumString = sumString.deleteCharAt(sumString.indexOf("="));
        differenceString = differenceString.replace(differenceString.indexOf("="), differenceString.indexOf("=") + 1, "equals");
        multiplyString = multiplyString.replace(multiplyString.indexOf("="), multiplyString.indexOf("=") + 1, "equals");

        System.out.printf("\n%s \n%s \n%s \n", sumString, differenceString, multiplyString);
    }

    //second
    public static String studentInfo(String name, int mark, String subject) {
        return new StringBuilder(String.format("Student %.15s got %.3s in %.25s ", name, mark, subject)).toString();
    };

    //third
    public static String changeTextInString(String inputString, String stringToReplace, String replacingString) {
        StringBuilder finalString = new StringBuilder(inputString);
        if (finalString.toString().toLowerCase().indexOf(stringToReplace) == -1) {
            return "The input string doesn't contain this substring.";
        } else {
            int counter = 0,
            indexOfFounded = finalString.toString().toLowerCase().indexOf(stringToReplace);

            while (indexOfFounded != -1) {
                if (counter % 2 == 1) { 
                    finalString.replace(indexOfFounded, indexOfFounded + stringToReplace.length(), replacingString);
                    indexOfFounded += replacingString.length(); 
                } else {
                    indexOfFounded += stringToReplace.length(); 
                }
                indexOfFounded = finalString.toString().toLowerCase().indexOf(stringToReplace, indexOfFounded); 
                counter++; 
            }
            return finalString.toString();
        }
    }
}
