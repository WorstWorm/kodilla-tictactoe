package com.tictactoe;

public class State {
    char[][] state;
    char[][] duringMove;

    public char[][] getState(){
        char[][] result = {
                {'x','o','x'},
                {'o','x','o'},
                {'o','o','x'}
        };
        return result;
    }
}
