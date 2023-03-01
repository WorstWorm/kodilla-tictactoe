package com.tictactoe.ai;

import com.tictactoe.Field;
import com.tictactoe.State;

public interface MoveGenerator {
    Field generateNextMove(State state);
}
