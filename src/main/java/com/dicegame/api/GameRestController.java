package com.dicegame.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicegame.application.GameController;
import com.dicegame.application.DTO.GameDTO;
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
	//playGame: fa una tirada i l'emmagatzema en el jugador POST
	@PostMapping(value = "/players/{playerID}/games", produces = "application/json;charset=UTF-8")
	public String playGame(@PathVariable int playerID) throws Exception {

		GameDTO game = controller.playGame(playerID);
		return toJson(game);
	}
	//listResults: torna el llistat de les tirades del jugador GET
	@GetMapping(value = "/players/{playerID}/games", produces = "application/json;charset=UTF-8")
	public String listResults(@PathVariable int playerID)  throws Exception {
		
		List<GameDTO> games = controller.listGames(playerID);
		return toJson(games);
	}
}
