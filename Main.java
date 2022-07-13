package machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String action;
        boolean power = true;
        CoffeeMachine cm = new CoffeeMachine(400, 540, 120, 9, 550);

        while (power) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            action = sc.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    if (sc.hasNext("back")) {
                        break;
                    }
                    cm.buyCoffee(sc.nextInt());
                    break;
                case "fill":
                    cm.fill(sc);
                    break;
                case "take":
                    cm.take();
                    break;
                case "remaining":
                    cm.getState();
                    break;
                case "exit":
                    power = false;
                    break;
            }
        }
    }
}
