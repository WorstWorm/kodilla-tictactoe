package com.tictactoe;

import java.util.ArrayList;

public class BoardHandler {

    public static boolean isFieldEmpty(String[][] situation, Field field) {
        if(isItOnBoardRange(situation, field)) {
            return !situation[field.y()][field.x()].equals("x") && (!situation[field.y()][field.x()].equals("o"));
        } else {
            return false;
        }
    }

    public static boolean isItOnBoardRange(String[][] situation, Field field) {
        try{
            String temp = situation[field.y()][field.x()];
            return true;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static Field getFieldByNr(String[][] situation, int fieldIndex) {
        for(int y=0; y< situation.length; y++) {
            for(int x=0; x<situation[y].length; x++) {
                if(situation[y][x].equals(Integer.toString(fieldIndex)) || situation[y][x].equals("0"+ fieldIndex)) {
                    return new Field(y,x);
                }
            }
        }
        return null;
    }

    public static ArrayList<Field> buildEmptyFieldsArray(String[][] situation) {
        ArrayList<Field> fields = new ArrayList<>();
        for(int y=0; y<situation.length; y++){
            for(int x=0; x<situation[y].length; x++){
//                if(!situation[y][x].equals("x") && !situation[y][x].equals("o")){
                if(isFieldEmpty(situation, new Field(y,x))){
                    fields.add(new Field(y,x));
                }
            }
        }
        return fields;
    }

    public static boolean doesEmptyFieldExists(String[][] situation) {
        ArrayList<Field> fields = buildEmptyFieldsArray(situation);
        return !fields.isEmpty();
    }

        public static String getNrByField(State state, Field field) {
        int fieldNr = 0;
        for(int i=0; i<state.getSize(); i++) {
            for(int j=0; j< state.getSize(); j++) {
                if(i==field.y() && j==field.x()){
                    return Integer.toString(fieldNr);
                }
                fieldNr++;
            }
        }
        return null;
    }


}
