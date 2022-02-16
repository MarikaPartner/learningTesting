package lesson_8.JC_Homework_8;

// Ошибка на случай, если Dadata не сможет распознать город и пришлет пустой ответ
public class DoNotFindCityExeption extends NullPointerException{
    DoNotFindCityExeption(String message) {
        super(message);
    }
}
