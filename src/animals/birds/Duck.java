package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFly{

   public Duck(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    public void fly(){ System.out.println("Я лечу"); }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    }
