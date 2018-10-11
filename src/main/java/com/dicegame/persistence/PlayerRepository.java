package com.dicegame.persistence;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.domain.Player;
import com.dicegame.utilities.NotFoundException;

public class PlayerRepository {
		
	private static List<Player> players=new ArrayList<>();
	
	public PlayerRepository() {
	}
	
	public void addPlayer(Player player) throws Exception{
		if(player==null) throw new Exception();
		players.add(player);
	}
	
	public List<Player> getAllPlayers(){
		return new ArrayList<>(players);
	}
	
	public Player getPlayerByID(int playerID) throws NotFoundException {
        for (Player player : players) {
            if (player.getPlayerID() == playerID)
                return player;		
       }      
       throw new NotFoundException(); 
	}
}