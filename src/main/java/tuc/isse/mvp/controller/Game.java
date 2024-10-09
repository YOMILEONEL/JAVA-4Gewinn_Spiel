package tuc.isse.mvp.controller;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de


import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;

import java.io.IOException;

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Die abstrakte Klasse Game hilft uns dabei, das Spiel zu konfigurieren. (Anzahl von Spielern und der Spieler, der dran ist.)
 *
 */

public abstract class Game {

    Bord bord;
    Player player1;
    Player player2;

    Player currentPlayer;

    public Game(Bord bord) {
        this.bord = bord;
    }

    /**
     * Tauscht den aktuellen Spieler gegen den nächsten Spieler aus.
     */
    protected void swapPlayer(){
        currentPlayer = (currentPlayer ==player1)?player2:player1;
    }

    /**
     * Abstrakte Methode, die das Spiel durchführt.
     *
     * @param player1 Der erste Spieler.
     * @param player2 Der zweite Spieler.
     * @throws ColumnFullException Wenn eine Spalte voll ist und kein weiterer Zug möglich ist.
     * @throws IllegalMoveException Wenn ein illegaler Zug gemacht wird.
     * @throws IOException Wenn ein Ein-/Ausgabefehler auftritt.
     */
    public abstract void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, IOException;
}
