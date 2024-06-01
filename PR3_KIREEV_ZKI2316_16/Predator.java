// Класс Predator, наследник класса Animal, представляющий хищника.
public class Predator extends Animal {
    private double strength; // Сила хищника.
    private String activity; // Время суток когда хищник наиболее активен.

    // Конструктор по умолчанию.
    public Predator() {
        super(); // Вызов конструктора базового класса.
        this.strength = 0.0;
        this.activity = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и силы.
    public Predator(int age, String name, double strength, String activity) {
        super(age, name);
        this.strength = strength;
        this.activity = activity;
    }

    // Переопределение метода toString для представления информации о хищнике.
    @Override
    public String toString() {
        return "Predator{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", strength='" + strength + '\''+
                ", activity=" + activity +
                '}';
    }
}
