package com.chess;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chess.beans.game.Game;
import com.chess.beans.game.Player;
import com.chess.beans.piece.PieceColor;
import com.chess.exception.InvalidMoveException;

@Controller
@RequestMapping("/game")
public class GameController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Game getGame(@RequestParam String playerOneName, @RequestParam String playeTwoName) {
		Player playerOne = new Player(playerOneName, PieceColor.WHITE);
		Player playerTwo = new Player(playeTwoName, PieceColor.BLACK);
		return Game.getInstance(playerOne, playerTwo);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	SimpleResponse move(@RequestParam int startRow, @RequestParam int startColumn,
			@RequestParam int endRow, @RequestParam int endColumn) {
		Game game = Game.getGame();
		SimpleResponse simpleResponse = new SimpleResponse();
		if(game  == null){
			simpleResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			simpleResponse.setDesc("Board Unavailable");
			return simpleResponse;
		}
		try {
			game.getBoard().move(startRow, startColumn, endRow, endColumn);
			simpleResponse.setStatus(HttpStatus.OK.value());
			simpleResponse.setDesc("Success");
		} catch (InvalidMoveException e) {
			simpleResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			simpleResponse.setDesc(e.getMessage());
		}
		return simpleResponse;
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public @ResponseBody Game resetGame() {
		Game game = Game.getGame();
		if(game  == null){
			return null;
		}
		Game.getGame().getBoard().resetBoard();
		return game;
	}
}