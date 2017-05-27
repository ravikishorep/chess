package com.chess.interfaces.move;

import com.chess.beans.board.Square;
import com.chess.exception.InvalidMoveException;

public interface MoveValidator {
	public boolean move(Square startSquare, Square endSquare, Square[][] squares) throws InvalidMoveException;
}
