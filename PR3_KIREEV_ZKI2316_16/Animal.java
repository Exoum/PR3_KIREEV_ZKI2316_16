// Базовый класс, представляющий животное.
public class Animal {
    protected int age; // Возраст животного.
    protected String name; // Имя животного.

    // Конструктор по умолчанию.
    public Animal() {
        this.age = 0;
        this.name = "Unknown";
    }

    // Конструктор с параметрами для установки возраста и имени.
    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Переопределение метода equals для сравнения объектов Animal.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return age == animal.age && name.equals(animal.name);
    }

    // Переопределение метода hashCode для корректной работы хэш-коллекций.
    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    // Переопределение метода toString для представления информации о животном в строковом виде.
    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}