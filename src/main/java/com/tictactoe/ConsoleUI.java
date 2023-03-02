package com.tictactoe;

import com.tictactoe.ai.ComputerMoveGenerator;
import com.tictactoe.ai.MoveGenerator;

import java.util.Scanner;

public class ConsoleUI {
    private final static Scanner scanner = new Scanner(System.in);
    private static State state;

    private static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void gamePvP () {
        System.out.println("Turn " + (state.getTurn() + 1) + " - move: " + state.getActivePlayer());
        ConsoleBoardGenerator.generateBoardInConsole(state.getMap());
        while (!state.isEnd()) {
            makeMoveConsoleProcedure();
        }
    }

    private static void gamePvC () {
        MoveGenerator moveGenerator = new ComputerMoveGenerator();
        System.out.println("Turn " + (state.getTurn() + 1) + " - move: " + state.getActivePlayer());
        ConsoleBoardGenerator.generateBoardInConsole(state.getMap());
        while (!state.isEnd()) {
            makeMoveConsoleProcedure();
            if(!state.isEnd()){
                Field chosenField = moveGenerator.generateNextMove(state);
                state.makeMove(chosenField);
                checkEndConsoleProcedure();
            }
        }
    }

    private static void makeMoveConsoleProcedure() {
        Field chosenField;
        boolean getOut = false;
        do {
            System.out.println("Make move: ");
            int playerMove = scanner.nextInt();
            chosenField = BoardHandler.getFieldByNr(state.getMap(), playerMove);
            if (BoardHandler.isFieldEmpty(state.getMap(), chosenField)) {
                state.makeMove(chosenField);
                getOut = true;
            } else {
                System.out.println("This field is not available");
                ConsoleBoardGenerator.generateBoardInConsole(state.getMap());
            }
        } while (!getOut);
        checkEndConsoleProcedure();
    }

    private static void checkEndConsoleProcedure() {
        if (WinChecker.checkSequence(state)) {
            System.out.println(state.getActivePlayer() + " won");
            ConsoleBoardGenerator.generateBoardInConsole(state.getMap());
            state.setEnd(true);
            pressEnterToContinue();
        } else if (!BoardHandler.doesEmptyFieldExists(state.getMap())) {
            System.out.println("Draw");
            state.setEnd(true);
            pressEnterToContinue();
        } else {
            state.nextTurn();
            System.out.println("Turn " + (state.getTurn() + 1) + " - move: " + state.getActivePlayer());
            ConsoleBoardGenerator.generateBoardInConsole(state.getMap());
        }
    }


    public static void run() {
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
