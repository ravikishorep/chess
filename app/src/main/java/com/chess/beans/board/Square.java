package com.chess.beans.board;

import com.chess.beans.piece.Piece;

public class Square {
	 
	private int row;
	private int column;
	private Piece piece;
	
	public Square(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
