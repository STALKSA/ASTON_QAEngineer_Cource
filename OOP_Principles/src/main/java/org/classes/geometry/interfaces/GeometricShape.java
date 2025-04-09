package org.classes.geometry.interfaces;

public interface GeometricShape {

    default String getFillColor() {
        return "Белый";
    }

    default String getBorderColor() {
        return "Чёрный";
    }

    default void printInfo() {
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("----------------------");
    }

    double calculatePerimeter();
    double calculateArea();
}
