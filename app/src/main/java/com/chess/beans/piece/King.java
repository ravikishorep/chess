package com.chess.beans.piece;

import com.chess.interfaces.move.KingMoveValidator;

public class King extends Piece {

	public King(PieceColor color) {
		super(color, PieceType.KING, new KingMoveValidator());
	}

	//TODO methods

}
 