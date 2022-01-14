/**
 * Java 1. Homework 4
 *
 * @author Marina Dumcheva
 * @version 18.11.2021
 */

import java.util.Random;
import java.util.Scanner;

class Homework_4 {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY =  '.';
    char[][] table;
    Scanner sc;
    Random random;

    public static void main(String[] args) {
        new Homework_4().game();
    }

    Homework_4() {
        table = new char[3][3];
        sc = new Scanner(System.in);
        random = new Random();
    }

    void game(){
        initTable();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("You won!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, draw");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("AI won!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, draw");
                break;
            }
        }
        System.out.println("Game over");
        printTable();
    }

// Сreating the initial table
    void initTable() {
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = SIGN_EMPTY;
            }
        }
    }

// Printing the table
    void printTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

// Human's move
    void turnHuman() {
        int x, y;
        do {
            System.out.print("Your turn x y [1..3]: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_X;
    }

// Computer's move
    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table [x][y] = SIGN_O;
    }

// Сheking winning
    boolean checkWin(char ch) {
    for (int x = 0; x < 3; x++) {
        if ((table[0][x] == ch && table[1][x] == ch && table[2][x] == ch) ||    // Check vertiсals
            (table[x][0] == ch && table[x][1] == ch && table[x][2] == ch)) {    // Check horizontals
            return true;
        }
    }

    if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
    if (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;
        return false;
    }

// Cheking validation
    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[x][y] == SIGN_EMPTY;
    }

// Cheking filling
    boolean isTableFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}