package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Создаем коллекцию студентов
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван Иванов", "Группа1", 1,
                Map.of("Математика", 4, "Физика", 3, "История", 5)));

        students.add(new Student("Петр Петров", "Группа2", 2,
                Map.of("Математика", 2, "Физика", 3, "История", 2)));

        students.add(new Student("Сидор Сидоров", "Группа1", 1,
                Map.of("Математика", 5, "Физика", 5, "История", 5)));

        // Выводим всех студентов
        System.out.println("Все студенты:");
        students.forEach(System.out::println);

        // Удаляем неуспевающих студентов
        Student.removeUnderperformingStudents(students);
        System.out.println("\nПосле удаления неуспевающих:");
        students.forEach(System.out::println);

        // Переводим студентов на следующий курс
        Student.promoteEligibleStudents(students);
        System.out.println("\nПосле перевода на следующий курс:");
        students.forEach(System.out::println);

        // Печатаем студентов 2 курса
        Student.printStudents(students, 2);

        System.out.println("=============================================");


        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Добавляем записи
        phoneDirectory.add("Иванов", "123-456");
        phoneDirectory.add("Петров", "234-567");
        phoneDirectory.add("Иванов", "345-678");
        phoneDirectory.add("Сидоров", "456-789");

        // Ищем номера по фамилии
        System.out.println("Иванов: " + phoneDirectory.get("Иванов"));
        System.out.println("Петров: " + phoneDirectory.get("Петров"));
        System.out.println("Сидоров: " + phoneDirectory.get("Сидоров"));
        System.out.println("Несуществующий: " + phoneDirectory.get("Несуществующий"));
    }
}