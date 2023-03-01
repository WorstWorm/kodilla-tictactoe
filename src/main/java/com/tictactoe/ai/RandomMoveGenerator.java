package com.tictactoe.ai;

import com.tictactoe.BoardHandler;
import com.tictactoe.Field;
import com.tictactoe.State;

import java.util.ArrayList;
import java.util.Random;

public class RandomMoveGenerator implements MoveGenerator {
    public Field generateNextMove(State state) {
        String[][] situation = state.getMap();
        Random random = new Random();
        ArrayList<Field> fields = BoardHandler.buildEmptyFieldsArray(situation);
        int select = random.nextInt(0, fields.size());
        return fields.get(select);
    }
}
