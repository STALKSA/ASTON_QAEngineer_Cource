package org.classes.animals;

public class Cat extends Animal {

    private static int catCount = 0;
    private boolean isFull;
    private static final int CAT_MAX_RUN = 200;
    private static final int CAT_MAX_SWIM = 0;
    public Cat(String name) {
        super(name, CAT_MAX_RUN, CAT_MAX_SWIM, false);
        this.isFull = false;
        catCount++;
    }

    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            this.isFull = true;
            System.out.println(name + " поел из миски и теперь сыт!");
        } else {
            System.out.println(name + " не смог поесть из миски - недостаточно еды!");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}
