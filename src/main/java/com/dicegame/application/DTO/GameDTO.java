package com.dicegame.application.DTO;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.domain.Dice;
import com.dicegame.domain.Game;
import com.dicegame.utilities.NotFoundException;
import com.google.gson.annotations.Expose;

public class GameDTO {
	
	@Expose
	public int gameID;
	@Expose
	public List<Integer> dicesResults = new ArrayList<>();
	@Expose
	public boolean hasWon;
	
	//valor daus amb int i boolean hasWon
	public GameDTO(Game game) throws NotFoundException {
		if (game == null)
			throw new NotFoundException();
		this.gameID = game.getGameID();
		this.hasWon = game.hasWon();
		this.dicesResults= game.getDicesResults();
	}

	public int getGameID() {
		return gameID;
	}

	public boolean isHasWon() {
		return hasWon;
	}
}
