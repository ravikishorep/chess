package com.chess.beans.piece;

import com.chess.interfaces.move.RookMoveValidator;

public class Rook extends Piece {

	public Rook(PieceColor color) {
		super(color, PieceType.ROOK, new RookMoveValidator());
	}
 
	//TODO methods

}
