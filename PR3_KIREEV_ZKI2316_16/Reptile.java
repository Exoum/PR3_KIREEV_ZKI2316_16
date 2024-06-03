// Класс Reptile, наследник класса Animal, представляющий рептилию.
public class Reptile extends Animal {
    private int temperature; // Температура тела рептилии.
    private String reproduction; // Способ размножения.

    // Конструктор по умолчанию.
    public Reptile() {
        super(); // Вызов конструктора базового класса.
        this.temperature = 0;
        this.reproduction = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и температуры.
    public Reptile(int age, String name, int temperature, String reproduction) {
        super(age, name);
        this.temperature = temperature;
        this.reproduction = reproduction;
    }

    // Переопределение метода equals для сравнения объектов Reptile.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reptile reptile = (Reptile) obj;
        return age == reptile.age && name.equals(reptile.name) && temperature == reptile.temperature && reproduction.equals(reptile.reproduction);
    }

    // Переопределение метода hashCode для корректной работы хэш-коллекций.
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + temperature;
        result = 31 * result + (reproduction != null ? reproduction.hashCode() : 0);
        return result;
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
