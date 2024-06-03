// Класс Predator, наследник класса Animal, представляющий хищника.
public class Predator extends Animal {
    private int strength; // Сила хищника.
    private String activity; // Время суток когда хищник наиболее активен.

    // Конструктор по умолчанию.
    public Predator() {
        super(); // Вызов конструктора базового класса.
        this.strength = 0;
        this.activity = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и силы.
    public Predator(int age, String name, int strength, String activity) {
        super(age, name);
        this.strength = strength;
        this.activity = activity;
    }

    // Переопределение метода equals для сравнения объектов Predator.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Predator predator = (Predator) obj;
        return age == predator.age && name.equals(predator.name) && strength == predator.strength && activity.equals(predator.activity);
    }

    // Переопределение метода hashCode для корректной работы хэш-коллекций.
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + strength;
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        return result;
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
