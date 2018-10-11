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

	//playGame: fa una tirada i l'emmagatzema en el jugador POST
	public GameDTO playGame (int playerID) throws Exception{
		Game game = new Game();
		game.playGame();
		Player player = playerRepository.getPlayerByID(playerID);
		player.addGame(game);
		//buscar el player i afegir el joc.
		//retornar el jocdto
		return new GameDTO(game);
	}

	//listResults: torna el llistat de les tirades del jugador GET
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
}

