package com.tictactoe;

import java.util.HashSet;
import java.util.Random;

public class State {
    private char[][] situation;
    char[] players = {'x', 'o'};
    char gameMode;
    int turn = 0;
    boolean endOfGame = false;
    private final HashSet<Integer> possibleMoves = new HashSet<>();


    public State(){
        situation = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        for(int i=1; i<10; i++){
            possibleMoves.add(i);
        }
    }


    public char[][] getSituation(){
        return situation;
    }

    public boolean makeMove(int field, char player){
        if(possibleMoves.contains(field)) {
            if (field == 1) {
                situation[0][0] = player;
            } else if (field == 2) {
                situation[0][1] = player;
            } else if (field == 3) {
                situation[0][2] = player;
            } else if (field == 4) {
                situation[1][0] = player;
            } else if (field == 5) {
                situation[1][1] = player;
            } else if (field == 6) {
                situation[1][2] = player;
            } else if (field == 7) {
                situation[2][0] = player;
            } else if (field == 8) {
                situation[2][1] = player;
            } else if (field == 9) {
                situation[2][2] = player;
            }
            possibleMoves.remove(field);
            return true;
        } else {
            return false;
        }
    }


    public char getPlayer(int turn) {
        return players[turn];
    }


    public char getGameMode() {
        return gameMode;
    }

    public void setGameMode(char gameMode) {
        this.gameMode = gameMode;
    }


    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn = turn+1;
    }


    public boolean isEndOfGame() {
        return endOfGame;
    }


    public void resetGame() {
        turn = 0;
        endOfGame = false;
        situation = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        for(int i=1; i<10; i++){
            possibleMoves.add(i);
        }
    }


    public char checkResult(char player){
        if(
                (situation[0][0]== situation[0][1] && situation[0][1]== situation[0][2] && situation[0][0]==player) ||
                (situation[1][0]== situation[1][1] && situation[1][1]== situation[1][2] && situation[1][0]==player) ||
                (situation[2][0]== situation[2][1] && situation[2][1]== situation[2][2] && situation[2][0]==player) ||

                (situation[0][0]== situation[1][0] && situation[1][0]== situation[2][0] && situation[0][0]==player) ||
                (situation[0][1]== situation[1][1] && situation[1][1]== situation[2][1] && situation[0][1]==player) ||
                (situation[0][2]== situation[1][2] && situation[1][2]== situation[2][2] && situation[0][2]==player) ||

                (situation[0][0]== situation[1][1] && situation[1][1]== situation[2][2] && situation[0][0]==player) ||
                (situation[0][2]== situation[1][1] && situation[1][1]== situation[2][0] && situation[0][2]==player)
        ){
            endOfGame = true;
            return player;
        } else {
            if(possibleMoves.isEmpty()){
                endOfGame = true;
                return 'd';
            }
        }
        return 'n';

    }


    public int randomMove(){
        Random random = new Random();
        int[] availableMoves = possibleMoves.stream().mapToInt(Number::intValue).toArray();
        return availableMoves[random.nextInt(1,availableMoves.length)];
    }
}
