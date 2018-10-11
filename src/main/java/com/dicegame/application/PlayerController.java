package com.dicegame.application;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.application.DTO.PlayerDTO;
import com.dicegame.domain.Player;
import com.dicegame.persistence.PlayerRepository;

public class PlayerController {
	
	private PlayerRepository playerepository = new PlayerRepository();
	
	public PlayerController () {		
	}
	
	//createPlayer: Em crea un nou jugador. Li passem per paràmetre el nom
	public PlayerDTO createPlayer (PlayerDTO playerDTO) throws Exception{
		Player player = new Player(playerDTO.getPlayerID(), playerDTO.getPlayerName());
		playerepository.addPlayer(player);
		return new PlayerDTO(player);
	}

	//ranking: retorna el percentatge mitg d’exits. GET
    public List<PlayerDTO> getAllPlayers() throws Exception {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
		for (Player player : playerepository. getAllPlayers()) {
			playerDTOList.add(new PlayerDTO(player));
		}
        return playerDTOList;
    }
}
