// Класс Fish, наследник класса Animal, представляющий рыбу.
public class Fish extends Animal {
    private int speed; // Скорость рыбы.
    private String habitat; // Место обитания рыбы.

    // Конструктор по умолчанию.
    public Fish() {
        super(); // Вызов конструктора базового класса.
        this.speed = 0;
        this.habitat = "Unknown";
    }

    // Конструктор с параметрами для установки возраста, имени и скорости.
    public Fish(int age, String name, int speed, String habitat) {
        super(age, name);
        this.speed = speed;
        this.habitat = habitat;
    }

     // Переопределение метода equals для сравнения объектов Fish.
     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         Fish fish = (Fish) obj;
         return age == fish.age && name.equals(fish.name) && speed == fish.speed && habitat.equals(fish.habitat);
     }
 
     // Переопределение метода hashCode для корректной работы хэш-коллекций.
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + speed;
        result = 31 * result + (habitat != null ? habitat.hashCode() : 0);
        return result;
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
