package com.tictactoe;

import org.junit.jupiter.api.*;

public class WinCheckerTestSuite {

    @Nested
    @DisplayName("test group - player o winning sequences on rows")
    class oWinOnRows {

        @Test
        @DisplayName("- test - o winning sequence on first row (board 3x3, line 3)")
        void test_OWinOnFirstRow_Board3Line3() {
            //Given
                State state = new State(3);
                state.setLengthOfLine(3);

            //When
                state.nextTurn();
                state.makeMove(new Field(0,0));
                state.makeMove(new Field(0,1));
                state.makeMove(new Field(0,2));
                boolean result = WinChecker.checkSequence(state);
                String activePlayer = state.getActivePlayer();
                String expectedPlayer = "o";

            //Then
                Assertions.assertTrue(result);
                Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on second row (board 3x3, line 3)")
        void test_OWinOnSecondRow_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(1,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on last row (board 3x3, line 3)")
        void test_OWinOnThirdRow_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(2,1));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on first row (board 10x10, line 5)")
        void test_OWinOnFirstRow_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on middle row (board 10x10, line 5)")
        void test_OWinOnMiddleRow_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on last row (board 10x10, line 5)")
        void test_OWinOnLastRow_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }


    @Nested
    @DisplayName("test group - player o winning sequences on columns")
    class oWinOnColumns {

        @Test
        @DisplayName("- test - o winning sequence on first column (board 3x3, line 3)")
        void test_OWinOnFirstColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on second column (board 3x3, line 3)")
        void test_OWinOnSecondColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,1));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on last column (board 3x3, line 3)")
        void test_OWinOnThirdColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,2));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on first column (board 10x10, line 5)")
        void test_OWinOnFirstColumn_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on middle column (board 10x10, line 5)")
        void test_OWinOnMiddleColumn_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on last column (board 10x10, line 5)")
        void test_OWinOnLastColumn_Board10Line5() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }


    @Nested
    @DisplayName("test group - player o winning sequences on diagonals")
    class oWinOnDiagonals {

        @Test
        @DisplayName("- test - o winning sequence on diagonal left-right (board 3x3, line 3)")
        void test_OWinOnDiagonalLR_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on diagonal right-left (board 3x3, line 3)")
        void test_OWinOnDiagonalRL_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,0));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on random diagonal left-right (board 10x10, line 5)")
        void test_OWinOnRandomDiagonalLR_Board3Line3() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - o winning sequence on random diagonal right-left (board 10x10, line 5)")
        void test_OWinOnRandomDiagonalRL_Board3Line3() {
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
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "o";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }


    @Nested
    @DisplayName("test group - player x winning sequences on rows")
    class xWinOnRows {

        @Test
        @DisplayName("- test - x winning sequence on first row (board 3x3, line 3)")
        void test_XWinOnFirstRow_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on second row (board 3x3, line 3)")
        void test_XWinOnSecondRow_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(1,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on last row (board 3x3, line 3)")
        void test_XWinOnThirdRow_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(2,1));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on first row (board 10x10, line 5)")
        void test_XWinOnFirstRow_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(0,3));
            state.makeMove(new Field(0,4));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on middle row (board 10x10, line 5)")
        void test_XWinOnMiddleRow_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,5));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(5,7));
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(5,9));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on last row (board 10x10, line 5)")
        void test_XWinOnLastRow_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(9,3));
            state.makeMove(new Field(9,4));
            state.makeMove(new Field(9,5));
            state.makeMove(new Field(9,6));
            state.makeMove(new Field(9,7));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }


    @Nested
    @DisplayName("test group - player x winning sequences on columns")
    class xWinOnColumns {

        @Test
        @DisplayName("- test - x winning sequence on first column (board 3x3, line 3)")
        void test_XWinOnFirstColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on second column (board 3x3, line 3)")
        void test_XWinOnSecondColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,1));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,1));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on last column (board 3x3, line 3)")
        void test_XWinOnThirdColumn_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,2));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on first column (board 10x10, line 5)")
        void test_XWinOnFirstColumn_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(2,0));
            state.makeMove(new Field(3,0));
            state.makeMove(new Field(4,0));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on middle column (board 10x10, line 5)")
        void test_XWinOnMiddleColumn_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(3,6));
            state.makeMove(new Field(4,6));
            state.makeMove(new Field(5,6));
            state.makeMove(new Field(6,6));
            state.makeMove(new Field(7,6));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on last column (board 10x10, line 5)")
        void test_XWinOnLastColumn_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,9));
            state.makeMove(new Field(6,9));
            state.makeMove(new Field(7,9));
            state.makeMove(new Field(8,9));
            state.makeMove(new Field(9,9));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }


    @Nested
    @DisplayName("test group - player x winning sequences on diagonals")
    class xWinOnDiagonals {

        @Test
        @DisplayName("- test - x winning sequence on diagonal left-right (board 3x3, line 3)")
        void test_XWinOnDiagonalLR_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on diagonal right-left (board 3x3, line 3)")
        void test_XWinOnDiagonalRL_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.makeMove(new Field(0,2));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,0));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test - x winning sequence on random diagonal left-right (board 10x10, line 5)")
        void test_XWinOnRandomDiagonalLR_Board3Line3() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            state.makeMove(new Field(3,3));
            state.makeMove(new Field(4,4));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }

        @Test
        @DisplayName("- test x winning sequence on random diagonal right-left (board 10x10, line 5)")
        void test_XWinOnRandomDiagonalRL_Board3Line3() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(5,8));
            state.makeMove(new Field(6,7));
            state.makeMove(new Field(7,6));
            state.makeMove(new Field(8,5));
            state.makeMove(new Field(9,4));
            boolean result = WinChecker.checkSequence(state);
            String activePlayer = state.getActivePlayer();
            String expectedPlayer = "x";

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(expectedPlayer, activePlayer);
        }
    }

    @Nested
    @DisplayName("test group - other tests")
    class otherTests {

        @Test
        @DisplayName("- test - no sequence (board 3x3, line 3)")
        void test_noSequence_Board3Line3() {
            //Given
            State state = new State(3);
            state.setLengthOfLine(3);

            //When
            state.nextTurn();
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,0));
            state.makeMove(new Field(0,2));
            boolean result = WinChecker.checkSequence(state);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("- test - no sequence (board 10x10, line 5)")
        void test_noSequence_Board10Line5() {
            //Given
            State state = new State(10);
            state.setLengthOfLine(5);

            //When
            state.makeMove(new Field(0,0));
            state.makeMove(new Field(1,1));
            state.makeMove(new Field(2,2));
            state.makeMove(new Field(4,4));
            boolean result = WinChecker.checkSequence(state);

            //Then
            Assertions.assertFalse(result);
        }
    }
}