package com.dicegame.domain;

public class Game {
	
	private int gameID;
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private static int counter=1;

	public Game() throws Exception {
		this.gameID = counter;
		counter++;
	}
		
	public int getGameID() {
		return gameID;
	}

	public Dice getDice1() {
		return dice1;
	}

	public Dice getDice2() {
		return dice2;
	}

	public boolean playGame() {
		dice1.rollDice();
		dice2.rollDice();
		return hasWon();
	}
	
	public int getDicesSum() {
		return dice1.getValue() + dice2.getValue();
	}
	
	public boolean hasWon() {
		return (getDicesSum()==7);
	}
}