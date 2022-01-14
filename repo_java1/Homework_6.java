/**
 * Java 1. Homework 6
 *
 * @author Marina Dumcheva
 * @version 28.11.2021
 */

class Homework_6 {
    public static void main(String[] args) {
    // Creating animals
        Dog dog1 = new Dog ("Polkan", 500, 10);
        Dog dog2 = new Dog ("Sharik", 500, 10);
        Dog dog3 = new Dog ("Guchka", 500, 10);
        Cat cat1 = new Cat ("Pushok", 200);
        Cat cat2 = new Cat ("Murka", 200);
    // Animals run and swim
        IAnimal[] animals = {dog1, dog2, cat1, cat2, dog3};
        for (IAnimal animal : animals){
        System.out.println(animal.run(130));
        System.out.println(animal.run(200));
        System.out.println(animal.run(600));
        System.out.println(animal.swim(5));
        System.out.println(animal.swim(10));
        System.out.println(animal.swim(15));
        System.out.println();
        }
    // Printing the sum of animals
        System.out.println("Animals were created: " + Animal.getSumAnimals()+
            "\n" + "Cats were created: " + Cat.getSumCats() +
            "\n" +"Dogs were created: "+ Dog.getSumDogs());
    }
}

interface IAnimal {
    public String run(int runDistance);
    public String swim(int swimDistance);
}

abstract class Animal implements IAnimal {
    private String name;
    private int maxDistanceRun;
    private int maxDistanceSwim;
    private static int sumAnimals = 0;

    Animal (String name, int maxDistanceRun, int maxDistanceSwim) {
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        sumAnimals++;
    }

    public String run (int runDistance) {
        if (runDistance <= this.maxDistanceRun) {
        return (this.getClass().getName() + " " + this.name + " ran: " + runDistance + " m");
        } else return (this.getClass().getName() + " "+ this.name + " can't run this distance");
    }

    public String swim (int swimDistance) {
        if (swimDistance <= this.maxDistanceSwim) {
        return (this.getClass().getName() +" "+ this.name + " swam: " + swimDistance + " m");
        } else return (this.getClass().getName() +" "+this.name + " can't swim this distance");
    }

    public String getName() {
        return name;
    }

    public static int getSumAnimals() {
        return sumAnimals;
    }
}

class Dog extends Animal {
    private static int sumDogs = 0;

    Dog (String name, int maxDistanceRun, int maxDistanceSwim) {
        super(name, maxDistanceRun, maxDistanceSwim);
        sumDogs++;
    }

    public static int getSumDogs() {
        return sumDogs;
    }
}

class Cat extends Animal {
    private static int sumCats = 0;

    Cat (String name, int maxDistanceRun) {
        super(name, maxDistanceRun, 0);
        sumCats++;
    }

        public static int getSumCats() {
        return sumCats;
    }

    @Override
    public String swim (int swimDistance) {
        return (this.getClass().getName()+" "+ getName() + " can't swim");
    }
}