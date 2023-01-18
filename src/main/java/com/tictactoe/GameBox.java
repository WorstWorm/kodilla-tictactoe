package com.tictactoe;

import java.util.Scanner;

public class GameBox {

    State state = new State();
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
                "c - new game (player vs computer)\n" +
                "p - new game (player vs player\n" +
                "x - quit");
        while(state.getGameMode()!='x' || state.getGameMode()!='c'|| state.getGameMode()!='p'){
            state.setGameMode(scanner.next().charAt(0));
            if(state.getGameMode() =='x'){
                System.exit(0);
            } else if (state.getGameMode() =='c' || state.getGameMode() =='p') {
                state.resetGame();
                while (!state.isEndOfGame()) {
                    System.out.println("MOVE NUMBER " + (state.getTurn() + 1));
                    gameBoard.generateBoard(state.getSituation());
                    System.out.println("The move belongs to player " + state.getPlayer(state.getTurn()%2) + ".\nChoose a square that is not already occupied.");
                    int move;
                    if(state.getGameMode()=='c') {
                        if (state.getPlayer(state.getTurn() % 2) == 'x') {
                            move = state.randomMove();
                        } else {
                            move = Character.getNumericValue(scanner.next().charAt(0));
                        }
                    } else {
                        move = Character.getNumericValue(scanner.next().charAt(0));
                    }
                    if (state.makeMove(move, state.getPlayer(state.getTurn()%2))) {
                        System.out.println("\nPlayer " + state.getPlayer(state.getTurn()%2) + " made a move on " + move);
                        char output = state.checkResult(state.getPlayer(state.getTurn()%2));
                        if (output == 'x') {
                            System.out.println("PLAYER X WON");
                            gameBoard.generateBoard(state.getSituation());
                        } else if (output == 'o') {
                            System.out.println("PLAYER O WON");
                            gameBoard.generateBoard(state.getSituation());
                        } else if(output == 'd') {
                            System.out.println("DRAW");
                            gameBoard.generateBoard(state.getSituation());
                        } else {
                            state.addTurn();
                        }
                    } else {
                        System.out.println("Wrong move. The move belongs to player " + state.getPlayer(state.getTurn()%2) + ". Choose a square that is not already occupied.\n");
                    }
                }
                state.setGameMode('a');
                System.out.println("\nselect an option:\n" +
                        "c - new game (player vs computer)\n" +
                        "p - new game (player vs player\n" +
                        "x - quit");
            } else {
                System.out.println("there is no such option - choose the correct option");
            }
        }
    }
}
