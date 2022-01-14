package java_core.lesson_3.JC_Homework_3;

public class MyArrIndexException extends ArrayIndexOutOfBoundsException {
    String message;

    MyArrIndexException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
