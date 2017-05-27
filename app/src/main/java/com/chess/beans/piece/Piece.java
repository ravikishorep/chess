package com.chess.beans.piece;

import com.chess.beans.board.Square;
import com.chess.exception.InvalidMoveException;
import com.chess.interfaces.move.MoveValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Piece {

	private PieceColor color;
	private PieceType type;
	@JsonIgnore
	private MoveValidator moveValidator;

		public Piece(PieceColor color, PieceType type, MoveValidator moveValidator){
		this.color = color;
		this.type = type;
		this.moveValidator = moveValidator;
	}
	 
	public void move(Square startSquare, Square endSquare, Square[][] squares) throws InvalidMoveException{
		moveValidator.move(startSquare, endSquare, squares);
	}
	
	public PieceColor getColor() {
		return color;
	}
	
	public PieceType getType() {
		return type;
	}
	
	public MoveValidator getMoveValidator() {
		return moveValidator;
	}
}
