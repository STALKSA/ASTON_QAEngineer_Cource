package org.classes;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String manufactureCountry;
    private float price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer, String manufactureCountry, float price, boolean isReserved){
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.manufactureCountry = manufactureCountry;
        this.price = price;
        this.isReserved = isReserved;

    }

    public void printProductInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + manufactureCountry);
        System.out.println("Цена: $" + price);
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
        System.out.println("----------------------");
    }
}
