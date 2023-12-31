import animals.Animal;
import animals.birds.IFly;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();

        while (true) {
            System.out.println("Введите команду ADD/List/Exit");
            String commandStr = scanner.next().toUpperCase(Locale.ROOT).trim();
            if (!commandValidator.isValidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели неверную команду");
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD:
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного: cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if(commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                        System.out.println("Вы ввели неверный вид животного");
                    }

                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                    while (true) {
                        System.out.println("Введите имя животного");
                        String nameStr = scanner.next();
                        if(commandValidator.isDataByRegExp(nameStr, Pattern.compile("^[а-яА-Я]{1,50}$"))) {
                            animal.setName(nameStr);
                            break;
                        }
                        System.out.println("Введите имя животного на кирилице не более 50 букв");
                    }

                    System.out.println("Введите возраст животного");
                    animal.setAge(scanner);

                    System.out.println("Введите вес животного");
                    animal.setWeight(scanner);

                    while (true) {
                        System.out.println("Введите цвет животного");
                        String colorStr = scanner.next();
                        if(commandValidator.isDataByRegExp(colorStr, Pattern.compile("^[а-яА-Я]{1,12}$"))) {
                            animal.setColor(colorStr);
                            break;
                        }
                        System.out.println("Введите цвет животного на кирилице не более 12 букв");
                    }

                    animalList.add(animal);

                    animal.say();
                    animal.go();;
                    animal.drink();
                    animal.eat();
                    if(animal instanceof IFly) {
                        ((IFly) animal).fly();
                    }

                    break;

                case LIST:
                    if(animalList.isEmpty()) {
                        System.out.println("Никого не создали");
                        continue;
                    }

                    for (Animal animalObj: animalList) {
                        System.out.println(animalObj.toString());
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }

        }
    }
}


