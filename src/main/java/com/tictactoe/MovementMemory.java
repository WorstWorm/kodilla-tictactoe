package com.tictactoe;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovementMemory {
    Deque<State> states;

    public MovementMemory() {
        this.states = new ArrayDeque<>();
    }

    public void addToMemory(State state) throws CloneNotSupportedException {
        states.push(state.deepCopy());
    }

    public State returnFromMemory() {
        return states.pop();
    }
}
