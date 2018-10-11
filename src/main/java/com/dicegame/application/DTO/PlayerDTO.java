package com.dicegame.application.DTO;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.domain.Game;
import com.dicegame.domain.Player;
import com.google.gson.annotations.Expose;

public class PlayerDTO {
	@Expose
	public int playerID;
	@Expose
	public String playerName;
	public List <Game> allGames = new ArrayList<Game>();
	@Expose
	public double succesRate;
	
	public PlayerDTO(Player player) {
		this.playerID = player.getPlayerID();
		this.playerName = player.getPlayerName();
		this.succesRate = player.getSuccessRate();
	}

	public int getPlayerID() {
		return playerID;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public List<Game> getAllGames() {
		return new ArrayList<>(allGames);
	}

	public double getSuccesRate() {
		return succesRate;
	}
}