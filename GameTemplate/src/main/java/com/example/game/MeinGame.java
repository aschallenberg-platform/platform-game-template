package com.example.game;

import de.aschallenberg.gamelibrary.game.Game;
import de.aschallenberg.communication.dto.BotData;
import de.aschallenberg.communication.messages.Payload;

import java.util.List;

/**
 * <p>
 *     Deine Hauptklasse muss von Game erben und einige Methoden des Spiels implementieren.
 *     Die Klasse Game stellt dir direkt einige Funktionen bereit.
 * </p>
 * <p>
 *     Der {@link Game#jsonObjectMapper} ist ein Jackson ObjectMapper, der dir hilft, aus Objekte im JSON-Format zu
 *     serialisieren und deserialisieren.
 * </p>
 * <p>
 *     {@link Game#getGameData()}
 *     gibt dir alle wichtigen Informationen über das Spiel zurück.
 *     Hiervon bekommst du eine Liste aller teilnehmenden Bots über
 *     {@link de.aschallenberg.communication.dto.GameData#getBots()}
 *     mit dem Namen des Bots und dem Nutzernamen des Besitzers.
 *     Zudem erhältst du über
 *     {@link de.aschallenberg.communication.dto.GameData#getModule()},
 *     {@link de.aschallenberg.communication.dto.GameData#getVersion()} und
 *     {@link de.aschallenberg.communication.dto.GameData#getSettings()}
 *     den Modulnamen des Moduls und die Version, welches bzw. in welcher gespielt wird (relevant, falls deine
 *     Implementierung verschiedene Module und/oder Versionen unterstützt) und die Spieleinstellungen.
 * </p>
 * <p>
 *     Des Weiteren gibt es verschiedene Möglichkeiten, Nachrichten zu versenden. Wichtig hierbei ist, dass jede
 *     Nachricht zuerst an die Plattform gesendet wird, bevor sie dann ggf. an einen oder mehrere Bots weitergeleitet
 *     werden.
 *     Mit {@link Game#sendMove(Object, BotData)} kannst du einen Spielzug (Object) an einen bestimmten Bot (BotData)
 *     senden. Beachte, dass dir
 *     der Typ Object zwar viel Spielraum für die Art eines Spielzugs gibt, du dies allerdings gut dokumentieren musst,
 *     da teilnehmende Bots sonst nicht wissen, wie sie mit so einem Object als Spielzug umgehen müssen und falsche
 *     Daten senden.
 *     Mit {@link Game#sendGameUpdate(Object, BotData)} bzw.
 *     {@link Game#sendGameUpdate(Object, java.util.List<BotData>)} kannst du an einen (BotData) bzw. mehrere
 *     (List<BotData>) teilnehmenden Bots Updates des Spiels (Object) zusenden (z.B. aktueller
 *     Punktestand, oder wie das Spielbrett gerade aussieht).
 *     Mit {@link Game#sendError(String, BotData)} verschickst du einen Error (String) an einen Bot (BotData). Dies ist
 *     nützlich, wenn du ungültige Information von einem Bot empfangen hast. Ein Error führt nicht zwingend zum
 *     Spielabbruch.
 *     {@link Game#sendFinished(java.util.Map)} benutzt du am Ende des Spiels, um das Spiel zu beenden und um den Bots
 *     und der Plattform die Punktestände mitzuteilen. In die Map sollen für jeden Teilnehmer (BotData) ein Punktestand
 *     (Integer). Der Bot mit dem höchsten Punktestand hat gewonnen (Nicht andersrum!). Bei Turnieren können auch
 *     mehrere Bots weiterkommen.
 *     {@link Game#sendLog(String)} ist dazu da, Logs an die Plattform zu senden. Diese Logs sind wichtig, um den
 *     Spielverlauf darzustellen. Die Logs werden auf der Plattform den jeweiligen Nutzern angezeigt. Es ist also
 *     sinnvoll, regelmäßig den aktuellen Stand des Spiels (z.B. aktueller Punktestand oder aktuelles Spielbrett) zu
 *     senden.
 *     Mit {@link Game#disqualifyBot(BotData)} disqualifizierst du einen Bot (BotData). Dies dient lediglich dazu, die
 *     Plattform und die Bots darauf hinzuweisen. Wie ein disqualifizierter Bot behandelt wird, ist entweder vom Spiel
 *     auf der Plattform vorgegeben oder du kannst dich selbst entscheiden.
 *     Weitere Nachrichten kannst du mit
 *     {@link de.aschallenberg.gamelibrary.websocket.MessageSender#sendMessage(Payload)} bzw.
 *     {@link de.aschallenberg.gamelibrary.websocket.MessageSender#sendMessage(Payload, List<BotData>)}
 *     (List sind die Bots, an die die Nachricht gehen soll) senden. Dies sollte allerdings nur in absoluten Ausnahmen
 *     verwendet werden, da dies fehleranfällig ist.
 * </p>
 * <p>
 *     Außerdem stehen Methoden bereit, die ein Standardverhalten haben und die du überschreiben kannst, um deren
 *     Verhalten zu erweitern oder zu ersetzen.
 *     {@link Game#onOtherMessageReceived(BotData, Payload)} verwaltet alle empfangenen Nachrichten, die keiner
 *     bekannten Kategorie (wie z.B. Move, GameUpdate, Error, ...) zugeordnet sind. Standardmäßig wird eine Warnung in
 *     der Konsole mit Absender und Nachrichtentyp ausgegeben.
 *     {@link Game#onInterruptGame()} wird aufgerufen, wenn irgendwas schiefgelaufen ist und das Spiel abgebrochen
 *     werden muss. Standardmäßig wird das Spiel dann einfach über die von der zu implementierende Methode
 *     {@link Game#resetGame()}} resettet.
 *     {@link Game#onBotDisconnected(BotData)} wird getriggert, wenn ein an dem aktuellen Spiel teilnehmender Bot
 *     (BotData) seine Verbindung zur Plattform verliert. Das Standardverhalten ist hierbei das Spiel zu beenden.
 * </p>
 */
