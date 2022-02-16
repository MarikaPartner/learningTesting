package lesson_8.JC_Homework_8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import lesson_8.JC_Homework_8.entity.Weather;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    List<Weather> getSavedToDBWeather(String selectedCity);
}
