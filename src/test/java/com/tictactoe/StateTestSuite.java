package com.tictactoe;

import org.junit.jupiter.api.*;

public class StateTestSuite {

    @Nested
    @DisplayName("O winning sequences")
    class oWinningSequences {

        @Test
        void oWinnerColumn1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'o');
            state.makeMove(4, 'o');
            state.makeMove(7, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerColumn2() {
            //Given
            State state = new State();

            //When
            state.makeMove(2, 'o');
            state.makeMove(5, 'o');
            state.makeMove(8, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerColumn3() {
            //Given
            State state = new State();

            //When
            state.makeMove(3, 'o');
            state.makeMove(6, 'o');
            state.makeMove(9, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerRow1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'o');
            state.makeMove(2, 'o');
            state.makeMove(3, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerRow2() {
            //Given
            State state = new State();

            //When
            state.makeMove(4, 'o');
            state.makeMove(5, 'o');
            state.makeMove(6, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerRow3() {
            //Given
            State state = new State();

            //When
            state.makeMove(7, 'o');
            state.makeMove(8, 'o');
            state.makeMove(9, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerDiagonal1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'o');
            state.makeMove(5, 'o');
            state.makeMove(9, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void oWinnerDiagonal2() {
            //Given
            State state = new State();

            //When
            state.makeMove(3, 'o');
            state.makeMove(5, 'o');
            state.makeMove(7, 'o');
            char result = state.checkResult('o');

            //Then
            char expected = 'o';
            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("X winning sequences")
    class xWinningSequences {

        @Test
        void xWinnerColumn1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(4, 'x');
            state.makeMove(7, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerColumn2() {
            //Given
            State state = new State();

            //When
            state.makeMove(2, 'x');
            state.makeMove(5, 'x');
            state.makeMove(8, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerColumn3() {
            //Given
            State state = new State();

            //When
            state.makeMove(3, 'x');
            state.makeMove(6, 'x');
            state.makeMove(9, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerRow1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(2, 'x');
            state.makeMove(3, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerRow2() {
            //Given
            State state = new State();

            //When
            state.makeMove(4, 'x');
            state.makeMove(5, 'x');
            state.makeMove(6, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerRow3() {
            //Given
            State state = new State();

            //When
            state.makeMove(7, 'x');
            state.makeMove(8, 'x');
            state.makeMove(9, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerDiagonal1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(5, 'x');
            state.makeMove(9, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void xWinnerDiagonal2() {
            //Given
            State state = new State();

            //When
            state.makeMove(3, 'x');
            state.makeMove(5, 'x');
            state.makeMove(7, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'x';
            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("draw sequences")
    class drawSequences {

        @Test
        void drawCombination1() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(2, 'o');
            state.makeMove(3, 'x');
            state.makeMove(4, 'o');
            state.makeMove(5, 'x');
            state.makeMove(7, 'o');
            state.makeMove(6, 'x');
            state.makeMove(9, 'o');
            state.makeMove(8, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'd';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void drawCombination2() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(3, 'o');
            state.makeMove(2, 'x');
            state.makeMove(4, 'o');
            state.makeMove(6, 'x');
            state.makeMove(5, 'o');
            state.makeMove(7, 'x');
            state.makeMove(8, 'o');
            state.makeMove(9, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'd';
            Assertions.assertEquals(expected, result);
        }

        @Test
        void drawCombination3() {
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            state.makeMove(2, 'o');
            state.makeMove(5, 'x');
            state.makeMove(3, 'o');
            state.makeMove(6, 'x');
            state.makeMove(4, 'o');
            state.makeMove(7, 'x');
            state.makeMove(9, 'o');
            state.makeMove(8, 'x');
            char result = state.checkResult('x');

            //Then
            char expected = 'd';
            Assertions.assertEquals(expected, result);
        }
    }
    @Nested
    @DisplayName("draw sequences")
    class wrongMoves {

        @Test
        void fieldAlreadyTaken(){
            //Given
            State state = new State();

            //When
            state.makeMove(1, 'x');
            boolean result = state.makeMove(1, 'y');

            //Then
            boolean expected = false;
            Assertions.assertEquals(expected, result);
        }

        @Test
        void fieldOutsideBox(){
            //Given
            State state = new State();

            //When
            boolean result = state.makeMove(11, 'y');

            //Then
            boolean expected = false;
            Assertions.assertEquals(expected, result);
        }
    }
}