public class MeinGame extends Game {

	/**
	 * Diese Methode wird aufgerufen, wenn eine Lobby auf der Plattform startet. Hier kannst du dein Spiel
	 * initialisieren und die ersten Daten an die Bots versenden.
	 */
	@Override
	public void onStartGame() {
		// TODO implement
	}

	/**
	 * Hier bekommst du einen Spielzug (payload) eines Bots (botData). Achte darauf, dass vorher nicht überprüft
	 * wird, dass ein Spielzug wirklich von dem Bot kommt, der an der Reihe ist.
	 *
	 * @param botData der Bot, der den Spielzug gesendet hat.
	 * @param payload der Spielzug (Muss je nach Typ von dir weiterverarbeitet werden).
	 */
	@Override
	public void onMoveReceived(final BotData botData, final Object payload) {
		// TODO implement
	}

	/**
	 * Hier werden weitere Daten (payload) von einem Bot (botData) empfangen, die kein Spielzug sind.
	 *
	 * @param botData der Bot, der das Spielupdate gesendet hat.
	 * @param payload das Spielupdate (Muss je nach Typ von dir weiterverarbeitet werden).
	 */
	@Override
	public void onGameUpdateReceived(final BotData botData, final Object payload) {
		// TODO implement
	}

	/**
	 * Hier musst du eine Reset-Logik einbauen, die dein Spiel zurücksetzt. Dies wird standardmäßig getan, wenn ein
	 * Bot während des Spiels disconnected.
	 */
	@Override
	public void resetGame() {
		// TODO implement
	}

	/**
	 * Beim Erstellen einer Lobby kann die Antwortzeit eines Bots eingestellt werden.
	 * Ab dem Zeitpunkt, an dem die Plattform eine Move-nachricht von dieser Spielimplementation weiterleitet,
	 * wird gemessen, wie lange der Bot zum Antworten auf diese Nachricht benötigt. Wenn der Bot nicht innerhalb
	 * der eingestellten Zeit antwortet, wird auf der Plattform ein Timeout gemeldet. Dieser wird hier hin versendet
	 * und diese Methode wird getriggert.
	 * Dies verhindert, dass das Spiel hängen bleibt, wenn der Bot nicht antwortet oder zu lange braucht.
	 * Es kann trotzdem passieren, dass der Bot nach diesem Timeout noch auf die Move-Nachricht antwortet.
	 * Daher sollte in dem Spiel auf der Plattform eine klare Empfehlung für die Antwortzeit angegeben werden.
	 * <p>
	 * Hier musst du also deine eigene Timeout-Logik einbauen.
	 * </p>
	 *
	 * @param botData der Bot, der noch nicht auf die Move-Nachricht geantwortet hat.
	 */
	@Override
	public void onBotTimedOut(final BotData botData) {
		// TODO implement
	}
}
