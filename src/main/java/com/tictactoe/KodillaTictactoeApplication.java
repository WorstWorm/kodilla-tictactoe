package com.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class KodillaTictactoeApplication {

	public static void main(String[] args) {
		State actualState = new State();
		Controller controller = new Controller();
		Board gameBoard = new Board();
		gameBoard.generateBoard(actualState.getState(), controller.getCursorPosition());
	}

}
