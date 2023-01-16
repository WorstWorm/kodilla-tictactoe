package com.tictactoe;

import java.util.Scanner;

public class GameBox {

    char[] player = {'x', 'o'};
    char c = 'a';
    int turn = 0;
    boolean endOfGame = false;
    State actualState = new State();
    Board gameBoard = new Board();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println(
                "  _____ ___ ____   _____  _    ____   _____ ___  _____ \n" +
                " |_   _|_ _/ ___| |_   _|/ \\  / ___| |_   _/ _ \\| ____|\n" +
                "   | |  | | |       | | / _ \\| |       | || | | |  _|  \n" +
                "   | |  | | |___    | |/ ___ \\ |___    | || |_| | |___ \n" +
                "   |_| |___\\____|   |_/_/   \\_\\____|   |_| \\___/|_____|");
        System.out.println("                                   by Michal Kaczmarski\n");

        System.out.println("select an option:\n" +
                "n - new game\n" +
                "x - quit");
        while(c!='x' || c!='n'){
            c = scanner.next().charAt(0);
            if(c=='x'){
                System.exit(0);
            } else if (c=='n') {
                endOfGame = false;
                turn = 0;
                actualState = new State();
                while (!endOfGame) {
                    System.out.println("MOVE NUMBER " + (turn + 1));
                    gameBoard.generateBoard(actualState.getState());
                    System.out.println("The move belongs to player " + player[turn % 2] + ".\nChoose a square that is not already occupied.");
                    int move = Character.getNumericValue(scanner.next().charAt(0));
                    if (actualState.setState(move, player[turn % 2])) {
                        System.out.println("\nPlayer " + player[turn % 2] + " made a move on " + move);
                        c = actualState.checkResult(player[turn % 2]);
                        if (c == 'x') {
                            System.out.println("PLAYER X WON");
                            gameBoard.generateBoard(actualState.getState());
                            endOfGame = true;
                        } else if (c == 'o') {
                            System.out.println("PLAYER O WON");
                            gameBoard.generateBoard(actualState.getState());
                            endOfGame = true;
                        } else {
                            turn++;
                        }
                    } else {
                        System.out.println("Wrong move. The move belongs to player " + player[turn % 2] + ". Choose a square that is not already occupied.\n");
                    }
                }
                c='a';
                System.out.println("\nselect an option:\n" +
                        "n - new game\n" +
                        "x - quit");
            } else {
                System.out.println("there is no such option - choose the correct option");
            }
        }
    }
}
