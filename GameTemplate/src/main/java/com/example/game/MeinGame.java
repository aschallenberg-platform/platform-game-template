package com.example.game;

import de.aschallenberg.gamelibrary.data.BotData;
import de.aschallenberg.gamelibrary.game.Game;

/*
 * Deine Hauptklasse muss von Game erben und einige Methoden des Spiels implementieren.
 * Die Klasse Game stellt dir direkt einige Funktionen bereit.
 *
 * Der jsonObjectMapper ist ein Jackson ObjectMapper, der dir hilft, aus Objekte im JSON-Format zu serialisieren und
 * deserialisieren.
 *
 * getBots() gibt dir eine Liste aller teilnehmenden Bots (speziell Bot-Token, Bot-Name und Besitzer)
 * getModule() gibt dir das Modul des Spiels, welches gespielt werden soll.
 * getVersion() gibt dir die Version des Spiels, in der gespielt werden soll.
 * getSettings() gibt dir eine Map an Einstellungen, die vorher getroffen wurden (Bis jetzt nicht implementiert)
 *
 * Mit sendMove(Object, BotData) sendest du einen Spielzug (Object) an einen bestimmten Bot (BotData). Beachte, dass dir
 * der Typ Object zwar viel Spielraum für die Art eines Spielzugs gibt, du dies allerdings gut dokumentieren musst, da
 * teilnehmende Bots sonst nicht wissen, wie sie mit so einem Object als Spielzug umgehen müssen und falsche Daten
 * senden.
 * Mit sendMessage(Object, BotData) bzw. sendMessage(Object, List<BotData>) kannst du an einen (BotData) bzw. mehrere
 * (List<Botdata>) teilnehmenden Bots Informationen (Object) senden, die kein Spielzug sind (z.B. aktueller Punktestand,
 * oder wie das Spielbrett gerade aussieht).
 * Mit sendError(String, BotData) verschickst du einen Error (String) an einen Bot (BotData). Dies ist nützlich, wenn du
 * ungültige Information von einem Bot empfangen hast. Ein Error führt nicht zwingend zum Spielabbruch.
 * sendFinished(Map<BotData, Integer>) benutzt du am Ende des Spiels um das Spiel zu beenden und um den Bots und der
 * Plattform die Punktestände mitzuteilen. In die Map sollen für jeden Teilnehmer (BotData) ein Punktestand (Integer).
 * Der Bot mit dem höchsten Punktestand hat gewonnen (Nicht andersrum!).
 *
 * Du kannst (musst aber nicht) zwei weitere Methode überschreiben:
 * onInterrupt() setzt standardmäßig das Spiel zurück. Dies passiert z.B. wenn ein interner Fehler auf der Plattform
 * auftritt.
 * onBotDisconnected(BotData) beinhaltet das Verhalten deines Spiels, wenn ein teilnehmender Bot (BotData) während des
 * Spiels disconnected. Standardmäßig bricht onBotDisconnected das Spiel einfach ab und setzt es zurück.
 */
public class MeinGame extends Game {
	@Override
	public void onStartGame() {
		/*
		 * Diese Methode wird aufgerufen, wenn eine Lobby auf der Plattform startet. Hier kannst du dein Spiel
		 * initialisieren und die ersten Daten an die Bots versenden.
		 */
	}

	@Override
	public void onMove(final BotData sender, final Object object) {
		/*
		 * Hier bekommst du alle Spielzüge der Bots. Achte darauf, dass vorher nicht überprüft wird, dass ein Spielzug
		 * wirklich von dem Bot kommt, der an der Reihe ist.
		 */
	}

	@Override
	public void onMessageReceived(final BotData sender, final Object object) {
		/*
		 * Hier werden andere Daten von Bots empfangen, die kein Spielzug sind.
		 */
	}

	@Override
	public void resetGame() {
		/*
		 * Hier musst du eine Reset-Logik einbauen, die dein Spiel zurücksetzt. Dies wird standardmäßig getan, wenn ein
		 * Bot während des Spiels disconnected.
		 */
	}
}
