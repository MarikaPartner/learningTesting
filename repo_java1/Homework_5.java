/**
 * Java 1. Homework 5
 *
 * @author Marina Dumcheva
 * @version 21.11.2021
 */

class Homework_5 {
    public static void main(String[] args) {

        Worker[] workersArr = new Worker[5];
        workersArr[0] = new Worker("Ivanov Ivan Ivanovich", "courier", "ivanov@test.ru", "+7(999)8886677", 25000, 26);
        workersArr[1] = new Worker("Petrov Petr Petrovich", "director", "petrov@test.ru", "+7(999)8886600", 125000, 40);
        workersArr[2] = new Worker("Osipov Osip Osipovich", "yard keeper", "osipov@test.ru", "+7(999)8886633", 25000, 55);
        workersArr[3] = new Worker("Davidov David Davidovish", "programmer", "davidov@test.ru", "+7(999)8886611", 85000, 42);
        workersArr[4] = new Worker("Sidorov Sidor Sidorovish", "tester", "sidorov@test.ru", "+7(999)8886666", 55000, 35);

        workersArr[2].setFullName(null); // Checking valid full name
        workersArr[2].setSalary(-1000);  // Checking valid salary
        workersArr[2].setAge(6);         // Checking valid age

        int f = 0;
        for (int i = 0; i < workersArr.length; i++) {
            if (workersArr[i].getAge() > 40) {
                System.out.println(workersArr[i]);
                System.out.println();
                f = 1;
            }
        }
        if (f == 0) {
            System.out.println("The workers satisfying the condition was not found.");
        }
    }
 }

class Worker {
    private String fullName;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    Worker(String fullName, String post, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

// Restricting the full name
    public void setFullName(String fullName) {
        if (fullName != null) {
            this.fullName = fullName;
        }
    }
    public String getFullName() {
        return fullName;
    }

// Restricting the salary
    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
    public int getSalary() {
        return salary;
    }

// Restricting the age
    public void setAge(int age) {
        if (age >= 14) {
            this.salary = salary;
        }
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "full name: " + fullName + "\n" + "post: " + post + "\n" + "email: " + email + "\n" + "phone number " + phoneNumber + "\n" + "salary: " + salary + " RUB" + "\n" + "age: " + age;
    }
}

