/**
 * Java 1. Homework 7
 *
 * @author Marina Dumcheva
 * @version 24.11.2021
 */

import java.util.Scanner;

class Homework_7 {
    public static void main(String[] args) {

    // Creating cats and a plate
        Cat[] catsArr = new Cat[3];
        catsArr[0] = new Cat("Barsik", 50);
        catsArr[1] = new Cat("Mursik", 100);
        catsArr[2] = new Cat("Rysik", 50);
        boolean needToAdd = true;
        Plate plate = new Plate(0);

    // Printing cats and the plate
        System.out.println("ATTENTION! There are " + catsArr.length +" hungry cats in your house:");
        System.out.println();
        for (int i = 0; i < catsArr.length; i++) {
            System.out.println(catsArr[i]);
        }
        System.out.println();

    // Feeding cats
        while (needToAdd == true) {
            plate.addFood();
            System.out.println();
            for (int i = 0; i < catsArr.length; i++) {
                catsArr[i].eat(plate);
            }

    // Printing cats and the plate after eating
            for (int i = 0; i < catsArr.length; i++) {
                System.out.println(catsArr[i]);
            }
            System.out.println(plate);
            System.out.println();

    // Cheking the satiety of cats
            for (int i = 0; i < catsArr.length; i++) {
                if (catsArr[i].satiety == false) {
                    needToAdd = true;
                    System.out.println("Oh, there are hungry cats left!");
                    break;
                } else needToAdd = false;
            }
        }
        System.out.println("Thank you, all cats are full!");
    }
    }

class Cat {
    String name;
    int appetite;
    boolean satiety;

    Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate) {
        if (!satiety) {
            this.satiety = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return name + ", appetite - " + appetite + "g, satiety - " + satiety;
    }
}

class Plate {
    int food;
    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int appetite) {
            if (this.food < appetite) {
                return false;
            } else {
                this.food -= appetite;
                return true;
            }
    }

    void addFood() {
        Scanner sc = new Scanner(System.in);
        int newFood;
        do {
            System.out.println("Please, add the food (in grams) on the plate: ");
            while (!sc.hasNextInt()) {
                System.out.println("Enter the number!");
                sc.next();
            }
            newFood = sc.nextInt();
            if (newFood < 0) {
                System.out.println("The value must be positive");
            }
        } while (newFood < 0);
        this.food += newFood;
    }

        @Override
        public String toString() {
        return "In the plate: " + food + " g";
        }
}