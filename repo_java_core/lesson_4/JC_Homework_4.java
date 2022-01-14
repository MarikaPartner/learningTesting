package java_core.lesson_4;

import java.util.*;

public class JC_Homework_4 {
    public static void main(String[] args) {
        // Задание 1

        // Создаем массив
        String[] fruitArr = new String[25];
        fruitArr[0] = "apple";
        fruitArr[1] = "apple";
        fruitArr[2] = "apple";
        fruitArr[3] = "kiwi";
        fruitArr[4] = "kiwi";
        fruitArr[5] = "mango";
        fruitArr[6] = "mango";
        fruitArr[7] = "tangerine";
        fruitArr[8] = "mango";
        fruitArr[9] = "mango";
        fruitArr[10] = "apple";
        fruitArr[11] = "mango";
        fruitArr[12] = "mango";
        fruitArr[13] = "mango";
        fruitArr[14] = "mango";
        fruitArr[15] = "mango";
        fruitArr[16] = "tangerine";
        fruitArr[17] = "watermelon";
        fruitArr[18] = "plum";
        fruitArr[19] = "plum";
        fruitArr[20] = "tangerine";
        fruitArr[21] = "pear";
        fruitArr[22] = "plum";
        fruitArr[23] = "pear";
        fruitArr[24] = "plum";

        // Печатаем исходный массив
        System.out.println("The original array:");
        for (String i : fruitArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Передаем исходный массив в коллекцию HashSet, чтобы получить список уникальных элементов. Печатаем.
        HashSet<String> fruitHashSet = new HashSet<>(Arrays.asList(fruitArr));
        System.out.println(fruitHashSet);

        // Создаем коллекцию HashMap и добавляем в нее пары "слово - количество повторов"
        HashMap<String, Integer> fruitHashMap = new HashMap<>(fruitHashSet.size());
        for (int i = 0; i < fruitArr.length; i++) {
            int quantity = 1;
            for (int j = i + 1; j < fruitArr.length; j++) {   // ищем повторы и считаем их количество
                if (fruitArr[i] == fruitArr[j]) {
                    quantity++;
                }
            }
            if (!fruitHashMap.containsKey(fruitArr[i])) {     // заносим данные в HashMap, если данного "ключа" еще нет
                fruitHashMap.put(fruitArr[i], quantity);
            }
        }
        System.out.println(fruitHashMap);
        System.out.println();

        // Task 2

        // Создаём телефонный справочник и вносим в него данные
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Petrova","79209990099");
        phoneDirectory.add("Petrova","79209990096");
        phoneDirectory.add("Petrov","79209990096");
        phoneDirectory.add("Ivanova","79209990000");
        phoneDirectory.add("Petrova","79209992222");
        phoneDirectory.add("Ivanova","79530000033");
        phoneDirectory.add("Sidorov","79209991111");

        // Печатаем телефонный справочник
        System.out.println(phoneDirectory);

        // Выводим телефоны ао указанным фамилиям
        System.out.println("Petrova " + phoneDirectory.get("Petrova"));
        System.out.println("Sidorov " + phoneDirectory.get("Sidorov"));
        System.out.println("Sidorova " + phoneDirectory.get("Sidorova"));
    }
}