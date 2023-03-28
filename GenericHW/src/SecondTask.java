public class SecondTask {
    public static void main(String[] args) {
        // First
        Integer[] intArrayForFirst = {1, 2, 3};
        String[] stringArrayForFirst = {"abc", "bca", "cba"};
        System.out.printf("\nFirst:\nFirst elements: %d, %s\n", getFirst(intArrayForFirst), getFirst(stringArrayForFirst));

        // Second
        Integer[] intArrayForSecond = {1, 2, 3};
        String[] stringArrayForSecond = {"Second", "encondS", "ncondSe"};
        Integer[] nullArrayForSecond = {1, null, 3};
        System.out.printf("\nSecond:\nArrays contains null: %b, %b, %b\n", hasNull(intArrayForSecond), hasNull(stringArrayForSecond), hasNull(nullArrayForSecond));

        // Third
        Integer[] intArrayForThird = {1, 2, 3};
        String[] stringArrayForThird = {"Third", "hitdT", "itdTh"};
        Integer[] emptyArrayForThird = {1, 2, 3};
        System.out.println("\nThird:\n");
        System.out.println(info(intArrayForThird));
        System.out.println(info(stringArrayForThird));
        System.out.println(info(emptyArrayForThird));

        // Fourth
        Integer[] intArrayForFourth = {1, 2, 3};
        String[] stringArrayForFourth = {"Fourth", "ourthF", "urthFo"};
        System.out.printf("\nFourth:\nReversed arrays: %s, %s\n", info(inverse(intArrayForFourth)), info(inverse(stringArrayForFourth)));
    }

    // First
    public static <T> T getFirst(T[] inputArray) {
        if (inputArray.length == 0) return null;
        return inputArray[0];
    }

    //  Second
    public static <T> boolean hasNull(T[] inputArray) {
        for (T t : inputArray) {
            if (t == null) return true;
        }
        return false;
    }

    // Third
    public static <T> String info(T[] inputArray) {
        if (inputArray.length == 0) return "String: []";
        String outputString = "String: [";
        for (int i = 0; i < inputArray.length; i++) {
            outputString += inputArray[i];
            if (i < inputArray.length - 1) outputString += ", ";
        }
        return outputString += "]";
    }

    // Fourth
    public static <T> T[] inverse(T[] inputArray) {
        T[] outputArray = inputArray;
        T lastValue = inputArray[inputArray.length - 1];
        int index = 0;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            outputArray[i] = inputArray[index];
            index++;
        }
        outputArray[0] = lastValue;
        return outputArray;
    }
}
