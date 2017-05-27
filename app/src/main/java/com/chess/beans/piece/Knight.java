package com.chess.beans.piece;

import com.chess.interfaces.move.KnightMoveValidator;

public class Knight extends Piece {

	public Knight(PieceColor color) {
		super(color, PieceType.KNIGHT, new KnightMoveValidator());
	}

	//TODO methods
}
  