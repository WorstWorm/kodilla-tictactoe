package com.tictactoe;

public class State {
    private String[][] map;
    private int size;
    private int lengthOfLine;
    private String activePlayer="x";
    private int turn=0;
    private boolean end=false;

    public State(int size) {
        resetState(size);
    }

    public State(int size, int lengthOfLine){
        resetState(size);
        setLengthOfLine(lengthOfLine);
    }

    public String[][] getMap() {
        return map;
    }

    public void resetState(int size){
        this.size = size;
        map = new String[size][size];
        end = false;
        turn = 0; //dodane w ciemno
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

    public int getSize() {
        return size;
    }
}
