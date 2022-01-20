package lesson_6;

import java.net.MalformedURLException;
import java.net.URL;

// MalformedURLException - неправильный URL
public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://geekbrains.ru:80/courses?type=ga&level=super#1");

        //System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getQuery());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());

        URL url1 = new URL("https", "geekbrains.ru", 80, "/courses");

    }
}
