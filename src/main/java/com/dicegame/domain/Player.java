package com.dicegame.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int playerID;
	private String playerName;
	private List <Game> games = new ArrayList<>();	
	private static int counter=1;
	
	public Player(int playerID, String playerName) throws Exception {
		if (playerName.equals(" ")) throw new Exception();
		this.playerID = counter;
		this.playerName = playerName;
		counter++;
	}

	public int getPlayerID() {
		return playerID;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public List<Game> getAllGames() {
		return new ArrayList<>(games);
	}

	public void addGame(Game game){
		this.games.add(game);
	}
	
	public double getSuccessRate () {
		List<Game> allGames = getAllGames();
		double success = 0;
		for (Game game : allGames) {
			if (game.hasWon())
			++success;				
		}
		if (allGames.size() > 0) {
			return (success*100) / allGames.size();
		} return  0.00;		
	}	
}
