public class SecondTask {
    public static void main(String[] args) {
        Brochure brochure = new Brochure("NewBrochure");
        Shelf<Brochure> shelf = new Shelf<>();
        shelf.setElement(brochure);
        System.out.println(shelf.getElement().getName());
    }
}

class Shelf<T extends Book> {
    private T t;

    public void setElement(T t) {
        this.t = t;
    }

    public T getElement() {
        return t;
    }
}

class Book {
}

class Brochure extends Book {
    private String name;

    Brochure(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
}
