/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson04;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class MoveGame {

    static int X = 2, Y = 2, XENEMY = 0, YENEMY = 0;
    static char[][] MAP = new char[5][5];
    static Scanner sc = new Scanner(System.in);
    static int endX, endY;

    public static void main(String[] args) {
        do {
            endX = (int) (Math.random() * 4);
            endY = (int) (Math.random() * 4);
        } while (endX == 2 && endY == 2);
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP.length; j++) {
                if (i == X && j == Y) {
                    MAP[i][j] = 'X';
                } else if (i == endX && j == endY) {
                    MAP[i][j] = 'O';
                } else if (i == XENEMY && j == YENEMY) {
                    MAP[i][j] = 'E';
                } else {
                    MAP[i][j] = '-';
                }
            }
        }
        while (true) {
            showMap();
            switch(check()){
                case 1:
                    System.out.println("Thang roi");
                    return;
                case -1:
                    System.out.println("Thua roi");
                    return;
                case 0:
                    
            }
            char inputValue = input();
            changePos(inputValue);
            moveEnemy();
        }
    }

    static void showMap() {
        if (XENEMY == endX && YENEMY == endY) {
            MAP[XENEMY][YENEMY] = 'E';
        } else if (X == endX && Y == endY) {
            MAP[X][Y] = 'X';
        } else {
            MAP[endX][endY] = 'O';
        }
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP.length; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int check() {
        if (X == endX && Y == endY) {
            return 1;
        } else if (X == XENEMY && Y == YENEMY) {
            return -1;
        }
        return 0;
    }

    static char input() {
        System.out.println("Nhap WASD");
        char inputValue;
        String inputString = sc.nextLine();
        inputValue = inputString.charAt(0);

        return inputValue;
    }

    static void changePos(char input) { // AWSD
        switch (input) {
            case 'A':
                MAP[X][Y] = '-';
                Y = (Y - 1 + MAP.length) % MAP.length;
                MAP[X][Y] = 'X';
                break;
            case 'S':
                MAP[X][Y] = '-';
                X = (X + 1) % MAP.length;
                MAP[X][Y] = 'X';
                break;
            case 'D':
                MAP[X][Y] = '-';
                Y = (Y + 1) % MAP.length;
                MAP[X][Y] = 'X';
                break;
            case 'W':
                MAP[X][Y] = '-';
                X = (X - 1 + MAP.length) % MAP.length;
                MAP[X][Y] = 'X';
                break;

        }
    }

    private static void moveEnemy() {
        MAP[XENEMY][YENEMY] = '-';
        if (XENEMY < X) {
            XENEMY = (XENEMY + 1) % MAP.length;
            MAP[XENEMY][YENEMY] = 'E';
        } else if (XENEMY > X) {
            XENEMY = (XENEMY - 1 + MAP.length) % MAP.length;
            MAP[XENEMY][YENEMY] = 'E';
        } else if (YENEMY > Y) {
            YENEMY = (YENEMY - 1 + MAP.length) % MAP.length;
            MAP[XENEMY][YENEMY] = 'E';
        } else if (YENEMY < Y) {
            YENEMY = (YENEMY + 1) % MAP.length;
            MAP[XENEMY][YENEMY] = 'E';
        }
    }
}
