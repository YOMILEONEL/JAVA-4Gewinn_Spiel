package tuc.isse.mvp.model;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 *  Die Cell-Klasse dient dazu, ein Spielstein mit einer genaueren Farbe zu erstellen
 *
 */
public class Token extends GameObjekt {

    Color color ;

    /**
     * Gibt eine String-Repräsentation des Tokens zurück
     * @return "O" wenn die Farbe blau ist, sonst "X"
     */
    public String toString() {
        if(color==Color.BLUE) return "O";
        return "X";
    }

    public enum Color{RED, BLUE}


    public enum Winner{RED, BLUE, NONE, TIE}



    public Token(Color c){
        this.color= c;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
