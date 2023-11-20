package animals;

public class Animal {
    //поля класса
    private String name = "";
    private String color = "";
    private int weight = -1;
    private int age = -1;
    private String str_age = "";

    //конструктор класса
    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        getStrAge();
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
    }
    private String getStrAge() {
        if (this.age > 50 || this.age < 0) {
            return null;
        }
        if (this.age >  10 && this.age < 20) {

            return "лет";
        }

        int ostatok = this.age % 10;

        if(ostatok == 1) {
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
        String strAge = getStrAge();
        if (strAge == null){
            return "Возраст введен неверно";
        }
        return "Привет! Меня зовут " + name + ", мне " + age + " " + strAge + ", я вешу - " + weight + " кг, " + "мой цвет - " + color;
    }


}
