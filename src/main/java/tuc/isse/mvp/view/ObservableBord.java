package tuc.isse.mvp.view;

import tuc.isse.mvp.model.Bord;
import tuc.isse.mvp.model.ColumnFullException;
import tuc.isse.mvp.model.IllegalMoveException;
import tuc.isse.mvp.model.Token;

import java.util.Vector;

public class ObservableBord extends Bord {
    private Vector<BordObserver> observersMenge;

    public ObservableBord() {
        observersMenge = new Vector<BordObserver>();
    }
    public void addObserver(BordObserver observer) {
        observersMenge.add(observer);
    }
    public void removeObserver(BordObserver observer) {
        observersMenge.remove(observer);
    }
    public void notifyObservers() {
        for (BordObserver observer : observersMenge) {
            observer.update(this);
        }
    }

    @Override
    public boolean dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
        boolean b = super.dropToken(token, columnIndex);
        notifyObservers();
        return b;
    }
}
