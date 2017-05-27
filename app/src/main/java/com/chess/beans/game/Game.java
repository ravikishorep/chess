package com.chess.beans.game;

import com.chess.beans.board.Board;

public class Game { 
	private Player playerOne;
	private Player playerTwo;
	private Board board;
	private boolean checkMate;
	private Result result;
	private static Game game;
	
	private Game(Player playerOne, Player playerTwo){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		board = Board.getInstance();
	}
	
	public static Game getInstance(Player playerOne, Player playerTwo){
		if(game == null){
			game = new Game(playerOne, playerTwo);
		}
		return game;
	}
	
	public Player getPlayerOne() {
		return playerOne;
	}
	public Player getPlayerTwo() {
		return playerTwo;
	}
	public Board getBoard() {
		return board;
	}
	public boolean isCheckMate() {
		return checkMate;
	}
	public Result getResult() {
		return result;
	}
	public static Game getGame() {
		return game;
	}
}
