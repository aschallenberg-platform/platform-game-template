package com.example.game;


import de.aschallenberg.gamelibrary.game.GameRegisty;
import de.aschallenberg.gamelibrary.websocket.WebSocketInitiator;

/*
 * Hier startest du dein Bot-Programm
 */
public class Main {
	public static void main(String[] args) {

		// Hiermit teilst du der Schnittstelle zur Plattform mit, welche Klasse die Hauptklasse deines Bots ist.
		GameRegisty.setGameClass(MeinGame.class);

		// Hiermit initiierst du die Websocket-Verbindung zur Plattform.
		WebSocketInitiator.initConnection();
	}
}
