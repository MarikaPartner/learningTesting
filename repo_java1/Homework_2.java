/**
 * Java 1. Homework 2
 *
 * @author Marina Dumcheva
 * @version 8.11.2021
 */
class Homework_2_re {
    public static void main(String[] args) {
        //Task 1
        System.out.println(checkSumbetween10_20(-10, 5));
        System.out.println(checkSumbetween10_20(5, 5));
        System.out.println(checkSumbetween10_20(10, 5));
        System.out.println(checkSumbetween10_20(15, 5));
        System.out.println(checkSumbetween10_20(10, 55));
        //Task 2
        isPositiveOrNegative(-110);
        isPositiveOrNegative(0);
        isPositiveOrNegative(87);
        //Task 3
        System.out.println(checkNegative(-675));
        System.out.println(checkNegative(0));
        System.out.println(checkNegative(596));
        //Task 4
        printWordNTimes("Hello!", 4);
        printWordNTimes("Goodbye!", 0);
        //Task 5*
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2007));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1900));
    }
    static boolean checkSumbetween10_20(int a, int b) {
        return (a+b>=10&&a+b<=20);
    }

    static void isPositiveOrNegative(int f) {
        System.out.println("The number is "+(f<0? "negative" : "positive")+".");
    }

    static boolean checkNegative(int k) {
        return (k<0);
    }

    static void printWordNTimes(String text, int times){
        for (int i=1; i<=times; i++) {
            System.out.println(text);
        }
    }

    static boolean isLeapYear(int year) {
        return (year%4==0 && year%100!=0)||(year%400==0);
    }
}