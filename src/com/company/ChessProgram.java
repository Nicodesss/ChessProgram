package com.company;
import java.util.Scanner;
//Eduardo Dominico Llosa
//CC 11 A2
public class ChessProgram {
    public static void main(String[] args) {

        char[][] cBoard = new char[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                cBoard[i][j] = '+';
            }
        }
        System.out.println("This is a 3X3 game board, empty cells are represented by the symbol +");

        printBoard2(cBoard);
        System.out.println("/012/");
        System.out.println("INPUT 0, 1, 2 FOR ROWS \nINPUT 0, 1, 2 FOR COLUMNS");
        Scanner input = new Scanner(System.in);

        System.out.println("Start....");
        System.out.print("Enter your name, player 1: ");
        String playerOne = input.nextLine();
        System.out.print("Enter your name, player 2: ");
        String playerTwo = input.nextLine();

        boolean isPlayerOne = true;

        boolean gameFinished = false;
        while(!gameFinished) {

            printBoard(cBoard);

            if(isPlayerOne) {
                System.out.println("It's your turn " + playerOne);
            } else {
                System.out.println("It's your turn " + playerTwo);
            }

            char symbol = '+';
            if(isPlayerOne) {
                symbol = 'X';
            } else {
                symbol = 'O';
            }

            int r = 0;
            int c = 0;

            while(true) {

                System.out.print("Row number: ");
                r = input.nextInt();
                System.out.print( "Column number: ");
                c = input.nextInt();

                if(r < 0 || c < 0 || r > 2 || c > 2) {
                    System.out.println("Invalid Move!");

                } else if(cBoard[r][c] != '+') {
                    System.out.println("Invalid Move!");
                } else {
                    break;
                }

            }
            cBoard[r][c] = symbol;

            if(playerHasWon(cBoard) == 'X') {
                System.out.println("CONGRATULATIONS!!\nYOU WIN!! " + playerOne + "!");
                gameFinished = true;
            } else if(playerHasWon(cBoard) == 'O') {
                System.out.println("CONGRATULATIONS!!\nYOU WIN!! "+ playerTwo + "!");
                gameFinished = true;
            } else {

                if(boardIsFull(cBoard)) {
                    System.out.println("It's a tie!");
                    gameFinished = true;
                } else {
                    isPlayerOne = !isPlayerOne;
                }

            }

        }
        printBoard(cBoard);
    }

    public static void printBoard(char[][] board) {
        System.out.println("Game board:");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void printBoard2(char[][] board) {
        System.out.println("Game board:\n/012/ Columns");
        for(int i = 0; i < 3; i++) {
            System.out.print(i);
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println(i + " row");
        }
    }

    public static char playerHasWon(char[][] board) {

        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '+') {
                return board[i][0];
            }
        }
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '+') {
                return board[0][j];
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '+') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '+') {
            return board[2][0];
        }
        return ' ';
    }

    public static boolean boardIsFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '+') {
                    return false;
                }
            }
        }
        return true;
    }
}


