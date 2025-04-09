import org.classes.animals.Animal;
import org.classes.animals.Bowl;
import org.classes.animals.Cat;
import org.classes.animals.Dog;
import org.classes.geometry.Circle;
import org.classes.geometry.Rectangle;
import org.classes.geometry.Triangle;
import org.classes.geometry.interfaces.GeometricShape;


public class Main {

    public static void main(String[] args) {

        System.out.println("=================== Задание 1 =========================");

        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Мурзик");

        dog.run(150);
        dog.run(600);
        dog.swim(5);
        dog.swim(15);

        cat.run(100);
        cat.run(250);
        cat.swim(10);

        Bowl bowl = new Bowl(30);
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Рыжик"),
                new Cat("Васька"),
                new Cat("Мурка")
        };

        System.out.println("\nКоты пытаются поесть:");
        for (Cat c : cats) {
            c.eatFromBowl(bowl, 10);
        }

        System.out.println("\nСостояние сытости котов:");
        for (Cat c : cats) {
            System.out.println(c.getName() + ": " + (c.isFull() ? "сыт" : "голоден"));
        }

        bowl.addFood(20);
        cats[1].eatFromBowl(bowl, 10);
        System.out.println(cats[1].getName() + " теперь " + (cats[1].isFull() ? "сыт" : "голоден"));

        // Вывод статистики
        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Из них котов: " + Cat.getCatCount());
        System.out.println("Из них собак: " + Dog.getDogCount());

        System.out.println("============================================");
        System.out.println("=================== Задание 2 =========================");

        GeometricShape circle = new Circle(5, "Красный", "Синий");
        GeometricShape rectangle = new Rectangle(4, 6, "Зелёный", "Жёлтый");
        GeometricShape triangle = new Triangle(3, 4, 5, "Голубой", "Фиолетовый");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Треугольник:");
        triangle.printInfo();
    }
}
