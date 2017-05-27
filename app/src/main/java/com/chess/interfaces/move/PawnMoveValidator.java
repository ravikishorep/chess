package com.chess.interfaces.move;

import com.chess.beans.board.Square;
import com.chess.beans.piece.Pawn;
import com.chess.beans.piece.PieceColor;
import com.chess.exception.InvalidMoveException;

public class PawnMoveValidator implements MoveValidator {

	@Override
	public boolean move(Square startSquare, Square endSquare, Square[][] squares) throws InvalidMoveException {
		if(startSquare.getPiece() instanceof Pawn &&
				endSquare.getPiece() instanceof Pawn){
			int startRow = startSquare.getRow();
			int startColumn = startSquare.getColumn();
			int endRow = endSquare.getRow();
			int endColumn = endSquare.getColumn();
			//one move forward 
			if((endSquare.getPiece().getColor().equals(PieceColor.WHITE)
					&& startRow == endRow && (endColumn - startColumn) == 1)
					|| (endSquare.getPiece().getColor().equals(PieceColor.BLACK)
							&& startRow == endRow && (startColumn - endColumn) == 1)){
				if(endSquare.getPiece() == null){
					endSquare.setPiece(startSquare.getPiece());
					startSquare.setPiece(null);
				} else if (!endSquare.getPiece().getColor().equals(startSquare.getPiece().getColor())){
					//TODO - track kill
					endSquare.setPiece(startSquare.getPiece());
					startSquare.setPiece(null);
				} else {
					throw new InvalidMoveException("InvalidMove");
				}
			} else {
				throw new InvalidMoveException("InvalidMove");
			}
		} else {
			throw new InvalidMoveException("InvalidMove");
		}
		return true;
	}

}
