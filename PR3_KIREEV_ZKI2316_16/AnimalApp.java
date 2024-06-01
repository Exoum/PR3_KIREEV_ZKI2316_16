import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Класс приложения с пользовательским интерфейсом для управления коллекцией животных.
public class AnimalApp {
    private static List<Animal> animals = new ArrayList<>(); // Коллекция для хранения объектов Animal.
    private static Scanner scanner = new Scanner(System.in); // Сканер для чтения ввода пользователя.

    public static void main(String[] args) {
        int menu;
        do {
            // Вывод меню в консоль.
            System.out.println("Выберите опцию:");
            System.out.println("1. Добавить новый элемент");
            System.out.println("2. Удалить элемент коллекции по индексу");
            System.out.println("3. Вывод всех элементов коллекции в консоль");
            System.out.println("4. Сравнение двух элементов на равенство (по индексу)");
            System.out.println("5. Завершение работы приложения");

            menu = validateIntInput(scanner, 1, 5);

            switch (menu) {
                case 1:
                    clearConsole();
                    addNewAnimal(); // Добавление нового животного.
                    break;
                case 2:
                    clearConsole();
                    removeAnimalByIndex(); // Удаление животного по индексу.
                    break;
                case 3:
                    clearConsole();
                    printAllAnimals(); // Вывод всех животных в консоль.
                    break;
                case 4:
                    clearConsole();
                    compareAnimals(); // Сравнение двух животных.
                    break;
                case 5:
                    System.out.println("Завершение работы приложения."); // Завершение программы.
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите опцию от 1 до 5."); // Обработка неверного ввода.
            }
        } while (menu != 5);
    }

     // Метод для добавление нового животного
     private static void addNewAnimal() {
        System.out.println("Выберите тип животного для добавления:");
        System.out.println("1 - Хищник, 2 - Рыба, 3 - Рептилия");
        int type = validateIntInput(scanner, 1, 3);
        scanner.nextLine(); // очистка буфера ввода после числа

        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст животного:");
        int age = validateIntInput(scanner, 0, 100);

        switch (type) {
            case 1:
                System.out.println("Введите силу хищника:");
                int strength = validateIntInput(scanner, 0, 100);
                System.out.println("Введите период активности хищника (день/ночь):");
                String activity = validateString(scanner);
                animals.add(new Predator(age, name, strength, activity));
                break;
            case 2:
                System.out.println("Введите скорость рыбы:");
                int speed = validateIntInput(scanner, 0, 100);
                System.out.println("Введите место обитания рыбы:");
                String habitat = validateString(scanner);
                animals.add(new Fish(age, name, speed, habitat));
                break;
            case 3:
                System.out.println("Введите температуру рептилии:");
                int temperature = validateIntInput(scanner, 0, 50);
                System.out.println("Введите способ размножения рептилии (яйцекладущая/живородящая):");
                String reproduction = validateString(scanner);
                animals.add(new Reptile(age, name, temperature, reproduction));
                break;
        }
        System.out.println("Животное добавлено.\n");
    }

    private static void removeAnimalByIndex() {
        System.out.println("Введите индекс элемента для удаления:");
        int index = validateIntInput(scanner, 1, animals.size());
        if (index >= 0 && index <= animals.size()) {
            animals.remove(index-1);
            System.out.println("Элемент удален.\n");
        } else {
            System.out.println("Неверный индекс.\n");
        }
    }

    private static void printAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.\n");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println(i + ": " + animals.get(i) + "\n");
            }
        }
    }

    private static void compareAnimals() {
        if (animals.isEmpty() || animals.size() < 2){
            System.out.println("Чтоб сделать сравнение добавьте минимум двух животных в список. Сейчас животных в списке: " + animals.size() + "\n");
        }
        else{
            System.out.println("Введите индекс первого животного для сравнения:");
            int firstIndex = validateIntInput(scanner, 1, animals.size());
            System.out.println("Введите индекс второго животного для сравнения:");
            int secondIndex = validateIntInput(scanner, 1, animals.size());
        
            if (firstIndex >= 0 && firstIndex <= animals.size() && secondIndex >= 0 && secondIndex <= animals.size()) {
                Animal firstAnimal = animals.get(firstIndex - 1);
                Animal secondAnimal = animals.get(secondIndex - 1);
        
                // Сначала сравниваем hashCode
                if (firstAnimal.hashCode() == secondAnimal.hashCode()) {
                    // Если hashCode совпадают, проверяем equals
                    System.out.println("Результат сравнения: " + firstAnimal.equals(secondAnimal) + "\n");
                } else {
                    System.out.println("Объекты не равны, так как их hashCode различаются.\n");
                }
            } else {
                System.out.println("Неверные индексы.");
            }
        }
    }

    protected static int validateIntInput(Scanner scanner, int min, int max) {
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите число:");
                scanner.next(); // очистка буфера ввода
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Число вне допустимого диапазона. Пожалуйста, введите число от " + min + " до " + max + ":\n");
            }
        } while (input < min || input > max);
        return input;
    }

    protected static String validateString(Scanner scanner) {
        String string;

        scanner.nextLine(); // очистка буфера ввода
        do {
            while (!scanner.hasNextLine()) {
                System.out.println("Пожалуйста, введите строку:");
                scanner.next(); // очистка буфера ввода
            }
            string = scanner.nextLine();
            if (string.trim().isEmpty()) {
                System.out.println("Введенная строка не может быть пустой");
            }
        } while (string.trim().isEmpty());
        return string;
    }

    //Вспомогательный метод для очистки консоли.
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}