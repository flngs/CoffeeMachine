package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void getState() {
        System.out.printf("\nThe coffee machine has:\n" +
                                  "%d ml of water\n" +
                                  "%d ml of milk\n" +
                                  "%d g of coffee beans\n" +
                                  "%d disposable cups\n" +
                                  "$%d of money\n",
                          water, milk, coffeeBeans, disposableCups, money);
    }

    public void buyCoffee(int coffeeType) {
        switch (coffeeType) {
            case 1:
                if (checkIngredients(250, 0, 16, 1)) {
                    break;
                }
                this.water -= 250;
                this.coffeeBeans -= 16;
                this.disposableCups -= 1;
                this.money += 4;
                break;
            case 2:
                if (checkIngredients(350, 75, 20, 1)) {
                    break;
                }
                this.water -= 350;
                this.milk -= 75;
                this.coffeeBeans -= 20;
                this.disposableCups -= 1;
                this.money += 7;
                break;
            case 3:
                if (checkIngredients(200, 100, 12, 1)) {
                    break;
                }
                this.water -= 200;
                this.milk -= 100;
                this.coffeeBeans -= 12;
                this.disposableCups -= 1;
                this.money += 6;
                break;
        }
    }

    public void fill(Scanner sc) {
        System.out.println("\nWrite how many ml of water you want to add:");
        this.water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += sc.nextInt();
    }

    public void take() {
        System.out.printf("I gave you %d\n", this.money);
        this.money = 0;
    }

    private boolean checkIngredients(int water, int milk, int coffeeBeans, int disposableCups) {
        boolean st = false;
        if (this.water - water < 0) {
            System.out.println("Sorry, not enough water!\n");
        } else if (this.milk - milk < 0) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (this.coffeeBeans - coffeeBeans < 0) {
            System.out.println("Sorry, not enough coffee!\n");
        } else if (this.disposableCups - disposableCups < 0) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            st = true;
        }
        return !st;
    }
}
