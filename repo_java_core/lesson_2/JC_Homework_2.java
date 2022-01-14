/**
 * Java Core. Homework for Lesson 2
 *
 * @author Marina Dumcheva
 * @version 27.12.2021
 */

import java.util.Arrays;

class JC_Homework_2 {
    public static void main(String[] args) {

        String[][] myArray1 = {
            {"1","1","1","1"},
            {"1","1","1","1"},
            {"1","0","1","0"},
            {"1","1","1","1"}
        };

        String[][] myArray2 = {
            {"1","1","1","1"},
            {"1","1","1","1"},
            {"2","5","2","1"},
            {"1","1","1","1"},
            {"1","1","1","1"}
        };

        String[][] myArray3 = {
            {"1","1","1","1"},
            {"1","1","1","1"},
            {"1","1","1","1"},
            {"0","0","O","0"}
        };

        System.out.println("The original array 1:");
        printMyAray(myArray1);

// Converting the array 1 and calculating sum.
        System.out.println();
        try {
            System.out.println("The sum of all array elements: " + convertArrToInt(myArray1));
            } catch (MyArraySizeExeption | MyArrayDataException e) {
                System.out.println(e);
            }

        System.out.println();
        System.out.println("The original array 2:");
        printMyAray(myArray2);


// Converting the array 2 and calculating sum.
        System.out.println();
        try {
            System.out.println("The sum of all array elements: " + convertArrToInt(myArray2));
            } catch (MyArraySizeExeption | MyArrayDataException e) {
                System.out.println(e);
            }

// Printing the original array 3.
        System.out.println();
        System.out.println("The original array 3:");
        printMyAray(myArray3);

// Converting the array 3 and calculating sum.
        System.out.println();
        try {
            System.out.println("The sum of all array elements: " + convertArrToInt(myArray3));
            } catch (MyArraySizeExeption | MyArrayDataException e) {
                System.out.println(e);
            }
    }

    static void printMyAray(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(Arrays.toString(myArray[i]));
        }
    }

    static int convertArrToInt(String[][] originArr) throws MyArraySizeExeption {
        if (originArr.length != 4) {
            throw new MyArraySizeExeption("The array must have a size of 4x4!");
        }
        int[][] convertArr = new int[originArr.length][originArr.length];
        int summ = 0;
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr.length; j++) {
                try {
                    convertArr[i][j] = Integer.parseInt(originArr[i][j]);
                    summ = summ + convertArr[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                    }
            }
        }
        return summ;
    }
}

class MyArraySizeExeption extends ArrayIndexOutOfBoundsException {
    MyArraySizeExeption(String message) {
        super(message);
    }
}

class MyArrayDataException extends NumberFormatException {
    MyArrayDataException(int i, int j) {
        super("Incorrect data in the cell ["+ (j + 1) +"]["+ (i + 1) + "]");
    }
}