package com.chess.beans.game;

import com.chess.beans.piece.PieceColor;

public class Player {
	private String name;
	private PieceColor playerPieceColor;
	
	public Player(String name, PieceColor playerPieceColor){
		this.name = name;
		this.playerPieceColor = playerPieceColor;
	}  
	
	public String getName() {
		return name;
	}

	public PieceColor getPlayerPieceColor() {
		return playerPieceColor;
	}
}
