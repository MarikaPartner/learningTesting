package lesson_7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

public class YandexModel implements WeatherModel {

    //https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String VERSION = "v2";
    private static final String FORECAST = "forecast";
    private static final String API_KEY = "663b8b39-4e47-41d0-9e6e-daa1443adaa9";
    private static final String API_KEY_OUERY_PARAMS = "X-Yandex-API-Key";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Метод, получающий прогноз с помощью сервиса Яндекс.Погода
    @Override
    public void getWeather(String selectedCity, Period period) throws IOException, DoNotFindCityExeption {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("lat", findCoordinatesCity(selectedCity).get("latitude"))  // Широта
                .addQueryParameter("lon", findCoordinatesCity(selectedCity).get("longitude")) // Долгота
                .addQueryParameter("lang", "ru")
                .addQueryParameter("limit", "5")     // Количество дней в прогнозе
                .addQueryParameter("hours", "false") // Почасовой прогноз не нужен
                .build();

        Request request = new Request.Builder()    // Построение запроса
                .url(httpUrl)
                .get()
                .addHeader("X-Yandex-API-Key", "663b8b39-4e47-41d0-9e6e-daa1443adaa9")
                .build();

        Response forcastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = forcastResponse.body().string();

        // Вывод ответа сервера
        //System.out.println("Response:");
        //System.out.println(weatherResponse);

        // Вывод прогноза в удомном виде
        String city = objectMapper.readTree(weatherResponse).at("/geo_object").at("/locality").at("/name").asText();
        String province = objectMapper.readTree(weatherResponse).at("/geo_object").at("/province").at("/name").asText();
        System.out.println("Погода для города " + city + ", " + province);

            switch (period) {
                case NOW:
                    String nowDate = objectMapper.readTree(weatherResponse).at("/now_dt").asText();

                    String nowTemp = objectMapper.readTree(weatherResponse).at("/fact").at("/temp").asText();
                    String nowCondition = objectMapper.readTree(weatherResponse).at("/fact").at("/condition").asText();

                    System.out.println("Дата: " + nowDate);
                    System.out.println("Температура воздуха сейчас: " + nowTemp + " (градусов Цельсия), " + nowCondition + ".");
                    System.out.println();
                    break;

                case FIVE_DAYS:
                    for (int i = 0; i < 5; i++) {
                        String date = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/date").asText();

                        String minNightTemp = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/night").at("/temp_min").asText();
                        String maxNightTemp = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/night").at("/temp_max").asText();
                        String nightCondition = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/night").at("/condition").asText();

                        String minDayTemp = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/day").at("/temp_min").asText();
                        String maxDayTemp = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/day").at("/temp_max").asText();
                        String dayCondition = objectMapper.readTree(weatherResponse).at("/forecasts").get(i).at("/parts").at("/day").at("/condition").asText();

                        System.out.println("Дата: " + date);
                        System.out.println("Ночь: температура максимальная " + maxNightTemp + ", минимальная " + minNightTemp + " (градусов Цельсия); " + nightCondition + ".");
                        System.out.println("День: температура максимальная " + maxDayTemp + ", минимальна " + minDayTemp + " (градусов Цельсия); " + dayCondition + ".");
                        System.out.println();
                    }
                    break;
            }
    }

    // Метод, позволяющий с помощью сервиса Dadata по названию города найти координаты
    public HashMap<String, String> findCoordinatesCity(String selectedCity) throws IOException, DoNotFindCityExeption {

        //https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/address
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("suggestions.dadata.ru")
                .addPathSegment("suggestions")
                .addPathSegment("api")
                .addPathSegment("4_1")
                .addPathSegment("rs")
                .addPathSegment("suggest")
                .addPathSegment("address")
                .addQueryParameter("query", selectedCity)
                .addQueryParameter("language", "ru")
                .addQueryParameter("count", "1")  // Количество результатов в ответе (первый - наиболее релевантный)
                .build();

        Request request = new Request.Builder()    // Построение запроса
                .url(httpUrl)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Token 9c561c9c939d94702ae2f20f727fd60f9804e54f")
                .build();

        Response coordinatesResponse = okHttpClient.newCall(request).execute();
        String lanLonResponse = coordinatesResponse.body().string();
        //System.out.println(lanLonResponse);

        HashMap<String, String> cityCoordinates = new HashMap<>(2); // Создаем HashMap для хранения координат

        // Если пришел пустой ответ, выбрасываем исключение
        if (objectMapper.readTree(lanLonResponse).at("/suggestions").size() == 0) {
            throw new DoNotFindCityExeption("Город с таким названием не найден!");
        } else {
            String dateLat = objectMapper.readTree(lanLonResponse).at("/suggestions").get(0).at("/data").at("/geo_lat").asText();
            String dateLon = objectMapper.readTree(lanLonResponse).at("/suggestions").get(0).at("/data").at("/geo_lon").asText();

            cityCoordinates.put("latitude", dateLat);
            cityCoordinates.put("longitude", dateLon);
        }
        return cityCoordinates;
    }
}