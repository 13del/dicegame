package com.dicegame.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dicegame.domain.Player;
import com.dicegame.utilities.InvalidParamException;
import com.dicegame.utilities.NotFoundException;

public class PlayerRepository {
		
	private static Set<Player> players=new HashSet<>();
	
	public PlayerRepository() {
	}
	
	public void addPlayer(Player player) throws InvalidParamException{
		if(player==null)
			throw new InvalidParamException();
			try {
				players.add(player);
				
			} catch (Exception e) {
				throw new InvalidParamException();
			}
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

    public void deletePlayerById(int id) throws Exception {
        players.remove(getPlayerByID(id));
    }
}