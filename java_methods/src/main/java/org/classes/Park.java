package org.classes;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, double price) {
        attractions.add(new Attraction(name, workingHours, price));
    }

    public void printParkInfo() {
        System.out.println("Парк: " + parkName);
        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }

    public List<Attraction> getAttractions() {
        return new ArrayList<>(attractions);
    }

    public static class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: $" + price);
            System.out.println("----------------------");
        }

        public String getName() {
            return name;
        }
    }
}