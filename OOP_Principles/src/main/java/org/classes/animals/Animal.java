package org.classes.animals;

public class Animal {

    private static int animalCount = 0;
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected boolean canSwim;

    public Animal(String name, int maxRunDistance, int maxSwimDistance, boolean canSwim) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.canSwim = canSwim;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + maxRunDistance + " м.)");
        }
    }

    public void swim(int distance) {
        if (!canSwim) {
            System.out.println(name + " не умеет плавать!");
            return;
        }
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + maxSwimDistance + " м.)");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}