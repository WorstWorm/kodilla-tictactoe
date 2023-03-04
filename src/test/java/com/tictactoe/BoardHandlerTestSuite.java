package com.tictactoe;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class BoardHandlerTestSuite {

    //Given
    //When
    private static final String[][] situation = {
            {"0", "1", "o"},
            {"o", "x", "x"},
            {"6", "7", "o"}
    };

    @Nested
    @DisplayName("test group - is field empty method")
    class IsFieldEmpty {

        @Test
        @DisplayName("- test - is field empty - empty")
        void test_IsFieldEmpty_EmptyField() {
            //Then
            Assertions.assertTrue(BoardHandler.isFieldEmpty(situation, new Field(0, 0)));
        }

        @Test
        @DisplayName("- test - is field empty - occupied field")
        void test_IsFieldEmpty_OccupiedField() {
            //Then
            Assertions.assertFalse(BoardHandler.isFieldEmpty(situation, new Field(0, 2)));
        }

        @Test
        @DisplayName("- test - is field empty - field don't exist")
        void test_IsFieldEmpty_NotValidField() {
            //Then
            Assertions.assertFalse(BoardHandler.isFieldEmpty(situation, new Field(3, 3)));
        }

    }

    @Nested
    @DisplayName("test group - is it on board range method")
    class IsItOnBoardRange {

        @Test
        @DisplayName("- test - is field in board range - true")
        void test_IsItOnBoardRange_True() {
            //Then
            Assertions.assertTrue(BoardHandler.isItOnBoardRange(situation, new Field(1, 1)));
        }

        @Test
        @DisplayName("- test - is field in board range - false")
        void test_IsItOnBoardRange_False() {
            //Then
            Assertions.assertFalse(BoardHandler.isItOnBoardRange(situation, new Field(3, 3)));
        }

    }

    @Nested
    @DisplayName("test group - test get field by nr method")
    class GetFieldByNr {

        @Test
        @DisplayName("- test - get field coordinates by its number - valid")
        void testGetFieldByNrValid() {
            //Then
            Assertions.assertEquals(new Field(0, 1), BoardHandler.getFieldByNr(situation, 1));
        }

        @Test
        @DisplayName("- test - get field coordinates by its number - invalid")
        void testGetFieldByNrInvalid() {
            //Then
            Assertions.assertNull(BoardHandler.getFieldByNr(situation, 9));
        }

    }

    @Nested
    @DisplayName("test group -  build empty fields array method")
    class BuildEmptyFieldsArray {

        @Test
        @DisplayName("- test  - build empty fields array - empty fields exist")
        void test_BuildEmptyFieldsArray_EmptyFieldsExist() {
            //When
            ArrayList<Field> expected = new ArrayList<>();
            expected.add(new Field(0, 0));
            expected.add(new Field(0, 1));
            expected.add(new Field(2, 0));
            expected.add(new Field(2, 1));

            //Then
            Assertions.assertEquals(expected, BoardHandler.buildEmptyFieldsArray(situation));
        }

        @Test
        @DisplayName("- test  - build empty fields array - no empty fields")
        void test_BuildEmptyFieldsArray_NoEmptyFields() {
            //Given
            //When
            String[][] noEmptyFields = {
                    {"o", "x", "o"},
                    {"o", "x", "x"},
                    {"x", "o", "o"}
            };

            //Then
            Assertions.assertTrue(BoardHandler.buildEmptyFieldsArray(noEmptyFields).isEmpty());
        }

    }

    @Nested
    @DisplayName("test group -  does empty field exists method")
    class DoesEmptyFieldExists {

        @Test
        @DisplayName("- test - does empty field exist - true")
        void test_DoesEmptyFieldExists_True() {
            //Then
            Assertions.assertTrue(BoardHandler.doesEmptyFieldExists(situation));
        }

        @Test
        @DisplayName("- test - does empty field exist - false")
        void test_DoesEmptyFieldExists_False() {
            //Given
            //When
            String[][] noEmptyFields = {
                    {"o", "x", "o"},
                    {"o", "x", "x"},
                    {"x", "o", "o"}
            };

            //Then
            Assertions.assertFalse(BoardHandler.doesEmptyFieldExists(noEmptyFields));
        }

    }

    @Nested
    @DisplayName("test group -  get nr by field method")
    class GetNrByField {

        @Test
        @DisplayName("- test - get number of field - valid")
        void test_GetNrByFieldValid() {
            //Then
            Assertions.assertEquals("1", BoardHandler.getNrByField(new State(3), new Field(0, 1)));
        }

        @Test
        @DisplayName("- test - get number of field - invalid")
        void test_GetNrByFieldInvalid() {
            //Then
            Assertions.assertNull(BoardHandler.getNrByField(new State(3), new Field(3, 3)));
        }
    }

    @Nested
    @DisplayName("test group -  draw situations")
    class DrawSituations {

        @Test
        @DisplayName("- test - draw situation (board 3x3)")
        void test_Draw_Board3() {
            //Given
            State state = new State(3);

            //When
            state.makeMove(new Field(0, 0));
            state.makeMove(new Field(0, 1));
            state.makeMove(new Field(0, 2));
            state.makeMove(new Field(1, 0));
            state.makeMove(new Field(1, 1));
            state.makeMove(new Field(1, 2));
            state.makeMove(new Field(2, 0));
            state.makeMove(new Field(2, 1));
            state.makeMove(new Field(2, 2));
            boolean result = BoardHandler.doesEmptyFieldExists(state.getMap());

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("- test - draw situation (board 10x10)")
        void test_Draw_Board10() {
            //Given
            State state = new State(10);

            //When
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    state.makeMove(new Field(i, j));
                }
            }
            boolean result = BoardHandler.doesEmptyFieldExists(state.getMap());

            //Then
            Assertions.assertFalse(result);
        }

    }

}
