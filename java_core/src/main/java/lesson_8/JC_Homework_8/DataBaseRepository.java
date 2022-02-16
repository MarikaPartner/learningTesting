package lesson_8.JC_Homework_8;

import lesson_8.JC_Homework_8.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:myWeather.db";
    private final String insertWeather = "insert into weather_archive (city, province, date, temperature, condition) values (?, ?, ?, ?, ?)";
    private final String getWeather = "select * from weather_archive where city = ?";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getProvince());
            saveWeather.setString(3, weather.getDate());
            saveWeather.setDouble(4, weather.getTemperature());
            saveWeather.setString(5, weather.getCondition());
            return saveWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение в базу не выполненно!");
    }

    public List<Weather> getSaveToDBWeather(String selectedCity) {
        List<Weather> weather = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement getWeatherCity = connection.prepareStatement(getWeather);
            getWeatherCity.setString(1, selectedCity);
            ResultSet resultSet = getWeatherCity.executeQuery();
            while (resultSet.next()) {
                weather.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("date"),
                        resultSet.getDouble("temperature"),
                        resultSet.getString("condition")));
            }
            if (weather.size() == 0) {
                System.out.println("В базе нет данных по данному городу.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weather;
        }
}
