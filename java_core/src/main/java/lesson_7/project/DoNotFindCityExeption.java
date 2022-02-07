package lesson_7.project;

// Ошибка на случай, если Dadata не сможет распознать город и пришлет пустой ответ
public class DoNotFindCityExeption extends NullPointerException{
    DoNotFindCityExeption(String message) {
        super(message);
    }
}
