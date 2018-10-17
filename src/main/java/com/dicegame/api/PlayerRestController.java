package com.dicegame.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dicegame.application.PlayerController;
import com.dicegame.application.DTO.PlayerDTO;
import com.dicegame.utilities.InvalidParamException;
import com.dicegame.utilities.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
public class PlayerRestController {
	
	private PlayerController controller = new PlayerController();

	private String toJson(Object object){
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	//POST: /players : crea un jugador
	@PostMapping(value = "/players", produces = "application/json;charset=UTF-8")
	public String createPlayer(@RequestBody String jPlayer) throws NotFoundException, InvalidParamException {

		PlayerDTO newPlayer = new Gson().fromJson(jPlayer, PlayerDTO.class);
		PlayerDTO player = controller.createPlayer(newPlayer);
		return toJson(player);
	}
	//GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
	@GetMapping(value = "/players", produces = "application/json;charset=UTF-8")
	public String getPlayerwithSuccessRate()  throws NotFoundException {	
	
		List<PlayerDTO> player = controller.getAllPlayers();		
		return toJson(player);
	}
	//PUT /players : modifica el nom del jugador
	@PutMapping(value = "/players/{playerID}", produces = "application/json;charset=UTF-8")
	public String updateUser(@PathVariable int playerID, @RequestBody String jPlayer)	throws Exception {

		PlayerDTO userToUpdate = new Gson().fromJson(jPlayer, PlayerDTO.class);
		PlayerDTO user = controller.updatePlayer(playerID, userToUpdate);

		return toJson(user);
	}	
	//DELETE /players/{id} elimina el jugador.
	@DeleteMapping(value = "/players/{playerID}", produces = "application/json;charset=UTF-8")
	public void removePlayer(@PathVariable int playerID)	throws Exception {
		controller.deletePlayerByID(playerID);
	}	

	/**
	 * GET RANKING 
	 * @return
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/players/ranking", produces = "application/json;charset=UTF-8")
	public String ranking()	throws NotFoundException {	
	
		double ranking = controller.getRanking();		
		return toJson(ranking);
	}
	//GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	@GetMapping(value = "/players/ranking/loser", produces = "application/json;charset=UTF-8")
	public String rankingLoser()  throws NotFoundException {	
	
		PlayerDTO loser = controller.getRankingLoser();		
		return toJson(loser);
	}
	//GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	@GetMapping(value = "/players/ranking/winner", produces = "application/json;charset=UTF-8")
	public String rankingWinner()  throws NotFoundException {	
	
		PlayerDTO winner = controller.getRankingWinner();		
		return toJson(winner);
	}
}
