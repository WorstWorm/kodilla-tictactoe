package com.tictactoe;

import java.util.Scanner;

public class ConsoleInterface {
    private final static Scanner scanner = new Scanner(System.in);
    private static State state;

    static private void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static public void gamePvP () {
        System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
        Board.generateBoardInConsole(state.getMap());
        while (!state.isEnd()) {
            makeMoveConsoleProcedure();
        }
    }

    static public void gamePvC () {
        System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
        Board.generateBoardInConsole(state.getMap());
        while (!state.isEnd()) {
            makeMoveConsoleProcedure();
            if(!state.isEnd()){
                Field chosenField = Logic.randomMove(state.getMap());
                state.makeMove(chosenField);
                checkEndConsoleProcedure(chosenField);
            }
        }
    }

    static private void makeMoveConsoleProcedure() {
        Field chosenField;
        boolean getOut = false;
        do {
            System.out.println("Make move: ");
            int playerMove = scanner.nextInt();
            chosenField = Logic.checkFieldByNr(state.getMap(), playerMove);
            if (Logic.checkField(state.getMap(), chosenField)) {
                state.makeMove(chosenField);
                getOut = true;
            } else {
                System.out.println("This field is not available");
                Board.generateBoardInConsole(state.getMap());
            }
        } while (!getOut);
        checkEndConsoleProcedure(chosenField);
    }

    static private void checkEndConsoleProcedure(Field chosenField) {
        if (Logic.checkSequence(state.getMap(), state.getActivePlayer(), chosenField, state.getLengthOfLine())) {
            System.out.println(state.getActivePlayer() + " won");
            Board.generateBoardInConsole(state.getMap());
            state.setEnd(true);
            pressEnterToContinue();
        } else if (!Logic.emptyField(state.getMap())) {
            System.out.println("Draw");
            state.setEnd(true);
            pressEnterToContinue();
        } else {
            state.nextTurn();
            System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
            Board.generateBoardInConsole(state.getMap());
        }
    }


    static public void run() {
        System.out.println(
            "  _____ ___ ____   _____  _    ____   _____ ___  _____ \n" +
            " |_   _|_ _/ ___| |_   _|/ \\  / ___| |_   _/ _ \\| ____|\n" +
            "   | |  | | |       | | / _ \\| |       | || | | |  _|  \n" +
            "   | |  | | |___    | |/ ___ \\ |___    | || |_| | |___ \n" +
            "   |_| |___\\____|   |_/_/   \\_\\____|   |_| \\___/|_____|\n" +
            "                                   by Michal Kaczmarski\n");

        while (true) {
            System.out.println("MENU: \n" +
                    "select an option:\n" +
                    "0 - new game (p v p)\n" +
                    "1 - new game (p v c - easy)\n" +
                    "3 - quit");

            int gameMode;

            do {
                gameMode = scanner.nextInt();
            } while (gameMode < 0 || gameMode > 3);

            if (gameMode == 3) {
                System.exit(0);
            }

            System.out.println("choose size of the board (3-10):");
            int size;
            do {
                size = scanner.nextInt();
            } while (size < 3 || size > 10);
            state = new State(size);

            System.out.println("choose the length of the line which is needed to win");
            state.setLengthOfLine(scanner.nextInt());

            if (gameMode == 0) {
                gamePvP();
            } else if (gameMode == 1) {
                gamePvC();
            }
        }
    }
}
