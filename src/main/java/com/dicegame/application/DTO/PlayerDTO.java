package com.dicegame.application.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dicegame.domain.Game;
import com.dicegame.domain.Player;
import com.dicegame.utilities.NotFoundException;
import com.google.gson.annotations.Expose;

public class PlayerDTO {
	@Expose
	public int playerID;
	@Expose
	public String playerName;
	public List <Game> allGames = new ArrayList<Game>();
	@Expose
	public double succesRate;
	@Expose
	public String registrationDate;
	
	public PlayerDTO(Player player) throws NotFoundException {
		if (player == null)
			throw new NotFoundException();
		this.playerID = player.getPlayerID();
		this.playerName = player.getPlayerName();
		this.succesRate = player.getSuccessRate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");		
		this.registrationDate=dateFormat.format(player.getRegistrationDate());
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

	public String getRegistrationDate() {
		return registrationDate;
	}
}