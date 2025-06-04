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

## Fehlerbehebung
Falls es zu Fehlern kommt, versuchen Sie die die Projektspezifischen Dependencies manuell zu installieren.
Laden Sie sich zunächst die Communication Library (https://github.com/aschallenberg-platform/platform-communication-library-java) herunter. Führen Sie in dem Ordner der Bibliothek, in dem die pom.xml liegt, folgendes in der Kommandozeile auf:
```
mvn install
```
Wiederholen Sie diesen Schritt dann mit der Game Library (https://github.com/aschallenberg-platform/platform-game-library).

Versuchen Sie anschließend erneut das Template zu installieren.
