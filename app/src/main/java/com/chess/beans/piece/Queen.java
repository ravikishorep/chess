package com.chess.beans.piece;

import com.chess.interfaces.move.QueenMoveValidator;

public class Queen extends Piece {

	public Queen(PieceColor color) {
		super(color, PieceType.QUEEN, new QueenMoveValidator());
	}

	//TODO methods

}
 