package org.methods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("============задание 1=================");
        printThreeWords();

        System.out.println("=============задание 2================");
        checkSumSign(5, -100);

        System.out.println("=============задание 3================");
        printColor(99);

        System.out.println("=============задание 4================");
        compareNumbers(4, 80);

        System.out.println("=============задание 5================");
        System.out.println(checkSumInRange(12, 5));

        System.out.println("=============задание 6================");
        checkNumber(0);

        System.out.println("=============задание 7================");
        System.out.println(isNegative(-5));

        System.out.println("=============задание 8================");
        printString("Красивый", 5);

        System.out.println("=============задание 9================");
        System.out.println("1991: " + isLeapYear(1991));
        System.out.println("2020: " + isLeapYear(2020));

        System.out.println("=============задание 10================");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Было: " + Arrays.toString(array));
        invertArray(array);
        System.out.println("Стало: " + Arrays.toString(array));

        System.out.println("=============задание 11================");
        int[] array2 = createSequenceArray(100);
        System.out.println(Arrays.toString(array2));

        System.out.println("=============задание 12================");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Было: " + Arrays.toString(array3));
        multiplyLessThanSix(array3);
        System.out.println("Стало: " + Arrays.toString(array3));

        System.out.println("=============задание 13================");
        int size = 7;
        int[][] squareArray = createDiagonalArray(size);
        for (int[] row : squareArray) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("=============задание 14================");
        int[] array4 = createInitializedArray(10, 5);
        System.out.println(Arrays.toString(array4));
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

    // Задание 8
    public static void printString(String str, int a){
        for(int i = 0; i < a; i++){
            System.out.println(str);
        }
    }

    // Задание 9
    public static boolean isLeapYear(int year){
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    // Задание 10
    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
    }

    // Задание 11
    public static int[] createSequenceArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Задание 12
    public static void multiplyLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    // Задание 13
    public static int[][] createDiagonalArray(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - 1 - i] = 1;
        }
        return arr;
    }

    // Задание 14
    public static int[] createInitializedArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

}