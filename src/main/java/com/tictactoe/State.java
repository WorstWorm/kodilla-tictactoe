package com.tictactoe;

public class State extends Prototype<State> {
    private String[][] map;
    private int size;
    private int lengthOfLine;
    private String activePlayer = "x";
    private int turn = 0;
    private boolean end = false;
    private boolean computerPlayer = false;

    public State(int size) {
        resetState(size);
    }

    public State(int size, int lengthOfLine, boolean computerPlayer) {
        resetState(size);
        setLengthOfLine(lengthOfLine);
        this.computerPlayer = computerPlayer;
    }

    public String[][] getMap() {
        return map;
    }

    public void resetState(int size) {
        this.size = size;
        map = new String[size][size];
        end = false;
        turn = 0;
        int fieldNr = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.toString(fieldNr);
                fieldNr++;
            }
        }
    }

    public void makeMove(Field field) {
        if(BoardHandler.isFieldEmpty(this.getMap(), field)) {
            map[field.y()][field.x()] = activePlayer;
        }
    }

    public String getActivePlayer() {
        return activePlayer;
    }


    public void changeActivePlayer() {
        if(turn%2 == 0) {
            activePlayer = "x";
        }  else {
            activePlayer = "o";
        }
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        turn++;
        changeActivePlayer();
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public int getLengthOfLine() {
        return lengthOfLine;
    }

    public void setLengthOfLine(int lengthOfLine) {
        this.lengthOfLine = lengthOfLine;
    }

    public int getSize() {
        return size;
    }

    public boolean getComputerPlayer() {
        return computerPlayer;
    }

    public State deepCopy() throws CloneNotSupportedException {
        State clonedState = super.clone();
        clonedState.map = new String[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                clonedState.map[i][j] = map[i][j];
            }
        }
        clonedState.turn = turn;
        clonedState.changeActivePlayer();
        clonedState.end = end;
        return clonedState;
    }

}
