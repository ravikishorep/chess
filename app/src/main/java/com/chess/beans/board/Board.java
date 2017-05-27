package com.chess.beans.board;

import com.chess.beans.piece.Bishop;
import com.chess.beans.piece.King;
import com.chess.beans.piece.Knight;
import com.chess.beans.piece.Pawn;
import com.chess.beans.piece.Piece;
import com.chess.beans.piece.PieceColor;
import com.chess.beans.piece.Queen;
import com.chess.beans.piece.Rook;
import com.chess.exception.InvalidMoveException;
  
public class Board {
	
	private Square[][] squares;
	private static Board board = new Board();
	
	public static Board getInstance(){
		return board;
	}
	
	public Board resetBoard(){
		return new Board();
	}
	
	public Square[][] getSquares() {
		return squares;
	}

	private Board(){
		squares = new Square[8][8];
		initiailizeBoard();
	}

	private void initiailizeBoard() {
		for(int i = 0; i < 8; i ++){
			//Adding white pawns from (0,1) to (7,1)
			addPiece(new Pawn(PieceColor.WHITE),i,1);
			//Adding black pawns from (0,6) to (7,6)
			addPiece(new Pawn(PieceColor.BLACK),i,6);
		}
		
		//add other white pieces
		addPiece(new Rook(PieceColor.WHITE),0,0);
		addPiece(new Rook(PieceColor.WHITE),7,0);
		addPiece(new Knight(PieceColor.WHITE),1,0);
		addPiece(new Knight(PieceColor.WHITE),6,0);
		addPiece(new Bishop(PieceColor.WHITE),2,0);
		addPiece(new Bishop(PieceColor.WHITE),5,0);
		addPiece(new Queen(PieceColor.WHITE),3,0);
		addPiece(new King(PieceColor.WHITE),4,0);
		
		//add other black pieces
		addPiece(new Rook(PieceColor.BLACK),0,7);
		addPiece(new Rook(PieceColor.BLACK),7,7);
		addPiece(new Knight(PieceColor.BLACK),1,7);
		addPiece(new Knight(PieceColor.BLACK),6,7);
		addPiece(new Bishop(PieceColor.BLACK),2,7);
		addPiece(new Bishop(PieceColor.BLACK),5,7);
		addPiece(new Queen(PieceColor.BLACK),3,7);
		addPiece(new King(PieceColor.BLACK),4,7);
		
		//create other squares without pieces
		for(int i = 0; i < 8; i++){
			for(int j = 2; j < 6; j++){
				addPiece(null,i,j);
			}
		}
	}

	private void addPiece(Piece piece, int x, int y) {
		Square square = new Square(x, y);
		square.setPiece(piece);
		this.squares[x][y] = square;
	}
	
	public void move(int startRow, int startColumn, 
			int endRow, int endColumn) throws InvalidMoveException{
		if(startRow < 0 || endRow < 0 || startColumn > 7 || endColumn > 7){
			throw new InvalidMoveException("Invalid indices"); 
		}
		if(board.squares[startRow][startColumn].getPiece() == null){
			throw new InvalidMoveException("Nothing to Move");
		}
		board.squares[startRow][startColumn].getPiece().
				move(squares[startRow][startColumn], squares[endRow][endColumn], squares);
	}
	
}
