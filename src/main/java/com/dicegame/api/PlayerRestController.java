package com.dicegame.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dicegame.application.PlayerController;
import com.dicegame.application.DTO.PlayerDTO;
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
	//createPlayer: Em crea un nou jugador. Li passem per paràmetre el nom POST
	@PostMapping(value = "/players", produces = "application/json;charset=UTF-8")
	public String createPlayer(@RequestBody String jPlayer) throws Exception {

		PlayerDTO newPlayer = new Gson().fromJson(jPlayer, PlayerDTO.class);
		PlayerDTO player = controller.createPlayer(newPlayer);
		return toJson(player);
	}
	//ranking: retorna el percentatge mitg d’exits. GET
	@GetMapping(value = "/players", produces = "application/json;charset=UTF-8")
	public String ranking()  throws Exception {	
	
		List<PlayerDTO> player = controller.getAllPlayers();		
		return toJson(player);
	}
}
