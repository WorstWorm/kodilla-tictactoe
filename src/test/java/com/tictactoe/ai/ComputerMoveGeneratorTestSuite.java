package com.tictactoe.ai;

import com.tictactoe.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerMoveGeneratorTest {

    @Test
    @DisplayName("- test - generate best move (board 3x3, line 3)")
    void test_GenerateBestMove_Board3Line3() {
        // Given
        State state;
        ComputerMoveGenerator generator = new ComputerMoveGenerator();
        state = new State(3, 3, false);
        state.makeMove(new Field(0,0));
        state.nextTurn();
        state.makeMove(new Field(1,1));
        state.nextTurn();
        state.makeMove(new Field(2,2));
        state.nextTurn();
        state.makeMove(new Field(1,0));
        state.nextTurn();
        state.makeMove(new Field(0,2));
        state.nextTurn();

        // When
        Field nextMove = generator.generateNextMove(state);
        Field expected = new Field(1,2);

        // Then
        assertEquals(expected.x(), nextMove.x());
        assertEquals(expected.y(), nextMove.y());

    }



    @Test
    @DisplayName("- test - generate best move (board 10x10, line 5)")
    void test_GenerateBestMove_Board10Line5() {
        // Given
        State state;
        ComputerMoveGenerator generator = new ComputerMoveGenerator();
        state = new State(10, 5, false);

        state.makeMove(new Field(0,0));
        state.nextTurn();
        state.makeMove(new Field(0,3));
        state.nextTurn();
        state.makeMove(new Field(0,4));
        state.nextTurn();
        state.makeMove(new Field(1,3));
        state.nextTurn();
        state.makeMove(new Field(0,5));
        state.nextTurn();
        state.makeMove(new Field(1,4));
        state.nextTurn();
        state.makeMove(new Field(0,6));
        state.nextTurn();
        state.makeMove(new Field(1,6));
        state.nextTurn();
        state.makeMove(new Field(1,5));
        state.nextTurn();
        state.makeMove(new Field(2,5));
        state.nextTurn();
        state.makeMove(new Field(1,0));
        state.nextTurn();
        state.makeMove(new Field(3,6));
        state.nextTurn();
        state.makeMove(new Field(3,0));
        state.nextTurn();

        // When
        Field nextMove = generator.generateNextMove(state);
        Field expected = new Field(4,7);

        // Then
        assertEquals(expected.x(), nextMove.x());
        assertEquals(expected.y(), nextMove.y());

    }

}