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
 * Die Klasse ConsoleGame erbt von Game und erstellt ein Spielbrett, um das Spielen möglich zu machen
 */
public class ConsoleGame extends Game{

    public ConsoleGame(Bord bord) {
        super(bord);
    }

    /**
     * Wandelt den Spieler in eine String-Darstellung um.
     *
     * @param player Der Spieler, der in eine String-Darstellung umgewandelt wird.
     * @return "X" für einen roten Spieler, "O" für einen blauen Spieler.
     */
    public String playerToString(Player player) {
        return (player.color== Token.Color.RED)?"X":"O";

    }

    /**
     * Führt das Spiel durch, indem die Spieler abwechselnd ihre Züge machen, bis ein Gewinner feststeht.
     *
     * @param player1 Der erste Spieler.
     * @param player2 Der zweite Spieler.
     * @throws ColumnFullException Wenn eine Spalte voll ist und kein Zug mehr möglich ist.
     * @throws IllegalMoveException Wenn ein illegaler Zug gemacht wird.
     * @throws IOException Wenn ein Ein-/Ausgabefehler auftritt.
     */
    public void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, IOException {
        super.player1=player1;
        super.player2=player2;
        super.currentPlayer =player1;
        while(super.bord.testVictory()==Token.Winner.NONE){

            System.out.println(super.bord.toString());
            System.out.println(" Spieler "+playerToString(currentPlayer)+" , was ist dein nächster Zug?");
            super.currentPlayer.doTurn();
            super.swapPlayer();

        }
        System.out.println(super.bord.toString());
        super.swapPlayer();
        System.out.println(" An the Winner is: "+playerToString(currentPlayer));
    }
}
