package com.dicegame.application;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.application.DTO.GameDTO;
import com.dicegame.domain.Game;
import com.dicegame.domain.Player;
import com.dicegame.persistence.PlayerRepository;
import com.dicegame.utilities.NotFoundException;

public class GameController {
	
	private PlayerRepository playerRepository = new PlayerRepository();

	public GameController() {
	}

	//POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	public GameDTO playGame (int playerID) throws NotFoundException{
		Game game = new Game();
		game.addDices();
		game.playGame();
		Player player = playerRepository.getPlayerByID(playerID);
		player.addGame(game);
		return new GameDTO(game);
	}
	//GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	public List<GameDTO> listGames(int playerID) throws NotFoundException {
		List<GameDTO> gameDTOList = new ArrayList <>();	
		Player player = playerRepository.getPlayerByID(playerID);		
		for (Game u : player.getAllGames()) {
			gameDTOList.add(new GameDTO(u));
		}	
		if (gameDTOList.isEmpty())
			throw new NotFoundException();
		return gameDTOList;
	}
	//DELETE /players/{id}/games: elimina les tirades del jugador.
	public void deleteGamesByPlayerID(int playerID) throws NotFoundException {
        Player player = playerRepository.getPlayerByID(playerID);
        player.getAllGames().clear();		
	}	
}

