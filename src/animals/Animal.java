package animals;

import validators.DataValidator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Animal {

    private String name;
    private String color;
    private int weight;
   private int age;
   private String str_age;

    private DataValidator dataValidator = new DataValidator();

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        //getStrAge();
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    private int getAgeWeightValidData(Scanner scanner) {
        int data = -1;
        while (true) {
            String ageStr = scanner.next();
            if (dataValidator.isDataByRegExp(ageStr, Pattern.compile("^\\d+$"))) {
                data = Integer.parseInt(ageStr);
                if (data > 50 || data <= 0) {
                    System.out.println("Данные введены не корректно. Используйте цифры до 50");
                    continue;
                }
                break;
            }
            System.out.println("Данные введены не корректно. Используйте цифры до 50");
        }

        return data;

    }

    public void setAge(Scanner scanner) {
        this.age = this.getAgeWeightValidData(scanner);
    }

    private String getStrAge() {
        if (this.age > 50 || this.age < 0) {
            return null;
        }
        if (this.age > 10 && this.age < 20) {

            return "лет";
        }

        int ostatok = this.age % 10;

        if (ostatok == 1) {
            return "год";
        }
        if (ostatok > 1 && ostatok < 5) {
            return "года";
        }

        return "лет";
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Scanner scanner) {
        this.weight = this.getAgeWeightValidData(scanner);
    }


    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {

        String strAge = getStrAge();
        if (strAge == null) {
            return "Возраст введен неверно";
        }
        return "Привет! Меня зовут " + name + ", мне " + age + " " + strAge + ", я вешу - " + weight + " кг, " + "мой цвет - " + color;
    }


}
