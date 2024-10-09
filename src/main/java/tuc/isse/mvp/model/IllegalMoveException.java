package tuc.isse.mvp.model;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 */
public class IllegalMoveException extends Exception {

    public IllegalMoveException() {
        super(" Es kann kein Token mehr eingeworfen werden, weil ein Spieler schon gewonnen hat ");
    }
}
