package com.dicegame.application.DTO;

import com.dicegame.domain.Game;
import com.google.gson.annotations.Expose;

public class GameDTO {
	
	@Expose
	public int gameID;
	@Expose
	public int dice1, dice2;
	@Expose
	public boolean hasWon;
	
	//valor daus amb int i boolean hasWon
	public GameDTO(Game game) {
		this.gameID = game.getGameID();
		this.hasWon = game.hasWon();
		this.dice1 = game.getDice1().getValue();
		this.dice2 = game.getDice2().getValue();
	}

	public int getGameID() {
		return gameID;
	}

	public boolean isHasWon() {
		return hasWon;
	}
}
