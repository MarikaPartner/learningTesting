/**
 * Java 1. Homework 3
 *
 * @author Marina Dumcheva
 * @version 14.11.2021
 */
import java.util.Arrays;

class Homework_3 {
    public static void main(String[] args) {
        //Task 1
        reverseArray();

        //Task 2
        createFillIntArray();

        //Task 3
        multiplyByTwo();

        //Task 4
        fillDiagonal(2);
        fillDiagonal(7);
        
        //Task 5
        System.out.println(Arrays.toString(createFillArray(5, 25)));
        System.out.println(Arrays.toString(createFillArray(1, -6)));

        //Task 6*
        findMinMax(new int[]{1, 4, 99, -10});
        findMinMax(new int[]{0, 0, 0});
        findMinMax(new int[]{1});
        findMinMax(new int[]{-10000, -8888, -9, 0});
    }

//Task 1
    static void reverseArray() {
        int [] arra = {1, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(Arrays.toString(arra));
        for (int j = 0; j < arra.length; j++) {
            arra[j] = (arra[j] == 0? 1 : 0);
        }
        System.out.println(Arrays.toString(arra));
    }

//Task 2
    static void createFillIntArray() {
        int[] arrb = new int[100];
        for (int k =0 ; k < arrb.length; k++) {
            arrb[k] = k + 1;
        }
        System.out.println(Arrays.toString(arrb));
    }

//Task 3
    static void multiplyByTwo() {
        int [] arrc = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int p = 0; p < arrc.length; p++) {
            if (arrc[p] < 6) {
            arrc[p] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrc));
    }

//Task 4
    static void fillDiagonal(int d) {
        int [][] arrd = new int [d][d];
        for (int x = 0; x < arrd.length; x++) {
            for (int y = 0; y < arrd.length; y++) {
                if (x == y || (x + y) == (arrd.length - 1)) {
                    arrd [x][y] = 1;
                }
            }
        }
        for (int x=0; x < arrd.length; x++) {
            for (int y = 0; y < arrd.length; y++) {
                System.out.print(arrd[x][y] + "  ");
            }
            System.out.println();
        }
    }

//Task 5
    static int[] createFillArray(int len, int initialValue) {
        int[] arre = new int[len];
        Arrays.fill(arre, initialValue);
        return arre;
    }

//Task 6*
    static void findMinMax(int[] arrf) {

        System.out.println(Arrays.toString(arrf));
        int min = arrf[0];
        int max = arrf[0];
        for (int q = 0; q <a arrf.length; q++) {
                if (arrf[q] < min) {
                    min = arrf[q];
                }
                if (arrf[q] > max) {
                    max = arrf[q];
                }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}