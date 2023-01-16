package com.tictactoe;

import java.util.HashSet;

public class State {
    private char[][] state;
    private HashSet<Integer> moves = new HashSet<>();

    public State(){
        state = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        for(int i=1; i<10; i++){
            moves.add(i);
        }
    }

    public char[][] getState(){
        return state;
    }

    public boolean setState(int i, char c){
        if(moves.contains(i)) {
            if (i == 1) {
                state[0][0] = c;
            } else if (i == 2) {
                state[0][1] = c;
            } else if (i == 3) {
                state[0][2] = c;
            } else if (i == 4) {
                state[1][0] = c;
            } else if (i == 5) {
                state[1][1] = c;
            } else if (i == 6) {
                state[1][2] = c;
            } else if (i == 7) {
                state[2][0] = c;
            } else if (i == 8) {
                state[2][1] = c;
            } else if (i == 9) {
                state[2][2] = c;
            }
            moves.remove(i);
            return true;
        } else {
            return false;
        }
    }

    public char checkResult(char player){
        if(
                (state[0][0]==state[0][1] && state[0][1]==state[0][2] && state[0][0]==player) ||
                (state[1][0]==state[1][1] && state[1][1]==state[1][2] && state[1][0]==player) ||
                (state[2][0]==state[2][1] && state[2][1]==state[2][2] && state[2][0]==player) ||

                (state[0][0]==state[1][0] && state[1][0]==state[2][0] && state[0][0]==player) ||
                (state[0][1]==state[1][1] && state[1][1]==state[2][1] && state[0][1]==player) ||
                (state[0][2]==state[1][2] && state[1][2]==state[2][2] && state[0][2]==player) ||

                (state[0][0]==state[1][1] && state[1][1]==state[2][2] && state[0][0]==player) ||
                (state[0][2]==state[1][1] && state[1][1]==state[2][0] && state[0][2]==player)
        ){
            return player;
        }
        return 'n';
    }
}
