public class ThirdTask {
    public static void main(String[] args) {
        GenericClass<Integer> gc = new GenericClass<>();
    }
}

class GenericClass <T> {
    private T t;
    // private V v;
    
    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    // public void setV(V v) {
    //     this.v = v;
    // }

    // public V getV() {
    //     return v;
    // }

    public String toString() {
        return String.format("\n%s", t);
    }
}