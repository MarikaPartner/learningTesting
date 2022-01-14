package java_core.lesson_3.JC_Homework_3;

/**
 * Java Core. Homework for Lesson 3
 *
 * @author Marina Dumcheva
 * @version 07.01.2022
 */

import java.util.Arrays;

public class JC_Homework_3 {

    public static void main(String[] args) {

        // Задание 1

        // Создаем и выводим массивы различных типов

        String[] arr1 = {"A", "B", "C"};
        Integer[] arr2 = {10, 20, 30, 40, 50};
        Fruit[] arr3 = {new Apple(), new Orange()};
        Integer[] arr4 = {5};

        System.out.println("Original arrays:");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println();

        // Меняем элементы местами и выводим измененные массивы

        System.out.println("Changed arrays:");
        try {
            changePlace(arr1,-1,2);
            System.out.println(Arrays.toString(arr1));
        } catch (MyArrIndexException e) {
            System.out.println(e);
        }
        try {
            changePlace(arr2, 1, 4);
            System.out.println(Arrays.toString(arr2));
        } catch (MyArrIndexException e) {
            System.out.println(e);
        }
        try {
            changePlace(arr3,1,2);
            System.out.println(Arrays.toString(arr3));
        } catch (MyArrIndexException e) {
            System.out.println(e);
        }
        try {
            changePlace(arr4,1,1);
            System.out.println(Arrays.toString(arr4));
        } catch (MyArrIndexException e) {
            System.out.println(e);
        }
        System.out.println();

        // Задание 2

        // Создаем и выводим коробки

        Box<Apple> box1 = new Box<>(10.0);
        Box<Orange> box2 = new Box<>(10.0);
        Box<Orange> box3 = new Box<>(12.0);
        box1.printBox();
        box2.printBox();
        box3.printBox();
        System.out.println();

        // Добавляем в коробки фрукты и выводим заполненные коробки

            box1.addFruitInBox(new Apple(), 3);
            box2.addFruitInBox(new Orange(), 5);
            box3.addFruitInBox(new Orange(), 9);

        box1.printBox();
        box2.printBox();
        box3.printBox();

        // Сравниваем коробки 1 и 2

        System.out.println();
        System.out.println();
        System.out.println("Equality of boxes by weight: " + box1.compareBoxes(box2));

        // Пересыпаем фрукты из коробки 2 в коробку 3, выводим коробки.

        box2.pourInBox(box3);

        box2.printBox();
        box3.printBox();
    }

    public static void changePlace(Object[] arr, int a, int b) throws MyArrIndexException {
        if (a > arr.length || b > arr.length) {
            throw new MyArrIndexException("There are no elements with the specified positions!");
        }
        if (a < 1 || b < 1 ) {
            throw new MyArrIndexException("The element number must be greater than zero!");
        }
        if (arr.length == 1) {
            throw new MyArrIndexException("There is only one element in the array!");
        }
        Object c = arr[a - 1];
        arr[a - 1] = arr[b - 1];
        arr[b - 1] = c;
    }
}