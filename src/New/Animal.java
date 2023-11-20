package New;

public class Animal {
    //поля класса
    private String name;
    private String color;
    private int weight;
    private int age;
    private String str_age = "";

    //конструктор класса
    public Animal(String name, int age, int weight, String color) {
        this.name = name;
//        this.age = age;
        this.setAge(age);
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

    public void setAge(int age) {
        this.age = age;

        if (this.age == 1) {
            str_age = "год";
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void saySay() {
        System.out.println("Я говорю");
    }

    public void sayGo() {
        System.out.println("Я иду");
    }

    public void sayDrink() {
        System.out.println("Я пью");
    }

    public void sayEat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ", мне " + age + " " + str_age + ", я вешу - " + weight + " кг, " + "мой цвет - " + color;
    }



}
