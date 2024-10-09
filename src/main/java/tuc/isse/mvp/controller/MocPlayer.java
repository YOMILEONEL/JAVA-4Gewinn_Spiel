package tuc.isse.mvp.controller;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Die Klasse MocPlayer hilft uns dabei, das Spiel zu simulieren.
 *
 */
public class MocPlayer extends Player{
    int moveFirstColumn;
    int moveSecondColumn;
    int round;

    public MocPlayer(Token.Color color, Bord bord, int moveFirstColumn, int moveSecondColumn, int round) {
        super(color, bord);
        this.moveFirstColumn = moveFirstColumn;
        this.moveSecondColumn = moveSecondColumn;
        this.round = round;

    }

    /**
     * Führt den Zug des Spielers aus. Der Spieler wechselt jede Runde zwischen der ersten und zweiten Spalte.
     *
     * @throws ColumnFullException Wenn die ausgewählte Spalte voll ist.
     * @throws IllegalMoveException Wenn der Zug illegal ist.
     */
    public void doTurn() throws ColumnFullException, IllegalMoveException {

        if(round%2==0) {
            super.doDrop(moveFirstColumn);
        }
        else{
            super.doDrop(moveSecondColumn);
        }
        round++;
    }
}
