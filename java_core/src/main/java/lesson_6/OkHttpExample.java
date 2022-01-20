package lesson_6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpExample {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()   // Формируем адрес страницы
                .scheme("https")
                .host("gb.ru")
                .addPathSegment("it_dao/prof2022")
                .build();

        Request request = new Request.Builder() // Формируем запрос
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute(); // Ответ
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());




    }
}
