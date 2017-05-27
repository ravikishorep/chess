package com.chess.beans.piece;

import com.chess.interfaces.move.BishopMoveValidator;

public class Bishop extends Piece {

	public Bishop(PieceColor color) {
		super(color, PieceType.BISHOP, new BishopMoveValidator());
	}

	//TODO methods

}
 