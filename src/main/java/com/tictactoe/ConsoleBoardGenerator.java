package com.tictactoe;

public class ConsoleBoardGenerator {
    public static void generateBoardInConsole(String[][] situation) {
        String greatestNumber = situation[situation.length-1][situation.length-1];
        int leadingZeros = (greatestNumber).length();
        for(int i=0; i<situation.length; i++) {
            System.out.print("|");
            for(int j=0; j<situation[i].length; j++) {
                System.out.printf(String.format("%" + leadingZeros + "s", situation[i][j]) + "|");
            }
            System.out.print("\n");
        }
    }
}