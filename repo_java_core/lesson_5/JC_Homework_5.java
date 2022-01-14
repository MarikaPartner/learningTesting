package java_core.lesson_5;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java Core. Homework for Lesson 5
 *
 * @author Marina Dumcheva
 * @version 13.01.2022
 */

public class JC_Homework_5 {
    public static void main (String[] args) throws FileNotFoundException {

        // Создаём и печатаем таблицу (объект класса AppData)
        String[] header1 = {"rat", "ox", "tiger", "hare", "dragon", "snake"};
        int[][] data1 = {{1196, 1997, 1998, 1999, 2000, 2001}, {2008, 2009, 2010, 2011, 2012, 2013}, {2020, 2021, 2022, 2023, 2024, 2025}};
        AppData chineseHoroscope1 = new AppData(header1, data1);

        System.out.println("The original table:");
        chineseHoroscope1.printAppData();

        // Запись в файл

        try (PrintWriter printWriter = new PrintWriter("chineseHoroscope.csv")) {
            for (int i = 0; i < chineseHoroscope1.getHeader().length; i++) {
                printWriter.print(chineseHoroscope1.getHeader()[i] + ";");
            }
            printWriter.println();
            for (int i = 0; i < chineseHoroscope1.getData().length; i++) {
                for (int j = 0; j < chineseHoroscope1.getData()[i].length; j++) {
                    printWriter.print(chineseHoroscope1.getData()[i][j] + ";");
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Чтение из файла

        // Создаем списки, которые будут содержать заголовок и данные таблицы
        // (используем списки, так как не знаем, сколько данных считаем из таблицы)
        ArrayList<String> tempHeadList = new ArrayList<>();
        ArrayList<String[]> tempDateList = new ArrayList<>();

        // Считываем данные из файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("chineseHoroscope.csv"))) {
            String[] tempHead= bufferedReader.readLine().split(";");
            for (String i : tempHead) {
                tempHeadList.add(i);
            }
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] strTempDate = temp.split(";");
                tempDateList.add(strTempDate);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Преобразуем список с заголовком в массив с заголовком
        String[] header2 = new String[tempHeadList.size()];
        for (int i = 0; i < tempHeadList.size(); i++) {
            header2[i] = tempHeadList.get(i);
        }

        // Преобразуем список (String) с данными в массив (int) данных
        int[][] data2 = new int[tempDateList.size()][tempDateList.get(0).length];
        for (int i = 0; i < tempDateList.size(); i++) {
            for (int j = 0; j < tempDateList.get(i).length; j++) {
                data2[i][j] = Integer.parseInt(tempDateList.get(i)[j]);
            }
        }

        // Создаем новый объект класса AppData из полученных из файла данных
        AppData newChineseHoroscope = new AppData(header2, data2);
        System.out.println("New array:");
        newChineseHoroscope.printAppData();
    }
}
