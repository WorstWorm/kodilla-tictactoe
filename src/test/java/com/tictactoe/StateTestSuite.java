package com.tictactoe;

import org.junit.jupiter.api.*;

public class StateTestSuite {

    @Nested
    @DisplayName("o winning sequences on rows tests")
    class oWinOnRows {

        @Test
        @DisplayName("o winning sequence on first row (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_RowFirst() {
            //Given
                State state = new State(3);
                state.setLengthOfLine(3);

            //When
                state.nextTurn();
                state.makeMove(new Field(0,0));
                state.makeMove(new Field(0,1));
                state.makeMove(new Field(0,2));
                boolean result = Logic.checkSequence(state.getMap(), "o",new Field(0,2),3);

            //Then
                Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on middle row (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_RowMiddle() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(1,2));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(1,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on last row (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_RowLast() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(2,1));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(2,0),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on first row (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_RowFirst() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(0,3));
            state.makeMove(new Field(0,4));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(0,4),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on middle row (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_RowMiddle() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(5,5));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(5,7));
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(5,9));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(5,9),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on last row (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_RowLast() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(9,3));
            state.makeMove(new Field(9,4));
            state.makeMove(new Field(9,5));
            state.makeMove(new Field(9,6));
            state.makeMove(new Field(9,7));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(9,7),5);

            //Then
            Assertions.assertTrue(result);
        }
    }


    @Nested
    @DisplayName("o winning sequences on columns tests")
    class oWinOnColumns {

        @Test
        @DisplayName("o winning sequence on first column (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_ColumnFirst() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(1,0),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on middle column (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_ColumnMiddle() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,1));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(0,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on last column (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_ColumnLast() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,2));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(1,2),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on first column (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_ColumnFirst() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(3,0));
            state.makeMove(new Field(4,0));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(1,0),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on middle column (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_ColumnMiddle() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(3,6));
            state.makeMove(new Field(4,6));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(6,6));
            state.makeMove(new Field(7,6));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(7,6),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on last column (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_ColumnLast() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(5,9));
            state.makeMove(new Field(6,9));
            state.makeMove(new Field(7,9));
            state.makeMove(new Field(8,9));
            state.makeMove(new Field(9,9));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(8,9),5);

            //Then
            Assertions.assertTrue(result);
        }
    }


    @Nested
    @DisplayName("o winning sequences on diagonals")
    class oWinOnDiagonals {

        @Test
        @DisplayName("o winning sequence on diagonal left-right (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_DiagonalLeftRight() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(2,2),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on diagonal right-left (borad 3x3, line 3)")
        void test_WinOnRowsO_Line3_Board3_DiagonalRightLeft() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,0));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(1,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on diagonal left-right (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_RandomDiagonalLeftRight() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            state.makeMove(new Field(3,3));
            state.makeMove(new Field(4,4));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(3,3),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("o winning sequence on diagonal right-left (borad 10x10, line 5)")
        void test_WinOnRowsO_Line5_Board10_RandomDiagonalRightLeft() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.nextTurn();
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(6,7));
            state.makeMove(new Field(7,6));
            state.makeMove(new Field(8,5));
            state.makeMove(new Field(9,4));
            boolean result = Logic.checkSequence(state.getMap(), "o",new Field(6,7),3);

            //Then
            Assertions.assertTrue(result);
        }
    }


    @Nested
    @DisplayName("x winning sequences on rows tests")
    class xWinOnRows {

        @Test
        @DisplayName("x winning sequence on first row (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_RowFirst() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(0,2),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on middle row (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_RowMiddle() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(1,2));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(1,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on last row (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_RowLast() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(2,1));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(2,0),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on first row (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_RowFirst() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(0,3));
            state.makeMove(new Field(0,4));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(0,4),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on middle row (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_RowMiddle() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,5));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(5,7));
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(5,9));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(5,9),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on last row (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_RowLast() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(9,3));
            state.makeMove(new Field(9,4));
            state.makeMove(new Field(9,5));
            state.makeMove(new Field(9,6));
            state.makeMove(new Field(9,7));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(9,7),5);

            //Then
            Assertions.assertTrue(result);
        }
    }


    @Nested
    @DisplayName("x winning sequences on columns tests")
    class xWinOnColumns {

        @Test
        @DisplayName("x winning sequence on first column (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_ColumnFirst() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(1,0),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on middle column (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_ColumnMiddle() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,1));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(0,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on last column (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_ColumnLast() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,2));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(1,2),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on first column (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_ColumnFirst() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(3,0));
            state.makeMove(new Field(4,0));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(1,0),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on middle column (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_ColumnMiddle() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(3,6));
            state.makeMove(new Field(4,6));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(6,6));
            state.makeMove(new Field(7,6));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(7,6),5);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on last column (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_ColumnLast() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,9));
            state.makeMove(new Field(6,9));
            state.makeMove(new Field(7,9));
            state.makeMove(new Field(8,9));
            state.makeMove(new Field(9,9));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(8,9),5);

            //Then
            Assertions.assertTrue(result);
        }
    }


    @Nested
    @DisplayName("x winning sequences on diagonals")
    class xWinOnDiagonals {

        @Test
        @DisplayName("x winning sequence on diagonal left-right (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_DiagonalLeftRight() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(2,2),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on diagonal right-left (borad 3x3, line 3)")
        void test_WinOnRowsX_Line3_Board3_DiagonalRightLeft() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,0));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(1,1),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on diagonal left-right (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_RandomDiagonalLeftRight() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            state.makeMove(new Field(3,3));
            state.makeMove(new Field(4,4));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(3,3),3);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("x winning sequence on diagonal right-left (borad 10x10, line 5)")
        void test_WinOnRowsX_Line5_Board10_RandomDiagonalRightLeft() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(6,7));
            state.makeMove(new Field(7,6));
            state.makeMove(new Field(8,5));
            state.makeMove(new Field(9,4));
            boolean result = Logic.checkSequence(state.getMap(), "x",new Field(6,7),3);

            //Then
            Assertions.assertTrue(result);
        }
    }

    @Nested
    @DisplayName("other tests")
    class otherTests {

        @Test
        @DisplayName("draw situation (borad 3x3)")
        void test_Draw_Board3() {
            //Given
            State state = new State(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(1,2));
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(2,1));
            state.makeMove(new Field(2,2));
            boolean result = !Logic.emptyField(state.getMap());

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("draw situation (board 10x10)")
        void test_Draw_Board10() {
            //Given
            State state = new State(10);

            //When
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    state.makeMove(new Field(i,j));
                }
            }
            boolean result = !Logic.emptyField(state.getMap());

            //Then
            Assertions.assertTrue(result);
        }
    }
}