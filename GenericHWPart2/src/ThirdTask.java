public class ThirdTask {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        GenericClass<Integer,  Number> gc = new GenericClass<>(array, 5);
        System.out.println(gc.getT().toString() + " " + gc.getV());
        gc.setT(array);
        gc.setV(10);
        System.out.println("\n" + gc.getT() + " " + gc.getV());
    }
}

class GenericClass <T, V extends Number> {
    private T[] t;
    private V v;
    
    public GenericClass(T[] t, V v) {
        this.t = t;
        this.v = v;
    }

    public void setT(T[] t) {
        this.t = t;
    }

    public T[] getT() {
        return t;
    }

    public void setV(V v) {
        this.v = v;
    }

    public V getV() {
        return v;
    }

    public String toString() {
        String outputString = "[";
        for (T key : t) {
            outputString += key + ", ";
        }
        outputString = outputString.substring(0, outputString.length() - 2);
        outputString += "]";
        return String.format("\n%s", outputString);
    }
}