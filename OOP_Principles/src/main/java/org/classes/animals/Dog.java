package org.classes.animals;


public class Dog extends Animal {

    private static int dogCount = 0;
    private static final int DOG_MAX_RUN = 500;
    private static final int DOG_MAX_SWIM = 10;

    public Dog(String name) {
        super(name, DOG_MAX_RUN, DOG_MAX_SWIM, true);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

}
