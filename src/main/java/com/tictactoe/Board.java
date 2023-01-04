package com.tictactoe;

public class Board {

    public void generateBoard(char[][] board, int[] controller) {
        System.out.println("-------");
        for(int i=0; i<board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                if(i == controller[0] && j == controller[1]) {
                    System.out.print("*");
                } else {
                    System.out.print(board[i][j]);
                }
                System.out.print("|");
            }
            System.out.println("\n-------");
        }
    }
}
