public class FirstTask {
    public static void main(String[] args) throws Exception {
        Box<Animal> animalBox = new Box<>();
        animalBox.add(new Animal());
        animalBox.add(new extendedClass());
    }
}

class Box<T extends Animal> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

        public T get() {
        return t;
    }
}

class Animal {}

class extendedClass extends Animal {

}

class notAnimal {}
