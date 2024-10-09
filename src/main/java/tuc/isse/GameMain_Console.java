package tuc.isse;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

import tuc.isse.mvp.controller.ConsoleGame;
import tuc.isse.mvp.controller.ConsolePlayer;
import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

import java.io.IOException;
import java.util.*;

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Die Klasse GameMain_Console hilft 2 Spielern dabei, das Spiel miteinander zu spielen.
 *
 */ 
public class GameMain_Console {
    public static void main(String[] args) throws ColumnFullException, IllegalMoveException, IOException {

        Bord bord = new Bord();
        ConsoleGame console = new ConsoleGame(bord);
        ConsolePlayer player1 = new ConsolePlayer(Token.Color.RED,bord);
        ConsolePlayer player2 = new ConsolePlayer(Token.Color.BLUE,bord);

        console.doGame(player1,player2);
    }
}