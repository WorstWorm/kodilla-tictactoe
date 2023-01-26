package com.tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Logic {

    static public boolean checkField(String[][] situation, Field field){
        if(checkBoarder(situation, field)){
            return !situation[field.y()][field.x()].equals("x") && (!situation[field.y()][field.x()].equals("o"));
        } else {
            return false;
        }
    }

    static public Field checkFieldByNr(String[][] situation, int input){
        for(int i=0; i< situation.length; i++){
            for(int j=0; j<situation[i].length; j++){
                if(situation[i][j].equals(Integer.toString(input)) || situation[i][j].equals("0"+ input)){
                    return new Field(i,j);
                }
            }
        }
        return new Field(-1,-1);
    }

    static public boolean checkSequence(String[][] situation, String player, Field field, int length){

        int positionX = field.x();
        int positionY = field.y();

        //column check
        HashSet<Field> line = new HashSet<>();
        for(int i=0; i<length; i++){
            if(checkBoarder(situation, new Field(positionY+i, positionX))){
                if (situation[positionY + i][positionX].equals(player)) {
                    line.add(new Field(positionY + i, positionX));
                } else {
                    break;
                }
            }
        }

        for(int i=1; i<length; i++){
            if(checkBoarder(situation, new Field(positionY-i, positionX))){
                if (situation[positionY - i][positionX].equals(player)) {
                    line.add(new Field(positionY - i, positionX));
                } else {
                    break;
                }
            }
        }

        if(line.toArray().length>=length){
            return true;
        }

        //row check
        line = new HashSet<>();
        for(int i=0; i<length; i++){
            if(checkBoarder(situation, new Field(positionY, positionX+i))){
                if (situation[positionY][positionX+i].equals(player)) {
                    line.add(new Field(positionY, positionX+i));
                } else {
                    break;
                }
            }
        }

        for(int i=1; i<length; i++){
            if(checkBoarder(situation, new Field(positionY, positionX-i))){
                if (situation[positionY][positionX-i].equals(player)) {
                    line.add(new Field(positionY, positionX-i));
                } else {
                    break;
                }
            }
        }

        if(line.toArray().length>=length){
            return true;
        }

        //diagonal left-right check
        line = new HashSet<>();
        for(int i=0; i<length; i++){
            if(checkBoarder(situation, new Field(positionY+i, positionX+i))){
                if (situation[positionY+i][positionX+i].equals(player)) {
                    line.add(new Field(positionY+i, positionX+i));
                } else {
                    break;
                }
            }
        }

        for(int i=1; i<length; i++){
            if(checkBoarder(situation, new Field(positionY-i, positionX-i))){
                if (situation[positionY-i][positionX-i].equals(player)) {
                    line.add(new Field(positionY-i, positionX-i));
                } else {
                    break;
                }
            }
        }

        if(line.toArray().length>=length){
            return true;
        }


        //diagonal right-left check
        line = new HashSet<>();
        for(int i=0; i<length; i++){
            if(checkBoarder(situation, new Field(positionY+i, positionX-i))){
                if (situation[positionY+i][positionX-i].equals(player)) {
                    line.add(new Field(positionY+i, positionX-i));
                } else {
                    break;
                }
            }
        }

        for(int i=1; i<length; i++){
            if(checkBoarder(situation, new Field(positionY-i, positionX+i))){
                if (situation[positionY-i][positionX+i].equals(player)) {
                    line.add(new Field(positionY-i, positionX+i));
                } else {
                    break;
                }
            }
        }

        if(line.toArray().length>=length){
            return true;
        }
        return false;
    }

    static public boolean checkBoarder(String[][] situation, Field field){
        try{
            String temp = situation[field.y()][field.x()];
            return true;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    static public boolean emptyField(String[][] situation){
        ArrayList<Field> fields = new ArrayList<>();
        for(int i=0; i<situation.length; i++) {
            for (int j = 0; j < situation[i].length; j++) {
                if (!situation[i][j].equals("x") && !situation[i][j].equals("o")) {
                    fields.add(new Field(i, j));
                }
            }
        }
        if (fields.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    static public Field randomMove(String[][] situation){
        Random random = new Random();
        ArrayList<Field> fields = new ArrayList<>();
        for(int i=0; i<situation.length; i++){
            for(int j=0; j<situation[i].length; j++){
                if(!situation[i][j].equals("x") && !situation[i][j].equals("o")){
                    fields.add(new Field(i,j));
                }
            }
        }
        int select=random.nextInt(0, fields.size());
        return fields.get(select);
    }
}
