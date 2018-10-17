package com.dicegame.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dicegame.utilities.InvalidParamException;


public class Player {
	
	private int playerID;
	private String playerName;
	private List <Game> games = new ArrayList<>();	
	private static int counter=1;
	Calendar cal = Calendar.getInstance();
	
	public Player(int playerID, String playerName, String registrationDate) throws InvalidParamException{
		checkValidName(playerName);
		if (playerName.equals(""))
			playerName= "ÁNONIMO";
		this.playerID = counter;
		this.playerName = playerName;
		counter++;
	}
	
	private void checkValidName(String name) throws InvalidParamException {	
		if (name.equals(""))
			throw new InvalidParamException();
	}	

	public int getPlayerID() {
		return playerID;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) throws InvalidParamException {
		checkValidName(playerName);
		this.playerName = playerName;
	}

	public List<Game> getAllGames() {
		return new ArrayList<>(games);
	}

	public void addGame(Game game){
		this.games.add(game);
	}
	
	public double getSuccessRate () {
		double success = 0;
		for (Game game : games) {
			if (game.hasWon())
			++success;				
		}
		if (games.size() > 0) {
			return (success*100) / games.size();
		} return  0.00;		
	}

	public Date getRegistrationDate() {
		return cal.getTime();
	}
}
