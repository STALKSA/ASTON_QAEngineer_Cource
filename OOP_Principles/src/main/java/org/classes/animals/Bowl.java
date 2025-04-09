package org.classes.animals;

public class Bowl {

    private int foodAmount;
   
    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным!");
            return false;
        }
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " единиц еды. Теперь в миске: " + foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
