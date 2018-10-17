package com.dicegame.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicegame.application.GameController;
import com.dicegame.application.DTO.GameDTO;
import com.dicegame.utilities.InvalidParamException;
import com.dicegame.utilities.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
public class GameRestController {
	
	private GameController controller = new GameController();
	
	private String toJson(Object object){
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	//POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	@PostMapping(value = "/players/{playerID}/games", produces = "application/json;charset=UTF-8")
	public String playGame(@PathVariable int playerID) throws InvalidParamException, NotFoundException {

		GameDTO game = controller.playGame(playerID);
		return toJson(game);
	}
	//GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	@GetMapping(value = "/players/{playerID}/games", produces = "application/json;charset=UTF-8")
	public String listResults(@PathVariable int playerID)  throws NotFoundException {
		
		List<GameDTO> games = controller.listGames(playerID);
		return toJson(games);
	}
	//DELETE /players/{id}/games: elimina les tirades del jugador.
	public void removeGames(@PathVariable int playerID) throws Exception {
		controller.deleteGamesByPlayerID(playerID);	
	}
}
