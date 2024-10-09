package tuc.isse;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de
import org.junit.Test;
import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

import static org.junit.Assert.*;
/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 *  Die BordTest-Klasse diebnt dazu, die Klasse Bord zu testen
 *
 */

public class BordTest {

    @Test
    public void testToString1() throws ColumnFullException, IllegalMoveException {

        Bord b= new Bord();

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

        // Überprüfe, ob die toString()-Methode das erwartete Ergebnis liefert
        assertEquals("""
                ( )( )( )( )( )( )( )
                ( )( )( )( )( )( )( )
                ( )( )( )( )( )( )(O)
                ( )( )( )( )(X)( )(X)
                ( )( )(X)( )(O)(X)(X)
                ( )( )(O)(O)(O)(O)(X)
                """,b.toString());

        assertEquals(b.testVictory(), Token.Winner.NONE);

    }

    @Test
    public void testToString2() throws ColumnFullException, IllegalMoveException {
        IllegalMoveException e = assertThrows(IllegalMoveException.class, () ->{;
            Bord b = new Bord();

            b.dropToken(b.getToken(Token.Color.RED), 6);
            b.dropToken(b.getToken(Token.Color.RED), 6);
            b.dropToken(b.getToken(Token.Color.BLUE), 6);
            b.dropToken(b.getToken(Token.Color.RED), 6);
            b.dropToken(b.getToken(Token.Color.BLUE), 5);
            b.dropToken(b.getToken(Token.Color.BLUE), 5);
            b.dropToken(b.getToken(Token.Color.RED), 5);
            b.dropToken(b.getToken(Token.Color.BLUE), 4);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 3);
            b.dropToken(b.getToken(Token.Color.BLUE), 2);
            b.dropToken(b.getToken(Token.Color.RED), 2);
            b.dropToken(b.getToken(Token.Color.BLUE), 2);
            b.dropToken(b.getToken(Token.Color.RED), 1);
            b.dropToken(b.getToken(Token.Color.BLUE), 0);
            b.dropToken(b.getToken(Token.Color.BLUE), 0);

            // Überprüfe, ob die toString()-Methode das erwartete Ergebnis liefert
            assertEquals("""
                    ( )( )( )( )( )( )( )
                    ( )( )( )( )( )( )( )
                    ( )( )( )( )( )( )(X)
                    ( )( )(O)( )(X)(X)(O)
                    (O)( )(X)( )(X)(O)(X)
                    (O)(X)(O)(X)(O)(O)(X)
                    """, b.toString());

            assertEquals(b.testVictory(), Token.Winner.RED);});
        assertEquals(" Es kann kein Token mehr eingeworfen werden, weil ein Spieler schon gewonnen hat ",e.getMessage());


    }
    @Test
    public void testToString3() throws ColumnFullException, IllegalMoveException {

        IllegalMoveException e = assertThrows(IllegalMoveException.class, ()->{
            Bord b = new Bord();

            b.dropToken(b.getToken(Token.Color.BLUE), 6);
            b.dropToken(b.getToken(Token.Color.BLUE), 5);
            b.dropToken(b.getToken(Token.Color.BLUE), 5);
            b.dropToken(b.getToken(Token.Color.BLUE), 5);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 4);
            b.dropToken(b.getToken(Token.Color.RED), 3);
            b.dropToken(b.getToken(Token.Color.RED), 2);
            b.dropToken(b.getToken(Token.Color.BLUE), 2);
            b.dropToken(b.getToken(Token.Color.RED), 2);
            b.dropToken(b.getToken(Token.Color.BLUE), 2);
            b.dropToken(b.getToken(Token.Color.BLUE), 1);
            b.dropToken(b.getToken(Token.Color.RED), 1);
            b.dropToken(b.getToken(Token.Color.BLUE), 1);
            b.dropToken(b.getToken(Token.Color.RED), 0);
            b.dropToken(b.getToken(Token.Color.BLUE), 0);

            // Überprüfe, ob die toString()-Methode das erwartete Ergebnis liefert
            assertEquals("""
                    ( )( )( )( )( )( )( )
                    ( )( )( )( )( )( )( )
                    ( )( )(O)( )(X)( )( )
                    ( )(O)(X)( )(X)(O)( )
                    (O)(X)(O)( )(X)(O)( )
                    (X)(O)(X)(X)(X)(O)(O)
                    """, b.toString());


        assertEquals(b.testVictory(), Token.Winner.BLUE);});

        assertEquals(" Es kann kein Token mehr eingeworfen werden, weil ein Spieler schon gewonnen hat ", e.getMessage());


    }

    @Test
    public void testToString4() throws ColumnFullException, IllegalMoveException {
        Bord b= new Bord();

        b.dropToken(b.getToken(Token.Color.BLUE), 6);
        b.dropToken(b.getToken(Token.Color.RED), 6);
        b.dropToken(b.getToken(Token.Color.RED), 6);
        b.dropToken(b.getToken(Token.Color.BLUE), 6);
        b.dropToken(b.getToken(Token.Color.BLUE), 6);
        b.dropToken(b.getToken(Token.Color.RED), 6);


        for( int j=0; j<=5; j++){
            for( int i=5; i>=0; i--){
                if(j%2==0){
                    b.dropToken(b.getToken(Token.Color.RED), j);
                }
                if(j%2!=0){
                    b.dropToken(b.getToken(Token.Color.BLUE), j);
                }
            }
        }

        assertEquals(b.testVictory(),Token.Winner.TIE);

    }

}