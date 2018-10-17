package com.dicegame.domain;

import java.util.Random;

public class Dice {
	
	private static final int DICE_SIDES=6;
	private int value;

	public Dice() {
		value=1;
	}
	
	public void rollDice() {
		value=new Random().nextInt(DICE_SIDES)+1;
	}
	
	public int getValue() {
		return value;
	}
}
 //como hacerlo si tienes dados de mas de 6 caras?
