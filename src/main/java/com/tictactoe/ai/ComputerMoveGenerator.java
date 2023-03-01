package com.tictactoe.ai;

import com.tictactoe.BoardHandler;
import com.tictactoe.Field;
import com.tictactoe.State;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMoveGenerator implements MoveGenerator {

    public Field generateNextMove(State state) {
        int turn = state.getTurn();
        if(turn>2) {
            String[][] getMap = state.getMap();
            int getLengthOfLine = state.getLengthOfLine();
            BestOption best = checkByBlocks(getMap, getLengthOfLine);
            if(best.sloatsLacking()>getLengthOfLine){
                return randomMove(state);
            }
            String[][] situation = getMap;
            String direction = best.direction();
            Field startField = best.fieldOfStart();
            switch (direction) {
                case "column":
//                    for (int i = 0; i < getLengthOfLine; i++) {
                    for (int i = getLengthOfLine-1; i >= 0; i--) {
                        Field field = new Field(startField.y() + i, startField.x());
                        if (BoardHandler.isFieldEmpty(getMap, field) && BoardHandler.isItOnBoardRange(getMap, field)) {
                            return new Field(field.y(), field.x());
                        }
                    }
                    break;
                case "row":
//                    for (int i = 0; i < getLengthOfLine; i++) {
                    for (int i = getLengthOfLine-1; i >= 0; i--) {
                        Field field = new Field(startField.y(), startField.x() + i);
                        if (BoardHandler.isFieldEmpty(getMap, field) && BoardHandler.isItOnBoardRange(getMap, field)) {
                            return new Field(field.y(), field.x());
                        }
                    }
                    break;
                case "diagonalRL":
//                    for (int i = 0; i < getLengthOfLine; i++) {
                   for (int i = getLengthOfLine-1; i >= 0; i--) {
                        Field field = new Field(startField.y() + i, startField.x() - i);
                        if (BoardHandler.isFieldEmpty(getMap, field) && BoardHandler.isItOnBoardRange(getMap, field)) {
                            return new Field(field.y(), field.x());
                        }
                    }
                    break;
                case "diagonalLR":
//                    for (int i = 0; i < getLengthOfLine; i++) {
                    for (int i = getLengthOfLine-1; i >= 0; i--) {
                        Field field = new Field(startField.y() + i, startField.x() + i);
                        if (BoardHandler.isFieldEmpty(getMap, field) && BoardHandler.isItOnBoardRange(getMap, field)) {
                            return new Field(field.y(), field.x());
                        }
                    }
                    break;
                default:
                    //do nothing;
            }
        }
        return randomMove(state);
    }

    private static BestOption checkByBlocks(String[][] globalSituation, int lengthOfTheLine) {
        BestOption best = new BestOption(100, "column", new Field(-1,-1));
        int lengthOfTheBoard = globalSituation.length;
        int limit = lengthOfTheBoard-lengthOfTheLine;

        for(int y=0; y<=limit; y++) {
            for(int x=0; x<=limit; x++) {
                String[][] localSituation = new String[lengthOfTheLine][lengthOfTheLine];
                for(int i=0; i<lengthOfTheLine; i++) {
                    for (int j=0; j<lengthOfTheLine; j++) {
                        localSituation[i][j] = globalSituation[y+i][x+j];
                    }
                }
                BestOption temp = checkBestInABloc(localSituation, new Field(y,x));
                if(temp.sloatsLacking()< best.sloatsLacking()) {
                    best = temp;
                }
            }
        }
        return best;
    }


    private static BestOption checkBestInABloc(String[][] localSituation, Field initialPosition) {
        BestOption rows = checkRowsInABlock(localSituation, initialPosition);
        BestOption columns = checkColumnsInABlock(localSituation, initialPosition);
        BestOption diagonalLR = checkDiagonalLRInABlock(localSituation, initialPosition);
        BestOption diagonalRL = checkDiagonalRLInABlock(localSituation, initialPosition);

        BestOption best = rows;

        if(columns.sloatsLacking() <best.sloatsLacking()) {
            best = columns;
        }

        if(diagonalRL.sloatsLacking() < best.sloatsLacking()) {
            best = diagonalRL;
        }

        if(diagonalLR.sloatsLacking() < best.sloatsLacking()) {
            best = diagonalLR;
        }

        return best;
    }

    private static BestOption checkRowsInABlock(String[][] localSituation, Field initialPosition) {
        int line = -1;
        int lineLength = localSituation.length;
        int lacking = lineLength;
        for (int y=0; y<lineLength; y++) {
            int tempLack = lineLength;
            for (int x=0; x<localSituation[y].length; x++) {
                if(localSituation[y][x].equals("x")){
                    tempLack = 100;
                } else if (localSituation[y][x].equals("o")) {
                    tempLack--;
                }
            }
            if(tempLack<lacking) {
                line = y;
                lacking = tempLack;
            }
        }
        return new BestOption(lacking, "row", new Field(initialPosition.y()+line,initialPosition.x()));
    }

    private static BestOption checkColumnsInABlock(String[][] localSituation, Field initialPosition) {
        int line = -1;
        int lineLength = localSituation.length;
        int lacking = lineLength;
        for (int x=0; x<lineLength; x++) {
            int tempLack = lineLength;
            for (int y=0; y<localSituation[x].length; y++) {
                if(localSituation[y][x].equals("x")) {
                    tempLack = 100;
                }
                else if(localSituation[y][x].equals("o")) {
                    tempLack--;
                }
            }
            if(tempLack<lacking) {
                line = x;
                lacking = tempLack;
            }
        }
        return new BestOption(lacking, "column", new Field(initialPosition.y(), initialPosition.x()+line));
    }

    private static BestOption checkDiagonalLRInABlock(String[][] localSituation, Field initialPosition) {
        int lacking = localSituation.length;
        for(int i=0; i< localSituation.length; i++) {
            if(localSituation[i][i].equals("x")) {
                return new BestOption(lacking+1, "diagonalLR", new Field(-1,-1));
            } else if(localSituation[i][i].equals("o")) {
                lacking--;
            }
        }
        return new BestOption(lacking, "diagonalLR", initialPosition);
    }

    private static BestOption checkDiagonalRLInABlock(String[][] localSituation, Field initialPosition) {
        int lacking = localSituation.length;
        for(int i=0; i< localSituation.length; i++) {
            if(localSituation[i][localSituation.length-i-1].equals("x")) {
                return new BestOption(lacking+1, "diagonalRL", new Field(-1,-1));
            } else if(localSituation[i][localSituation.length-i-1].equals("o")) {
                lacking--;
            }
        }
        return new BestOption(lacking, "diagonalRL",
                new Field(initialPosition.y(), initialPosition.x()+localSituation.length-1));
    }

    public static Field randomMove(State state) {
        String[][] situation = state.getMap();
        Random random = new Random();
        ArrayList<Field> fields = BoardHandler.buildEmptyFieldsArray(situation);
        int select = random.nextInt(0, fields.size());
        return fields.get(select);
    }
}