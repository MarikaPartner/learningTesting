package lesson_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lesson_9.Student.printStudentsList;

public class JC_Homework_9 {
    public static void main(String[] args) {

        // Создаём список студентов
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ivanov", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.PROGRAMMING))));
        studentList.add(new Student("Ivanovа", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.PROGRAMMING, Course.TESTING, Course.INFORMATION_SECURITY))));
        studentList.add(new Student("Petrov", new ArrayList<>(Arrays.asList(Course.PROGRAMMING))));
        studentList.add(new Student("Polyakova", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.PROGRAMMING))));
        studentList.add(new Student("Arhipova", new ArrayList<>(Arrays.asList(Course.INFORMATION_SECURITY, Course.PROGRAMMING))));
        studentList.add(new Student("Smirnova", new ArrayList<>(Arrays.asList(Course.TESTING, Course.STATISTICS, Course.PROGRAMMING, Course.INFORMATION_SECURITY, Course.NETWORKS))));
        studentList.add(new Student("Bodrov", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.PROGRAMMING))));
        studentList.add(new Student("Starkova", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.INFORMATION_SECURITY, Course.STATISTICS, Course.PROGRAMMING))));
        studentList.add(new Student("Donorov", new ArrayList<>(Arrays.asList(Course.INFORMATION_SECURITY, Course.PROGRAMMING))));
        studentList.add(new Student("Pavlova", new ArrayList<>(Arrays.asList(Course.NETWORKS, Course.PROGRAMMING))));
        studentList.add(new Student("Rodina", new ArrayList<>(Arrays.asList(Course.NETWORKS))));

        // Печатаем список студентов
        printStudentsList(studentList);

        System.out.println();
        System.out.println("Three of the most inquisitive students:");
        printStudentsList(getMostInquisitiveStudents(studentList));

        System.out.println();
        System.out.println("List of courses:");
        System.out.println(getListOfCourses(studentList));

        System.out.println();
        System.out.println("List of course NETWORKS students:");
        printStudentsList(getStudentOfTheCourse(studentList, Course.NETWORKS));

        System.out.println();
        System.out.println("List of course TESTING students:");
        printStudentsList(getStudentOfTheCourse(studentList, Course.TESTING));
    }

    // Функция, принимающая список Student и возвращающая список уникальных курсов, на которые подписаны студенты.

    private static List<Course> getListOfCourses(List<Student> students) {
        return students.stream()                       // создаем поток из списка студентов
                .map(s -> s.getCourses())              // преобразуем поток студентов в поток списков посещаемых ими курсов
                .flatMap(c -> c.stream())              // преобразуем поток списков курсов в поток курсов
                .distinct()                            // выбираем уникальные курсы
                .collect(Collectors.toList());         // создаем коллекцию уникальных курсов
    }

    // Функция, принимающая на вход список Student и возвращающая список из трех самых любознательных (любознательность определяется количеством курсов).

    private static List<Student> getMostInquisitiveStudents (List<Student> students) {
        return students.stream()                                                     // создаем поток из списка студентов
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size()) // сортируем студентов по количеству посещаемых курсов
                .collect(Collectors.toList())                                        // создаем коллекцию из отсортированных студентов
                .subList(0, 3);                                                      // берем первых трех студентов
    }

    // Функция, принимающая на вход список Student и экземпляр Course, возвращающая список студентов, которые посещают этот курс.
    private static List<Student> getStudentOfTheCourse (List<Student> students, Course course) {
        return students.stream()                               // создаем поток из списка студентов
                .filter(s -> s.getCourses().contains(course))  // отфильтровываем тех, кто посещает данный курс
                .collect(Collectors.toList());                 // создаем коллекцию из отфильтрованых студентов
    }
}