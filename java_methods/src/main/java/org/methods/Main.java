package org.methods;

public class Main {
    public static void main(String[] args) {
        System.out.println("============задание 1=================");
        printThreeWords(); // задание 1

        System.out.println("=============задание 2================");
        checkSumSign(5, -100); // задание 2

        System.out.println("=============задание 3================");
        printColor(99); // задание 3

        System.out.println("=============задание 4================");
        compareNumbers(4, 80); // задание 4

        System.out.println("=============задание 5================");
        System.out.println(checkSumInRange(12, 5)); // задание 5

        System.out.println("=============задание 6================");
        checkNumber(0); // задание 6

        System.out.println("=============задание 7================");
        System.out.println(isNegative(-5)); // задание 7
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Задание 2
    public static void checkSumSign(int a, int b) {
        int sum = a + b;
        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    // Задание 3
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание 4
    public static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    // Задание 5
    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание 6
    public static void checkNumber(int a) {
        System.out.println(a >= 0 ? "Положительное" : "Отрицательное");
    }

    // Задание 7
    public static boolean isNegative(int number) {
        return number < 0;
    }
}