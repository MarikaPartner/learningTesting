package lesson_6.JC_Homework_6;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JC_Homework_6 {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        //https://api.weather.yandex.ru/v2/informers?lat=<широта>&lon=<долгота>&[lang=<язык ответа>]
        //https://api.weather.yandex.ru/v2/informers?lat=55.75396&lon=37.620393

        HttpUrl httpUrl = new HttpUrl.Builder()   // Построение URL (язык не важен, поэтому не включила)
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("informers")
                .addQueryParameter("lat", "54.193122")
                .addQueryParameter("lon", "37.617348")
                .build();
        // System.out.println(httpUrl);

        Request request = new Request.Builder()    // Построение запроса
                .url(httpUrl)
                .get()
                .addHeader("X-Yandex-API-Key", "fa21b4d6-f661-497e-b576-bb66c26fb699")
                .build();

        Response oneDayWeatherResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayWeatherResponse.body().string();

        // Вывод ответа сервера
        System.out.println("Response:");
        System.out.println(weatherResponse);
        System.out.println();

        // Выводим погоду в удобном виде
        System.out.println("Weather forecast:");
        String date = objectMapper.readTree(weatherResponse).at("/forecast").at("/date").asText();
        String minTemp = objectMapper.readTree(weatherResponse).at("/forecast").at("/parts").get(0).at("/temp_min").asText();
        String maxTemp = objectMapper.readTree(weatherResponse).at("/forecast").at("/parts").get(0).at("/temp_max").asText();
        String windSpeed = objectMapper.readTree(weatherResponse).at("/forecast").at("/parts").get(0).at("/wind_speed").asText();
        String precProb = objectMapper.readTree(weatherResponse).at("/forecast").at("/parts").get(0).at("/prec_prob").asText();

        System.out.println("Date: " + date);
        System.out.println("Minimum temperature: " + minTemp + " degree Celsius");
        System.out.println("Maximum temperature: " + maxTemp + " degree Celsius");
        System.out.println("Wind speed: " + windSpeed + " m/s");
        System.out.println("Probability of precipitation: " + precProb);
    }
}
