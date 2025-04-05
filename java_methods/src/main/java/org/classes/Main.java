package org.classes;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.01.2025", "Apple Inc.", "USA", 4999, false);
        productsArray[2] = new Product("Xiaomi 14", "10.03.2025", "Xiaomi", "China", 2999, true);
        productsArray[3] = new Product("Tesla Model Y", "05.01.2025", "Tesla", "USA", 54999, false);
        productsArray[4] = new Product("Dyson V12", "20.02.2025", "Dyson", "UK", 899, true);

        for (Product product : productsArray) {
            product.printProductInfo();
        }

        System.out.println("=====================================================");
        System.out.println("=====================================================");

        Park disneyland = new Park("Disneyland");
        Park universal = new Park("Universal Studios");
        Park efteling = new Park("Efteling");

        disneyland.addAttraction("Space Mountain", "10:00-22:00", 25.99);
        disneyland.addAttraction("Pirates of Caribbean", "09:00-20:00", 19.99);
        disneyland.addAttraction("Big Thunder Mountain", "11:00-21:00", 22.50);

        universal.addAttraction("Harry Potter and the Forbidden Journey", "09:00-19:00", 32.50);
        universal.addAttraction("Jurassic World Ride", "10:00-18:00", 28.75);
        universal.addAttraction("Transformers: The Ride", "09:30-19:30", 27.00);

        efteling.addAttraction("Baron 1898", "10:30-18:00", 15.50);
        efteling.addAttraction("Python", "10:00-17:30", 12.75);
        efteling.addAttraction("Symbolica", "10:15-18:15", 14.25);

        disneyland.printParkInfo();
        universal.printParkInfo();
        efteling.printParkInfo();


    }
}