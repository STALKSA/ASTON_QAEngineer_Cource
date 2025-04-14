package org.example;

public class Main {
    public static void main(String[] args) {

        // Создаем массивы
        String[][] correctArray = {
                {"1", "44", "9", "4"},
                {"5", "16", "7", "86"},
                {"9", "123", "11", "112"},
                {"103", "14", "35", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "0", "78", "3"},
                {"22", "77", "777", "8"},
                {"9", "10", "XX", "12"},
                {"13", "14", "100", "106"}
        };

        try {
            System.out.println("Сумма correctArray: " + sumArray(correctArray));
            System.out.println("Сумма wrongSizeArray: " + sumArray(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма wrongDataArray: " + sumArray(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        try {
            generateArrayIndexOutOfBounds();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nПоймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }


    }


    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Неверный размер массива! Ожидается 4x4, получено " + array.length + "xN");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Неверный размер массива! Ожидается 4x4, получено Nx" + row.length);
            }
        }

        // Суммирование
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'"
                    );
                }
            }
        }

        return sum;
    }

    public static void generateArrayIndexOutOfBounds() {
        int[] arr = new int[5];
        int value = arr[10];
    }

}
