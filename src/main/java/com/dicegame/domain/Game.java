package com.dicegame.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private int gameID;
	private List<Dice> dices = new ArrayList<>();
	private final int totalDices = 6;
	private static int counter=1;

	public Game() {
		this.gameID = counter;
		counter++;
	}
		
	public int getGameID() {
		return gameID;
	}

	public List<Integer> getDicesResults() {
		List<Integer> results = new ArrayList<>();
		for(Dice dice : dices) {
			results.add(dice.getValue());
		} return results;
	}
	
	public void addDices() {
		for (int i =0; i < totalDices; i++) {
			dices.add(new Dice());
		}
	}

	public boolean playGame() {
		for (Dice dice : dices)
		dice.rollDice();		
		return hasWon();
	}
	
	public boolean hasWon() {
		return hasAllDiceSameValue(5) || hasAllDiceSameValue(6);
	}
	
	public boolean hasAllDiceSameValue(int value) {		
		for (Dice dice: dices) {
			if (dice.getValue() != value) {
				return false;
			}
		}
		return true;	
	}
}