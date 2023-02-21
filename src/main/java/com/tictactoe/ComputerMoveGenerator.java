package com.tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMoveGenerator {

    public static Field randomMove(String[][] situation) {
        Random random = new Random();
        ArrayList<Field> fields = BoardHandler.buildFieldArray(situation);
        int select = random.nextInt(0, fields.size());
        return fields.get(select);
    }
}
