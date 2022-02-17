package lesson_9;

import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public static void printStudentsList(List<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return name + " " + courses;
    }
}