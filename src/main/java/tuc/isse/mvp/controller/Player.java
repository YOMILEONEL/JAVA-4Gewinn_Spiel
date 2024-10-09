package tuc.isse.mvp.controller;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

import java.io.IOException;

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Die abstrakte Klasse Player hilft uns dabei, ein Spieler zu erstellen.
 */
public abstract class Player {
    public Token.Color color;
    public Bord bord;

    public Player(Token.Color color, Bord bord) {
        this.color = color;
        this.bord = bord;
    }

    /**
     * Lässt einen Token in die angegebene Spalte fallen.
     *
     * @param columnIndex Der Index der Spalte, in die der Token fallen gelassen wird.
     * @throws ColumnFullException Wenn die ausgewählte Spalte voll ist.
     * @throws IllegalMoveException Wenn der Zug illegal ist.
     */
    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException {
        bord.dropToken(bord.getToken(color),columnIndex);
    }

    /**
     * Abstrakte Methode, die den Zug des Spielers ausführt. Muss von Unterklassen implementiert werden.
     *
     * @throws ColumnFullException Wenn die ausgewählte Spalte voll ist.
     * @throws IllegalMoveException Wenn der Zug illegal ist.
     * @throws IOException Wenn ein I/O-Fehler auftritt.
     */
    public abstract void doTurn() throws ColumnFullException, IllegalMoveException, IOException;

}
