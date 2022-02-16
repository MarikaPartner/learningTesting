package lesson_8.JC_Homework_8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String city;
            do {
                System.out.println();
                System.out.println("Введите название города России:");
                city = scanner.nextLine();
                } while (!isCity(city));

            // К названию города добавляем пробел, чтобы Dadata не перепутала название города с началом названия области.
            //city = city + " ";
            String command;
            do {
            System.out.println("Введите 1 - для получения погоды на текущий момент, 5 - для получения прогноза погоды на пять дней, 2 - для получения данных из базы, 0 - для выхода из программы");
            command = scanner.nextLine();
            } while (!command.matches("[1250]")); // Разрешаем ввод только 1, 2, 5 и 0

            if(command.equals("0")) break;
            try {
                controller.getWeather(command, city);
            } catch (DoNotFindCityExeption | IOException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Проверка валидности названия города (может содержать буквы, три слова, пробелы и тире)
    public static boolean isCity(String city) {
        String regex = "[а-яА-Я]+(\\s?|-?)[а-яА-Я]*(\\s?|-?)[а-яА-Я]*";
        return city.matches(regex);
    }
}
