import animals.Animal;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Murzik", 51, 12, "Red");
        animal.saySay();
        animal.sayDrink();

        System.out.println(animal);
    }
}



