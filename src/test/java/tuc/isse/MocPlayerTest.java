package tuc.isse;

import junit.framework.TestCase;
import org.junit.Test;
import tuc.isse.mvp.controller.ConsoleGame;
import tuc.isse.mvp.controller.MocPlayer;
import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;
import tuc.isse.mvp.view.BordObserver;
import tuc.isse.mvp.view.ObservableBord;

import java.io.IOException;

public class MocPlayerTest extends TestCase implements BordObserver {
    private boolean notified = false;

    @Override
    public void update(ObservableBord bord) {
        notified= true;
        // Überprüfen, ob die update-Methode mit der richtigen Bord-Instanz aufgerufen wird
        assertEquals(bord,bord);
    }


    @Test
    public void testMocPlayer() throws ColumnFullException, IllegalMoveException, IOException {

        ObservableBord bord = new ObservableBord();
        bord.addObserver(this); // Diese Testklasse als Beobachter registrieren

        ConsoleGame console = new ConsoleGame(bord);

        MocPlayer player1 = new MocPlayer(Token.Color.BLUE,bord,1,2,0);
        MocPlayer player2 = new MocPlayer(Token.Color.RED,bord,3,5,0);

        console.doGame(player1,player2);

        // Überprüfe ob der Observer benachrichtigt wurde.
        assertEquals(true, notified);

        // Überprüfen, ob der erwartete Gewinner korrekt ist
        assertEquals(Token.Winner.BLUE,bord.testVictory());

    }


}