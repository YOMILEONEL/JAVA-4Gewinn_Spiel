package tuc.isse.mvp.controller;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Diese Klasse erstellt Spieler mit den Eingenschaften von der Klasse Player, diese
 * werden dann ins Spiel durch die Funktion doGame in der Klasse ConsoleGame reingefügt.
 */
public class ConsolePlayer extends Player{


    public ConsolePlayer(Token.Color color, Bord bord) {
        super(color, bord);

    }

    /**
     * Führt den Zug des Spielers aus, indem die Spalte von der Konsole eingelesen wird.
     *
     * @throws ColumnFullException Wenn die gewählte Spalte voll ist und kein Zug mehr möglich ist.
     * @throws IllegalMoveException Wenn ein illegaler Zug gemacht wird.
     * @throws IOException Wenn ein Ein-/Ausgabefehler auftritt.
     */
    public void doTurn() throws ColumnFullException, IllegalMoveException, IOException {
        System.out.print("Eingabe : ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        super.doDrop((Integer.parseInt(consoleReader.readLine())));


    }
}
