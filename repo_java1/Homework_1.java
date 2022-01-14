class Homework_1_re {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println(checkSumSign(-35, 5));
        printColor();
        System.out.println(compareNumbers(500, -188));
    }
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }
    static String checkSumSign(int a, int b) {
        return("The sum is "+(a+b<0? "negative" : "positive"));
    }
    static void printColor() {
        int value=-1000;
        if (value <= 0) {
        System.out.println("Красный");
        } else if (value <=100) {
        System.out.println("Желтый");
        } else {
        System.out.println("Зеленый");
        }
        System.out.println();
        }
    static String compareNumbers(int a, int b) {
            return(a>=b? "a>=b" : "a<b");
    }
}