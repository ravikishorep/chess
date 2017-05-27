package com.chess.beans.piece;

import com.chess.interfaces.move.PawnMoveValidator;

public class Pawn extends Piece {

	public Pawn(PieceColor color) {
		super(color, PieceType.PAWN, new PawnMoveValidator());
	}

	//TODO methods
	
}
  