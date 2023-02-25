package com.tictactoe;

import java.util.HashSet;

public class Logic {

    private static boolean columnCheck(State state) {
        int length = state.getLengthOfLine();
        String player = state.getActivePlayer();
        String[][] situation = state.getMap();

        for (int positionY = 0; positionY < state.getSize(); positionY++) {
            for (int positionX = 0; positionX < state.getSize(); positionX++) {
                HashSet<Field> line = new HashSet<>();
                for (int i = 0; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY + i, positionX))) {
                        if (situation[positionY + i][positionX].equals(player)) {
                            line.add(new Field(positionY + i, positionX));
                        } else {
                            break;
                        }
                    }
                }

                for (int i = 1; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY - i, positionX))) {
                        if (situation[positionY - i][positionX].equals(player)) {
                            line.add(new Field(positionY - i, positionX));
                        } else {
                            break;
                        }
                    }
                }

                if (line.toArray().length >= length) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean rowCheck(State state) {
        int length = state.getLengthOfLine();
        String player = state.getActivePlayer();
        String[][] situation = state.getMap();

        for (int positionY = 0; positionY < state.getSize(); positionY++) {
            for (int positionX = 0; positionX < state.getSize(); positionX++) {
                HashSet<Field> line = new HashSet<>();

                for (int i = 0; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY, positionX + i))) {
                        if (situation[positionY][positionX + i].equals(player)) {
                            line.add(new Field(positionY, positionX + i));
                        } else {
                            break;
                        }
                    }
                }

                for (int i = 1; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY, positionX - i))) {
                        if (situation[positionY][positionX - i].equals(player)) {
                            line.add(new Field(positionY, positionX - i));
                        } else {
                            break;
                        }
                    }
                }

                if (line.toArray().length >= length) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean diagonalLRCheck(State state) {
        int length = state.getLengthOfLine();
        String player = state.getActivePlayer();
        String[][] situation = state.getMap();

        for (int positionY = 0; positionY < state.getSize(); positionY++) {
            for (int positionX = 0; positionX < state.getSize(); positionX++) {
                HashSet<Field> line = new HashSet<>();
                for (int i = 0; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY + i, positionX + i))) {
                        if (situation[positionY + i][positionX + i].equals(player)) {
                            line.add(new Field(positionY + i, positionX + i));
                        } else {
                            break;
                        }
                    }
                }

                for (int i = 1; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY - i, positionX - i))) {
                        if (situation[positionY - i][positionX - i].equals(player)) {
                            line.add(new Field(positionY - i, positionX - i));
                        } else {
                            break;
                        }
                    }
                }

                if (line.toArray().length >= length) {
                    return true;
                }
            }
        } return false;
    }

    private static boolean diagonalRLCheck(State state) {
        int length = state.getLengthOfLine();
        String player = state.getActivePlayer();
        String[][] situation = state.getMap();

        for (int positionY = 0; positionY < state.getSize(); positionY++) {
            for (int positionX = 0; positionX < state.getSize(); positionX++) {

                HashSet<Field> line = new HashSet<>();
                for (int i = 0; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY + i, positionX - i))) {
                        if (situation[positionY + i][positionX - i].equals(player)) {
                            line.add(new Field(positionY + i, positionX - i));
                        } else {
                            break;
                        }
                    }
                }

                for (int i = 1; i < length; i++) {
                    if (BoardHandler.isItOnBoardRange(situation, new Field(positionY - i, positionX + i))) {
                        if (situation[positionY - i][positionX + i].equals(player)) {
                            line.add(new Field(positionY - i, positionX + i));
                        } else {
                            break;
                        }
                    }
                }

                if (line.toArray().length >= length) {
                    return true;
                }

            }
        } return false;
    }


    public static boolean checkSequence(State state) {

        if (columnCheck(state)) {
            return true;
        }

        if (rowCheck(state)) {
            return true;
        }

        if (diagonalLRCheck(state)) {
            return true;
        }

        if (diagonalRLCheck(state)) {
            return true;
        }

        return false;
    }
}
