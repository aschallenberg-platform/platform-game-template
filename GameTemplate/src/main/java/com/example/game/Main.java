package com.example.game;


import de.aschallenberg.gamelibrary.config.ConfigLoader;
import de.aschallenberg.gamelibrary.game.GameRegistry;
import de.aschallenberg.gamelibrary.websocket.WebSocketInitiator;

/*
 * Hier startest du dein Bot-Programm
 */
public class Main {
	public static void main(String[] args) {

		// Hiermit lädst du wichtige Konfigurationen
		ConfigLoader.load(args);

		// Hiermit teilst du der Schnittstelle zur Plattform mit, welche Klasse die Hauptklasse deines Bots ist.
		GameRegistry.setGameClass(MeinGame.class);

		// Hiermit initiierst du die Websocket-Verbindung zur Plattform.
		WebSocketInitiator.initConnection();
	}
}
