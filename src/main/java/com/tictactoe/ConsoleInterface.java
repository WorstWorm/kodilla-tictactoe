package com.tictactoe;

import java.util.Scanner;

public class ConsoleInterface {
    static Scanner scanner = new Scanner(System.in);
    static State state;

    static private void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception e)
        {}
    }

    static public void gamePvP () {
        System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
        Board.generateBoard(state.getMap());
        while (!state.isEnd()) {
            Field choosenField;
            boolean getOut = false;
            do {
                System.out.println("Make move: ");
                int playerMove = scanner.nextInt();
                choosenField = Logic.checkFieldByNr(state.getMap(), playerMove);
                if (Logic.checkField(state.getMap(), choosenField)) {
                    state.makeMove(choosenField);
                    getOut = true;
                } else {
                    System.out.println("To pole nie jest dostępne");
                    Board.generateBoard(state.getMap());
                }
            } while (!getOut);
            if (Logic.checkSequence(state.getMap(), state.getActivePlayer(), choosenField, state.getLengthOfLine())) {
                System.out.println("Gra wygrana przez " + state.getActivePlayer());
                Board.generateBoard(state.getMap());
                state.setEnd(true);
                pressEnterToContinue();
            } else if (!Logic.emptyField(state.getMap())) {
                System.out.println("Remis");
                state.setEnd(true);
                pressEnterToContinue();
            } else {
                state.nextTurn();
                System.out.println("Turn " + state.getTurn() + " - move: " + state.getActivePlayer());
                Board.generateBoard(state.getMap());
            }
        }
    }

    static public void gamePvC () {
        System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
        Board.generateBoard(state.getMap());
        while (!state.isEnd()) {
            Field choosenField;
            boolean getOut = false;
            do {
                System.out.println("Make move: ");
                int playerMove = scanner.nextInt();
                choosenField = Logic.checkFieldByNr(state.getMap(), playerMove);
                if (Logic.checkField(state.getMap(), choosenField)) {
                    state.makeMove(choosenField);
                    getOut = true;
                } else {
                    System.out.println("To pole nie jest dostępne");
                    Board.generateBoard(state.getMap());
                }
            } while (!getOut);
            if (Logic.checkSequence(state.getMap(), state.getActivePlayer(), choosenField, state.getLengthOfLine())) {
                System.out.println("Gra wygrana przez " + state.getActivePlayer());
                state.setEnd(true);
                pressEnterToContinue();
            } else if (!Logic.emptyField(state.getMap())) {
                System.out.println("Remis");
                state.setEnd(true);
                pressEnterToContinue();
            } else {
                state.nextTurn();
                System.out.println("Turn " + state.getTurn() + 1 + " - move: " + state.getActivePlayer());
                Board.generateBoard(state.getMap());
            }


            choosenField = Logic.randomMove(state.getMap());
            state.makeMove(choosenField);
            if (Logic.checkSequence(state.getMap(), state.getActivePlayer(), choosenField, state.getLengthOfLine())) {
                System.out.println("Gra wygrana przez " + state.getActivePlayer());
                Board.generateBoard(state.getMap());
                state.setEnd(true);
                pressEnterToContinue();
            } else if (!Logic.emptyField(state.getMap())) {
                System.out.println("Remis");
                state.setEnd(true);
                pressEnterToContinue();
            } else {
                state.nextTurn();
                System.out.println("Turn " + state.getTurn() + " - move: " + state.getActivePlayer());
                Board.generateBoard(state.getMap());
            }
        }
    }

    static public void gamePvCx () {
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
                    "2 - new game (p v c - hard)\n" +
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
            } else {
                gamePvCx();
            }
        }
    }
}
