// Класс Fish, наследник класса Animal, представляющий рыбу.
public class Fish extends Animal {
    private double speed; // Скорость рыбы.
    private String habitat; // Место обитания рыбы.

    // Конструктор по умолчанию.
    public Fish() {
        super(); // Вызов конструктора базового класса.
        this.speed = 0.0;
        this.habitat = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и скорости.
    public Fish(int age, String name, double speed, String habitat) {
        super(age, name);
        this.speed = speed;
        this.habitat = habitat;
    }

    // Переопределение метода toString для представления информации о рыбе.
    @Override
    public String toString() {
        return "Fish{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", speed='" + speed + '\'' +
                ", habitat=" + habitat +
                '}';
    }
}
