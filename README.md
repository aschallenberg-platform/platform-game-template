# Platform Game Template

Dies ist eine Template zu Erstellung eines Spielservers für die Plattform. Benutze es um einen Spielserver für ein Spiel zu entwickeln.

## Installation
Um dieses Template zu benutzen können Sie es über die Knopf "Code" einfach als ZIP herunterladen oder das Repository clonen. 
Mittels Maven müssen dann alle Abhängigkeiten installiert werden. Navigieren Sie dazu in den Ordner `GameTemplate` und geben Sie
```
mvn package
```
in die Kommandozeile ein.
Eine Anleitung zur Installation von Maven ist hier zu finden: https://maven.apache.org/install.html
Anschließend kann das Projekt mit einem beliebigen Editor bearbeitet werden. 

### Fehlerbehebung
Falls es zu Fehlern kommt, versuchen Sie die die Projektspezifischen Dependencies manuell zu installieren.
Laden Sie sich zunächst die Communication Library (https://github.com/aschallenberg-platform/platform-communication-library-java) herunter. Führen Sie in dem Ordner der Bibliothek, in dem die pom.xml liegt, folgendes in der Kommandozeile auf:
```
mvn install
```
Wiederholen Sie diesen Schritt dann mit der Game Library (https://github.com/aschallenberg-platform/platform-game-library).

Versuchen Sie anschließend erneut das Template zu installieren.

## Anfangen das Spiel zu schreiben

Sie benötigen primär drei Dinge, um ein Spiel zu schreiben: eine main-Methode, eine (Haupt-)Klasse für Ihr Spiel und eine Konfigurationsdatei. In diesem Template sind sie schon vorprogrammiert.

## config-Datei

Die config-Datei `config.properties` muss in `src/main/resources` liegen. Sie muss Folgendes beinhalten:

```
platform.host=<IP-Adresse der Plattform, zu der Sie sich verbinden möchten>
platform.port=<Port der Plattform, zu der Sie sich verbinden möchten>
platform.game.token=<Der Game-Implementation-Token für das Spiel, das Sie implementieren möchten>
```

## (Haupt-)Klasse
Es muss eine Hauptklasse existieren, die von `de.aschallenberg.gamelibrary.game.Game` erbt. Sie werden einige Methoden in ihr implementieren müssen. Diese stellen die Schnittstelle zur Plattform und zu den Bots dar, die auf Ihren Spielservern spielen werden.

## main-Methode

Ihr Programm benötigt eine `main`-Methode. In diesem Template ist sie in einer eigenen Klasse `Main` angelegt. Sie können sie jedoch auch an anderer Stelle implementieren. Zunächst muss die Konfigurationsdatei geladen werden. Dies geschieht mit:
```java
ConfigLoader.load(args);
```
Wichtig ist auch, dass die Hauptklasse registriert ist. Das geschieht mit:
```java
GameRegisty.setGameClass(MeinGame.class);
```
**Danach** müssen wird die Library dazu aufgefordet, eine WebSocket-Verbindung zur Plattform aufzubauen. Dies funktioniert mit der Zeile:
```java
WebSocketInitiator.initConnection();
```
Die `main`-Methode sieht jetzt in etwa so aus:

```java
public static void main(String[] args) {
	ConfigLoader.load(args);
	GameRegisty.setGameClass(MeinGame.class);
	WebSocketInitiator.initConnection();
}
```

Wenn Sie alle drei Komponenten haben und diese korrekt konfiguriert sind, sollte das Spiel beim Starten eine WebSocket-Verbindung zur Plattform aufbauen und sich dort registrieren. Sie sollten dann in der Konsole etwas sehen wie
„Successfully registered“. Das Spiel bzw. die Module und Versionen davon, die Sie unterstützen, haben jetzt eine Instanz mehr online und es wird automatisch zum Spielen bereitgestellt.
Jedoch wird Ihre Spiel-Implementierung noch zu Fehlern führen, da Sie diese bis jetzt noch nicht implementiert haben.

## Implementierung

Die von `Game` überschriebenen Methoden müssen Sie nun implementieren. Achten Sie darauf, dass Sie Ein- und Ausgabe-Klassen (also die Typen von Objekten, die Sie erwarten können und die Sie versenden) genau auf die Voraussetzungen des Spiels abstimmen. Andernfalls wird Ihr Code zu Fehlern führen.
