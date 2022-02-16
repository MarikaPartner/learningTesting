package lesson_8.JC_Homework_8;

import lesson_8.JC_Homework_8.entity.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new YandexModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
        variants.put(2, Period.DB);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException, DoNotFindCityExeption, SQLException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                try {
                    weatherModel.getWeather(selectedCity, Period.NOW);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case FIVE_DAYS:
                try {
                    weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case DB:
                for (Weather i : weatherModel.getSavedToDBWeather(selectedCity)) {
                    System.out.println(i);
                }
        }
    }
}
