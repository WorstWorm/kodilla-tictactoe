package com.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

import static com.tictactoe.UIConstants.*;

public class GUIInterface extends Application {
    private State state = new State(3,3, false);
    Button[][] buttons = new Button[3][3];

    @Override
    public void start(Stage primaryStage) {
        startGame(primaryStage);
    }

    public void startGame(Stage stage) {
        stage.setTitle("Tic-tac-toe");
        Popup popup = new Popup();
        BorderPane root = new BorderPane();
        int sizeOfTheBoard = state.getSize() * BUTTON_SIZE;
        Scene scene = new Scene(root, sizeOfTheBoard, sizeOfTheBoard+26);
        GridPane grid = new GridPane();
        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        Menu fileMenu = new Menu("File");

        MenuItem newGame3ItemPvP = new MenuItem("New Game 3x3 - 3 in row against another player");
        MenuItem newGame10ItemPvP = new MenuItem("New Game 10x10 - 5 in row against another player");
        MenuItem newGame3ItemPvC = new MenuItem("New Game 3x3 - 3 in row against the computer");
        MenuItem newGame10ItemPvC = new MenuItem("New Game 10x10 - 5 in row against computer");
        MenuItem exitItem = new MenuItem("Exit");

        Label label = new Label();
        label.setStyle(POPUP_STYLE);
        label.setFont(Font.font(POPUP_FONT_SIZE));

        exitItem.setOnAction(event -> stage.close());
        newGame3ItemPvP.setOnAction(event -> {
            popup.hide();
            newGame(3,3, false);
            stage.close();
        });

        newGame10ItemPvP.setOnAction(event -> {
            popup.hide();
            newGame(10,5, false);
            stage.close();
        });

        newGame3ItemPvC.setOnAction(event -> {
            popup.hide();
            newGame(3,3, true);
            stage.close();
        });

        newGame10ItemPvC.setOnAction(event -> {
            popup.hide();
            newGame(10,5, true);
            stage.close();
        });

        fileMenu.getItems().addAll(newGame3ItemPvP, newGame10ItemPvP, newGame3ItemPvC, newGame10ItemPvC, exitItem);
        menuBar.getMenus().add(fileMenu);

        for(int y=0; y<state.getSize(); y++) {
            {
                for(int x=0; x<state.getSize(); x++) {
                    Button button = new Button();
                    button.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
                    button.setText(state.getMap()[y][x]);
                    int finalY = y;
                    int finalX = x;
                    button.setOnAction(event -> {
                        moveGUIProcedure(buttons[finalY][finalX], finalY, finalX, label, popup, stage);
                        if(state.getComputerPlayer()){
                            Field computerMove = Logic.randomMove(state.getMap());
                            moveGUIProcedure(buttons[computerMove.y()][computerMove.x()],
                                    computerMove.y(), computerMove.x(), label, popup, stage);
                        }
                    });
                    buttons[y][x] = button;
                    grid.add(button, y, x);
                }
            }
        }

        root.setCenter(grid);
        stage.setScene(scene);
        stage.show();
    }

    private void newGame(int size, int length,boolean computerPlayer) {
        state = new State(size,length, computerPlayer);
        buttons = new Button[size][size];
        startGame(new Stage());
    }

    private void moveGUIProcedure(Button button, int y, int x, Label label, Popup popup, Stage stage) {
        button.setDisable(true);
        state.makeMove(new Field(y, x));
        button.setFont(Font.font(MARKED_FIELD_FONT_SIZE));
        button.setText(state.getActivePlayer());

        if(Logic.checkSequence(state.getMap(), state.getActivePlayer(), new Field(y, x), state.getLengthOfLine())) {
            label.setText(" " + state.getActivePlayer() + " won ");
            popup.getContent().add(label);
            popup.show(stage);
            state.setEnd(true);
            for(int i=0; i<state.getSize(); i++) {
                for(int j=0; j<state.getSize(); j++) {
                    buttons[i][j].setDisable(true);
                }
            }
        } else if (!Logic.emptyField(state.getMap())) {
            label.setText(" draw ");
            popup.getContent().add(label);
            popup.show(stage);
            state.setEnd(true);
        }
        state.nextTurn();
        state.changeActivePlayer();
    }

    public static void main(String[] args) {
        launch(args);
    }

}