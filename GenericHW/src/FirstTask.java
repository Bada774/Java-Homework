public class FirstTask {
    public static void main(String[] args) throws Exception {
        Box<Cake> cakeBox = new Box<Cake>();
        cakeBox.put(new Cake());
        Box<Pie> pieBox = new Box<Pie>();
        pieBox.put(new Pie());
        Box<Tart> tartBox = new Box<Tart>();
        tartBox.put(new Tart());
    }
}

class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void put(T t) {
        this.t = t;
    }
}

class Cake { 

}

class Pie {

}

class Tart {

}