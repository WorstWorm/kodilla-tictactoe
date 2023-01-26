package com.tictactoe;

public class State {
    private String[][] map;
    private String activePlayer="x";
    private int turn=0;
    private boolean end=false;

    private int lengthOfLine;

    public State(int size) {
        resetState(size);
    }

    public String[][] getMap() {
        return map;
    }

    public void resetState(int size){
        map = new String[size][size];
        end = false;
        int fieldNr = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                map[i][j]=Integer.toString(fieldNr);
                fieldNr++;
            }
        }
    }

    public void makeMove(Field field){
        if(Logic.checkField(this.getMap(), field)){
            map[field.y()][field.x()]=activePlayer;
        }
    }

    public String getActivePlayer() {
        return activePlayer;
    }


    public void changeActivePlayer() {
        if(turn%2==0){
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
}
