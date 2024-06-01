// Класс Reptile, наследник класса Animal, представляющий рептилию.
public class Reptile extends Animal {
    private double temperature; // Температура тела рептилии.
    private String reproduction; // Способ размножения.

    // Конструктор по умолчанию.
    public Reptile() {
        super(); // Вызов конструктора базового класса.
        this.temperature = 0.0;
        this.reproduction = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и температуры.
    public Reptile(int age, String name, double temperature, String reproduction) {
        super(age, name);
        this.temperature = temperature;
        this.reproduction = reproduction;
    }

    // Переопределение метода toString для представления информации о рептилии.
    @Override
    public String toString() {
        return "Reptile{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", temperature='" + temperature + '\'' +
                ", reproduction=" + reproduction +
                '}';
    }
}
