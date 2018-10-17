package com.dicegame.application;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.application.DTO.PlayerDTO;
import com.dicegame.domain.Player;
import com.dicegame.persistence.PlayerRepository;
import com.dicegame.utilities.InvalidParamException;
import com.dicegame.utilities.NotFoundException;

public class PlayerController {
	
	private PlayerRepository playerRepository = new PlayerRepository();
	
	public PlayerController () {		
	}
	
	//POST: /players : crea un jugador
	public PlayerDTO createPlayer (PlayerDTO playerDTO) throws InvalidParamException, NotFoundException{
		Player player = new Player(playerDTO.getPlayerID(), playerDTO.getPlayerName(), playerDTO.getRegistrationDate());
		playerRepository.addPlayer(player);
		return new PlayerDTO(player);
	}

	//GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
    public List<PlayerDTO> getAllPlayers() throws NotFoundException {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
		for (Player player : playerRepository. getAllPlayers()) {
			playerDTOList.add(new PlayerDTO(player));
		}
        return playerDTOList;
    }
    
  //PUT /players : modifica el nom del jugador
    public PlayerDTO updatePlayer(int playerID, PlayerDTO playerToUpdate) throws NotFoundException, InvalidParamException  {
		Player player = playerRepository.getPlayerByID(playerID);
		if (!playerToUpdate.getPlayerName().equals(""))
			player.setPlayerName(playerToUpdate.getPlayerName());
		playerRepository.addPlayer(player);

		return new PlayerDTO(player);
	} 
    
    //DELETE /players/{id} elimina el jugador.
	public void deletePlayerByID(int playerID) throws Exception {
		playerRepository.deletePlayerById(playerID);					
	}
	
	//GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema.
	public double getRanking() throws NotFoundException {
		double successRate= 0;
		for (Player player : playerRepository.getAllPlayers()) {
			successRate = player.getSuccessRate()+successRate;
		};
		return successRate/playerRepository.getAllPlayers().size();
	}

	//GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	public PlayerDTO getRankingLoser() throws NotFoundException {
		Player player=null;
        for (Player p : playerRepository.getAllPlayers()) {
        	if (player == null || player.getSuccessRate() > p.getSuccessRate())
        		player=p;
        }
		return new PlayerDTO(player);
	}
	//GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	public PlayerDTO getRankingWinner() throws NotFoundException {
		Player player =null;
        for (Player p : playerRepository.getAllPlayers()) {
        	if (player == null || player.getSuccessRate() < p.getSuccessRate())
        		player=p;
        }
		return new PlayerDTO(player);
	}
}
