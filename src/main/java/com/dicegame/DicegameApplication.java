package com.dicegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DicegameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicegameApplication.class, args);
	}
}
/*	El joc de daus s’hi juga amb dos daus. 
	En cas que el resultat dels dos daus sigui 7, la partida és guanyada, 
	sinó per perduda.
	Per poder jugar al joc, t’has de registrar com a jugador amb un nom. 
	Un jugador pot veure un llistat de totes les tirades que ha fet i el 
	percentatge d’èxit. */

/*	createPlayer: Em crea un nou jugador. Li passem per paràmetre el nom POST
	playGame: fa una tirada i l'emmagatzema en el jugador POST
	listResults: torna el llistat de les tirades del jugador GET
	ranking: retorna el percentatge mitg d’exits. GET
*/