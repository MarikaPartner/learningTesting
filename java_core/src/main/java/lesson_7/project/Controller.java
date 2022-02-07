package lesson_7.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new YandexModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException, DoNotFindCityExeption {
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
        }
    }
}
