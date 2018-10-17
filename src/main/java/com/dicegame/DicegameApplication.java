package com.dicegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DicegameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicegameApplication.class, args);
	}
}
/*	Per poder jugar al joc de daus es necessiten sis daus. 
En cas que el resultat de tots els daus sigui sis o cinc, la partida �s guanyada, sin� es perduda.

Per poder realitzar una tirada, un usuari s�ha de registrar amb un nom no repetit. Al crear-se, se l�hi assigna un 
identificador num�ric �nic i una data de registre. Si l�usuari aix� ho desitja, pot no afegir cap nom i es dir� �AN�NIM�. 
Pot haver-hi m�s d�un jugador �AN�NIM�.
Cada jugador pot veure un llistat de totes les tirades que ha fet, amb el valor de cada dau i si s�ha guanyat o no 
la partida. A m�s, pot saber el seu percentatge d��xit per totes les tirades que ha realitzat. 
No es pot eliminar una partida en concret, per� si que es pot eliminar tot el llistat de tirades per un jugador.
El software ha de permetre llistar tots els jugadors que hi ha al sistema, el percentatge d��xit de cada jugador i el 
percentatge d��xit mig de tots els jugadors en el sistema.
El software ha d�estar el m�s preparat possible per implementar bases de dades i respectar els principals patrons de disseny.

POST: /players : crea un jugador
PUT /players : modifica el nom del jugador
POST /players/{id}/games/ : un jugador espec�fic realitza una tirada dels daus.
DELETE /players/{id} elimina el jugador. 
DELETE /players/{id}/games: elimina les tirades del jugador.
GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d��xits 
GET /players/{id}/games: retorna el llistat de jugades per un jugador.
GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema.
GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d��xit.
GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d��xit.

*/