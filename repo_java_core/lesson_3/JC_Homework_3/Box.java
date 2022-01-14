package java_core.lesson_3.JC_Homework_3;

import java.util.ArrayList;

public class Box<F extends Fruit> {

    private ArrayList<F> boxArrayList; // Динамический массив, хранящий фрукты
    private double maxWeight;          // Максимальная масса фруктов в коробке
    public static int number = 0;      // Количество созданных коробок
    private int numberBox;             // Номер коробки
    private boolean fullingBox;        // Наполненность коробки (true - если коробка полностью заполненна)

    public Box(double maxWeight) {
        this.boxArrayList = new ArrayList<F>();
        this.maxWeight = maxWeight;
        number++;
        this.numberBox = number;
    }

    // Метод, добавляющий в коробку фрукт
    public void addFruitInBox(F fruit) {
        if (this.getWeight() + fruit.weight <= this.maxWeight) {
            this.boxArrayList.add(fruit);
        } else {
            fullingBox = true;
        }
    }

    // Метод, добавляющий в коробку несколько фруктов одного типа
    public void addFruitInBox(F fruit, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.addFruitInBox(fruit);
        }
    }

    // Метод, высчитывающий вес одной коробки
    public double getWeight() {
        double sum = 0;
        for (F f : this.boxArrayList) {
            sum = sum + f.weight;
        }
        return sum;
    }

    // Метод, сравнивающий две коробки по весу
    public boolean compareBoxes(Box box) {
        return this.getWeight() == box.getWeight();
    }

    // Метод, пересыпающий фрукты из текущей коробки в указанную
    public void pourInBox(Box<F> box) {
        int a = this.boxArrayList.size();
        for (int i = this.boxArrayList.size() - 1; i >= 0; i--) {
            if (box.getWeight() + this.boxArrayList.get(i).weight <= box.maxWeight) {
                box.boxArrayList.add(this.boxArrayList.get(i));
                this.boxArrayList.remove(i);
            } else {
                box.fullingBox = true;
            }
        }
    }

    // Метод, выводящий коробку в консоль
    public void printBox() {
        System.out.println();
        System.out.print("[ box " + this.numberBox);
        System.out.print(" (<=" + this.maxWeight + "f)");
        if (this.boxArrayList.size() != 0) {
            System.out.print("| " + this.boxArrayList.size() + " " + this.boxArrayList.get(0) + "s ");
        } else {
            System.out.print("| The box is empty.");
        }
        System.out.print(" | weight: " + this.getWeight() + "f ");
        if (this.fullingBox) {
            System.out.print("| The box is full! ");
        }
        System.out.print("]");
    }

    public ArrayList<F> getBoxArrayList() {
        return boxArrayList;
    }

    public void setBoxArrayList(ArrayList<F> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getNumberBox() {
        return numberBox;
    }

    public void setNumberBox(int numberBox) {
        this.numberBox = numberBox;
    }

    public boolean isFullingBox() {
        return fullingBox;
    }

    public void setFullingBox(boolean fullingBox) {
        this.fullingBox = fullingBox;
    }
}
