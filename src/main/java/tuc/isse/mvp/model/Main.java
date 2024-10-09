package tuc.isse.mvp.model;

// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 *  Die main-Methode dient dazu, ein das Spiel in einem Spielbrett  zu simulieren
 *
 */
public class Main {
    public static void main(String[] args) throws ColumnFullException, IllegalMoveException {

        // Erstelle ein neues Spielbrett
        Bord b= new Bord();

        // Führe einige Spielsteine aus, um das Spiel zu simulieren
        b.dropToken(b.getToken(Token.Color.RED), 6);
        b.dropToken(b.getToken(Token.Color.RED), 6);
        b.dropToken(b.getToken(Token.Color.RED), 6);
        b.dropToken(b.getToken(Token.Color.BLUE), 6);
        b.dropToken(b.getToken(Token.Color.BLUE), 5);
        b.dropToken(b.getToken(Token.Color.RED), 5);
        b.dropToken(b.getToken(Token.Color.BLUE), 4);
        b.dropToken(b.getToken(Token.Color.BLUE), 4);
        b.dropToken(b.getToken(Token.Color.RED), 4);
        b.dropToken(b.getToken(Token.Color.BLUE), 3);
        b.dropToken(b.getToken(Token.Color.BLUE), 2);
        b.dropToken(b.getToken(Token.Color.RED), 2);


        // Drucke das aktuelle Spielbrett aus
        System.out.println(b.toString());



    }
}
